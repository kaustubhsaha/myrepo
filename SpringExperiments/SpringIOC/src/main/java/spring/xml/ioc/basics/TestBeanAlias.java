package spring.xml.ioc.basics;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBeanAlias {

	public static void main(String[] args) {
		ApplicationContext container = new ClassPathXmlApplicationContext("TestAlias.xml");
		SimpleDummyBean drogon = container.getBean("drogon", SimpleDummyBean.class);
		SimpleDummyBean viscerion = container.getBean("viscerion", SimpleDummyBean.class);
		SimpleDummyBean rhaegal = container.getBean("rhaegal", SimpleDummyBean.class);
		SimpleDummyBean khaleesi = container.getBean("khaleesi", SimpleDummyBean.class);
		
		// all of them should print true
		System.out.println(drogon == viscerion);
		System.out.println(viscerion == rhaegal);
		System.out.println(rhaegal == drogon);		
		System.out.println(khaleesi == drogon);
	}
}

class SimpleDummyBean {
	
}
