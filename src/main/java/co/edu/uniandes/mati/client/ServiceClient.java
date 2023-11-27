package co.edu.uniandes.mati.client;

import co.edu.uniandes.mati.vo.Calification;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("")
@RegisterRestClient(configKey = "blockchain-check")
public interface ServiceClient {
    @GET
    @Path("blockchain-status")
    Calification getCalification(@QueryParam("id_examen") String email);
}
