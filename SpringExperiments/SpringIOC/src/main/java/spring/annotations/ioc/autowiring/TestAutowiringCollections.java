package spring.annotations.ioc.autowiring;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestAutowiringCollections {

	public static void main(String[] args) {
		ApplicationContext container = new AnnotationConfigApplicationContext(TestAutowiringCollections.class);
		Alpha alpha = container.getBean("alpha", Alpha.class);
		
		// should be two different objects
		System.out.println(alpha.betas[0]);
		System.out.println(alpha.betas[1]);
		
		// should print out 3 different objects
		System.out.println(alpha.gammas.size());
		System.out.println(alpha.gammas.get(0));
		System.out.println(alpha.gammas.get(1));
		System.out.println(alpha.gammas.get(2));
		
		System.out.println(alpha.deltas);
	}
	
	@Bean
	public Alpha alpha() {
		return new Alpha();
	}
	
	@Bean
	public Beta beta1() {
		return new Beta();
	}
	
	@Bean
	public Beta beta2() {
		return new Beta();
	}
	
	@Bean
	public Gamma gamma1() {
		return new Gamma();
	}
	
	@Bean
	public Gamma gamma2() {
		return new Gamma();
	}
	
	@Bean
	public Gamma gamma3() {
		return new Gamma();
	}
	
	@Bean
	public Delta delta1() {
		return new Delta();
	}
	
	@Bean
	public Delta delta2() {
		return new Delta();
	}
} 
class Alpha {
	@Autowired
	Beta[] betas;
	@Autowired
	List<Gamma> gammas;
	@Autowired
	Map<String, Delta> deltas;	
}
class Beta {
	
}
class Gamma {
	
}
class Delta {
	
}
