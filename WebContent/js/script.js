function validate() {
	var titlename = document.forms["movie-cruiser"]["txtTitle"].value;
	var gross = document.forms["movie-cruiser"]["txtGross"].value;
	var datelaunch = document.forms["movie-cruiser"]["txtLaunch"].value;
	if(titlename == "")
	{
		alert("Title should not be empty...");
		return false;
	}
	if(titlename.length < 2)
	{
		alert("Title name should be greater than 2 letters...");
		return false;
	}
	if(gross == "") 
	{
		alert("Please provide gross value...");
		return false;
	}
	if(/[^0-9]/.test(gross))
	{
		alert("The gross value should contain only numbers...");
		return false;
	}
	if(datelaunch == "")
	{
		alert("Please provide valid date of launch...");
		return false;
	}
}
	
	
// Include form validation functions here