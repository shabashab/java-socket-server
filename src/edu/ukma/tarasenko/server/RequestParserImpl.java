package edu.ukma.tarasenko.server;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RequestParserImpl implements RequestParser {
  @Override
  public Request parseFromClient(Client client) throws Exception {
    InputStream stream = client.getSocket().getInputStream();
    BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

    String requestLine = reader.readLine();
    String[] requestLineSplit = requestLine.split("\s");

    return new Request() {
      @Override
      public String getMethod() {
        return requestLineSplit[0];
      }

      @Override
      public String getPath() {
        return requestLineSplit[1];
      }

      @Override
      public String getHttpVersion() {
        return requestLineSplit[2];
      }

      @Override
      public Client getClient() {
        return client;
      }
    };
  }
}
