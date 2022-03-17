package edu.ukma.tarasenko.server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerImpl implements Server {
  private void handleClient(Socket client) throws IOException {
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
    writer.write("Hello, world");
    writer.close();
  }

  @Override
  public void start(int port) throws IOException {
    ServerSocket server = new ServerSocket(port);

    while(!server.isClosed()) {
      Socket client = server.accept();
      handleClient(client);
    }
  }
}
