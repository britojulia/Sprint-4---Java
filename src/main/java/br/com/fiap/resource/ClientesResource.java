package br.com.fiap.resource;

import br.com.fiap.bo.ClientesBO;
import br.com.fiap.to.ClientesTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/guardianshields/clientes")
public class ClientesResource {
    private ClientesBO clientesBO = new ClientesBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        ArrayList<ClientesTO> resultado = clientesBO.findAll();
        Response.ResponseBuilder response = null;
        if (resultado != null){
            response = Response.ok(); //codigo 200 - OK
        } else {
            response = Response.status(404); // codigo 404 - NOT FOUND
        }
        response.entity(resultado);
        return response.build();
    }

    @GET
    @Path("/{cpf}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByCodigo(@PathParam("cpf") String cpf){
        ClientesTO resultado = clientesBO.findByCodigo(cpf);
        Response.ResponseBuilder response = null;
        if (resultado != null){
            response = Response.ok(); // codigo 200 - ok
        } else {
            response = Response.status(404); // codigo 404 - not found
        }
        response.entity(resultado);
        return response.build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(@Valid ClientesTO cliente){
        ClientesTO resultado = clientesBO.save(cliente);
        Response.ResponseBuilder response = null;
        if (resultado != null){
            response = Response.created(null); // codigo 201 - create
        } else {
            response = Response.status(400); // codigo 401 - bad request
        }
        response.entity(resultado);
        return response.build();
    }

    @PUT
    @Path("{/cpf}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@Valid ClientesTO cliente, @PathParam("cpf") String cpf){
        cliente.setCpf(cpf);
        ClientesTO resultado = clientesBO.update(cliente);
        Response.ResponseBuilder response = null;
        if (resultado != null){
            response = Response.created(null); // codigo 201 - create
        } else {
            response = Response.status(400); // codigo 401 - bad request
        }
        response.entity(resultado);
        return response.build();
    }

    @DELETE
    @Path("{/cpf}")
    public Response delete(@PathParam("cpf") String cpf){
        Response.ResponseBuilder response = null;
        if (clientesBO.delete(cpf)){
            response = Response.status(204); // codigo 204 - no content
        } else {
            response = Response.status(404); // codigo 404 - not found
        }
        return response.build();
    }
}
