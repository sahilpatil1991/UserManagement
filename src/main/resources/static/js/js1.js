

function loadingAgain(){
	document.getElementById('u-btn').style.display = 'none';
	document.getElementById('d-btn').style.display = 'none';
	document.getElementById('v-btn').style.display = 'none';
	console.log("Buttons Deleted");
	
	document.getElementById('btn-form').action = "/page";
	/**document.getElementById('btn-form').appendChild("value", "page");
	**/
	
	
	if(document.title == "Update")
	{
		console.log("its the update page");
	}
}
 	

	
	