package edu.ukma.tarasenko.server;

import java.net.Socket;

public class PlainSocketClient implements Client {
  private final Socket _socket;

  PlainSocketClient(Socket socket) {
    _socket = socket;
  }

  @Override
  public Socket getSocket() {
    return _socket;
  }
}
