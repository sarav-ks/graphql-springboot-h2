package com.example.bookreview.exception;

import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import org.springframework.stereotype.Component;
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.graphql.execution.ErrorType;

@Component
public class BookReviewExpHandler extends DataFetcherExceptionResolverAdapter{

    protected GraphQLError resolveToSingleError(Throwable ex, DataFetchingEnvironment env) {
        if (ex instanceof Exception) {
            return GraphqlErrorBuilder.newError()
              .errorType(ErrorType.NOT_FOUND)
              .message(ex.getMessage())
              .path(env.getExecutionStepInfo().getPath())
              .location(env.getField().getSourceLocation())
              .build();
        } else {
            return null;
        }
    }
}