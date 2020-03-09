package com.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ManagerInfoDao;
import com.dao.PatientInfoDao;
import com.model.ManagerInfo;
import com.model.PatientInfo;

/**
 * Servlet implementation class InsertPatientServlet
 */
@WebServlet("/InsertPatientServlet")
public class InsertPatientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertPatientServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String patNo = request.getParameter("patNo");
		String patName = request.getParameter("patName");
		String patType = request.getParameter("patType");
		boolean result = new PatientInfoDao().insert(new PatientInfo(patNo,
				patName, patType));
		response.getWriter().write(String.valueOf(result));
	}

}
