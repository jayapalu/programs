const request = require('request');

  const host_info = [
    { ipAddr: "172.18.69.160", port: "9000" },
    { ipAddr: "172.18.68.215", port: "9000" }
    
  ];

function get_cluster_health(cb) {


  let callbackCalled = false;

  const requests = host_info.map((host) => {
    const uri = `http://${host.ipAddr}:${host.port}/v1/cluster/health?inline=true`;

    return new Promise((resolve, reject) => {
      if (!callbackCalled) {
        console.log("callbackCalled = false ======== calling request1 ");
      request1(uri, 30000, function (error, response, body) {
        if (error || !response || response.statusCode !== 200) {
          console.log("Error occurred for the uri", uri);
          resolve(false); // Resolve with false on error
        } else {
          console.log("Status success ");
          if (!callbackCalled) {
            console.log("Status success. Calling cb ");
            cb(true); // Call the callback only once on success
            callbackCalled = true;
          }else{
            console.log("already called skipping ");

          }
          resolve(true); // Resolve with true on success
        }
      });

    }
    });
  });

  // Wait for the first promise to resolve (race condition)
  Promise.all(requests)
    .then((status) => {
      console.log("In promise status = ",status);

      if (!status || status.length == 0) {
        console.log("all requests are empty ######## ");
        cb(false);
      }

      flag = false;
      for (var s of status) {
        if(s == true){
          console.log("one of the status is true #### break");
          flag = true;
          break;
          
        }
      }

      if (flag == false) {
        console.log("both status are false ##### flag = false");
        cb(false);

      }
    })
    .catch((error) => {
      console.error("Error in Promise.race:", error);
      //if (!callbackCalled) {
        cb(false);
      //}
    });
}

function request1(uri, timeout, cb) {
  console.log("request1 is called == uri ", uri);
  request.get({
    uri: uri,
    timeout: setTimeout(function () {}, 10)
  }, cb);
  console.log(">>>>>>>>> request1 Completed ###  uri ", uri);
}

get_cluster_health(function (status) {
  console.log("End callback ##### status = ", status);
});
