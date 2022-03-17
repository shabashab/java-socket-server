package edu.ukma.tarasenko.server;

import java.net.Socket;

public class SocketHandlerServer extends SocketServerBase {
  private final SocketHandler _socketHandler;

  public SocketHandlerServer(SocketHandler handler) {
    _socketHandler = handler;
  }

  @Override
  protected void handleSocket(Socket client) throws Exception {
    this._socketHandler.handleSocket(client);
  }
}
