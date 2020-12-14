document.querySelector('#file-upload').addEventListener('change', event => { handleFileUpload(event) });

//add a functio for file-upload
function handleFileUpload(event) {
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
