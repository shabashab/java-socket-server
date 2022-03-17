package edu.ukma.tarasenko.server;

public class RequestHandlerServer extends ClientHandlingServerBase {
  private final RequestHandlerProvider _handlerProvider;
  private final RequestParser _requestParser;
  private final ResponseFactory _responseFactory;

  public RequestHandlerServer(RequestHandlerProvider handlerProvider, RequestParser requestParser, ResponseFactory responseFactory) {
    _requestParser = requestParser;
    _responseFactory = responseFactory;
    _handlerProvider = handlerProvider;
  }

  @Override
  protected void handleClient(Client client) throws Exception {
    Request request = _requestParser.parseFromClient(client);
    Response response = _responseFactory.createForClient(client);

    RequestHandler handler = this._handlerProvider.provideForRequest(request);
    handler.handleRequest(request, response);
  }
}
