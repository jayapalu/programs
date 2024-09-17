var events  = require("events");

//event emitter creation
var eventEmitter = new events.EventEmitter();

// Event handler function
var connectHandler = function connected() {

	console.log("connected function");

	//eventEmitter.emit('data_received');
	  eventEmitter.emit('data_received');

	console.log("secondEvent call done");
}

//bind annother event 

eventEmitter.on('data_received', function() {
   console.log('data received succesfully.');
});


//bind the event name with event handler
eventEmitter.on('EventNameConnection', connectHandler);
eventEmitter.emit('EventNameConnection');

console.log("program End");



// var events = require('events');

// // Create an eventEmitter object
// var eventEmitter = new events.EventEmitter();

// // Create an event handler as follows
// var connectHandler = function connected() {
//    console.log('connection succesful.');
  
//    // Fire the data_received event 
//    eventEmitter.emit('data_received');
// }

// // Bind the connection event with the handler
// eventEmitter.on('connection', connectHandler);
 
// // Bind the data_received event with the anonymous function
// eventEmitter.on('data_received', function() {
//    console.log('data received succesfully.');
// });

// // Fire the connection event 
// eventEmitter.emit('connection');

// console.log("Program Ended.");