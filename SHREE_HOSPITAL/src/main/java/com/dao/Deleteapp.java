package com.dao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.db.DBConnect;
@WebServlet("/deleteApp")
public class Deleteapp extends HttpServlet
{

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		
		
		AppointmentDAO dao = new AppointmentDAO(DBConnect.getConn());
		HttpSession session = req.getSession();

		if (dao.deleteappointment(id)) {
			session.setAttribute("succMsg", "");
			resp.sendRedirect("view_appointment.jsp");
		} else {
			session.setAttribute("errorMsg", "something wrong on server");
			resp.sendRedirect("view_appointment.jsp");
		}

	}


	
}
