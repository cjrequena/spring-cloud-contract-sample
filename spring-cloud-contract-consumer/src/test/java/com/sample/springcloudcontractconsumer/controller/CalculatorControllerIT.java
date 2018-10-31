package com.sample.springcloudcontractconsumer.controller;

import com.sample.springcloudcontractconsumer.MainApplication;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MainApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMessageVerifier
@AutoConfigureJsonTesters
@DirtiesContext
@AutoConfigureMockMvc
@AutoConfigureStubRunner
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@ActiveProfiles({
  "local"
})
public class CalculatorControllerIT {

  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
  }

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void given_WhenPassEvenNumberInQueryParam_ThenReturnEven() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/calculator-api/validate-prime-number?number=2")
      .contentType(MediaType.APPLICATION_JSON))
      .andExpect(status().isOk())
      .andExpect(content().string("Even"));
  }

  @Test
  public void given_WhenPassOddNumberInQueryParam_ThenReturnOdd() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/calculator-api/validate-prime-number?number=1")
      .contentType(MediaType.APPLICATION_JSON))
      .andExpect(status().isOk())
      .andExpect(content().string("Odd"));
  }
}
