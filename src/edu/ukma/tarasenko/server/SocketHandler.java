package edu.ukma.tarasenko.server;

import java.net.Socket;

public interface SocketHandler {
  void handleSocket(Socket socket) throws Exception;
}
