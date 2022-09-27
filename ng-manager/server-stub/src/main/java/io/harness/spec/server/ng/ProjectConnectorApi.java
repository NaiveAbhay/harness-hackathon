package io.harness.spec.server.ng;

import io.harness.spec.server.ng.model.ConnectorRequest;
import io.harness.spec.server.ng.model.ConnectorResponse;
import io.harness.spec.server.ng.model.ConnectorTestConnectionResponse;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import java.util.Map;
import java.util.List;
import java.io.InputStream;
import org.glassfish.jersey.media.multipart.FormDataParam;
import javax.validation.constraints.*;
import javax.validation.Valid;

@Path("/v1/orgs/{org}/projects/{project}/connectors")


public interface ProjectConnectorApi {

    @POST
    @Consumes({ "application/json", "application/yaml" })
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "createProjectScopedConnector", summary = "Create a Connector", description = "Creates a new connector", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Project Connector" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "201", description = "Connector response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ConnectorResponse.class))) })
    Response createProjectScopedConnector(@Valid ConnectorRequest body, @PathParam("org")

 @Parameter(description = "Slug field of the organization the resource is scoped to") String org
, @PathParam("project")

 @Parameter(description = "Slug field of the project the resource is scoped to") String project
,  @HeaderParam("Harness-Account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.") String harnessAccount
);
    @DELETE
    @Path("/{connector}")
    @Operation(operationId = "deleteProjectScopedConnector", summary = "Delete a connector", description = "Deletes the information of the connector with the matching connector slug.", tags={ "Project Connector" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "OK") })
    Response deleteProjectScopedConnector( @PathParam("org")

 @Parameter(description = "Slug field of the organization the resource is scoped to") String org
, @PathParam("project")

 @Parameter(description = "Slug field of the project the resource is scoped to") String project
, @PathParam("connector")

 @Parameter(description = "Connector slug") String connector
,  @HeaderParam("Harness-Account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.") String harnessAccount
);
    @GET
    @Path("/{connector}")
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "getProjectScopedConnector", summary = "Retrieve a connector", description = "Retrieves the information of the connector with the matching connector slug. ", tags={ "Project Connector" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Connector response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ConnectorResponse.class))) })
    Response getProjectScopedConnector( @PathParam("org")

 @Parameter(description = "Slug field of the organization the resource is scoped to") String org
, @PathParam("project")

 @Parameter(description = "Slug field of the project the resource is scoped to") String project
, @PathParam("connector")

 @Parameter(description = "Connector slug") String connector
,  @HeaderParam("Harness-Account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.") String harnessAccount
);
    @GET
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "getProjectScopedConnectors", summary = "List connectors", description = "Retrieves the information of the connectors.", tags={ "Project Connector" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Connector list response", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ConnectorResponse.class)))) })
    Response getProjectScopedConnectors( @PathParam("org")

 @Parameter(description = "Slug field of the organization the resource is scoped to") String org
, @PathParam("project")

 @Parameter(description = "Slug field of the project the resource is scoped to") String project
,  @QueryParam("recursive") @DefaultValue("false") 

 @Parameter(description = "Expand current scope to include all child scopes ")  Boolean recursive
,  @QueryParam("search_term") 

 @Parameter(description = "This would be used to filter resources having attributes matching with search term.")  String searchTerm
,  @QueryParam("page") @DefaultValue("0") 

 @Parameter(description = "Pagination page number strategy: Specify the page number within the paginated collection related to the number of items in each page ")  Integer page
,  @QueryParam("limit") @DefaultValue("30") 

 @Parameter(description = "Pagination: Number of items to return")  Integer limit
,  @HeaderParam("Harness-Account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.") String harnessAccount
);
    @GET
    @Path("/{connector}/test-connection")
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "testProjectScopedConnector", summary = "Test a connector", description = "Tests connection of the connector with the matching connector slug. ", tags={ "Project Connector" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "This has test connection details for the Connector defined in Harness.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ConnectorTestConnectionResponse.class))) })
    Response testProjectScopedConnector( @PathParam("org")

 @Parameter(description = "Slug field of the organization the resource is scoped to") String org
, @PathParam("project")

 @Parameter(description = "Slug field of the project the resource is scoped to") String project
, @PathParam("connector")

 @Parameter(description = "Connector slug") String connector
,  @HeaderParam("Harness-Account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.") String harnessAccount
);
    @PUT
    @Path("/{connector}")
    @Consumes({ "application/json", "application/yaml" })
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "updateProjectScopedConnector", summary = "Update a connector", description = "Updates the information of the secret with the matching secret slug.", tags={ "Project Connector" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Connector response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ConnectorResponse.class))) })
    Response updateProjectScopedConnector(@Valid ConnectorRequest body, @PathParam("org")

 @Parameter(description = "Slug field of the organization the resource is scoped to") String org
, @PathParam("project")

 @Parameter(description = "Slug field of the project the resource is scoped to") String project
, @PathParam("connector")

 @Parameter(description = "Connector slug") String connector
,  @HeaderParam("Harness-Account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.") String harnessAccount
);}
