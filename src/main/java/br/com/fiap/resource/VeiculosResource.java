package br.com.fiap.resource;

import br.com.fiap.bo.VeiculosBO;
import br.com.fiap.to.ClientesTO;
import br.com.fiap.to.VeiculosTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/guardianshields/veiculo")
public class VeiculosResource {
    private VeiculosBO veiculosBO = new VeiculosBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        ArrayList<VeiculosTO> resultado = veiculosBO.findAll();
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
    public Response findByCodigo(@PathParam("placa") String placa){
        VeiculosTO resultado = veiculosBO.findByCodigo(placa);
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
    public Response save(@Valid VeiculosTO veiculo){
        VeiculosTO resultado = veiculosBO.save(veiculo);
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
    @Path("{/placa}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@Valid VeiculosTO veiculo, @PathParam("placa") String placa){
        veiculo.setPlaca(placa);
        VeiculosTO resultado = veiculosBO.update(veiculo);
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
    @Path("{/placa}")
    public Response delete(@PathParam("placa") String placa){
        Response.ResponseBuilder response = null;
        if (veiculosBO.delete(placa)){
            response = Response.status(204); // codigo 204 - no content
        } else {
            response = Response.status(404); // codigo 404 - not found
        }
        return response.build();
    }

}
