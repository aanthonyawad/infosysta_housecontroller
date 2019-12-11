package com.awad.anthony.housecontroller.controller.curtain;

public class CurtainResult {
	public CurtainErrorResponse getCurtainErrorResponse() {
		return curtainErrorResponse;
	}
	public void setCurtainErrorResponse(CurtainErrorResponse curtainErrorResponse) {
		this.curtainErrorResponse = curtainErrorResponse;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	CurtainErrorResponse curtainErrorResponse;
	String result;
}
