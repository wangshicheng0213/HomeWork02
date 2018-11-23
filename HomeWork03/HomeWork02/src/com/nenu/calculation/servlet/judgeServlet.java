package com.nenu.calculation.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/judge.do")
public class judgeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int score = 0;
		String answerList = request.getParameter("answerList");
		String newStr = answerList.substring(1, answerList.length() - 1);
		String[]  strs01 = newStr.split(", ");
		double everyScore = 100 / strs01.length;
		System.out.println(everyScore);
		int corNum = 0;
		for(int i=0,len=strs01.length;i<len;i++){
			double out01 = Double.parseDouble(strs01[i].toString());
			double out02 = Double.parseDouble(request.getParameter("answer" + i));
			if(out01 == out02) {
				corNum ++ ;
			}
//		    System.out.println(strs01[i].toString());
		}
		score = (int) (everyScore * corNum);
//		for (int i = 0; i < strs01.length; i++) {
//		System.out.println(request.getParameter("answer" + i));;
//		}
//		System.out.println(answerList);
		request.setAttribute("score",score);
		request.getRequestDispatcher("/outCome.jsp").forward(request, response);
	}
}
