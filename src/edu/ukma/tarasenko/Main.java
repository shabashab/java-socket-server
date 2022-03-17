package edu.ukma.tarasenko;

import edu.ukma.tarasenko.server.HandlerSocketServer;
import edu.ukma.tarasenko.server.Server;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Main {
  private static final int PORT = 8000;

  private static Server createServer() {
    return new HandlerSocketServer(socket -> {
      socket.getOutputStream().write("Hello, world".getBytes(StandardCharsets.UTF_8));
      socket.close();
    });
  }

  public static void main(String[] args) throws IOException {
    Server server = createServer();
    server.start(PORT);
  }
}
