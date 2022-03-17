package edu.ukma.tarasenko.server;

import java.net.Socket;

public abstract class ClientHandlingServerBase extends SocketServerBase {
  protected abstract void handleClient(Client client) throws Exception;

  @Override
  protected void handleSocket(Socket socket) throws Exception {
    Client client = new PlainSocketClient(socket);
    handleClient(client);
  }
}
