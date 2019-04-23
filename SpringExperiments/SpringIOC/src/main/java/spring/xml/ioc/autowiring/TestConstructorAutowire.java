package spring.xml.ioc.autowiring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestConstructorAutowire {

	public static void main(String[] args) {
		ApplicationContext container = new ClassPathXmlApplicationContext("AutowireByConstructor.xml");
		Foo foo = container.getBean(Foo.class);
		// should not be null
		System.out.println(foo.bar);
	}
}
class Foo{
	
	Bar bar;
	
	public Foo(Bar bar) {
		this.bar = bar;
	}
}
class Bar {
	
}
