package com.control;

import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.WareHouseUpdateInfoDao;
import com.model.WareHouseUpdateInfo;

/**
 * Servlet implementation class AddInventoryServlet
 */
@WebServlet("/AddInventoryServlet")
public class AddInventoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddInventoryServlet() {
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
		
		WareHouseUpdateInfoDao wareHouseUpdateInfoDao=new WareHouseUpdateInfoDao();
		
		String medNo=request.getParameter("medNo");
		
		Date endDate= wareHouseUpdateInfoDao.to_Date(request.getParameter("endDate"));
		Integer addCount=Integer.valueOf(request.getParameter("addCount"));
		String manNo=String.valueOf(request.getSession().getAttribute("manNo"));
		boolean result=wareHouseUpdateInfoDao.Insert(new WareHouseUpdateInfo(
				"1",addCount,endDate,endDate,manNo,medNo
				));
		
		
		response.getWriter().write(String.valueOf(result));
		
	}

}
