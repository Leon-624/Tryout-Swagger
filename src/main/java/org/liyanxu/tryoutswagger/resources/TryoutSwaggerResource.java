package org.liyanxu.tryoutswagger.resources;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.liyanxu.tryoutswagger.api.api.TryoutSwaggerApi;
import org.liyanxu.tryoutswagger.api.model.User;
import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/user")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Api(description = "Tryout Swagger", protocols = "http")
public class TryoutSwaggerResource {

    private final TryoutSwaggerApi api;

    @Inject
    public TryoutSwaggerResource(@NotNull TryoutSwaggerApi api) {
        this.api = api;
    }

    @GET
    @Path("/alive")
    public String testAlive() {
        return "yes";
    }

    @GET
    @Path("/detail/{name}")
    @ApiOperation(value = "Returns the user detail by name.")
    public User getUserByName(@PathParam("name") String name) {
        return api.getUserByName(name);     //Dropwizard will handle response
    }

}
