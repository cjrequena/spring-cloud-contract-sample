package com.sample.springcloudcontractproducer.configuration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.filter.ShallowEtagHeaderFilter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.zalando.jackson.datatype.money.MoneyModule;

import javax.servlet.Filter;

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
public class WebConfiguration extends WebMvcConfigurerAdapter {

  /**
   * Jackson builder.
   * @return the jackson2 object mapper builder
   */
  @Bean
  public Jackson2ObjectMapperBuilder jacksonBuilder() {
    final Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
    builder.indentOutput(true);
    builder.featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    return builder;
  }

  /**
   * 
   * @return
   */
  @Bean
  public ObjectMapper objectMapper() {
    ObjectMapper builder = jacksonBuilder().simpleDateFormat("yyyy-MM-dd").modules(new JavaTimeModule()).build();
    builder.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    builder.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
    builder.registerModule(new MoneyModule());
    builder.registerModule(new MoneyModule().withDefaultFormatting());
    return builder;
  }

  /**
   *
   * @return
   */
  @Bean
  public Filter shallowEtagHeaderFilter() {
    return new ShallowEtagHeaderFilter();
  }
}
