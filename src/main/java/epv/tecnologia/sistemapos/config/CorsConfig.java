package epv.tecnologia.sistemapos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CorsConfig {
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
      return  new WebMvcConfigurer() {
          @Override
          public void addCorsMappings(CorsRegistry registry) {
              WebMvcConfigurer.super.addCorsMappings(registry);
              registry.addMapping("/media/**")
                      .allowedOrigins("*")
                      .allowedMethods("*");
          }

          @Override
          public void addResourceHandlers(ResourceHandlerRegistry registry) {
              WebMvcConfigurer.super.addResourceHandlers(registry);
              registry.addResourceHandler("/mediafiles/**")
                      .addResourceLocations("/mediafiles/");
          }
      };

    }
}
