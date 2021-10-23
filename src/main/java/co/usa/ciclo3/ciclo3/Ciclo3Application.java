package co.usa.ciclo3.ciclo3;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
        

//@EntityScan(basePackages={"co.usa.ciclo3.ciclo3.entities"})

//@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
//@SpringBootApplication
public class Ciclo3Application {

public static void main2(String[] args) {
		SpringApplication.run(Ciclo3Application.class, args);
                int i = 1;
	}
      	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/Category/all").allowedOrigins("http://129.151.123.218:8080/");
                                registry.addMapping("/Category/save").allowedOrigins("http://129.151.123.218:8080/");
				registry.addMapping("/Client/all").allowedOrigins("http://129.151.123.218:8080/");
                                registry.addMapping("/Client/save").allowedOrigins("http://129.151.123.218:8080/");
                                registry.addMapping("/Motorbike/save").allowedOrigins("http://129.151.123.218:8080/");
                                registry.addMapping("/Motorbike/all").allowedOrigins("http://129.151.123.218:8080/");
			}
		};
	}

}
