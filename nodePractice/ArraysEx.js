
var array1 = [2];

for (const i of array1) {
	console.log("Values of array ",i );
}


servers = {};


// servers[0] = {ipAddr: "192.168.1.2", port: "8000"};
// servers[1] = {ipAddr: "192.168.1.3", port: "8001"};

// servers[2] = {ipAddr: "192.168.1.4", port: "8001"};

	servers ={"0": {"ipAddr":"172.18.68.47", "port": 9000}};
    
    var hostIndex = 0;
    let indexArray = [];

    const dictionaryLength = Object.keys(servers).length;

    if (dictionaryLength >  2) {
        const randomIndex1 = Math.floor(Math.random() * dictionaryLength);
        let randomIndex2 = Math.floor(Math.random() * dictionaryLength);
        while (randomIndex2 === randomIndex1) {
            randomIndex2 = Math.floor(Math.random() * dictionaryLength);
        }
        indexArray[0] = randomIndex1;
        indexArray[1] = randomIndex2;
    } else if (dictionaryLength === 2){
          indexArray[0] = 0;
          indexArray[1] = 1;

    }else if (dictionaryLength === 1) {
        indexArray[0] = 0;

    }

    console.log("indexArray  ", indexArray );



    var server1 = {};

    if (!server1 || server1 == undefined ) {
    	console.log(" #### server1  ", server1 );
    }

