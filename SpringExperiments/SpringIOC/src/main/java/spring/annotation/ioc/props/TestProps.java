package spring.annotation.ioc.props;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Component;

@Configuration
@PropertySource("classpath:dummy.properties")
@ComponentScan(basePackages= {"spring.annotation.props"})
public class TestProps {

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfig() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	public static void main(String[] args) {
		ApplicationContext container = new AnnotationConfigApplicationContext(TestProps.class);
		Foo f = container.getBean(Foo.class);
		System.out.println(f);
	}
}
@Component
class Foo {
	
	@Value("${motto}")
	private String message;
	
	@Override
	public String toString() {
		return message;
	}
}
