package spring.xml.ioc.lifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDefaultInitDestroy {

	public static void main(String[] args) {
		System.out.println("Starting container loading");
		ApplicationContext container = new ClassPathXmlApplicationContext("DefaultInitDestroy.xml");
		
		System.out.println("Container Loaded");
		((ConfigurableApplicationContext)container).close();		
	}
}
class Alpha {
	
	public void init() {
		System.out.println("Alpha init");
	}
	
	public void destroy() {
		System.out.println("Alpha destroyed");
	}	
}
class Beta {
	public void init() {
		System.out.println("Beta init");
	}
	
	public void shutdown() {
		System.out.println("Beta destroyed");
	}		
}
class Gamma {
	public void destroy() {
		System.out.println("Gamma destroyed");
	}
	
	public void shutdown() {
		System.out.println("Gamma shutdown");
	}
	
	public void close() {
		System.out.println("Gamma close");
	}	
}