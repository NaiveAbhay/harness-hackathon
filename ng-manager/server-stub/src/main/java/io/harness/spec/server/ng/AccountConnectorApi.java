package io.harness.spec.server.ng;

import io.harness.spec.server.ng.model.ConnectorRequest;
import io.harness.spec.server.ng.model.ConnectorResponse;
import io.harness.spec.server.ng.model.ConnectorTestConnectionResponse;
import io.harness.spec.server.ng.model.ValidateConnectorSlugResponse;

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

@Path("/v1/connectors")


public interface AccountConnectorApi {

    @POST
    @Consumes({ "application/json", "application/yaml" })
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "createAccountScopedConnector", summary = "Create a Connector", description = "Creates a new connector", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Account Connector" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "201", description = "Connector response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ConnectorResponse.class))) })
    Response createAccountScopedConnector(@Valid ConnectorRequest body,  @HeaderParam("Harness-Account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.") String harnessAccount
);
    @DELETE
    @Path("/{connector}")
    @Operation(operationId = "deleteAccountScopedConnector", summary = "Delete a connector", description = "Deletes the information of the connector with the matching connector slug.", tags={ "Account Connector" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "OK") })
    Response deleteAccountScopedConnector( @PathParam("connector")

 @Parameter(description = "Connector slug") String connector
,  @HeaderParam("Harness-Account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.") String harnessAccount
);
    @GET
    @Path("/{connector}")
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "getAccountScopedConnector", summary = "Retrieve a connector", description = "Retrieves the information of the connector with the matching connector slug. ", tags={ "Account Connector" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Connector response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ConnectorResponse.class))) })
    Response getAccountScopedConnector( @PathParam("connector")

 @Parameter(description = "Connector slug") String connector
,  @HeaderParam("Harness-Account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.") String harnessAccount
);
    @GET
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "getAccountScopedConnectors", summary = "List connectors", description = "Retrieves the information of the connectors.", tags={ "Account Connector" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Connector list response", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ConnectorResponse.class)))) })
    Response getAccountScopedConnectors(  @QueryParam("recursive") @DefaultValue("false") 

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
    @Operation(operationId = "testAccountScopedConnector", summary = "Test a connector", description = "Tests connection of the connector with the matching connector slug. ", tags={ "Account Connector" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "This has test connection details for the Connector defined in Harness.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ConnectorTestConnectionResponse.class))) })
    Response testAccountScopedConnector( @PathParam("connector")

 @Parameter(description = "Connector slug") String connector
,  @HeaderParam("Harness-Account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.") String harnessAccount
);
    @PUT
    @Path("/{connector}")
    @Consumes({ "application/json", "application/yaml" })
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "updateAccountScopedConnector", summary = "Update a connector", description = "Updates the information of the secret with the matching secret slug.", tags={ "Account Connector" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Connector response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ConnectorResponse.class))) })
    Response updateAccountScopedConnector(@Valid ConnectorRequest body, @PathParam("connector")

 @Parameter(description = "Connector slug") String connector
,  @HeaderParam("Harness-Account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.") String harnessAccount
);
    @HEAD
    @Path("/{connector}")
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "validateUniqueAccountScopedConnectorSlug", summary = "Validate unique connector slug", description = "Validates connector slug is unique", tags={ "Account Connector" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Validate connector slug response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ValidateConnectorSlugResponse.class))) })
    Response validateUniqueAccountScopedConnectorSlug( @PathParam("connector")

 @Parameter(description = "Connector slug") String connector
,  @HeaderParam("Harness-Account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.") String harnessAccount
);}
