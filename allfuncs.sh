

set -o allexport
#LOGFILE='management-server-router-upgr-50rt-2000-rl_updatedb.log'
alias search='grep -h --color=always "$LOGFILE" -e'
#LOGFILE='management-server-100rt-2000rules-pre.log'
#alias search='grep -h --color=always management-server-router-upgr-50rt-2000-rl_updatedb.log -e'

function eachline() {

   while read line; do
     $("$1")
    done;

}

function topjobs() {
    logid=$1
    if [ "$logid" == "" ]; then
        search "API-Job-Executor.*into job monitoring" | cut -d' ' -f7 | cut -d')' -f1 
    else
        search "$logid.* AsyncJobVO" -o | tr -d , | cut -d' ' -f4
    fi;
}

function subjob() {
    topjob="$1"
    #./search -e "$topjob.*into job monitoring" -e "$topjob.*Remove.*from job monitoring"

    search "$topjob.*into job monitoring\|$topjob.*Remove.*from job monitoring"

    echo "-------"
}
function allsubjobs() {
    topjobs | while read line; do subjob $line; done
}


function jobhost() {

    topjob="$1"
    #./search -e "$topjob.*into job monitoring" -e "$topjob.*Remove.*from job monitoring"

    #./search "$topjob.*into job monitoring\|$topjob.*Remove.*from job monitoring\|$topjob.*hostname"
    #./search "Complete async $topjob," | cut -d, -f1,2,14
    #host in uuid
    #search "Complete async $topjob," | cut -d, -f1,2,14 | sed -e 's/,\|"/ /g'  | cut -d' ' -f2,3,12,16 | awk {'print $4" "$1""$2" "$3'}
    #host with number
    search "$topjob.*Returning Deployment" | cut -d: -f7 | cut -d- -f4
    #echo "-------"
}
function alljobhosts() {
    topjobs | while read line; do jobhost $line; done
}

function hostlist() {
    #host_list=$(topjobs | xargs -I{} search "{}.*hostname" | grep -o "hostid.*hostname")
    #host_list=$(topjobs | while read line; do search "$line.*hostname"; done | grep -o "hostid.*hostname" | cut -d'"' -f3)
    #host_list=$(search "hostid.*hostname" -o | cut -d'"' -f3 | sort -nu)
    host_list=$(search "Returning Deployment" | cut -d: -f7 | cut -d- -f4 | sort -u)

    if [ "$1" == "vrcount" ]; then
        host_count=$(echo "$host_list" | awk '{ a[$1]++ } END { for (n in a) print n, a[n] } ')
        echo "$host_count"
    else
        echo "$host_list"
    fi;
}

function hostjobs() {
    hostid=$1
    #hostid=5cfa57fd-e8c7-4fdd-944d-d89b533619c4 
    search $hostid | cut -d' ' -f6 | cut -d/ -f1 | uniq
}
function allhostjobs() {
   hostlist | while read line; do echo "$line <<<<------"; hostjobs $line; done
}

function timediff() {

    logpair="$1"
    echo "$logpair" | tr ",:" " " | awk {'print "("$2"*3600+"$3"*60+"$4")"'} | paste -s -d- | bc
}


function jobtimes() {

    topjob=$1
    start_log=$(subjob $topjob | head -n3 | tail -n2)
    stop_log=$(subjob $topjob | tail -n4 | head -n2)

    #start_ts=timediff "$start_log"
    #stop_ts=timediff "$stop_log"
    subjob_logs=$(subjob $topjob)
    total_ts=$(echo "$subjob_logs" | grep API-Job | tr ",:" " " | awk {'print "("$2"*3600+"$3"*60+"$4")"'} | paste -s -d- | bc)
    stop_ts=$(echo "$subjob_logs" | head -n3 | tail -n2 | tr ",:" " " | awk {'print "("$2"*3600+"$3"*60+"$4")"'} | paste -s -d- | bc) 
    start_ts=$(echo "$subjob_logs" | tail -n4 | head -n2 | tr ",:" " " | awk {'print "("$2"*3600+"$3"*60+"$4")"'} | paste -s -d- | bc)
    echo "$topjob total: $total_ts stop: $stop_ts start: $start_ts"
}
function alljobtimes() {
    topjobs | while read line; do jobtimes $line; done
}

