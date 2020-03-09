package com.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ManagerInfoDao;
import com.dao.SalesInfoDao;
import com.dao.WareHouseUpdateInfoDao;
import com.model.ManagerInfo;

/**
 * Servlet implementation class OptionSearchServlet
 */
@WebServlet("/OptionSearchServlet")
public class OptionSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OptionSearchServlet() {
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
		String manNo=request.getParameter("manNo");
		Integer authority=new ManagerInfoDao().selectAuthorityByManNo(manNo);
		ArrayList<Object[]> resultList;
		if(authority==1){
			resultList=new SalesInfoDao().selectAllBymanNo(manNo);
		}else{
			resultList=new WareHouseUpdateInfoDao().selectAllBymanNo(manNo);
		}
		request.setAttribute("resultList",resultList);
		request.getRequestDispatcher("superAdministrator_optionSearch_result"+authority+".jsp").forward(request, response);
	}

}
