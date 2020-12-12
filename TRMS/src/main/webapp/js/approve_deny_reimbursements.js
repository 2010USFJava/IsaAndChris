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

		tableCell0.innerHTML = dbRows[i].eventId;
		tableCell3.innerHTML = dbRows[i].eventLocation;
		approveButton = document.createElement("button");
		approveButton.innerHTML = "Approve";
		tableCell6.appendChild(approveButton);
		(function(eventId, approvallevel) {
			approveButton.onclick = postBody("/TRMS/eventapproval.change", "eventId=" + eventId + "&approvallevel=" + approvallevel);
		}(dbRows[i].eventId, dbRows[i].approvallevel));
		denyButton = document.createElement("button");
		denyButton.innerHTML = "Deny";
		tableCell7.appendChild(denyButton);
		updateButton = document.createElement("button");
		updateButton.innerHTML = "Request More Info";
		tableCell8.appendChild(updateButton);
	}
}