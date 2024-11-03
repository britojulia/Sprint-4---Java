package br.com.fiap.resource;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;

import java.io.IOException;

public class CorsFilter implements ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext request, ContainerResponseContext response) throws IOException {
        response.getHeaders().add("Access-Control-Allow-Origin", "*");
        response.getHeaders().add("Access-Control-Allow-Headres", "origin, content-type, accept, authorization");
        request.getHeaders().add("Access-Control-Allow-Credentials", "true");
        request.getHeaders().add("Access-Control-Allow-Methods", "GET, POTS, PUT, DELETE, UPDATE, OPTIONS, HEAD");

    }
}
