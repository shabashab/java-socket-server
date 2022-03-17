package edu.ukma.tarasenko.server;

import java.net.Socket;

public class HandlerSocketServer extends SocketServerBase {
  private final ClientHandler _clientHandler;

  public HandlerSocketServer(ClientHandler handler) {
    _clientHandler = handler;
  }

  @Override
  protected void handleClient(Socket client) throws Exception {
    this._clientHandler.handleClient(client);
  }
}
