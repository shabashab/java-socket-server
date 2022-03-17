package edu.ukma.tarasenko;

import edu.ukma.tarasenko.server.*;

import java.io.IOException;

public class Main {
  private static final int PORT = 8000;

  private static Server createServer() {
    return new SingleRequestHandlerServer((request, response) -> response.sendPlain(200, request.getPath() + "\nHello, Putin, suka!"), new RequestParserImpl(), new ResponseFactoryImpl());
  }

  public static void main(String[] args) throws IOException {
    Server server = createServer();
    server.start(PORT);
  }
}
