window.onload = function() {
	console.log("window");
	getVillain();
}

function getVillain() {
	let xhr = new HMLHttpRequest();

	xhr.onreadystatechange = function() {
		console.log("the ready state has changed");
		if (xhr.readyState == 4 && xhr.status == 200) {
			let vill = JSON.parse(xhr.responseText);
			console.log(vill);
		}
	}
	xhr.open("GET", "http://localhost:8080/ExampleFrontController/getsession.json");
	xhr.send();
}