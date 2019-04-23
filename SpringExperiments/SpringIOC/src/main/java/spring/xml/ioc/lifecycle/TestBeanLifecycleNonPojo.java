package spring.xml.ioc.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBeanLifecycleNonPojo {

	public static void main(String[] args) {
		
		System.out.println("Starting container loading");
		ApplicationContext container = new ClassPathXmlApplicationContext("Lifecycle1.xml");
		//Foo.afterPropertiesSet() invoked should be printed
		
		System.out.println("Container Loaded");
		((ConfigurableApplicationContext)container).close();
		//Bar.destroy() invoked should be printed now
	}

}
class Foo implements InitializingBean {

	public void afterPropertiesSet() throws Exception {
		System.out.println("Foo.afterPropertiesSet() invoked");
	}
	
}
class Bar implements DisposableBean {

	public void destroy() throws Exception {
		System.out.println("Bar.destroy() invoked");
	}
	
}
