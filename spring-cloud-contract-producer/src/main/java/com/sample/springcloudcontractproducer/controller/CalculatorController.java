package com.sample.springcloudcontractproducer.controller;

import com.sample.springcloudcontractproducer.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/calculator-service")
public class CalculatorController {

  @Autowired
  ICalculatorService calculatorService;

  @GetMapping("/validate-prime-number")
  public String validatePrimeNumber(@RequestParam("number") Integer number) {
    return calculatorService.validatePrimeNumber(number);
  }
}
