package com.fsd2425.Restdemo.Entity;

import org.springframework.stereotype.Component;

@Component
public class Calcobj {
	
	private int num1=0;
	private int num2=0;
	private String op="Not defined";
	private float result = 0;

	public Calcobj() {}

	public Calcobj(int num1, int num2, String op) {
		super();
		this.num1 = num1;
		this.num2 = num2;
		this.op = op;
		this.result=calculate(num1,num2,op);
	}

	public int getNum1() {
		return num1;
	}

	public void setNum1(int num1) {
		this.num1 = num1;
		this.result=calculate(num1,num2,op);
	}

	public int getNum2() {
		return num2;
	}

	public void setNum2(int num2) {
		this.num2 = num2;
		this.result=calculate(num1,num2,op);
	}

	public String getOp() {
		return op;
	}

	public void setOp(String op) {
		this.op = op;
		this.result=calculate(num1,num2,op);
	}

	
	public float calculate(int a,int b,String opr) {
        switch (opr) {
            case "Add" : return a + b;
            case "Sub" : return a - b;
            case "Mult" : return a * b;
            case "Div" : return b==0?0 : (float) a / b;
            default : return 0;
        }
	}

	@Override
	public String toString() {
		return ("{\"Num1\":\""+num1+
				"\",\n\"num2\":\""+num2+
				"\",\n\"Operation\":\""+op+
				"\",\n\"Result\":\""+result+
				"\"}");
	}
	
	
}
