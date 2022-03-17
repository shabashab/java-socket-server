package edu.ukma.tarasenko.server;

import java.io.IOException;

public interface Response {
  void sendPlain(int status, String text) throws IOException;
}
