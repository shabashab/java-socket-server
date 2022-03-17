package edu.ukma.tarasenko.server;

public interface ResponseFactory {
  Response createForClient(Client client);
}
