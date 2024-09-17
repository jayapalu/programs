const request = require('request');

var status = false;
get_cluster_health = function (cb) {

	host_info = {};

	host_info[0] = {ipAddr: "172.18.69.160", port: "9000"};
	host_info[1] = {ipAddr: "172.18.68.215", port: "9000"};


	 for (let hostIndex of [0,1]) {

	   var uri = 'http://' + host_info[hostIndex].ipAddr + ':'
        + host_info[hostIndex].port + "/v1/cluster/health" + "?inline=true";


            request1(uri, 30000, function (error, response, body) {

            	 if (error || !response || response.statusCode != 200) {
            	 	console.log("error occured");
            		status = false;

            	}else {
            		status = true;
            	}

            	if (status == true) {
            		console.log("status success calling cb ");
            		return cb(status);
            	}

            });

      console.log("For loop iteration ", hostIndex);
	 }

	 console.log(" End of function ", status);

}

request1 = function(uri, timeout, cb) {
    request.get({
        uri: uri,
        timeout: setTimeout(function() {}, 10)
    }, cb);
};

get_cluster_health( function(status) {
	console.log("End callback ##### status = ", status);
});