package spring.annotations.ioc.autowiring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

public class TestBeanPreference {

	@Bean
	public KingsLanding kingslanding() {
		return new KingsLanding();
	}
	
	@Bean
	@Primary
	public Family stark() {
		return new Family("Winter is coming");
	}
	
	@Bean
	public Family tully() {
		return new Family("Family.Duty.Honor");
	}
	
	@Bean
	public Family greyjoy() {
		return new Family("We do not sow");
	}
	
	public static void main(String[] args) {
		ApplicationContext container = new AnnotationConfigApplicationContext(TestBeanPreference.class);
		KingsLanding kl = container.getBean(KingsLanding.class);
		// should print 'Winter is coming'
		System.out.println(kl.ruler.motto);
	}
	
}
class Family {
	String motto;
	
	public Family(String motto) {
		this.motto = motto;
	}
}
class KingsLanding {
	
	@Autowired
	Family ruler;

}
