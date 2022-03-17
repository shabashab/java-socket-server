package edu.ukma.tarasenko.server;

import java.net.Socket;

public interface ResponseFactory {
  Response createForSocket(Socket socket);
}
