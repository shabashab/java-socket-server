package edu.ukma.tarasenko.server;

public interface RequestHandler {
  void handleRequest(Request request, Response response);
}
