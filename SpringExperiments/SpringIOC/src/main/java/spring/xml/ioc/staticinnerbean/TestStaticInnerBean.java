package spring.xml.ioc.staticinnerbean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestStaticInnerBean {

	public static void main(String[] args) {
		ApplicationContext container = new ClassPathXmlApplicationContext("TestStaticInnerBean.xml");
		Dummy.Inner inner = container.getBean(Dummy.Inner.class);
		
		// should not be none
		System.out.println(inner);
		
		((ConfigurableApplicationContext)container).close();
	}
}

class Dummy {
	
	static class Inner {
		
	}
}
