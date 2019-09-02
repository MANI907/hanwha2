package lab4;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class lab4Test {
	public static void main(String[] args) {
	
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("lab4.xml");
		
				
		//사용자는 건드리지 않음
		Car c = context.getBean("car2", Car.class);
		System.out.println(c);
		
		People p = context.getBean("people2", People.class);
		System.out.println(p);
		
	}
}
