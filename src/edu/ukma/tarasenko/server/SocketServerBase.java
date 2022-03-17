package edu.ukma.tarasenko.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public abstract class SocketServerBase implements Server {
  protected abstract void handleSocket(Socket client) throws Exception;

  @Override
  public void start(int port) throws IOException {
    ServerSocket server = new ServerSocket(port);

    while (!server.isClosed()) {
      Socket client = server.accept();

      try {
        handleSocket(client);
      } catch (Exception e) {
        System.out.println("Failed to handle connection from " + client.getInetAddress().toString() + ". " + e.getMessage());
      }
    }
  }
}
