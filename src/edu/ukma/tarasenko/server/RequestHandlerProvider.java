package edu.ukma.tarasenko.server;

public interface RequestHandlerProvider {
  RequestHandler provideForRequest(Request request);
}
