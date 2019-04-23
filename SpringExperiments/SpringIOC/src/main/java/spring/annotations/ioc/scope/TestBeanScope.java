package spring.annotations.ioc.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class TestBeanScope {
	
	@Bean
	@Scope("singleton")
	public Foo foo() {
		return new Foo();
	}
	
	@Bean
	@Scope("prototype")
	public Bar bar() {
		return new Bar();
	}
	
	public static void main(String[] args) {
		ApplicationContext container = new AnnotationConfigApplicationContext(TestBeanScope.class);
		Foo foo1 = container.getBean(Foo.class);
		Foo foo2 = container.getBean(Foo.class);
		
		Bar bar1 = container.getBean(Bar.class);
		Bar bar2 = container.getBean(Bar.class);
		
		//should print true
		System.out.println(foo1 == foo2);
		//should print false
		System.out.println(bar1 == bar2);
	}

}
class Foo {
	
}
class Bar {
	
}
