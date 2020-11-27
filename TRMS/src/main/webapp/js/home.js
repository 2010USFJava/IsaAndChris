window.onload = function () {
	console.log("window.onload");
	getUser();
}

getUser = function() {
	fetch ("http://localhost:8080/TRMS/getsession.json")
	.then(function(response){
		console.log(response);
		return response.json();
	}, function(){
		console.log("getUser JS failure");
	})
}