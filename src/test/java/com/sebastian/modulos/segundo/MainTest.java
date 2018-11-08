package com.sebastian.modulos.segundo;

import io.helidon.common.http.Http;
import io.helidon.webserver.WebServer;
import io.helidon.webserver.testsupport.TestClient;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Sebastian Avila A.
 */
public class MainTest {

  @Test
  public void testShutDown() throws Exception {
    var response = TestClient.create(Main.crearRutas())
            .path("/shutdown")
            .post();
    assertEquals(Http.Status.OK_200, response.status());
    CountDownLatch latch = new CountDownLatch(1);
    WebServer webServer = response.webServer();
    webServer.whenShutdown().thenRun(latch::countDown);
    assertTrue(latch.await(2, TimeUnit.SECONDS));
  }

  @Test
  public void testSaludo() throws Exception {
    var response = TestClient.create(Main.crearRutas())
            .path("/api")
            .get();
    assertEquals(Http.Status.OK_200, response.status());
    assertTrue(response.asString().get().equals("{\"mensaje\":\"hola\"}"));
  }

}
