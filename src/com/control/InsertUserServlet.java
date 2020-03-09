package com.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ManagerInfoDao;
import com.model.ManagerInfo;

/**
 * Servlet implementation class AddUserServlet
 */
@WebServlet("/InsertUserServlet")
public class InsertUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String manNo=request.getParameter("manNo");
		String pw=request.getParameter("pw");
		//Integer authority=Integer.valueOf(request.getParameter("authority"));
		int salt=((int)(Math.random()*100000))%983+5;
		Integer authority=Integer.valueOf(salt);
		pw=pw+String.valueOf(authority);
		pw=new Encrypt().encrypt(pw);
		boolean result=new ManagerInfoDao().insert(new ManagerInfo(manNo,pw,authority));
		response.getWriter().write(String.valueOf(result));
	}
	
}
