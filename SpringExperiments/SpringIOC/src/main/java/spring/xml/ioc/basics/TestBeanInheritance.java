package spring.xml.ioc.basics;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBeanInheritance {

	public static void main(String[] args) {
		ApplicationContext container = new ClassPathXmlApplicationContext("BeanInheritance.xml");
		
		Hitman luca = container.getBean("luca", Hitman.class);
		Hitman mcclasky = container.getBean("mcclaski", Hitman.class);
		Hitman neri = container.getBean("neri", Hitman.class);
		
		System.out.println(luca.toString());
		System.out.println(mcclasky.toString());
		System.out.println(neri.toString());
	}
}
class Boss {
	
	String bossName;
	
	public void setBossName(String bossName) {
		this.bossName = bossName;
	}
}

class Hitman extends Boss {
	
	String name;
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return this.name + " reports to " + super.bossName;
	}
	
}
