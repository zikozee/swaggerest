package com.zikozee.swaggerest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

@Configuration
public class SwaggerConfig {

        @Bean
        public Docket api() {
            return new Docket(DocumentationType.SWAGGER_2)
                    .select()
                    .apis(RequestHandlerSelectors.any())
                    .paths(PathSelectors.any())
                    .build()
                    .apiInfo(metaData());
        }

        private ApiInfo metaData(){

            Contact contact = new Contact("Ezekiel Eromosei", "https://github.com/zikozee/swaggerest",
                    "ezekiel.eromosei@gmail.com");

            return new ApiInfo(
                    "My Swagger Rest Repository",
                    "My swagger funky-sized repo",
                    "1.0",
                    "Terms of Service: Free baby",
                    contact,
                    "Apache License Version 2.0",
                    "https://www.apache.org/licenses/LICENSE-2.0",
                    new ArrayList<>());
        }
}
