package spring.annotations.ioc.autowiring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan(basePackages= {"spring.annotations.ioc.autowiring"})
public class TestFailsafeAutoworing {

	public static void main(String[] args) {
		ApplicationContext container = new AnnotationConfigApplicationContext(TestFailsafeAutoworing.class);
	}
	
	@Bean
	public Echo echo() {
		return new Echo();
	}
	
	@Bean
	public Foxtrot foxtrot1() {
		return new Foxtrot();
	}
	
	@Bean
	public Foxtrot foxtrot2() {
		return new Foxtrot();
	}
}

@Component
class Charlie {
	
	@Autowired(required = false)
	public Charlie(Echo echo) {
		System.out.println("Charlie(Echo echo) invoked");
	}
	
	@Autowired(required = false)
	public Charlie(Echo echo, @Qualifier("foxtrot2") Foxtrot foxtrot) {
		System.out.println("Charlie(Echo echo) invoked");
	}
	
	// The first two constructors both resolve fine. So the first one (in occurrence order) will be used
	
	@Autowired(required = false)
	// multiple matches
	public Charlie(Foxtrot foxtrot) {
		System.out.println("Charlie(Foxtrot foxtrot) invoked");
	}
	
	@Autowired(required = false)
	// no matches
	public Charlie(Lima lima) {
		System.out.println("Charlie(Lima lima) invoked");
	}
}
class Echo {
	 
}
class Foxtrot{
	
}
class Lima {
	
}
