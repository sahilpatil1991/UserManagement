function updateloading(){

	document.getElementById('add-btn').innerHTML = 'Back';
	document.getElementById('u-btn').style.display = 'none';
	document.getElementById('d-btn').style.display = 'none';
	document.getElementById('v-btn').style.display = 'none';
	console.log("Buttons Deleted");
	
	document.getElementById('btn-form').action = "/view";
	/**document.getElementById('btn-form').appendChild("value", "page");
	**/
	
}
