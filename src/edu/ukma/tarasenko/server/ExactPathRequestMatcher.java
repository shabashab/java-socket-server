package edu.ukma.tarasenko.server;

public class ExactPathRequestMatcher implements RequestMatcher {
  private final String _path;

  public ExactPathRequestMatcher(String path) {
    _path = path;
  }

  @Override
  public boolean match(Request request) {
    return request.getPath().equals(_path);
  }
}
