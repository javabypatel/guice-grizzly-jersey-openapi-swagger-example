package com.javabypatel.resource;

import com.javabypatel.model.GreetResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("greet")
public class GreetResource {

    private static final String GREET_MESSAGE = "Hello";

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(
            summary = "This is a sample test API to greet user.",
            parameters = {
                    @Parameter(in = ParameterIn.QUERY, name = "name")
            },
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Greeted successfully.",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON,
                                    array = @ArraySchema(schema = @Schema(implementation = GreetResponse.class))
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Bad request. Request is not well formed."
                    )
            }
    )
    public Response greet(@Context UriInfo uriInfo) {
        if (!uriInfo.getQueryParameters().containsKey("name")) {
            throw new BadRequestException("'name' query parameter is missing.");
        }
        return Response
                .ok()
                .entity(new GreetResponse(GREET_MESSAGE + " " + uriInfo.getQueryParameters().getFirst("name")))
                .build();
    }
}