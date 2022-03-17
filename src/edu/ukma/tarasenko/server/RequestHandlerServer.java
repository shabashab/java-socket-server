package edu.ukma.tarasenko.server;

import java.io.InputStream;
import java.net.Socket;

public class RequestHandlerServer extends SocketServerBase {
  private final RequestHandlerProvider _handlerProvider;
  private final RequestParser _requestParser;
  private final ResponseFactory _responseFactory;

  public RequestHandlerServer(RequestHandlerProvider handlerProvider, RequestParser requestParser, ResponseFactory responseFactory) {
    _requestParser = requestParser;
    _responseFactory = responseFactory;
    _handlerProvider = handlerProvider;
  }

  @Override
  protected void handleClient(Socket client) throws Exception {
    InputStream socketInputStream = client.getInputStream();

    Request request = _requestParser.parseFromStream(socketInputStream);
    Response response = _responseFactory.createForSocket(client);

    RequestHandler handler = this._handlerProvider.provideForRequest(request);
    handler.handleRequest(request, response);
  }
}
