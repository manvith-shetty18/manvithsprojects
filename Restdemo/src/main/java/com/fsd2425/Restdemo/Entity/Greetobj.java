package com.fsd2425.Restdemo.Entity;

import org.springframework.stereotype.Component;

@Component
public class Greetobj {
	private String msg;
	
	public Greetobj() {}

	public Greetobj(String msg) {
		super();
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return ("{\n\"Message\":"+msg+",\n}");
	}
	
	

}
