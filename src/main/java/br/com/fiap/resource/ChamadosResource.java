package br.com.fiap.resource;

import br.com.fiap.bo.ChamadoBO;
import br.com.fiap.bo.ClientesBO;
import br.com.fiap.to.ChamadoTO;
import br.com.fiap.to.ClientesTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/guardianshields/chamado")
public class ChamadosResource {
    private ChamadoBO chamadoBO = new ChamadoBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        ArrayList<ChamadoTO> resultado = chamadoBO.findAll();
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
    @Path("/{id_chamado}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByCodigo(@PathParam("id_chamado") Long id_chamado){
        ChamadoTO resultado = chamadoBO.findByCodigo(id_chamado);
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
    public Response save(ChamadoTO chamado){
        ChamadoTO resultado = chamadoBO.save(chamado);
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
    @Path("{/id_chamado}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@Valid ChamadoTO chamado, @PathParam("id_chamado") Long id_chamado){
        chamado.setId_chamado(id_chamado);
        ChamadoTO resultado = chamadoBO.update(chamado);
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
    @Path("{/id_chamado}")
    public Response delete(@PathParam("id_chamado") Long id_chamado){
        Response.ResponseBuilder response = null;
        if (chamadoBO.delete(id_chamado)){
            response = Response.status(204); // codigo 204 - no content
        } else {
            response = Response.status(404); // codigo 404 - not found
        }
        return response.build();
    }
}
