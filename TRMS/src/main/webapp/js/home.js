window.onload = function() {
	console.log("home.js window.onload");
	makeRequest("http://localhost:8080/TRMS/getsession.json", displayMenu); // In xhr.js
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

displayMenu = function(user) {
	let name = user.firstName + " " + user.lastName;
	document.getElementById("usersName").innerHTML = name;
	switch (user.jobTitleCode) {
		case 1:
			document.getElementById("employeeMenu").style.display = "block";
			break;
		case 2:
			document.getElementById("dirSuperMenu").style.display = "block";
			break;
		case 3:
			document.getElementById("depHeadMenu").style.display = "block";
			break;
		case 4:
			document.getElementById("benCoMenu").style.display = "block";
			break;
	}
}