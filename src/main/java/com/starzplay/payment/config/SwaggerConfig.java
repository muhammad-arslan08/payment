package com.starzplay.payment.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

  @Bean
  public Docket apiV1() {
    return new Docket(DocumentationType.SWAGGER_2)
        .groupName("V1")
        .select()
        .apis(RequestHandlerSelectors.any())
        .paths(regex("/api/v1.*"))
        .build()
        .apiInfo(new ApiInfoBuilder().version("1.0").title("Payment Methods API").build());
  }
}
