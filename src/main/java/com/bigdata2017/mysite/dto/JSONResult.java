package com.bigdata2017.mysite.dto;

public class JSONResult {
	private String result; // either "success" or "fail"
	private String message; // result가 "fail"인 경우 원인 메시지
	private Object data; // result가 "success"인 경우 전달할 데이터
	
	private JSONResult() {
	}
	private JSONResult(String result, String message, Object data) {
		this.result = result;
		this.message = message;
		this.data = data;
	}
	
	public static JSONResult success( Object data ) {
		return new JSONResult("success", null, data);
	}
	
	public static JSONResult fail( String message ) {
		return new JSONResult("fail", message, null);
	}
	
	public String getResult() {
		return result;
	}
	public String getMessage() {
		return message;
	}
	public Object getData() {
		return data;
	}
	
	
}
