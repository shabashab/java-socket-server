package edu.ukma.tarasenko.server;

public class EveryRequestMatcher implements RequestMatcher {
  @Override
  public boolean match(Request request) {
    return true;
  }
}
