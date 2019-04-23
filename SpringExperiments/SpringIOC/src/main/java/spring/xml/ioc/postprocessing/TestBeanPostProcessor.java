package spring.xml.ioc.postprocessing;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBeanPostProcessor {

	public static void main(String[] args) {
		ApplicationContext container = new ClassPathXmlApplicationContext("BeanPostProcessor.xml");
		((ConfigurableApplicationContext)container).close();		
	}
}

class Foo {
	
}

class Bar {
	
}

class MyBeanPostProcessor implements BeanPostProcessor {

	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("postProcessBeforeInitialization invoked for bean "+beanName);
		return bean;
	}

	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("postProcessAfterInitialization invoked for bean "+beanName);
		return bean;
	}
	
}
