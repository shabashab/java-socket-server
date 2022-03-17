package edu.ukma.tarasenko.server;

import java.io.IOException;

public interface RequestHandler {
  void handleRequest(Request request, Response response) throws IOException;
}
