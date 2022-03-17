package edu.ukma.tarasenko;

import edu.ukma.tarasenko.server.Server;
import edu.ukma.tarasenko.server.ServerImpl;

import java.io.IOException;

public class Main {
  private static final int PORT = 8000;

  public static void main(String[] args) throws IOException {
    Server server = new ServerImpl();
    server.start(PORT);
  }
}
