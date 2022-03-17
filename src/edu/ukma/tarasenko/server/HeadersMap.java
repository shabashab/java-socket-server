
package edu.ukma.tarasenko.server;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HeadersMap implements Headers {
  private final Map<String, String> _headers;

  public HeadersMap() {
    _headers = new HashMap<>();
  }

  @Override
  public Set<String> getNames() {
    return _headers.keySet();
  }

  @Override
  public String getValue(String name) {
    return _headers.get(name);
  }

  @Override
  public void setValue(String name, String value) {
    _headers.put(name, value);
  }
}
