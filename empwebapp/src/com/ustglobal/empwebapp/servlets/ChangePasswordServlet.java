package com.ustglobal.empwebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ustglobal.empwebapp.dao.EmployeeDAO;
import com.ustglobal.empwebapp.dto.EmployeeInfo;
import com.ustglobal.empwebapp.util.EmployeeDaoManager;
@WebServlet("/changePassword")
public class ChangePasswordServlet extends HttpServlet {

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	
		HttpSession session = req.getSession(false);
		
		if(session != null) {
			
			String pass= req.getParameter("pwd");
			String confirmpass= req.getParameter("cnfpwd");
			
			if (pass.equals(confirmpass)) {
				
				EmployeeInfo info = (EmployeeInfo)session.getAttribute("info");
				EmployeeDAO dao = EmployeeDaoManager.getEmployeeDAO();
				dao.changePassword(info.getId(), pass);
				
				RequestDispatcher dispatcher = req.getRequestDispatcher("/home");
				dispatcher.forward(req, resp);
				
			} else {
				
				PrintWriter out = resp.getWriter();
				
				out.println("<html>");
				out.println("<h4> Password not matching </h4>");
				out.println("</html>");
				
				RequestDispatcher dispatcher = req.getRequestDispatcher("/changePassword.html");
				dispatcher.include(req, resp);
			}
			
			EmployeeDAO dao = EmployeeDaoManager.getEmployeeDAO();
			
			
		} else {
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("/login.html");
			dispatcher.forward(req, resp);
		}
	
	}//end of doPost()
	
}//end of ChangePasswordServlet
