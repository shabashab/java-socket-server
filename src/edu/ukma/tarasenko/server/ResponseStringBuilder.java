package edu.ukma.tarasenko.server;

public interface ResponseStringBuilder {
  String buildStatusLine(int status);
  String buildHeaders(Headers headers);
}
