package edu.ukma.tarasenko.server;

public class RequestHandlerServer extends BaseRequestHandlerServer {
  private final RequestHandlerProvider _handlerProvider;

  public RequestHandlerServer(RequestHandlerProvider handlerProvider, RequestParser requestParser, ResponseFactory responseFactory) {
    super(requestParser, responseFactory);
    _handlerProvider = handlerProvider;
  }

  @Override
  protected void handleRequest(Request request, Response response) throws Exception {
    RequestHandler handler = this._handlerProvider.provideForRequest(request);
    handler.handleRequest(request, response);
  }
}
