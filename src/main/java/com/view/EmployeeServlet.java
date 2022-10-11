package com.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.webcreation.bean.Encapsulation;

public class EmployeeServlet extends HttpServlet {
	public EmployeeServlet() {
		super();
		}

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		HttpSession session = request.getSession();
		Object obj =session.getAttribute("EmployeeObject");
		Encapsulation emp = null;
		if(obj!=null) {
		emp = (Encapsulation)obj;
		}
		
		PrintWriter pw = response.getWriter();
		pw.print("<html><body><table>");
		//out.print("<tr><th>id")
		//out.print("<td>"+emp.getid()+"</td>");
  /*		pw.print("EmployeeName:<output type = \"text\" name ="+emp.getEmployeeName() +">");
		pw.print("<table>");
		pw.print("<tr><th>id</tr></th>");
		pw.print("<tr><th><name></tr></th>");
		pw.print("<tr><th><mobile></tr></th>");
		pw.print("</table></body></html>");      */ 
		
		pw.print("<tr><th>EmplooyeeId</th><th>EmployeeName</th><th>fatherName</th><th>MobileNumber</th><th>EmailId</th><th>address</th><th>dob</th></tr>");
	    pw.print("<tr><td>"+emp.getEmployeeId()+"</td>");
	    pw.print("<td>"+emp.getEmployeeName()+"</td>");
	    pw.print("<td>"+emp.getFatherName()+"</td>");
	    pw.print("<td>"+emp.getMobileNumber()+"</td>");
	    pw.print("<td>"+emp.getEmailId()+"</td>");
	    pw.print("<td>"+emp.getAddress()+"</td>");
	    pw.print("<td>"+emp.getDob()+"</td>");         
		
	pw.print("<tr><td><button><a href='Index.html'>Homepage</a></td></tr>");

		pw.print("</table></body></html>");
		}
		
		}
		

