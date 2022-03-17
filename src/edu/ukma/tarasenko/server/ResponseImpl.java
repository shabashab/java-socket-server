package edu.ukma.tarasenko.server;


import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ResponseImpl implements Response {
  private final ResponseStringBuilder _responseStringBuilder;
  private final Client _client;

  public ResponseImpl(
          Client client,
          ResponseStringBuilder responseStringBuilder
  ) {
    _client = client;
    _responseStringBuilder = responseStringBuilder;
  }

  @Override
  public void sendPlain(int status, String text) throws IOException {
    Headers headers = new HeadersMap();
    headers.setValue("Content-Type", "text/plain");
    headers.setValue("Content-Length", String.valueOf(text.length()));

    String statusLine = _responseStringBuilder.buildStatusLine(status);
    String headersString = _responseStringBuilder.buildHeaders(headers);

    String responseString = statusLine + "\r\n" +
            headersString + "\r\n" +
            text;

    Socket socket = _client.getSocket();
    OutputStream outputStream = socket.getOutputStream();

    outputStream.write(responseString.getBytes(StandardCharsets.UTF_8));

    socket.close();
  }
}
