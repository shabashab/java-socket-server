package edu.ukma.tarasenko.server;

import java.util.Set;

public interface Headers {
  Set<String> getNames();
  String getValue(String name);
  void setValue(String name, String value);
}
