package com.fsd2425.exmdem.entity;

import org.springframework.stereotype.Component;

@Component
public class rectagle {
	private String shape="not defined";
	private int length=0;
	private int breadth=0;
	private float area=0;
	
	public rectagle() {}

	public rectagle(String shape,float area, int length, int breadth) {
		super();
		this.shape = shape;
		this.length = length;
		this.breadth = breadth;
		this.area=area(length,breadth,shape);
	}

	public String getShape() {
		return shape;
	}

	public void setShape(String shape) {
		this.shape = shape;
		this.area=area(length,breadth,shape);
	}
	
	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
		this.area=area(length,breadth,shape);
	}

	public int getBreadth() {
		return breadth;
	}

	public void setBreadth(int breadth) {
		this.breadth = breadth;
		this.area=area(length,breadth,shape);
	}

	public float area(int length,int breadth,String ar) {
        switch (ar) {
            case "rectangle" : return length*breadth;
            default : return 0;
        }
	}

	@Override
	public String toString() {
		
		return  ("{\"length\":\""+length+
				"\",breadth\":\""+breadth+
				"\",\n\"Shape\":\""+shape+
				"\",\n\"Area\":\""+area+
				"\"}");
	}
	
	}



	
