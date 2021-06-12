package cr.ac.ucr.ProyectoHotelero;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer{

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		WebMvcConfigurer.super.addResourceHandlers(registry);
		registry.addResourceHandler("/uploads/**").addResourceLocations("file:/C:/Users/charlylen/Documents/workspace-spring-tool-suite-4-4.10.0.RELEASE/ProyectoHotelero/src/main/resources/static/imagenes/");
	}
}