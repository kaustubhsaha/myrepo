package spring.xml.ioc.lifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.Lifecycle;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestLifecycleBean {

	public static void main(String[] args) {
		System.out.println("Starting container loading");
		ApplicationContext container = new ClassPathXmlApplicationContext("Lifecycle3.xml");
		
		System.out.println("Container Loaded");
		((ConfigurableApplicationContext)container).close();		
	}
}
class Dummy implements Lifecycle  {

	public void start() {
		System.out.println("Dummy lifecycle started");
	}

	public void stop() {
		System.out.println("Dummy lifecycle stopped");
	}

	public boolean isRunning() {
		return true;
	}
	
}
