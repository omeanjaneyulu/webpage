function clearErrorMessage(){
document.getElementById("errorMsgEmployeeId").innerHTML="";
document.getElementById("errorMsgEmployeeName").innerHTML="";
document.getElementById("errorMsgfatherName").innerHTML="";
document.getElementById("errorMsgMobileNumber").innerHTML="";

}

function validcheck() {
var employeeId = document.getElementById("employeeId").value;
var employeename = document.getElementById("employeeName").value;
var fatherName=document.getElementById("fatherName").value;

if(employeeId == "" || employeeId == null){
document.getElementById("errorMsgEmployeeId").innerHTML="please enter ID";
return false;
} else if (employeename == "" || employeename == null){
document.getElementById("errorMsgEmployeeName").innerHTML="please enter name";
return false;
} else if(fatherName=="" || fatherName== null){
document.getElementById("errorMsgfatherName").innerHTML="please enter fatherName";
return false;	
}
else {
return true;
}
}

