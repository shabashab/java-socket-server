package edu.ukma.tarasenko.server;

public class SingleRequestHandlerServer extends RequestHandlerServer {
  public SingleRequestHandlerServer(RequestHandler handler, RequestParser requestParser, ResponseFactory responseFactory) {
    super(request -> handler, requestParser, responseFactory);
  }
}
