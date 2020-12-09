window.onload = function() {
	console.log("approve_deny_reimbursements.js window.onload");
	getRows();
}


getRows = function() {
	let xhttp = new XMLHttpRequest();

	xhttp.onreadystatechange = function() {
		console.log("the ready state has changed");
		if (xhttp.readyState == 4 && xhttp.status == 200) {
			let rows = JSON.parse(xhttp.responseText);
			console.log(rows);
			// Call row creation method
			displayRows(rows);
		}
	}
	xhttp.open("GET", "http://localhost:8080/TRMS/getforms.json");

	xhttp.send();
}

// Implement row creation method
displayRows = function(dbRows) {
	table = document.getElementById("reimburseReqTable");
	for (var i = dbRows.length - 1; i > -1; i--) {
		tableRow = table.insertRow(1);
		tableCell0 = tableRow.insertCell(0);
		tableCell1 = tableRow.insertCell(1);
		tableCell2 = tableRow.insertCell(2);
		tableCell3 = tableRow.insertCell(3);
		tableCell4 = tableRow.insertCell(4);

		tableCell0.innerHTML = dbRows[i].eventId;
		tableCell4.innerHTML = dbRows[i].eventLocation;
	}
}