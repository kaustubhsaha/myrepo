package spring.xml.ioc.basics;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestIOCBasics {

	public static void main(String[] args) {
		ApplicationContext container = new ClassPathXmlApplicationContext("DependencyInjectionBasics1.xml");
		
		Foo foo1 = container.getBean("foo1", Foo.class);
		Foo foo2 = container.getBean("foo2", Foo.class);
		Foo foo3 = container.getBean("foo3", Foo.class);
		Foo foo4 = container.getBean("foo4", Foo.class);
		Foo foo5 = container.getBean("foo5", Foo.class);

		String sep = "---------------------------------------------------";
		
		System.out.println(sep);
		
		//should be null
		System.out.println(foo1.bar);
		System.out.println(sep);
		
		// both should print some non null value
		System.out.println(foo2.bar);
		System.out.println(foo3.bar);
		// should print true - same object injected into both
		System.out.println(foo2.bar == foo3.bar);
		System.out.println(sep);
		
		// both should print some non null value
		System.out.println(foo4.baz);
		System.out.println(foo5.baz);
		// should print true - same object injected into both
		System.out.println(foo4.baz == foo5.baz);
		System.out.println(sep);
		
		((ConfigurableApplicationContext)container).close();
		
		try {
			container = new ClassPathXmlApplicationContext("DependencyInjectionBasics2-NotWitableProperty.xml");
		}
		catch (BeanCreationException ex) {
			// should result in Exception. Spring relies on settewr method to complete property injection
			System.out.println(ex.getLocalizedMessage());
			System.out.println(sep);
			
			((ConfigurableApplicationContext)container).close();
		}
	}
}
class Foo {
	
	protected Baz baz;
	protected Bar bar;
	
	public Foo (Bar b) {
		System.out.println(" public Foo (Bar b) -> constructor invoked");
		bar = b;
	}
	
	private Foo() {
		
	}
	
	public void setBaz(Baz baz) {
		this.baz = baz;
	}
	
}
class Bar {
	
}
class Baz {
	
}
