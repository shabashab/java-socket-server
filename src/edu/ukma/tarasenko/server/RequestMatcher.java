package edu.ukma.tarasenko.server;

public interface RequestMatcher {
  boolean match(Request request);
}
