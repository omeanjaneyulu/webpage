package com.view;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connection.DBoperation;
import com.webcreation.bean.Encapsulation;

import javax.servlet.http.HttpSession;

public class FetchData extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public FetchData() {
		super();
	}
	protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		DBoperation dao = new DBoperation();
		List<Encapsulation> result = dao.Fetch();

		HttpSession session = request.getSession();
		session.setAttribute("Object", result);

		RequestDispatcher req = request.getRequestDispatcher("View.jsp");
		req.forward(request, response);
		}

}
