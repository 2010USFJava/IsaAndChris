
window.onload = function () {
	console.log("window");
	//	document.getElementById("form-submit").addEventListener("click", getForm, false);
	//	document.getElementById("form-submit").addEventListener("click", postForm, false);
	//document.querySelector('#file-upload2').addEventListener('change', event=>{handleFileUpload(event)});
	//document.querySelector('#file-upload1').addEventListener('change', event=>{handleFileUpload(event)});
	var num = document.getElementById("field7");
	getAmount(num);
}

document.querySelector('#file-upload2').addEventListener('change', event => { handleFileUpload(event) });
document.querySelector('#file-upload1').addEventListener('change', event => { handleFileUpload(event) });

const formInput = document.querySelector(".form-style");
const formButton = document.getElementById("form-btn");
const formList = document.getElementById("form-style");
const logForm = document.getElementById("log");
const formCost = document.getElementById("field7");
const eventSelect = document.getElementById("event-select");
const grade = document.getElementById("field8");

//event listeners
formInput.addEventListener('click', addForm);
form.addEventListener('submit', logSubmit);
eventSelect.addEventListener('input', getAmount);
grade.addEventListener('input', getGrade);

//functions
function getAmount(event) {
	let cost = document.getElementById("field7");
	switch (event) {
		case "universitycourse":
			var total = parseFloat((cost.value * .80)).toFixed(2);
			total = document.getElementById("pro-amount").value.display;
			break;
		case "seminar":
			var total = parseFloat((cost.value * .60)).toFixed(2);
			total = document.getElementById("pro-amount").value.display;
			break;
		case "cerificationpreparationclasse":
			var total = parseFloat((cost.value * .75)).toFixed(2);
			total = document.getElementById("pro-amount").value.display;
			break;
		case "certification":
			var total = parseFloat(cost.value).toFixed(2);
			total = document.getElementById("pro-amount").value.display;
			break;
		case "technicaltraining":
			var total = parseFloat((cost.value * .90)).toFixed(2);
			total = document.getElementById("pro-amount").value.display;
			break;
		case "other":
			var total = parseFloat((cost.value * .60)).toFixed(2);
			total = document.getElementById("pro-amount").value.display;
			break;
		default:
			console.log("error in getAmount");
	}
}

function getGrade(event){
	event.preventDefault();
	switch(event){
		case "grade":
			const gradeitem = document.createElement('li');
			const gradeBox = docoument.createElement('input');
			gradeBox.formList.add("input type=text");
			gradeBox.inputMode.addTextarea;
			gradeitem.appendChild(gradeBox);
			break;
		case "presentation":
			break;
	}
}

//get timestamp of submission
function logSubmit(event) {
	log.textContent = `Form Submitted! Time stamp: ${event.timestamp}`;
	event.timestamp = document.getElementById("timestamp");
	event.preventDefault();
	loadForm(event);
}

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

function loadForm(form) {
	document.getElementById("field1").innerHTML = form.formFirst;
	document.getElementById("field2").innerHTML = form.formLast;
	document.getElementById("field3").innerHTML = form.formEvent;
	document.getElementById("field4").innerHTML = form.formDate;
	document.getElementById("field5").innerHTML = form.formTime;
	document.getElementById("field6").innerHTML = form.formLocation;
	document.getElementById("field7").innerHTML = form.formCost;
	document.getElementById("field8").innerHTML = form.formFormat;
	document.getElementById("field9").innerHTML = form.formDescript;
	document.getElementById("field10").innerHTML = form.formJustif;
	getAmount(form);
	//file uploads
}

function getAmount(event) {
	switch (event) {
		case "universitycourse":
			var number = this.value;
			var total = parseFloat((number * .80)).toFixed(2);
			total = document.getElementById("pro-amount").value.display;
			break;
		case "seminar":
	}
}


function addTextarea() {
	var x = document.getElementById("event-select");
	if (x.style.display === "none") {
		x.style.display = "block";
	} else {
		x.style.display = "none";
	}
}



//trying to preview before upload
function previewUpload(event) {
	var reader = new FileReader();
	reader.onload = function () {
		var output = document.getElementById('file-upload2');
		output.src = reader.result;
	}
	reader.readAsDataURL(event.target.files[0]);

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

//function to convert all element data to json for POST
function jsonBuilder() {
	var data = document.getElementById("form").elements;
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



/*


function getForm() {
		form.onsubmit = function(event) {
			event.preventDefault;
			const file = document.getElementById("file-upload1");
			file.addEventListener("change", handleFiles, flase);
			function handleFiles() {
				const fileList = this.files; //allows us to work with the file list
				const numFiles = fileList.length;
			}
			for (let i = 0; i < numFiles; i++) {
				const oneFile = fileList[i];
			}

		var submit = document.getElementById("form-submit");
		var files = file.files;

		var formData = new FormData();
		formData.append('file', files[0], files[0].name);




		var xhr = new XMLHttpRequest();
		xhr.onload = function() {
			if (xhr.readyState == 4 && xhr.status == 200) {
				var response = JSON.parse(formData);
				alert('File success');
			} else {
				alert('file fail');
			}
		};

		xhr.open("POST", "http://localhost:8080/TRMS/FrontEndFiles/HTML/form.html", true);

	}


	xhr.send(formData);
}


var xhr = new XMLHttpRequest();
xhr.withCredentials = true;

xhr.addEventListener("readystatechange", function() {
	if (this.readyState === 4) {
		console.log(this.responseText);
	}
});

xhr.open("POST", "http://localhost:8080/TRMS/FrontEndFiles/HTML/form.html");

xhr.send();
*/

/*
xhr.onload.onprogress = function(files){
	if(files.leng){
		var percentComplete = (event.loaded / event.total) * 100;
		console.log(percentComplete + '% uploaded');
	}
};
*/ //for images





/*

window.onload = function(){
		console.log("window onload func");
		let eventForm = document.getElementById("form").addEventListener('submit', formSubmit);
		getForm();
		formSubmit(eventForm);
}

async function formSubmit(event){
	//log.textContent =  `From Submitted! Timestamp: ${event.timeStamp}`;
	event.preventDefault();

	const form = event.currentTarget();
	const url = form.action;

	try{
		const formData = new FormData(form);
		const responseData = await postFormDataAsJson({url, formData});
		console.log({responseData});
	}catch(error){
		console.error(error);
	}
}

async function postFormDataAsJson({url, formData}){
	const plainFormData = Object.formEntries(formData.entries());
	const formDataJsonString = JSON.stringify(plainFormData);

	const fetchOptions = {
		method: "POST",
		headers: {
			"Content-Type": "application/json",
			"Accept": "application/json"
		},
		body: formDataJsonString,
	};

	const response = await fetch(url, fetchOptions);

	if(!response.ok){
		const errorMsg = await response.text();
		throw new Error(errorMsg);
	}

	return response.json();
}

/*
function getForm(){

	fetch('http://local:8080/TRMS/getsession.json',{
		method: "POST",
		credentials: 'include'
	})
		.then(function(response){
			console.log(repsonse);
			return response.json();
		}, function(){
			console.log("getForm failed")
		})
}


*/
/*
function doSubmit() {
	let fileInput = document.getElementById("file-upload1");
	let xhr = new XMLHttpRequest();
	xhr.open('POST', "http://localhost:8080/TRMS/form.change");
	xhr.setRequestHeader('content-type', 'application/json');
	xhr.send({
		"fileInput": fileInput
	});
}
*/