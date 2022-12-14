package crm.client.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("crm.client")
@PropertySource({ "classpath:application.properties" })
public class WebAppConfigurer implements WebMvcConfigurer {

	
	private java.util.logging.Logger logger = java.util.logging.Logger.getLogger(getClass().getName());

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// <mvc:resources location="/resources/"
		// mapping="/resources/**"></mvc:resources>
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}


}
