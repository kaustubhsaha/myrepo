package spring.xml.ioc.basics;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestInnerBean {

	public static void main(String[] args) {
		ApplicationContext container = new ClassPathXmlApplicationContext("InnerBean.xml");
		
		Stark stark = container.getBean(Stark.class);
		// shouldnt be null
		System.out.println(stark.mormont);
		// shouldnt be null
		System.out.println(stark.bolton);
		
		try {
			Mormont mormont = container.getBean(Mormont.class);	
		}
		catch (NoSuchBeanDefinitionException ex) {
			// throws exception because its an inner bean and cant be accessed beyond its scope
			System.out.println(ex.getMessage());
		}
		
		try {
			Bolton bolton = container.getBean(Bolton.class);	
		}
		catch (NoSuchBeanDefinitionException ex) {
			// throws exception because its an inner bean and cant be accessed beyond its scope
			System.out.println(ex.getMessage());
		}

	}
}
class Stark {
	
	Bolton bolton;
	Mormont mormont;
	
	public Stark(Mormont mormont) {
		this.mormont = mormont;
	}
	
	public void setBolton(Bolton bolton) {
		this.bolton = bolton;
	}
	
}
class Bolton {
	
}
class Mormont {
	
}