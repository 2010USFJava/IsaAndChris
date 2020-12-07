window.onload = function() {
	console.log("window.onload");
	console.log(getUser());
}

/*getUser = function() {
	fetch("http://localhost:8080/TRMS/getsession.json", {
		credentials: "include"
	})
		.then(function(response) {
			console.log("home.js getUser response = " + response);
			return response.json();
		}, function() {
			console.log("getUser JS failure");
		})
}*/

function getUser() {
	let xhttp = new XMLHttpRequest();

	xhttp.onreadystatechange = function() {
		console.log("the ready state has changed");
		if (xhttp.readyState == 4 && xhttp.status == 200) {
			let user = JSON.parse(xhttp.responseText);
			let name = user.firstName + " " + user.lastName;
			console.log("xhr getUser = " + name);
			document.getElementById("usersName").innerHTML = name;
		}
	}
	xhttp.open("GET", "http://localhost:8080/TRMS/getsession.json");

	xhttp.send();
}