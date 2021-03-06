package com.ac.ac.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
@EnableSwagger2
class SwaggerConfig {

    @Bean
    fun api(): Docket? {
        return Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors
                        .basePackage("com.ac.ac.controller"))
                .paths(PathSelectors.ant("/**"))
                .build()
                .apiInfo(apiDetail())
    }

    private fun apiDetail(): ApiInfo? {
        return ApiInfo(
                "AC API documentation",
                "Documentation for the API of AC",
                "0.1",
                "MIT",
                Contact("AC", "", "enzoarauco@gmail.com"),
                "",
                "", emptyList())
    }

}