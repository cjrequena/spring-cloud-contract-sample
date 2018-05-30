package com.sample.springcloudcontractconsumer;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * <p>
 * <p>
 * <p>
 * <p>
 *
 * @author cjrequena
 * @version 1.0
 * @see
 * @since JDK1.8
 */
@Log4j2
@SpringBootApplication
@EnableFeignClients
public class MainApplication { //NOSONAR


  private static Class<MainApplication> mainApplicationClass = MainApplication.class;

  /**
   * @param args
   * @throws Exception
   */
  public static void main(String[] args)  {
    try {
      SpringApplication springApplication = new SpringApplication(mainApplicationClass);
      springApplication.run(args);
    } catch (Exception ex) {
      log.error("Error: " + ex);
      throw ex;
    }
  }
}

