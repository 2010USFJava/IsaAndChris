function loadForm(form) {
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

document.querySelector('#file-upload1').addEventListener('change', event => { handleFileUpload(event) });
document.querySelector('#file-upload2').addEventListener('change', event => { handleFileUpload(event) });
document.querySelector('#field8').addEventListener('change'), event => {getCheckbox(event)};
document.querySelector('#field7').addEventListener('change'), event => {displayCheckboc(event)};

function getAmount(){
	document.getElementById("field6").value = parseFloat(document.getElementById("field6").value).toFixed(2);
	var amount = document.getElementById("field6").value;
	var event = document.getElementById("inputGroupSelect01")

	document.getElementById("field6").addEventListener('change', getAmount());
	document.getElementById('inputGroupSelect01').addEventListener('change', getAmount());
	
	switch(event){
		case "universitycourse":
			document.getElementById("field6").value = parseFloat((amount * .6)).toFixed(2);
			document.getElementById("disabledInput").value = parseFloat((amout * .6)).toFixed(2);
			document.getElementById("disabledInput").style.display;
			break;
		case "seminar":
			document.getElementById("field6").value = parseFloat((amount * .6)).toFixed(2);
			document.getElementById("disabledInput").value = parseFloat((amout * .6)).toFixed(2);
			document.getElementById("disabledInput").style.display;
			break;
		case "certificationpreparationclass":
			document.getElementById("field6").value = parseFloat((amount * .6)).toFixed(2);
			document.getElementById("disabledInput").value = parseFloat((amout * .6)).toFixed(2);
			document.getElementById("disabledInput").style.display;
			break;
		case "certification":
			document.getElementById("field6").value = parseFloat((amount * .6)).toFixed(2);
			document.getElementById("disabledInput").value = parseFloat((amout * .6)).toFixed(2);
			document.getElementById("disabledInput").style.display;
			break;
		case "technicaltraining":
			document.getElementById("field6").value = parseFloat((amount * .6)).toFixed(2);
			document.getElementById("disabledInput").value = parseFloat((amout * .6)).toFixed(2);
			document.getElementById("disabledInput").style.display;
			break;
		case "other":
			document.getElementById("field6").value = parseFloat((amount * .6)).toFixed(2);
			document.getElementById("disabledInput").value = parseFloat((amout * .6)).toFixed(2);
			document.getElementById("disabledInput").style.display;
			break;
		default:
			console.log("error");
	}
}

const displayCheckbox = event => {
	if(event.value == "grade"){
		document.getElementsByClassName("form-check-label").style.displpay = "block";
		document.getElementsByClassName("form-check-input").style.display = "block";
	}
}

const getCheckbox = event => {
	if(document.getElementById("field8-1").checked){
		document.getElementById("field8-1").value = true;
	}else if(document.getElementById("field8-2").checked){
		document.getElementById("field8-2").checked = true;
	}else if(document.getElementById("field8-3").checked){
		document.getElementById("field8-3").value = true;
	}else if(document.getElementById("field8-4").checked){
		document.getElementById("field8-3").value = true;
	}else{
		document.getElementById("field8-4").value = true;
	}
}
	


function getForm() {
	console.log("in get form");

	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function () {
		console.log("in on ready state change");
		if (xhr.readyState == 4 && xhr.status == 200) {
			console.log(xhr.responseText);
			var form = JSON.parse(xhr.responseText);
			loadForm(form);
		}
	}
	xhr.open("GET", "http://localhost:8080/TRMS/form.change", true);
	xhr.send();
}

//add a functio for file-upload
const handleFileUpload = event => {
	var payload = jsonBuilder();
	const files = event.target.files;
	const formData = new FormData();
	formData.append('file', files[0]);

	fetch('/saveImage', {
		method: 'POST',
		body: formData
	})
		.then(response => response.json())
		.then(data => {
			console.log(data.path);
		})
		.catch(error => {
			console.error(error);
		})
}

	document.querySelector('#file-upload1').addEventListener('change', event => { handleFileUpload(event) });
	document.querySelector('#file-upload2').addEventListener('change', event => { handleFileUpload(event) });
window.onload = function () {
	console.log("window");
	document.getElementById("form-submit").addEventListener("click", getForm, false);
	document.getElementById("form-submit").addEventListener("click", postForm, false);
//	var num = document.getElementById("field6");
	//getAmount(num);
}
/*
function postForm(){
	console.log("inside post form");
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		console.log("in readystatechange in post" + xhr.readyState);
		if(xhr.readyState==4 && xhr.status==200){
			console.log(xhr.responseText);
			let form = JSON.parse(xhr.responseText);
		}
	}
	
	xhr.open("POST", "http://localhost:8080/TRMS/form.change", true);
	var payload = jsonBuilder();
	xhr.send(payload);
}

//function to convert all element data to json for POST
function jsonBuilder() {
	var data = document.getElementById("form-container").elements;
	var dataObj = {};
	for (let i = 0; i < elements.length; i++) {
		var item = elements.item(i);
		dataObj[item.name] = item.value;
		console.log(dataObj);
	}
	var json = JSON.stringify(dataObj);
	console.log(json);
	return json;
}
window.onload = function () {
	console.log("window");
	document.getElementById("form-submit").addEventListener("click", getForm, false);
	document.getElementById("form-submit").addEventListener("click", postForm, false);
//	var num = document.getElementById("field6");
	//getAmount(num);
}

/*
function getGrade(event){
	event.preventDefault();
	switch(event){
		case "grade":
			const gradeitem = document.createElement('li');
			//const gradeBox = docoument.createElement('input');
			//gradeBox.formList.add("input type=text");
			//gradeBox.inputMode.addTextarea;
			//gradeitem.appendChild(gradeBox);
			break;
		case "presentation":
			break;
	}
}
/*

function filerForm(event){
	const forms = formList.childNodes;
	forms.forEach(function(forms){
		switch(e.target.value){
			case "viewall":
				forms.style.display = "flex";
				break;
			case "viewpending":
				if(forms.formList.contains("pending")){
					formList.style.display = "flex";
				}else{
					form.style.display = "none";
				}
				break;
			case "viewnew":
				//create new
				break;
			case "viewpast":
				if(forms.formList.contains("approved")){
					formList.style.display = "flex";
				}else{
					form.style.display = "none";
				}
				break;
		}
	});
}
*/