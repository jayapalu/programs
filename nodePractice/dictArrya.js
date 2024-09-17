

const http = require('http');
const request = require('request');

var servers = {};


servers[0] = {ipAddr: "192.168.1.2", port: "8000"};
// servers[1] = {ipAddr: "192.168.1.3", port: "8001"};

// servers[2] = {ipAddr: "192.168.1.4", port: "8001"};
// // servers[3] = {ipAddr: "192.168.1.5", port: "8001"};
// // servers[4] = {ipAddr: "192.168.1.6", port: "8001"};
// // servers[5] = {ipAddr: "192.168.1.7", port: "8001"};
// // servers[6] = {ipAddr: "192.168.1.8", port: "8001"};
// // servers[7] = {ipAddr: "192.168.1.9", port: "8001"};


name = "shndlpapi";

if (name.indexOf(":") !== -1) {
	console.log(" server name ", name);
}else {
	console.log(" server name does not contain : ")
}


 //var servers = {};
 //servers ={"0": {"ipAddr":"172.18.68.47", "port": 9000}};

const dictionaryLength = Object.keys(servers).length;

console.log("dictionary lenght =%d and dict = %o", dictionaryLength, servers);

const randomIndex1 = Math.floor(Math.random() * dictionaryLength);

console.log("random key1  ", randomIndex1);
randomIndex2 = Math.floor(Math.random() * dictionaryLength);

  // while (randomIndex2 == randomIndex1) {
  // 	console.log("random key2 ###### is same");
  //   randomIndex2 = Math.floor(Math.random() * dictionaryLength);
  // }

console.log("random key2  ", randomIndex2);


let array1 = [randomIndex1, randomIndex2];
console.log("array  ", array1);

for (const val of array1) {
	console.log("val  ", val);

}




console.log(servers);


let success = false;
var i = 0;


 func1 = function(cb) {

for (i in servers) {

	console.log("server ----", servers[i]);

	makeRequest("uri", function(error, response) {

		console.log("inside call back <<<<< ");

		if (error != 200) {
			console.log("error returned");
		}else {
			console.log(error);
			console.log(response);
			//success = true;
		}
	});


	if (success == true) {
		console.log("makeRequest is success ... breaking the loop");
		break;
	}	


}

	
	console.log("returning from func --------");
	return cb(success);
}


function makeRequest(uri, cb) {

	console.log("calling the makeRequest function ##########");
	
	console.log(uri);
	cb(200, "192.168.1.2###");

}

func1(function(status) {

	console.log("Final status ", status);

});
