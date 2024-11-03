package br.com.fiap.resource;

import br.com.fiap.bo.AgendamentoBO;
import br.com.fiap.bo.ChamadoBO;
import br.com.fiap.to.AgendametoTO;
import br.com.fiap.to.ChamadoTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/guardianshields/agendamento")
public class AgendamentoResource {
    private AgendamentoBO agendamentoBO = new AgendamentoBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        ArrayList<AgendametoTO> resultado = agendamentoBO.findAll();
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
    @Path("/{id_agendamento}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByCodigo(@PathParam("id_agendamento") Long id_agendamento){
        AgendametoTO resultado = agendamentoBO.findByCodigo(id_agendamento);
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
    public Response save(AgendametoTO agenda){
        AgendametoTO resultado = agendamentoBO.save(agenda);
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
    @Path("{/id_agendamento}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@Valid AgendametoTO agenda, @PathParam("id_agendamento") Long id_agendamento){
        agenda.setId_agendamento(id_agendamento);
        AgendametoTO resultado = agendamentoBO.update(agenda);
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
    @Path("{/id_agendamento}")
    public Response delete(@PathParam("id_agendamento") Long id_agendamento){
        Response.ResponseBuilder response = null;
        if (agendamentoBO.delete(id_agendamento)){
            response = Response.status(204); // codigo 204 - no content
        } else {
            response = Response.status(404); // codigo 404 - not found
        }
        return response.build();
    }

}
