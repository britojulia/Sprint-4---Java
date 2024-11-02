package br.com.fiap.resource;

import br.com.fiap.bo.ClientesBO;
import br.com.fiap.to.ClientesTO;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/guardianshields")
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
    }selspljhhj
}
