package ua.com.owu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;



@Configuration
// анотація, яка каже, що цей клас буде генерувати біни
// Методи, які нам повертають об'єкти, із анотацією бін автоматично ставатимуть бінами
@EnableWebMvc
// активує мвс патеррн
@ComponentScan("ua.com.owu.*")
// сканує наявність анотацій в пакетах
public class WebConfig extends WebMvcConfigurerAdapter {

    @Bean
    public InternalResourceViewResolver viewResolver(){
// цей бін відповідає за розташування шаблонів (сторінок)

        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/pages/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
}
