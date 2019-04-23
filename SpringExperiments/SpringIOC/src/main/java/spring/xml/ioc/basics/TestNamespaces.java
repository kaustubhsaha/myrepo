package spring.xml.ioc.basics;

import java.beans.ConstructorProperties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestNamespaces {

	public static void main(String[] args) {
		ApplicationContext container = new ClassPathXmlApplicationContext("UsingNamespaces.xml");
		MafiaFamily corleone1 = container.getBean("corleone1", MafiaFamily.class);
		MafiaFamily corleone2 = container.getBean("corleone2", MafiaFamily.class);
		MafiaFamily corleone3 = container.getBean("corleone3", MafiaFamily.class);
		MafiaFamily corleone4 = container.getBean("corleone4", MafiaFamily.class);
		
		// should print the same thing - 4 times over
		System.out.println(corleone1);
		System.out.println(corleone2);
		System.out.println(corleone3);
		System.out.println(corleone4);
	}
}
class MafiaFamily {
	
	String boss;
	String conseglerie;
	
	String henchman;
	String caporegime;
	
	@ConstructorProperties({"boss","conseglerie"})
	public MafiaFamily(String boss, String conseglerie) {
		this.boss = boss;
		this.conseglerie = conseglerie;
	}

	public void setCaporegime(String caporegime) {
		this.caporegime = caporegime;
	}

	public void setHenchman(String henchman) {
		this.henchman = henchman;
	}

	@Override
	public String toString() {
		return "MafiaFamily [boss=" + boss + ", conseglerie=" + conseglerie + ", henchman=" + henchman + ", caporegime="
				+ caporegime + "]";
	}
	
}
