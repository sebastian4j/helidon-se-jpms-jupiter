package com.sebastian.modulos.segundo;

import io.helidon.common.http.Http.Status;
import io.helidon.common.http.MediaType;
import io.helidon.webserver.Routing;
import io.helidon.webserver.ServerConfiguration;
import io.helidon.webserver.WebServer;
import io.helidon.webserver.json.JsonSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

  private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

  public static void main(String[] args) {
    WebServer.create(ServerConfiguration.builder().port(8080).build(), crearRutas()).start();
  }

  public static Routing crearRutas() {
    return Routing.builder()
            .register(JsonSupport.get())
            .register("/api", new Recursos())
            .post("/shutdown", (req, res) -> {
              res.headers().contentType(MediaType.TEXT_PLAIN.withCharset("UTF-8"));
              res.send("shutting down");
              res.whenSent().thenRun(() -> req.webServer().shutdown());
            })
            .error(Exception.class, (req, res, ex) -> {
              res.status(Status.INTERNAL_SERVER_ERROR_500);
              res.send("Unable to parse request");
              LOGGER.log(Level.SEVERE, "Unable to parse request", ex);
              LOGGER.log(Level.SEVERE, "request", req);
            }).build();
  }
}
