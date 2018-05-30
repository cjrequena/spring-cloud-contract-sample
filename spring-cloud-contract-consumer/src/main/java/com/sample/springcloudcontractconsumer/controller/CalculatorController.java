package com.sample.springcloudcontractconsumer.controller;

import com.sample.springcloudcontractconsumer.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
@RestController
@RequestMapping(value = "/calculator-api")
public class CalculatorController {

  @Autowired
  ICalculatorService calculatorService;

  @GetMapping("/validate-prime-number")
  public String validatePrimeNumber(@RequestParam("number") Integer number) {
    return calculatorService.validatePrimeNumber(number);
  }

}
