package lv.aml.adversemediascreening.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "lv.aml.adversemediascreening")
@EntityScan(basePackages = "lv.aml.adversemediascreening.core.domain")
@EnableJpaRepositories(basePackages = "lv.aml.adversemediascreening.core.dao")
public class AppCoreConfig {

    public static void main(String[] args) {
        SpringApplication.run(AppCoreConfig.class, args);
    }

}