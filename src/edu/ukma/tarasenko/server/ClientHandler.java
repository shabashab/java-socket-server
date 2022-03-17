package edu.ukma.tarasenko.server;

import java.net.Socket;

public interface ClientHandler {
  void handleClient(Socket socket) throws Exception;
}
