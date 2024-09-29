package com.fsd2425.exmdem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsd2425.exmdem.entity.circleobj;
import com.fsd2425.exmdem.entity.rectagle;

@Service
public class servesobj {
	
	@Autowired
	private circleobj calc;
	@Autowired
	private rectagle calcs;

	public String calculations(int x,String arith) {
		calc.setRadius(x);
		calc.setShape(arith);
		return calc.toString();
	}
	public String calculators(int y,int z,String aarith) {
		calcs.setLength(y);
		calcs.setBreadth(z);
		calcs.setShape(aarith);
		return calcs.toString();
		
	}
}