function sequencetime() {
    #jobdetails job-20917 | awk '{ a[i]=$_; b[i]=$2;i++ } END { for (n in a) print b[n]" "a[n] } '
    initialsec=$(echo "$1" | head -n1 | awk '{split($2, arr, ":|,"); ts=arr[1]*3600+arr[2]*60+arr[3]; print ts}')
    echo "$1" | awk -v initsec="$initialsec" '{ a[i]=$_; b[i]=$2; {split($2, arr, ":|,"); c[i]=arr[1]*3600+arr[2]*60+arr[3]-initsec};i++ } END {for (n in a) print c[n],a[n]}'
    #echo "$1" | awk '{ a[i]=$_; b[i]=$2; {split($2, arr, ":|,"); c[i]=arr[1]*3600+arr[2]*60+arr[3]-$initialsec};i++ } END { for (n in a) print c[n],a[n]}'
}




function apilogid() {
    user_api=upgradeRouterTemplate
    search "START.*$user_api" | grep -o "logid:.*)" | tr ":)" " " | cut -d' ' -f2
}

function allvrs() {
    apilogid=$1
    #search "$apilogid.*AsyncJobVO.*cmd:" | tr -d ',' | cut -d' ' -f21
    search "$apilogid.*submit.*AsyncJobVO.*DomainRouter.*cmd:" | tr -d ',' | cut -d' ' -f21
}

function vrjobs() {
    vrid=$1
    search "submit.*AsyncJobVO.*DomainRouter.*$vrid.*cmd:" | tr -d ',' | cut -d' ' -f10
}

function jobvr() {
    topjob=$1
    search "submit.*$topjob.*AsyncJobVO.*DomainRouter.*cmd:" | tr -d ',' | cut -d' ' -f21
}

function rebootonlyjobs() {
     search "No need to recreate" | cut -d' ' -f6 | cut -d'/' -f1
}
function upgradeonlyjobs() {
    search "Sending.*CopyCommand.*destTO.*VolumeObjectTO" | cut -d' ' -f6 | cut -d'/' -f1
}

function jobsummary() {
    topjob="$1"
    host=$(jobhost $topjob)
    primary=$(jobprimarystore $topjob)
    echo "$topjob,$host,$primary"
}
function printpatternlog() {
    pattern="$1"
    log="$2"
    if [ "$2" == "" ]; then
        log=$(search "$pattern")
    fi
    prefix=$(echo "$log" | cut -d' ' -f1-3)
    #echo "$prefix $pattern"
    echo "$prefix" | xargs -I{} echo "{} $pattern"
}
function printjustlog() {
    #just print log
    if [ "$2" == "" ]; then
        search "$1"
    else
        echo "$2"
    fi;
}
function printpattern() {
    if [ "$logpattern" == "true" ]; then
        printpatternlog "$1" "$2"
    else
        printjustlog "$1" "$2"
    fi
}

