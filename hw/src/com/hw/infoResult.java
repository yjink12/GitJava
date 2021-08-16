package com.hw;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class infoResult
 */
@WebServlet(name = "info", urlPatterns = "/info")
public class infoResult extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public infoResult() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doReq(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doReq(request, response);
	}
	
	private void doReq(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//요청
		StringBuffer url=request.getRequestURL();
		String pro=request.getScheme();
		String ip=request.getServerName();
		int port=request.getServerPort();
		String uri=request.getRequestURI();
		
		//응답
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.print(url+"<br>");
		out.print(pro+"://"+ip+"<br>");
		out.print(port+"<br>");
		out.print(ip+"<br>");
		out.print(uri+"<br>");
	}

}
