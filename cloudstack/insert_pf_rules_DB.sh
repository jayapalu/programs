#!/bin/bash

# script for inserting portforwarding rules into the cloudstack DB

networkid=305
ipid=33
instance_id=306
#vm ip address
pfvmip=10.1.1.230

#set -x
for i in {5..4000}
do

	a=$(uuidgen)
	uuid=$(echo "$a" | tr '[:upper:]' '[:lower:]')

	mysql -uroot --database cloud -bse "INSERT INTO firewall_rules
	(id, uuid, ip_address_id, start_port, end_port, state, protocol, purpose, account_id, domain_id, network_id, xid, created, icmp_code, icmp_type, related, type, vpc_id, traffic_type, display)
	VALUES ($i,UUID(), $ipid, $i, $i, 'Active', 'tcp', 'PortForwarding', 2, 1, $networkid, '$uuid', now(), NULL, NULL, NULL, 'User', NULL, NULL, 1)"
	echo "Ports $i - $i Inserting into * firewall_rules rule *  success=$?"
	mysql -uroot --database cloud -bse "INSERT INTO port_forwarding_rules (id, instance_id,dest_ip_address,dest_port_start, dest_port_end) VALUES($i,$instance_id,'$pfvmip',$i,$i);" 

	echo "Ports $i - $i Inserting into * port_forwarding_rules * rule success=$?"

done
