package spring.xml.ioc.profile;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestProfile {

	public static void main(String[] args) {
		
		ApplicationContext container = new ClassPathXmlApplicationContext("TestProfile.xml");
		Motto m = null;
		try{
			m = container.getBean("motto", Motto.class);
		}
		catch (NoSuchBeanDefinitionException ex) {
			// fails because we havent setup a profile yet
			System.out.println(ex.getLocalizedMessage());
		}
		((ConfigurableApplicationContext)container).close();
		
		System.setProperty("spring.profiles.active", "lannister");
		
		container = new ClassPathXmlApplicationContext("TestProfile.xml");
		m = container.getBean("motto", Motto.class);
		System.out.println(m.toString());
		
	}
}
class Motto {
	String motto;
	
	public Motto(String motto) {
		this.motto = motto;
	}
	
	@Override
	public String toString() {
		return this.motto;
	}
}

