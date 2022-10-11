package dummy;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.connection.DBoperation;
import com.webcreation.bean.Encapsulation;

//@webServlet("/DemoServelet")
	public class ServletDemo extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public ServletDemo() {
	super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("form submitted on GET");
	String employeeId = request.getParameter("employeeId");
	String employeeName = request.getParameter("employeeName");
	 String fatherName=request.getParameter("fatherName");
	 String mobileNumber=request.getParameter("mobileNumber");
	 String emailId=request.getParameter("emailId");
	 String address=request.getParameter("address");
	 String dob=request.getParameter("dob");
	
	Encapsulation es = new Encapsulation();
	es.setEmployeeId(employeeId);
	es.setEmployeeName(employeeName);
	es.setFatherName(fatherName);
	es.setMobileNumber(mobileNumber);
	es.setEmailId(emailId);
	es.setAddress(address);
	es.setDob(dob);
	
	DBoperation we = new DBoperation();
	int result = we.insertDataWithStatement(es);
	HttpSession session = request.getSession();
	session.setAttribute("EmployeeObject", es);

	RequestDispatcher empservlet = request.getRequestDispatcher("/EmployeeData");
	RequestDispatcher failure = request.getRequestDispatcher("Fail.html");
	if(result>0) {
	empservlet.forward(request, response);
	} else {
	failure.forward(request, response);
	}


	}

	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		 System.out.println("Submitted on post");
		 String employeeId = request.getParameter("EmployeeId");
		 

		 Encapsulation es = new Encapsulation();
		 es.setEmployeeId(employeeId);

		 DBoperation we = new DBoperation();
		 int result = we.deletedata(es);
		 RequestDispatcher success = request.getRequestDispatcher("Success.html");
		 RequestDispatcher failure = request.getRequestDispatcher("Fail.html");
		 if(result>0) {
		 success.forward(request, response);
		 }else {
		 failure.forward(request, response);
		 }
		 
	 }
		
	 }
	



