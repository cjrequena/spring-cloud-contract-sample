package com.sample.springcloudcontractproducer;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import lombok.extern.log4j.Log4j2;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

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
@Ignore
@Log4j2
@RunWith(SpringRunner.class)
@SpringBootTest(classes = { MainApplication.class }, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext
@AutoConfigureMessageVerifier
@ActiveProfiles({"local"})
public class ContractVerifierBase {

  @Autowired
  private WebApplicationContext context;

  /**
   *
   */
  @Before
  public void setup() {
    RestAssuredMockMvc.webAppContextSetup(this.context);
  }
}
