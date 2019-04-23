package spring.xml.ioc.basics;

import java.util.concurrent.TimeUnit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBeanDependencies {

	public static void main(String[] args) {
		// Alpha will always be loaded last
		ApplicationContext container = new ClassPathXmlApplicationContext("BeanDependencies.xml");
	}
}
class Alpha{
	
	public Alpha() {
		System.out.println("Alpha loaded");
	}
}
class Beta{
	
	public Beta() {
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Beta loaded");
	}
}
class Gamma{
	
	public Gamma() {
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
		System.out.println("Gamma loaded");
	}
}
