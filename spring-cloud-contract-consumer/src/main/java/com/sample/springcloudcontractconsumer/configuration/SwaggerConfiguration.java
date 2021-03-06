package com.sample.springcloudcontractconsumer.configuration;

import com.fasterxml.classmate.TypeResolver;
import com.sample.springcloudcontractconsumer.controller.CalculatorController;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.WildcardType;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.DocExpansion;
import springfox.documentation.swagger.web.ModelRendering;
import springfox.documentation.swagger.web.OperationsSorter;
import springfox.documentation.swagger.web.TagsSorter;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;

import static springfox.documentation.schema.AlternateTypeRules.newRule;

/**
 * <p>
 * <p>
 * <p>
 * <p>
 * @author cjrequena
 * @version 1.0
 * @since JDK1.8
 * @see
 *
 */
@Configuration
@EnableSwagger2
@ComponentScan(basePackageClasses = {
  CalculatorController.class
})
public class SwaggerConfiguration {

  /** The type resolver. */
  @Autowired
  private TypeResolver typeResolver;

  /**
   * Metadata.
   *
   * @return the api info
   */
  @Bean
  public ApiInfo metadata() {
    return new ApiInfoBuilder()
      .title("Project Name")
      .description("Project Description")
      .version("v1")
      .build();
  }

  /**
   * Docket factory.
   *
   * @return the docket
   */
  @Bean
  public Docket docketFactory() {
    return new Docket(DocumentationType.SWAGGER_2)
      .select()
        .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
        .paths(PathSelectors.any())
        . build()
      .pathMapping("/")
      .directModelSubstitute(LocalDate.class, String.class)
      .directModelSubstitute(LocalDateTime.class, String.class)
      .directModelSubstitute(LocalTime.class, String.class)
      .directModelSubstitute(OffsetDateTime.class, String.class)
      .directModelSubstitute(OffsetTime.class, String.class)
      .genericModelSubstitutes(ResponseEntity.class)
      .alternateTypeRules(
        newRule(typeResolver.resolve(DeferredResult.class, typeResolver.resolve(ResponseEntity.class, WildcardType.class)), typeResolver.resolve(WildcardType.class))
      )
      .useDefaultResponseMessages(false)
      .apiInfo(metadata());
  }

  /**
   * Swagger ui config.
   *
   * @return the ui configuration
   */
  @Bean
  public UiConfiguration uiConfiguration() {
    return UiConfigurationBuilder.builder()
      .deepLinking(true)
      .displayOperationId(false)
      .defaultModelsExpandDepth(1)
      .defaultModelExpandDepth(1)
      .defaultModelRendering(ModelRendering.EXAMPLE)
      .displayRequestDuration(false)
      .docExpansion(DocExpansion.FULL)
      .filter(false)
      .maxDisplayedTags(null)
      .operationsSorter(OperationsSorter.ALPHA)
      .showExtensions(false)
      .tagsSorter(TagsSorter.ALPHA)
      .validatorUrl(null)
      .build();
  }

}
