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
		tableCell5 = tableRow.insertCell(5);
		tableCell6 = tableRow.insertCell(6);
		tableCell7 = tableRow.insertCell(7);
		tableCell8 = tableRow.insertCell(8);

		tableCell0.innerHTML = dbRows[i].eventId;
		tableCell4.innerHTML = dbRows[i].eventLocation;
		approveButton = document.createElement("button");
		approveButton.innerHTML = "Approve";
		tableCell6.appendChild(approveButton);
		denyButton = document.createElement("button");
		denyButton.innerHTML = "Deny";
		tableCell7.appendChild(denyButton);
		updateButton = document.createElement("button");
		updateButton.innerHTML = "Request More Info";
		tableCell8.appendChild(updateButton);
	}
}

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
				case 2:
					getRows();
					break;
				case 4:
					getRows();
					break;
			}
		}
	}
	xhttp.open("GET", "http://localhost:8080/TRMS/getsession.json");

	xhttp.send();
}