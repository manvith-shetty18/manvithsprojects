package com.fsd2425.Restdemo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsd2425.Restdemo.Entity.Calcobj;
import com.fsd2425.Restdemo.Entity.Greetobj;

@Service
public class Serv {
	@Autowired
	private Greetobj gobj ;
	@Autowired
	private Calcobj calc;
	
	public String greetuser () {
		gobj.setMsg("GoodDay from Spring boot");
		return gobj.toString();
	}
	public String calculations(int x,int y,String arith) {
		calc.setNum1(x);
		calc.setNum2(y);
		calc.setOp(arith);
		return calc.toString();
		
	}
}
