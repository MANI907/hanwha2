package lab2;

import javax.annotation.Resource;
import lab2.TV;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;


public class TVUser {
	public static void main(String[] args) {
		
	
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("lab2.xml");
		TV tv = (lab2.TV) context.getBean("stv");
		tv.powerOn();
		tv.powerOff();
		
		
		//Resource r = new ClassPathResource("lab2.xml");
		//BeanFactory factory = new XmlBeanFactory(resource);
	}
}
