package edu.ukma.tarasenko.server;

public interface RequestParser {
  Request parseFromClient(Client client) throws Exception;
}
