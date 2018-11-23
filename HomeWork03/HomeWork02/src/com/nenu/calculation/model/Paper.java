package com.nenu.calculation.model;

import java.util.ArrayList;

public class Paper {
	
	private Integer queNum;
	private ArrayList<String> question;
	private ArrayList<String> answer;
	
	public Integer getQueNum() {
		return queNum;
	}
	public void setQueNum(Integer queNum) {
		this.queNum = queNum;
	}
	public ArrayList<String> getQuestion() {
		return question;
	}
	public void setQuestion(ArrayList<String> question) {
		this.question = question;
	}
	public ArrayList<String> getAnswer() {
		return answer;
	}
	public void setAnswer(ArrayList<String> answer) {
		this.answer = answer;
	}
	
}
