window.onload = function() {
	console.log("approve_deny_reimbursements.js window.onload");
	makeRequest("http://localhost:8080/TRMS/employeeforms.json", displayRows); // In xhr.js
}

// Implement row creation method
displayRows = function(dbRows) {
	table = document.getElementById("reimburseReqTable");
	for (var i = dbRows.length - 1; i > -1; i--) {
		tableRow = table.insertRow(1);
		fillRow(tableRow, dbRows[i]);



		approveButton = document.createElement("button");
		approveButton.classList.add("btn");
		approveButton.classList.add("btn-success");
		approveButton.innerHTML = "Update";
		tableCell13.appendChild(approveButton);
		createApproveFunction(approveButton, dbRows[i].eventId);

	}
}

createApproveFunction = function(button, eventId) {
	button.onclick = function() {
		postBody("/TRMS/updateform.change", eventId);
		row = button.parentElement.parentElement;
		table = row.parentElement;
		table.removeChild(row);
	}
}

