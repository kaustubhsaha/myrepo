package spring.annotations.ioc.autowiring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestAutowiring {
	
	public static void main(String[] args) {
		ApplicationContext container = new AnnotationConfigApplicationContext(TestAutowiring.class);
		Foo foo = container.getBean("foo", Foo.class);
		Baz baz = container.getBean("baz", Baz.class);
		
		//should print false
		System.out.println(foo.bar == baz.bar);
	}
	
	@Bean
	public Foo foo(@Qualifier("bar1")Bar bar) {
		return new Foo(bar);
	}
	
	@Bean
	public Bar bar1() {
		return new Bar();
	}
	
	@Bean
	public Bar bar2() {
		return new Bar();
	}
	
	@Bean
	public Baz baz() {
		return new Baz();
	}

}
class Foo{
	
	Bar bar;
	
	@Autowired
	public Foo(Bar bar) {
		this.bar = bar;
	}
}
class Bar {
	
}
class Baz{
	
	Bar bar;
	
	@Autowired
	@Qualifier("bar2")
	public void setBar(Bar bar) {
		this.bar = bar;
	}
}
