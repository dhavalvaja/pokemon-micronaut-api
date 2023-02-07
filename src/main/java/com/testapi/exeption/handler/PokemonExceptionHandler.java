package com.testapi.exeption.handler;

import com.testapi.exeption.PokemonException;
import com.testapi.exeption.PokemonNotFoundException;
import io.micronaut.context.annotation.Requires;
import io.micronaut.data.annotation.Repository;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import jakarta.inject.Singleton;

@Produces
@Singleton
@Requires(classes = {PokemonException.class})
public class PokemonExceptionHandler implements
        ExceptionHandler<PokemonException, HttpResponse<PokemonException>> {
    @Override
    public HttpResponse<PokemonException> handle(HttpRequest request, PokemonException exception) {
        if (exception instanceof PokemonNotFoundException) {
            return HttpResponse.notFound(exception);
        }
        return HttpResponse.badRequest(exception);
    }
}
