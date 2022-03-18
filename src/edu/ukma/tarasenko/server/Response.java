package edu.ukma.tarasenko.server;

import java.io.File;
import java.io.IOException;

public interface Response {
  boolean isSent();
  void sendPlain(int status, String text) throws IOException;
  void sendFile(int status, File file) throws IOException;
}
