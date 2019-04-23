package spring.annotation.ioc.filter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Component
@ComponentScan(basePackages= {"spring.annotation.ioc.filter"},
					includeFilters = @Filter(Repository.class),
					excludeFilters = @Filter(Service.class)
				)
public class TestComponentScanFilter {

	public static void main(String[] args) {
		ApplicationContext container = new AnnotationConfigApplicationContext(TestComponentScanFilter.class);
		// should print true
		System.out.println(container.containsBean("foo"));
		// should print false
		System.out.println(container.containsBean("bar"));
	}
}
@Repository("foo")
class Foo {
	
}
@Service("bar")
class Bar {
	
}

