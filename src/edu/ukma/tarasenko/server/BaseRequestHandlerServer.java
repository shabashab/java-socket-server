package edu.ukma.tarasenko.server;

public abstract class BaseRequestHandlerServer extends ClientHandlingServerBase {
  private final RequestParser _requestParser;
  private final ResponseFactory _responseFactory;

  protected abstract void handleRequest(Request request, Response response) throws Exception;

  public BaseRequestHandlerServer(RequestParser requestParser, ResponseFactory responseFactory) {
    _requestParser = requestParser;
    _responseFactory = responseFactory;
  }

  @Override
  protected void handleClient(Client client) throws Exception {
    Request request = _requestParser.parseFromClient(client);
    Response response = _responseFactory.createForClient(client);

    handleRequest(request, response);
  }
}
