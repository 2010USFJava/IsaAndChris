window.onload = function() {
	console.log("confirm_grade_presentation.js window.onload");
	makeRequest("http://localhost:8080/TRMS/getsession.json", getUser);
}

getUser = function(user) {
	switch (user.jobTitleCode) {
		case 2:
			makeRequest("http://localhost:8080/TRMS/getforms.json", displayRowsAndDirSuperButtons);
			break;
		case 4:
			makeRequest("http://localhost:8080/TRMS/getforms.json", displayRowsAndBenCoButtons);
			break;
	}
}

fillRow = function(tableRow, dbRow) {
	tableCell0 = tableRow.insertCell(0);
	tableCell1 = tableRow.insertCell(1);
	tableCell2 = tableRow.insertCell(2);
	tableCell3 = tableRow.insertCell(3);
	tableCell4 = tableRow.insertCell(4);
	tableCell5 = tableRow.insertCell(5);
	tableCell0.innerHTML = dbRow.eventId;
	tableCell3.innerHTML = dbRow.eventLocation;
}

displayRowsAndBenCoButtons = function(dbRows) {
	table = document.getElementById("reimburseReqTable");
	for (var i = dbRows.length - 1; i > -1; i--) {
		tableRow = table.insertRow(1);
		fillRow(tableRow, dbRows[i]);
		tableCell6 = tableRow.insertCell(6);
		tableCell7 = tableRow.insertCell(7);

		approveButton = document.createElement("button");
		approveButton.innerHTML = "Approve";
		tableCell6.appendChild(approveButton);
		denyButton = document.createElement("button");
		denyButton.innerHTML = "Deny";
		tableCell7.appendChild(denyButton);
	}
}

displayRowsAndDirSuperButtons = function(dbRows) {
	table = document.getElementById("reimburseReqTable");
	for (var i = dbRows.length - 1; i > -1; i--) {
		tableRow = table.insertRow(1);
		fillRow(tableRow, dbRows[i]);
		tableCell6 = tableRow.insertCell(6);
		tableCell7 = tableRow.insertCell(7);
		
		approveButton = document.createElement("button");
		approveButton.innerHTML = "Approve";
		tableCell6.appendChild(approveButton);
		denyButton = document.createElement("button");
		denyButton.innerHTML = "Deny";
		tableCell7.appendChild(denyButton);
	}
}
