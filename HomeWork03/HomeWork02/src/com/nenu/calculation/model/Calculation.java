package com.nenu.calculation.model;

public class Calculation {
	private Integer questionNum;
	private Integer numDown;
	private Integer numUp;
	private Integer opNum;
	private Boolean isCheck01;
	private Boolean isCheck02;
	public Integer getQuestionNum() {
		return questionNum;
	}
	public void setQuestionNum(Integer questionNum) {
		this.questionNum = questionNum;
	}
	public Integer getNumDown() {
		return numDown;
	}
	public void setNumDown(Integer numDown) {
		this.numDown = numDown;
	}
	public Integer getNumUp() {
		return numUp;
	}
	public void setNumUp(Integer numUp) {
		this.numUp = numUp;
	}
	public Integer getOpNum() {
		return opNum;
	}
	public void setOpNum(Integer opNum) {
		this.opNum = opNum;
	}
	public Boolean getIsCheck01() {
		return isCheck01;
	}
	public void setIsCheck01(Boolean isCheck01) {
		this.isCheck01 = isCheck01;
	}
	public Boolean getIsCheck02() {
		return isCheck02;
	}
	public void setIsCheck02(Boolean isCheck02) {
		this.isCheck02 = isCheck02;
	}
	@Override
	public String toString() {
		return "Calculation [questionNum=" + questionNum + ", numDown=" + numDown + ", numUp=" + numUp + ", opNum="
				+ opNum + ", isCheck01=" + isCheck01 + ", isCheck02=" + isCheck02 + "]";
	}
}
