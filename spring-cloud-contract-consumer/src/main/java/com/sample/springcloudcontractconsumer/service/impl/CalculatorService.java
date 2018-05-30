package com.sample.springcloudcontractconsumer.service.impl;

import com.sample.springcloudcontractconsumer.service.ICalculatorService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Log4j2
@Service
public class CalculatorService implements ICalculatorService{

  @Autowired
  CalculatorServiceFeignClient calculatorServiceFeignClient;

  @Override
  public String validatePrimeNumber(Integer number) {
    return calculatorServiceFeignClient.validatePrimeNumber(number);
  }

  /**
   *
   */
  @FeignClient(name = "calculator-service", url = "http://localhost:8080/calculator-service")
  public interface CalculatorServiceFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "/validate-prime-number")
    String validatePrimeNumber(@RequestParam("number") Integer number);

  }
}
