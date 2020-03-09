package com.control;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.SalesInfoDao;
import com.model.SalesInfo;

/**
 * Servlet implementation class medicineSaleServlet
 */
@WebServlet("/MedicineSaleServlet")
public class MedicineSaleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MedicineSaleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String patNo=request.getParameter("patNo");
		String medNo=request.getParameter("medNo");
		Integer salCount=Integer.valueOf(request.getParameter("salCount"));
		String manNo=String.valueOf(request.getSession().getAttribute("manNo"));
		boolean result=new SalesInfoDao().insert(new SalesInfo("1",patNo,medNo,salCount,new Date(),manNo));
		response.getWriter().write(String.valueOf(result));
	}

}
