package spring.annotation.ioc.namegenerator;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan(basePackages= {"spring.annotation.ioc.namegenerator"}, nameGenerator=MyNameGenerator.class)
public class TestNameGenerator {
	
	public static void main(String[] args) {
		ApplicationContext container = new AnnotationConfigApplicationContext(TestNameGenerator.class);
	}
	
}

class MyNameGenerator implements BeanNameGenerator {

	private int count;
	
	public String generateBeanName(BeanDefinition definition, BeanDefinitionRegistry registry) {
		String className = definition.getBeanClassName();
		return className.toLowerCase() + "-" + count;
	}

	
}
@Component
class Dummy implements BeanNameAware {

	public void setBeanName(String name) {
		System.out.println("Bean defined with name : "+name);	
	}
	
}
