package com.nenu.calculation.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nenu.calculation.model.Calculation;
import com.nenu.calculation.model.Paper;
import com.nenu.calculation.service.QuertionService;

@WebServlet("/generate.do")
public class generateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String questionNum = request.getParameter("questionNum");
		String numDown = request.getParameter("numDown");
		String numUp = request.getParameter("numUp");
		String opNum = request.getParameter("opNum");
		String isCheck01 = request.getParameter("isCheck01");
		String isCheck02 = request.getParameter("isCheck02");
//		System.out.println(isCheck01 + isCheck02);
		if(!(isCheck01 == null ||"".equals(isCheck01))) {isCheck01 = "true";}
		if(!(isCheck02 == null ||"".equals(isCheck02))) {isCheck02 = "true";}
//		System.out.println(question+Numm+numDown+numUp+opNum+isCheck01+isCheck02);
		Calculation calculation = new Calculation();
		calculation.setQuestionNum(Integer.valueOf(questionNum));
		calculation.setNumDown(Integer.valueOf(numDown));
		calculation.setNumUp(Integer.valueOf(numUp));
		calculation.setOpNum(Integer.valueOf(opNum));
		calculation.setIsCheck01(Boolean.valueOf(isCheck01));
		calculation.setIsCheck02(Boolean.valueOf(isCheck02));
//		System.out.println(calculation);
		Paper paper = new QuertionService().questionCre(calculation);
		ArrayList<String> arrayQuestion = paper.getQuestion();
		ArrayList<String> arrayAnswer = paper.getAnswer();
		Integer questionNumer = paper.getQueNum();
//		System.out.println(questionNumer);
		request.setAttribute("arrayQuestion",arrayQuestion);
		request.setAttribute("arrayAnswer",arrayAnswer);
		request.setAttribute("questionNumer",questionNumer);
		
		request.getRequestDispatcher("/questionSel.jsp").forward(request, response);
	}

}
