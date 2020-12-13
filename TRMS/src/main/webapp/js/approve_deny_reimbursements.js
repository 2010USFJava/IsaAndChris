window.onload = function() {
	console.log("approve_deny_reimbursements.js window.onload");
	makeRequest("http://localhost:8080/TRMS/getforms.json", displayRows); // In xhr.js
}

// Implement row creation method
displayRows = function(dbRows) {
	table = document.getElementById("reimburseReqTable");
	for (var i = dbRows.length - 1; i > -1; i--) {
		tableRow = table.insertRow(1);
		fillRow(tableRow, dbRows[i]);
		tableCell6 = tableRow.insertCell(6);
		tableCell7 = tableRow.insertCell(7);
		tableCell8 = tableRow.insertCell(8);

		approveButton = document.createElement("button");
		approveButton.classList.add("btn");
		approveButton.classList.add("btn-success");
		approveButton.innerHTML = "Approve";
		tableCell6.appendChild(approveButton);
		createApproveFunction(approveButton, dbRows[i].eventId);
		denyButton = document.createElement("button");
		denyButton.innerHTML = "Deny";
		denyButton.classList.add("btn");
		denyButton.classList.add("btn-danger");
		tableCell7.appendChild(denyButton);
		createDenyFunction(denyButton, dbRows[i].eventId);
		updateButton = document.createElement("button");
		updateButton.innerHTML = "Request More Info";
		updateButton.classList.add("btn");
		updateButton.classList.add("btn-info");
		tableCell8.appendChild(updateButton);
	}
}

createApproveFunction = function(button, eventId) {
	button.onclick = function() {
		postBody("/TRMS/raiseapprovallevel.change", eventId);
		row = button.parentElement.parentElement;
		table = row.parentElement;
		table.removeChild(row);
	}
}

createDenyFunction = function(button, eventId) {
	button.onclick = function() {
		postBody("/TRMS/denyevent.change", eventId);
		row = button.parentElement.parentElement;
		table = row.parentElement;
		table.removeChild(row);
	}
}