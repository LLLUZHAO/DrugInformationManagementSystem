package com.control;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dao.*;
import com.model.ManagerInfo;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
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
		System.out.println("调用loginServlet");
		
		String manNo = request.getParameter("manNo");
		String pw = request.getParameter("pw");
		String rjsp = "login.jsp";
		if (manNo.length() > 0 && pw.length() > 0) {
			ManagerInfo manageInfo = new ManagerInfo(manNo);
			/*
			System.out.println(manageInfo.getPw());
			new ManagerInfoDao().initByManNo(manageInfo);
			System.out.println(manageInfo.getPw());
			System.out.println("1"+login(manageInfo,pw));
			*/
			if (new ManagerInfoDao().initByManNo(manageInfo)
					&&
					login(manageInfo,pw)
					//manageInfo.getPw().equals(pw)
					) {
				//request.setAttribute("msg", "<script>alert('登陆成功！');</script>");
				
				
					request.getSession().setAttribute("manNo", manNo);
					rjsp = "success.jsp";
					/*
					switch (manageInfo.getAuthority()) {
					case 0:
						rjsp = "superAdministrator.jsp";
						break;
					case 1:
						rjsp = "ordinaryAdministrator_doctor.jsp";
						break;
					case 2:
						rjsp = "ordinaryAdministrator_inventoryManager.jsp";
						break;
					}
					*/
			}
			else{
				rjsp = "false.jsp";
			}
		}
		response.sendRedirect(rjsp);
	}
	private boolean login(ManagerInfo manageInfo, String pw){
		System.out.println("开始加密");
		/*MD5加密根据时间不同，结果不同
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			pw=pw+String.valueOf(manageInfo.getAuthority());
			System.out.println("加盐："+pw+"  salt="+manageInfo.getAuthority());
			pw=String.valueOf(md.digest(pw.getBytes()));
			System.out.println("MD5："+pw+"  "+manageInfo.getPw());
			if(pw.equals(manageInfo.getPw())){
				return true;
			}
			return false;
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		*/
		pw=pw+String.valueOf(manageInfo.getAuthority());
		System.out.println("加盐："+pw+"  salt="+manageInfo.getAuthority());
		//pw=encrypt(pw);
		pw=new Encrypt().encrypt(pw);
		System.out.println("加密："+pw+"  "+manageInfo.getPw());
		if(pw.equals(manageInfo.getPw())){
			return true;
		}
		return false;
	}
	/*
	private String encrypt(String pw){
		//x*31+101
		int len=pw.length();
		String ans=new String();
		for(int i=0;i<len;i++){
			ans=ans+String.valueOf(pw.charAt(i)*31+101);
		}
		return ans;
	}
	*/
}
