package cn.et.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.et.model.MyFood;
import cn.et.model.MyFoodType;
import cn.et.model.PageTools;

/**
 * Servlet implementation class ShowFood
 */
public class ShowFood extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	MyFoodType mft=new MyFoodType();
	MyFood mf=new MyFood();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		try {
			HttpSession session =request.getSession();
			String did =request.getParameter("did");
			if (did!=null && did !="") {
				session.setAttribute("did", did);
			}
			//²ËÏµ
			request.setAttribute("listFoodType", mft.getAllFoodType());
			
			//²ËÆ·
			String curPage=request.getParameter("carPage");
			Integer curPageInt=1;
			if (curPage!=null) {
				curPageInt=Integer.parseInt(curPage);
			}
			PageTools listFood = mf.getTableListPager(curPageInt);
			System.out.println(listFood.toString());
			request.setAttribute("listFood", listFood);
			
			request.getRequestDispatcher("detail/caidan.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
