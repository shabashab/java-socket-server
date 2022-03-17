package edu.ukma.tarasenko.server;

public class ResponseStringBuilderImpl implements ResponseStringBuilder {
  @Override
  public String buildStatusLine(int status) {
    return String.format("HTTP/1.1 %d", status);
  }

  @Override
  public String buildHeaders(Headers headers) {
    StringBuilder headersStringBuilder = new StringBuilder();
    for (String headerKey : headers.getNames()) {
      headersStringBuilder.append(String.format("%s: %s", headerKey, headers.getValue(headerKey))).append("\r\n");
    }
    return headersStringBuilder.toString();
  }
}
