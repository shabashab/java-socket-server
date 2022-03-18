package edu.ukma.tarasenko.server;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class StaticRequestHandler implements MatchableRequestHandler {
  private final Path _rootDir;

  public StaticRequestHandler(String rootDir) {
    _rootDir = Paths.get(rootDir);
  }

  private Path getFilePath(String requestPath) {
    return _rootDir.resolve(requestPath.substring(1));
  }

  @Override
  public void handleRequest(Request request, Response response) throws IOException {
    Path filePath = getFilePath(request.getPath());
    File file = new File(String.valueOf(filePath));

    response.sendFile(200, file);
  }

  @Override
  public boolean match(Request request) {
    Path filePath = getFilePath(request.getPath());
    File file = new File(String.valueOf(filePath));
    return file.exists();
  }
}
