package com.test.bean;

public class SumBean {
	private int firstNumber;
	private int secondNumber;
	private int result;

	public int getFirstNumber() {
		return firstNumber;
	}

	public void setFirstNumber(int firstNumber) {
		this.firstNumber = firstNumber;
	}

	public int getSecondNumber() {
		return secondNumber;
	}


	public void setSecondNumber(int secondNumber) {
		this.secondNumber = secondNumber;
	}

	public int getResult() {
		this.result = this.firstNumber + this.secondNumber;
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

}
