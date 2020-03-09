package com.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.MedicineInfoDao;
import com.model.MedicineInfo;

/**
 * Servlet implementation class InsertMedicineServlet
 */
@WebServlet("/InsertMedicineServlet")
public class InsertMedicineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertMedicineServlet() {
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
		
		String medName = request.getParameter("medName");
		String acceptNo = request.getParameter("acceptNo");
		String medType = request.getParameter("medType");
		String medCount = request.getParameter("medCount");
		Integer useDate = Integer.valueOf(request.getParameter("useDate"));
		String proName = request.getParameter("proName");
		boolean result = new MedicineInfoDao()
				.insert(new MedicineInfo("1", medName, acceptNo, medType,
						 medCount, useDate, proName));
		response.getWriter().write(String.valueOf(result));

	}
}
