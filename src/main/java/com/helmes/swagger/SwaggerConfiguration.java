package com.helmes.swagger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfiguration {
    @Value("{meta.title}")
    private String title;
    @Value("{meta.description}")
    private String description;
    @Value("{meta.licence}")
    private String licence;
    @Value("{meta.licenceUrl}")
    private String licenceUrl;
    @Value("{meta.tosUrl}")
    private String tosUrl;
    @Value("{meta.version}")
    private String version;
    @Value("{contact.name}")
    private String name;
    @Value("{contact.url}")
    private String url;
    @Value("{contact.email}")
    private String email;

    ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(title)
                .description(description)
                .license(licence)
                .licenseUrl(licenceUrl)
                .termsOfServiceUrl(tosUrl)
                .version(version)
                .contact(new Contact(name,url, email))
                .build();
    }

    @Bean
    public Docket customImplementation(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }
}
