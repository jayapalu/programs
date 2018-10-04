
#Initialising the zone
set -x

zone_id=$(cloudmonkey list zones | jq '.zone[0].id')
echo "Zone Id is : $zone_id"
echo "Zone"

#Getting the built in template present in that zone 
templ=$(cloudmonkey list templates templatefilter=all keyword=centos zoneid=$zone_id | jq '.template[0].id')

#Getting network names in that zone


echo "The names of the network in the zone are"
list_networks1=$(cloudmonkey list networks zoneid=$zone_id)
count=$(echo "$list_networks1" | jq .count)
echo $count
echo "total number of networks are $count"
let count=$count-1





#Displaying network name

for j in $(seq 0 $count); do
    net_id=$(echo "$list_networks1" | jq .network[$j].id)
    net_name=$(echo "$list_networks1" | jq .network[$j].name)
    echo  $net_name | sed 's/"//g'
done


#Initialising the network id to null
net_id=null
found_network=0



#Asking the user for the network name 
echo "Enter the network name"
read name 

#If user did not pass any name by default it takes first network

if [ -z $name ]
then 
net_id=$(echo "$list_networks1" | jq .network[0].id)
        found_network=1
fi


#Adding double quotes to the user choice

name1='"'$name'"'
echo $name1

#Checking whether the given network name exists 
for j in $(seq 0 $count); do
   net_name=$(echo "$list_networks1" | jq .network[$j].name)
   
    if [ $net_name = $name1 ]
    then
	net_id=$(echo "$list_networks1" | jq .network[$j].id)
	found_network=1
fi
done

#If the given name is not present then exit

if [ $found_network -eq 0 ]
then
	echo "Network not found"
	exit

else

sod=$(cloudmonkey list serviceofferings  | jq '.serviceoffering[0].id')
vmdep_resp=$(cloudmonkey deploy virtualmachine zoneid=$zone_id  templateid=$templ serviceofferingid=$sod networkids=$net_id)

fi


