/**
 * 
 */
package ari.biblio;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author remij
 *
 */
@Configuration
public class MvcConfiguration implements WebMvcConfigurer{

	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/home").setViewName("home");
		registry.addViewController("/").setViewName("home");
		registry.addViewController("/lecteur").setViewName("lecteur");
		registry.addViewController("/auteur").setViewName("auteur");
		registry.addViewController("/bibliotheque").setViewName("bibliotheque");
	}

}