function jobdetails() {

    topjob=$1
    #search $topjob | grep "^.*submit.*cmdInfo" -o | cut -d' ' -f2,10,20,21,23
    asyncjobpattern="$topjob).*Executing AsyncJobVO"
    topasyncjob=$(search "$asyncjobpattern")
    printpattern "$asyncjobpattern"  "$topasyncjob"

    logid=$(echo "$topasyncjob" | cut -d' ' -f7 | tr ':)' ' ' | cut -d' ' -f2)
    #echo $logid
    #search "$topjob).*Executing AsyncJobVO" | cut -d' '  -f1,2,6,8,9,17-20
    subjob1=$(search "$topjob.*Sync job.*execution" -o | cut -d' ' -f5 | head -n1)

    #VMWorkStop initiated
    vmstoppattern="$subjob1.*Executing.*Cmd"
    stopcmdlog=$(search "$vmstoppattern")
    printpattern "$vmstoppattern" "$stopcmdlog"
    stopseqid=$(echo "$stopcmdlog" | cut -d' ' -f 10)
    printpattern "$subjob1.*$stopseqid.*Received"

    #VMWorkStop complete
    printpattern "$topjob.*release resource"
    printpattern "$subjob1.*Remove"


    #VMWorkstartCmd
    subjob2=$(search "$topjob.*Sync job.*execution" -o | cut -d' ' -f5 | tail -n1)
    printpattern "$subjob2.*Executing AsyncJobVO"
    #Deplyment Planner details
    printpattern "$topjob.*Returning Deployment"

    #prepare network completion
    printpattern "$topjob.*prepare network"

    #volume activity started
    printpattern "$topjob.*working on volume"
    printpattern "$topjob.*createVolumeFromTemplateAsync"
    #search "$topjob.*is already copied"

    #copy command
    #check if template copy is involved
    #search "$topjob.*.*Sending.*CopyCommand"

    #template copy command
    #copycmdlog=$(search "$topjob.*Sending.*CopyCommand")
    copycmdpattern="$topjob.*Sending.*CopyCommand.*destTO.*TemplateObjectTO"
    copycmdlog=$(search "$copycmdpattern")
    if [ "$copycmdlog" != "" ]; then
        printpattern "$copycmdpattern" "$copycmdlog"
        copyseqid=$(echo "$copycmdlog" | cut -d' ' -f10)
        printpattern "$subjob2.*$copyseqid.*Received"
    else
        ##templateprefix=$(search "$subjob2.*lock is acquired" | cut -d' ' -f1-2)
        ##printpattern " " "$templateprefix $copycmdpattern" 
        ##printpattern " " "$templateprefix $subjob2.*Received" 
        #echo "$topasyncjob" | cut -d' ' -f1-3
        #echo "$topasyncjob" | cut -d' ' -f1-3
        DO='NOTHING'
    fi
    #volume copy command
    volumecopypattern="$topjob.*Sending.*CopyCommand.*destTO.*VolumeObjectTO"
    copycmdlog=$(search "$volumecopypattern")
    #check reboot case -- no volume creation
    if [ "$copycmdlog" != "" ]; then
        printpattern "$volumecopypattern" "$copycmdlog"
        copyseqid=$(echo "$copycmdlog" | cut -d' ' -f10)
        printpattern "$subjob2.*$copyseqid.*Received"
    fi;

    #incase volume is not created
    printpattern "$subjob2.*No need to recreate the volume"

    #acquire lock
    printpattern "$subjob2.*Acquire lock"
    printpattern "$subjob2.*lock is acquired"
    printpattern "$subjob2.*releasing lock"


    #start command 
    startcmdpattern="^.*$topjob.*.*Sending.*StartCommand"
    startcmdlog=$(search "$startcmdpattern" -o)
    printpattern "$startcmdpattern" "$startcmdlog"

    startseqid=$(echo "$startcmdlog" | cut -d' ' -f10)
    printpattern "$subjob2.*$startseqid.*Received"

    #controlip=$(search "$startseqid.*Processing" | grep -o "eth1ip.*eth1mask"| tr '=' ' ' | cut -d' ' -f2)
    #echo $controlip

    printpattern "$logid.*Ping command port"
    printpattern "$logid.*Executing.*vr_cfg"

    printpattern "$topjob[ |)].*Complete async"
}
function alljobdetails() {
    topjobs | while read line; do jobdetails $line; done
}

function jobdetailsseq() {

    topjob=$1
    jobdetailstr=$(jobdetails "$topjob")
    sequencetime "$jobdetailstr" | sort -n #|  cut -d' ' -f1-3,9-18
}

function dbydx() {
    topjob=$1
    jobdetailsseq $topjob | cut -d' ' -f1 | awk '{a[i]=$1; d[i]=a[i]-a[i-1];i++}END {for (n=0; n<i; n++) print d[n]}'
}

function jobprimarystore() {
    topjob="$1"
    #search "$topjob.*Executing.*destTO.*\"port" -o  | grep -o "path.*," | tr -d '"' | sed -e 's|/|\n|g' | grep "^.*,$" | tr -d ','
    search "$topjob.*Executing.*PrimaryDataStoreTO.*volumeId" -o | grep "path.*,\"port" -o | tr -d '"' | cut -d, -f1 | sed -e 's|/|\n|g' | tail -n1
    #search "$topjob.*Executing.*PrimaryDataStoreTO.*volumeId" -o | grep "PrimaryDataStoreTO.*,\"port" -o | tr -d '"'  |  sed -e 's|/|\n|g' | tail -n1 | cut -d, -f1


}

function listprimarystores() {
   search "destTO.*\"port" -o  | grep -o "path.*," | tr -d '"' | sed -e 's|/|\n|g' | grep "^.*,$" | sort -u | tr -d ','
}

function primarystorejobs() {
    #primarystore="pri4_xen_reg"
    primarystore="$1"
    search "org.apache.cloudstack.storage.to.TemplateObjectTO" | grep "Executing:.*" | grep "$primarystore"| grep "job-...../" -o | tr -d '/' | uniq
#ori4_xen_reg"
}
function allprimarystorejobs() {
    listprimarystores | while read line;do echo $line; primarystorejobs $line; done
}

function showcumulativetable() {
    topjob="$1"
    summary=$(jobsummary $topjob)
    echo -n "$summary,"
    jobdetailsseq $topjob | cut -d' ' -f1 | paste -s -d','
}
function showdbydxtable() {
    topjob="$1"
    summary=$(jobsummary $topjob)
    echo -n "$summary,"
    dbydx $topjob | paste -s -d','
}
