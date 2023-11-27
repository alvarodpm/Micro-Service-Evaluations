package co.edu.uniandes.mati.infrastructure.graphql;


import co.edu.uniandes.mati.client.ServiceClient;
import co.edu.uniandes.mati.vo.Calification;
import io.smallrye.common.annotation.Blocking;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Name;
import org.eclipse.microprofile.graphql.Query;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@GraphQLApi
@ApplicationScoped
@Blocking
public class GraphQLBlockChain {
    @Inject
    @RestClient
    ServiceClient client;

    @Query
    @Description("Get status for blockchain")
    public Calification getCalification(@Name("id") String email) {
        return client.getCalification(email);
    }


}
