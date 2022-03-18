package edu.ukma.tarasenko;

import edu.ukma.tarasenko.server.*;

import java.io.IOException;

public class Main {
  private static final int PORT = 8000;

  private static Server createServer() {
    MultipleRequestHandlerServer server = new MultipleRequestHandlerServer(
            new RequestParserImpl(), new ResponseFactoryImpl()
    );

    server.registerHandler(new ExactPathRequestMatcher("/putin"), (request, response) -> {
      response.sendPlain(200, "Putin Huilo!");
    });

    server.registerHandler(new ExactPathRequestMatcher("/hello"), (request, response) -> {
      response.sendPlain(200, "Hi dude!");
    });

    server.registerHandler(new StaticRequestHandler("static/"));

    server.registerHandler((request, response) -> response.sendPlain(404, ":("));

    return server;
  }

  public static void main(String[] args) throws IOException {
    Server server = createServer();
    server.start(PORT);
  }
}
