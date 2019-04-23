package spring.annotations.ioc.autowiring;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan(basePackages= {"spring.annotations.ioc.autowiring"})
public class TestNullableAutowiring {

	public static void main(String[] args) {
		ApplicationContext container = new AnnotationConfigApplicationContext(TestNullableAutowiring.class);
		Westeros westeros = container.getBean(Westeros.class);
		// shouldnt be null
		System.out.println(westeros);
	}
	
}
@Component
class Westeros {
	
		
	@Autowired
	public Westeros(Optional<Dorthraki> opt) {
		System.out.println("isPresent : "+opt.isPresent());
	}
}
class Dorthraki {
	
}
