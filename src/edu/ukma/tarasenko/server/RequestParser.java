package edu.ukma.tarasenko.server;

import java.io.InputStream;

public interface RequestParser {
  Request parseFromStream(InputStream stream);
}
