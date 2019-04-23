package spring.xml.ioc.factory;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestFactoryBean {
	
	public static void main(String[] args) {
		ApplicationContext container = new ClassPathXmlApplicationContext("FactoryBean.xml");
		Dummy d1 = (Dummy) container.getBean("factory");
		Dummy d2 = (Dummy) container.getBean("factory");
		// should print true
		System.out.println(d1 == d2);
	}
	
}

class DummyFactory implements FactoryBean<Dummy>{

	public Dummy getObject() throws Exception {
		return new Dummy();
	}

	public Class<?> getObjectType() {
		return Dummy.class;
	}

	public boolean isSingleton() {
		return true;
	}
	
}
class Dummy {
	
}
