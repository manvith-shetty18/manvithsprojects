package com.fsd2425.Autowiring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Student {
        private String regno;
        private String name;
        @Autowired
        @Qualifier ("add3")
        private Address add;
        @Autowired
        @Qualifier ("cls")
        private classstudying cls;
        public Student () {}

		public Student(String regno, String name) {
			super();
			this.regno = regno;
			this.name = name;
		
		}

		public String getRegno() {
			return regno;
		}

		public void setRegno(String regno) {
			this.regno = regno;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}


		@Override
		public String toString() {
			
			return ("{\"Regno\":\""+regno+
					"\",\n\"Name\":\""+name+
					"\",\n\"ClassStudying\":"+cls+
					",\n\"Address\":"+add+"}");
		}
        
		
}
