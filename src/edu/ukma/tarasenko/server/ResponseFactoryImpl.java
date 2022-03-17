package edu.ukma.tarasenko.server;

public class ResponseFactoryImpl implements ResponseFactory {
  @Override
  public Response createForClient(Client client) {
    return new ResponseImpl(client, new ResponseStringBuilderImpl());
  }
}
