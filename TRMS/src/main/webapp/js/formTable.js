fillRow = function(tableRow, dbRow) {
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
	tableCell0.innerHTML = dbRow.eventId;
	tableCell1.innerHTML = dbRow.employeeId;
	//tableCell2.innerHTML = dbRow.eventType;
	tableCell3.innerHTML = dbRow.dateAndTime;
	console.log("dateAndTime:");
	console.log(dbRow.dateAndTime);
	tableCell4.innerHTML = dbRow.eventLocation;
	/*tableCell5.innerHTML = dbRow.
	tableCell6.innerHTML = dbRow.
	tableCell7.innerHTML = dbRow.
	tableCell8.innerHTML = dbRow.
	tableCell9.innerHTML = dbRow.
	tableCell10.innerHTML = dbRow.
	tableCell11.innerHTML = dbRow.
	tableCell12.innerHTML = dbRow.
	tableCell13.innerHTML = dbRow.
	tableCell14.innerHTML = dbRow.*/
}