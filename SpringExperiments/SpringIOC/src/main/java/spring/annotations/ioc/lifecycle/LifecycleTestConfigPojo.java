package spring.annotations.ioc.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LifecycleTestConfigPojo {

	@Bean
	public Foo foo() {
		return new Foo();
	}
	
	@Bean(initMethod = "begin", destroyMethod="end")
	public Bar bar() {
		return new Bar();
	}
	
	@Bean(initMethod = "begin", destroyMethod="end")
	public Baz baz() {
		return new Baz();
	}
	
	public static void main(String[] args) {
		System.out.println("Starting container loading");
		ApplicationContext container = new AnnotationConfigApplicationContext(LifecycleTestConfigPojo.class);
		// for any bean @PostConstruct is executed before initMethod
		
		System.out.println("Container Loaded");
		((ConfigurableApplicationContext)container).close();
		// for any bean @PreDestroy is executed before destroyMethod
	}
}
class Foo {
	
	@PostConstruct
	public void init() {
		System.out.println("Foo: @PostConstruct annotated method invoked");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("Foo: @PreDestroy annotated method invoked");
	}
	
}
class Bar {
	public void begin() {
		System.out.println("Bar: begin invoked");
	}
	
	public void end() {
		System.out.println("Bar: end invoked");
	}
}
class Baz {
	@PostConstruct
	public void init() {
		System.out.println("Baz: @PostConstruct annotated method invoked");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("Baz: @PreDestroy annotated method invoked");
	}
	
	public void begin() {
		System.out.println("Baz: begin invoked");
	}
	
	public void end() {
		System.out.println("Baz: end invoked");
	}
}
