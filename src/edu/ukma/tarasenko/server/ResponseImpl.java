package edu.ukma.tarasenko.server;


import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class ResponseImpl implements Response {
  private final ResponseStringBuilder _responseStringBuilder;
  private final Client _client;
  private boolean _isSent;

  public ResponseImpl(
          Client client,
          ResponseStringBuilder responseStringBuilder
  ) {
    _client = client;
    _responseStringBuilder = responseStringBuilder;
    _isSent = false;
  }

  @Override
  public boolean isSent() {
    return _client.getSocket().isClosed() || _isSent;
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
    _isSent = true;
  }

  private void sendStream(int status, InputStream stream, Headers headers) throws IOException {
    String statusLine = _responseStringBuilder.buildStatusLine(status);
    String headersString = _responseStringBuilder.buildHeaders(headers);

    String requestString = statusLine + "\r\n" + headersString + "\r\n";

    Socket socket = _client.getSocket();
    OutputStream outputStream = socket.getOutputStream();

    outputStream.write(requestString.getBytes(StandardCharsets.UTF_8));

    byte[] bytes = new byte[1024];
    int count;

    while((count = stream.read(bytes)) > 0) {
      outputStream.write(bytes, 0, count);
    }

    socket.close();
    _isSent = true;
  }

  @Override
  public void sendFile(int status, File file) throws IOException {
    Headers headers = new HeadersMap();
    headers.setValue("Content-Length", String.valueOf(file.length()));
    headers.setValue("Content-Type", Files.probeContentType(file.toPath()));

    FileInputStream stream = new FileInputStream(file);
    sendStream(status, stream, headers);
  }
}
