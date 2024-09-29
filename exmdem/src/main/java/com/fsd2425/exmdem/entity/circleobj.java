package com.fsd2425.exmdem.entity;

import org.springframework.stereotype.Component;

@Component
public class circleobj {
	private String shape="not defined";
	private int radius=0;
	private float area=0;
	
	public circleobj() {}

	public circleobj(String shape, int radius) {
		super();
		this.shape = shape;
		this.radius = radius;
		this.area = areas(radius,shape);
	}

	public String getShape() {
		return shape;
	}

	public void setShape(String shape) {
		this.shape = shape;
		this.area = areas(radius,shape);
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
		this.area = areas(radius,shape);
	}
	
	public float areas(int radius,String ar) {
        switch (ar) {
            case "circle" : return (float) (3.14*radius*radius);
            default : return 0;
        }
	}
	@Override
	public String toString() {
		
		return  ("{\"radius\":\""+radius+
				"\",\n\"Shape\":\""+shape+
				"\",\n\"Area\":\""+area+
				"\"}");
	}	

}
