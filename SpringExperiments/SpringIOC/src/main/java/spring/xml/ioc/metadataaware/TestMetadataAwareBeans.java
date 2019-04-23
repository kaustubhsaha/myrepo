package spring.xml.ioc.metadataaware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMetadataAwareBeans {

	public static void main(String[] args) {
		System.out.println("Starting container loading");
		ApplicationContext container = new ClassPathXmlApplicationContext("MetadataAware.xml");
		((ConfigurableApplicationContext)container).close();		
	}
}
class TestBean implements ApplicationContextAware, BeanNameAware {

	public void setBeanName(String name) {
		System.out.println("Bean Name Injected : "+name);
		
	}

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("Application context injected : "+applicationContext);
	}
	
}
