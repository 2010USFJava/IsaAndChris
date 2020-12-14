fillRow = function(tableRow, dbRows) {
	tableCell0 = tableRow.insertCell(0);
	tableCell1 = tableRow.insertCell(1);
	tableCell2 = tableRow.insertCell(2);
	tableCell3 = tableRow.insertCell(3);
	tableCell4 = tableRow.insertCell(4);
	tableCell5 = tableRow.insertCell(5);
	tableCell6 = tableRow.insertCell(6);
	tableCell7 = tableRow.insertCell(7);
	tableCell8 = tableRow.insertCell(8);
	tableCell9 = tableRow.insertCell(9);
	tableCell10 = tableRow.insertCell(10);
	tableCell11 = tableRow.insertCell(11);
	tableCell12 = tableRow.insertCell(12);
	tableCell13 = tableRow.insertCell(13);
	tableCell14 = tableRow.insertCell(14);
	tableCell0.innerHTML = dbRows.eventId;
	tableCell1.innerHTML = dbRows.employeeId;
	tableCell2.innerHTML = dbRows.eventType;
	var date = new Date(dbRows.dateAndTime)
	tableCell3.innerHTML = date.getFullYear() + "/" + (date.getMonth() + 1) + "/" + date.getDate();
	tableCell4.innerHTML = dbRows.eventLocation;
	tableCell5.innerHTML = dbRows.eventCost;
	tableCell6.innerHTML = dbRows.gradeFormat;
	tableCell7.innerHTML = dbRows.description;
	tableCell8.innerHTML = dbRows.justification;
	tableCell9.innerHTML = dbRows.hasApprovalEmail;
	tableCell10.innerHTML = dbRows.approval;
	tableCell11.innerHTML = dbRows.projectedAmount;
	tableCell12.innerHTML = dbRows.passingGrade;
	tableCell13.innerHTML = dbRows.approvalLevel;


}