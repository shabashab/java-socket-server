package edu.ukma.tarasenko.server;

public interface Response {
  void sendPlain(int status, String text);
}
