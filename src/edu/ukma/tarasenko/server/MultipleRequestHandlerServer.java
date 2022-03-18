package edu.ukma.tarasenko.server;

import java.util.ArrayList;
import java.util.List;

record MatcherHandlerPair(RequestMatcher matcher, RequestHandler handler) {
}

public class MultipleRequestHandlerServer extends BaseRequestHandlerServer {
  private final List<MatcherHandlerPair> _handlers;

  public MultipleRequestHandlerServer(RequestParser requestParser, ResponseFactory responseFactory) {
    super(requestParser, responseFactory);

    _handlers = new ArrayList<>();
  }

  public void registerHandler(RequestMatcher matcher, RequestHandler handler) {
    _handlers.add(new MatcherHandlerPair(matcher, handler));
  }

  public void registerHandler(RequestHandler handler) {
    registerHandler(new EveryRequestMatcher(), handler);
  }

  public void registerHandler(MatchableRequestHandler handler) {
    _handlers.add(new MatcherHandlerPair(handler, handler));
  }

  @Override
  protected void handleRequest(Request request, Response response) throws Exception {
    for(MatcherHandlerPair handlerPair: _handlers) {
      if(!handlerPair.matcher().match(request))
        continue;

      handlerPair.handler().handleRequest(request, response);

      if(response.isSent())
        return;
    }

    response.sendPlain(404, "404 Not Found");
  }
}
