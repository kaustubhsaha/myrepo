package spring.xml.ioc.autowiring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBeanPreference {

	public static void main(String[] args) {
		ApplicationContext container = new ClassPathXmlApplicationContext("BeanPreference.xml");
		Foo foo = container.getBean(Foo.class);
		// should not be null
		System.out.println(foo.bar);
		
		Bar bar = container.getBean("bar", Bar.class);
		// should print true
		System.out.println(foo.bar == bar);
	}
}
