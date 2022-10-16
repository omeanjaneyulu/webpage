function clearerrorMsg(){
	document.getElementById("errorMsgEmployeeId").innerHTML="";
}
function validcheck(){
	var employeeId=document.getElementById("employeeId").value;
	
	if(employeeId== ""||employeeId==null){
		document.getElementById("errorMsgEmployeeId").innerHTML="Please enter valid Id";
		return false;
	}else{
		return true;
	}
}