
const request = require('request');


request1 = function(uri, timeout) {
    return request.get({
        uri: uri,
        timeout: setTimeout(function() {}, 10)
    });

    //return error, response, body;
};

// get_cluster_health( function(status) {
// 	console.log("End callback ##### status = ", status);
// });


function testReq1() {

	result = request1("http://172.18.69.160:9000/v1/cluster/health?inline=true", 3000);
	//console.log("response ", result);

}

testReq1();