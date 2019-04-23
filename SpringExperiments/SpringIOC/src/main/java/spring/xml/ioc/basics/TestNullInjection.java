package spring.xml.ioc.basics;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestNullInjection {

	public static void main(String[] args) {
		ApplicationContext container = new ClassPathXmlApplicationContext("ExplicitNullInject.xml");
		Foo foo1 = container.getBean("foo1", Foo.class);
		Foo foo2 = container.getBean("foo2", Foo.class);
		
		//should print null - twice
		System.out.println(foo1.bar);
		System.out.println(foo1.baz);
		
		//should print null - twice
		System.out.println(foo2.bar);
		System.out.println(foo2.baz);
	}
}
