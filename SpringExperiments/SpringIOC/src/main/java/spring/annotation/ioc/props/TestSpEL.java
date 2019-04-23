package spring.annotation.ioc.props;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestSpEL {

	public static void main(String[] args) {
		System.setProperty("message", "Thank you Mario but princess is in another castle");
		
		ApplicationContext container = new AnnotationConfigApplicationContext(TestSpEL.class);
		Bar b = container.getBean(Bar.class);
		System.out.println(b.toString());
	}
	
	@Bean
	public Bar bar() {
		return new Bar();
	}
	
}
class Bar {
	
	@Value("#{systemProperties['motto']}")
	private String message;
	
	@Override
	public String toString() {
		return message;
	}
}
