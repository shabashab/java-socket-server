package edu.ukma.tarasenko.server;

public interface Request {
  String getMethod();
  String getPath();
  String getHttpVersion();
  Client getClient();
}
