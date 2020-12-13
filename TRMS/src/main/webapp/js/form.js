window.onload=function(){
	getForm();
}

function getForm() {
	console.log("in get form");

	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function () {
		console.log("in on ready state change");
		if (xhr.readyState == 4 && xhr.status == 200) {
			console.log(xhr.responseText);
			var form = JSON.parse(xhr.responseText);
		//	loadForm(form);
			//displayForm(form);
			loadForms(form);
			
		}
	}
	xhr.open("GET", "http://localhost:8080/TRMS/form.change", true);
	xhr.send();
}


function displayForms(form){  //pass in already parsed json
    var obj = form;//this is kind of useless but obj is shorter lol
    $.each(obj, function(key,value) { //for each object in reqList:(index, json )
        console.log(key);
        console.log(value.requestId); //json.parameter, will pass in the value associated with the parameter
        optionText = value.requestId; //stores the seen text in option
        optionValue = value.requestId; //stores a value that is passed in when this option is chosen
        $('#sreq').append(`<option value="${optionValue}">${optionText}</option>`);
         //^^^
        });
}

function loadForm(form){

	let header = form;
	let col = [];
	  for (var i = 0; i < header.length; i++) {
        for (var key in abc[i]) {
            if (col.indexOf(key) === -1) {
                col.push(key);
            }
        }
    }
	let table = document.getElementById("employee-table");
	table.classList.add("employee-table");
	table.classList.add("table table-striped text-white");
	
	var tr = table.insertRow(-1);
	for(var i = 0; i < col.length; i++){
		var th = document.createElement("th");
		th.classList.add("thread-dark");
		th.innerHTML = col[i];
		tr.appendChild(th);
	}
	
	for(var i = 0; i < header.length; i++){
		for(var j = 0; j < col.length; j++){
			var cell = tr.insertCell(-1);
			cell.innerHTML = header[i][col[j]];
		}
	}
	
	var div = document.getElementById("col");
	div.innerHTML = "";
	div.appendchild(table);
	
}



function loadForm1(form) {
	document.getElementById("field1").innerHTML = form.formFirst;
	document.getElementById("field2").innerHTML = form.formLast;
	document.getElementById("inputGroupSelect01").innerHTML = form.formEvent;
	document.getElementById("field4").innerHTML = form.formDate;
	//document.getElementById("field5").innerHTML = form.formTime;
	document.getElementById("field5").innerHTML = form.formLocation;
	document.getElementById("field6").innerHTML = form.formCost;
	document.getElementById("field7").innerHTML = form.formFormat;
	document.getElementById("field8").innerHTML = form.formGrade;
	document.getElementById("field9").innerHTML = form.formDescript;
	document.getElementById("field10").innerHTML = form.formJustif;
	document.getElementById("disabledInput").innerHTML = form.formProjected;
	document.querySelector('#file-upload1').addEventListener('change', event => { handleFileUpload(event) });
	document.querySelector('#file-upload2').addEventListener('change', event => { handleFileUpload(event) });
	getAmount(form);
	//file uploads
}



function loadForms(tableRow, form){
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
	tableCell0.innerHTML = form.eventId;
	tableCell1.innerHTML = form.employeeId;
		var date = new Date(form.dateAndTime)
	tableCell3.innerHTML = date.getFullYear() + "/" + (date.getMonth() + 1) + "/" + date.getDate();
}


