package com.howtographql.hackernews;

/*

To forward the data-fetching exception messages,
while still hiding the corresponding stack traces,
you should start by creating a simple wrapper class:
This wrapper doesn’t do much -
it just instructs Jackson (the JSON (de)serialization library) to ignore the linked exception during serialization.
 This way, the stack trace won’t reach the client.
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import graphql.ExceptionWhileDataFetching;

public class SanitizedError extends ExceptionWhileDataFetching {
    public SanitizedError(ExceptionWhileDataFetching inner) {
        super(inner.getException());
    }

    @Override
    @JsonIgnore
    public Throwable getException() {
        return super.getException();
    }
}
