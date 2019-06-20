package com.helmes.swagger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Primary
@Component
public class DocumentationController implements SwaggerResourcesProvider {
    @Autowired
    private Application.Endpoints endpoints;

    @Override
    public List<SwaggerResource> get() {
        List<SwaggerResource> resources = new ArrayList<>();
        HashMap<String, String> endpoints = this.endpoints.getEndpoints();
        endpoints.forEach((key, value) -> {
            SwaggerResource resource = new SwaggerResource();
            resource.setName(key);
            resource.setUrl(value);
            resource.setSwaggerVersion(DocumentationType.SWAGGER_2.getVersion());
            resources.add(resource);
        });
        return resources;
    }
}
