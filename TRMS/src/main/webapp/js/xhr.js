makeRequest = function(address, func) {
	let xhttp = new XMLHttpRequest();

	xhttp.onreadystatechange = function() {
		console.log("the ready state has changed to " + xhttp.readyState + ", and status " + xhttp.status);
		if (xhttp.readyState == 4 && xhttp.status == 200) {
			let result = JSON.parse(xhttp.responseText);
			console.log("makeRequest - result:")
			console.log(result);
			func(result);
		}
	}
	xhttp.open("GET", address);

	xhttp.send();
}

postBody = function(address, body) {
	let xhttp = new XMLHttpRequest();

	xhttp.onreadystatechange = function() {
		console.log("the ready state has changed to " + xhttp.readyState + ", and status " + xhttp.status);
		if (xhttp.readyState == 4 && xhttp.status == 200) {
			console.log("postBody = success");
		}
	}
	xhttp.open("POST", address);

	xhttp.send(body);
}