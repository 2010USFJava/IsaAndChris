window.onload = function() {
	console.log("home.js window.onload");
	getUser();
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
			console.log(user);
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
	}
	xhttp.open("GET", "http://localhost:8080/TRMS/getsession.json");

	xhttp.send();
}