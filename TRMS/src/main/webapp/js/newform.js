function getAmount(){

	var amount = document.getElementById("field6").value;
	var event = document.getElementById("inputGroupSelect01").value;
	var projected;

	switch(event){
		case "universitycourse":
			projected = parseFloat((amount * .6)).toFixed(2);
			document.getElementById("hidden-text").value = projected;
			break;
		case "seminar":
			projected = parseFloat((amount * .6)).toFixed(2);
			document.getElementById("hidden-text").value = projected;
			break;
		case "certificationpreparationclass":
			projected = parseFloat((amount * .6)).toFixed(2);
			document.getElementById("hidden-text").value = projected;
			break;
		case "certification":
			projected = parseFloat((amount * .6)).toFixed(2);
			document.getElementById("hidden-text").value = projected;
			break;
		case "technicaltraining":
			projected = parseFloat((amount * .6)).toFixed(2);
			document.getElementById("hidden-text").value = projected;
			break;
		case "other":
			projected = parseFloat((amount * .6)).toFixed(2);
		document.getElementById("hidden-text").value = projected;
			break;
		default:
			console.log("error");
	}

}

/*
function displayCheckbox(){
	let grade = document.getElementById("field7").value;
	if(grade.value == "grade"){
		document.getElementById("form-check-label").style.display = "block";
		document.getElementById("form-check-input").style.display = "block";
	}
}
*/



function getCheckbox() {
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
	

document.querySelector('#file-upload1').addEventListener('change', event => { handleFileUpload(event) });
document.querySelector('#file-upload2').addEventListener('change', event => { handleFileUpload(event) });

//add a functio for file-upload
function handleFileUpload(event) {
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
		});
}

	document.querySelector('#file-upload1').addEventListener('change', event => { handleFileUpload(event) });
	document.querySelector('#file-upload2').addEventListener('change', event => { handleFileUpload(event) });
window.onload = function () {
	console.log("window");

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