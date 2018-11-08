package com.sebastian.modulos.segundo;

import io.helidon.common.http.Http.Status;
import io.helidon.webserver.Routing;
import io.helidon.webserver.ServerRequest;
import io.helidon.webserver.ServerResponse;
import io.helidon.webserver.Service;
import javax.json.bind.JsonbBuilder;


class Recursos implements Service {

  @Override
  public void update(Routing.Rules rules) {
    rules.get("/", this::root);
  }

  private void root(final ServerRequest req, final ServerResponse res) {
    res.status(Status.OK_200).send(JsonbBuilder.create().toJson(new Saludo("hola")));
  }
}
