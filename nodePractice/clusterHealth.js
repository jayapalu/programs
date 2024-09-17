
const http = require('http');
const request = require('request');

get_zeus_cluster_health = function (cb) {

const server = { 
    notes: {
      health_check: {
        FAIL: 'True',
        OK: 'True'
      }
    }
};



	   let zeus_cluster_health_status = {
        overAllHealthStatus : "N/A"
    	}


	var zeus_host_info = {};

	zeus_host_info[0] = {ipAddr: "172.18.69.160", port: "9000"};
	zeus_host_info[1] = {ipAddr: "172.18.68.215", port: "9000"};


    var hostIndex = 0;
    let indexArray = [];

    const dictionaryLength = Object.keys(zeus_host_info).length;

    //we need to search random zeus nodes to avoid health check failures status.
    if (dictionaryLength >  2) {
        const randomIndex1 = Math.floor(Math.random() * dictionaryLength);
        let randomIndex2 = Math.floor(Math.random() * dictionaryLength);
        while (randomIndex2 === randomIndex1) {
            randomIndex2 = Math.floor(Math.random() * dictionaryLength);
        }
        indexArray[0] = randomIndex1;
        indexArray[1] = randomIndex2;
    } else if (dictionaryLength === 2) {
          indexArray[0] = 0;
          indexArray[1] = 1;

    } else if (dictionaryLength === 1) {
        indexArray[0] = 0;
    }

    console.log("zeus host array indexes ", indexArray)
    for (let hostIndex of indexArray) {

    var zeus_cluster_health_uri = 'http://' + zeus_host_info[hostIndex].ipAddr + ':'
        + zeus_host_info[hostIndex].port + "/v1/cluster/health" + "?inline=true";
    console.log("zeus_cluster_health_uri = %s", zeus_cluster_health_uri);
    make_request(zeus_cluster_health_uri, 30000, function (error, response, body) {

    	console.log("make_request callback start >>>>> ");

        if (error || !response || response.statusCode != 200) {
            console.log('Zeus cluster failure status= Error when making zeus cluster heath request to %s, response code: %d,',
                zeus_cluster_health_uri, response ? response.statusCode : -1, error);
            zeus_cluster_health_status.overAllHealthStatus = server.notes.health_check.FAIL;
        } else {
            //console.log('zeus cluster health response body = %s', body);
            var zeus_cluster_status = JSON.parse(body);
            
            if (zeus_cluster_status.status == 'UP') {
                zeus_cluster_health_status.overAllHealthStatus = server.notes.health_check.OK;
            } else {
            	zeus_cluster_health_status.overAllHealthStatus = server.notes.health_check.FAIL;
            	let statusMessage;
            	let keys = [];
            	for (let i of Object.keys(zeus_cluster_status)) {
            	if(i != "status"){
                     keys.push(i);
                  }
                }
                for(let key of keys){
                	let values = zeus_cluster_status[key];
                	let hostNameStatus =  values['status'];
                	if(hostNameStatus != "UP"){
                		if( statusMessage == null){
                			statusMessage = "Host name: "+key ;
                		}else{
                            statusMessage = statusMessage + "\n";
                            statusMessage = statusMessage +  "Host name: "+key ;
                        }
                        statusMessage = statusMessage + " status: "+ hostNameStatus + " ";
                        for(let nestedKey of Object.keys(values)){
                        	if(nestedKey != "status"){
                        		statusMessage = statusMessage +" "+nestedKey;
                        		let components = values[nestedKey];
                        		for(let componentKey of Object.keys(components)){
                        			if(componentKey == "status"){
                        				statusMessage = statusMessage + ":" + components['status'] + ",";
                        			}
                        		}
                        	}
                        }
                	}
                }
                if(statusMessage == null){
                    statusMessage = JSON.stringify(zeus_cluster_health_status)
                }
                console.log("Zeus cluster failure status= %s", statusMessage);
            }
        }

	console.log(' status before condition for cb = ', zeus_cluster_health_status.overAllHealthStatus);
    if(zeus_cluster_health_status.overAllHealthStatus == server.notes.health_check.OK ) {
         console.log(' hostIndex = %d, health status = %s calling call back', hostIndex, zeus_cluster_health_status);
         return cb(zeus_cluster_health_status)
    }

        console.log("make_request callback END <<<< ");
    }); // make_request end

    console.log(' for loop iteration end status ', zeus_cluster_health_status.overAllHealthStatus);

    // if(zeus_cluster_health_status.overAllHealthStatus == server.notes.health_check.OK) {
    //     break;
    // }

    console.log(' for loop iteration end hostIndex >>> ', hostIndex);

    } //for

    console.log("function return <<<<<")
    //return cb(zeus_cluster_health_status);
} //function




make_request = function(uri, timeout, cb) {
    request.get({
        uri: uri,
        timeout: timeout
    }, cb);
};


get_zeus_cluster_health( function(status) {
	console.log("End callback ##### status = ", status);
});