package io.harness.spec.server.ng;

import io.harness.spec.server.ng.model.ConnectorRequest;
import io.harness.spec.server.ng.model.ConnectorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/v1/orgs/{org}/connectors")


public interface OrgConnectorApi {

    @POST
    @Consumes({ "application/json", "application/yaml" })
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "createOrgScopedConnector", summary = "Create a Connector", description = "Creates a new connector", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Org Connector" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "201", description = "Connector response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ConnectorResponse.class))) })
    Response createOrgScopedConnector(@Valid ConnectorRequest body, @PathParam("org")

 @Parameter(description = "Slug field of the organization the resource is scoped to") String org
,  @QueryParam("account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization method other than x-api-key header. If you are using x-api-key header this can be skipped.")  String account
);
    @GET
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "getOrgScopedConnectors", summary = "List connectors", description = "Retrieves the information of the connectors.", tags={ "Org Connector" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Connector list response", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ConnectorResponse.class)))) })
    Response getOrgScopedConnectors( @PathParam("org")

 @Parameter(description = "Slug field of the organization the resource is scoped to") String org
);}
