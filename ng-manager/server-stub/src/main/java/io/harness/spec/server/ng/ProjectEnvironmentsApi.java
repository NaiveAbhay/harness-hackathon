package io.harness.spec.server.ng;

import io.harness.spec.server.ng.model.EnvironmentListResponse;
import io.harness.spec.server.ng.model.EnvironmentRequest;
import io.harness.spec.server.ng.model.EnvironmentResponse;
import io.harness.spec.server.ng.model.ServiceOverrideListResponse;
import io.harness.spec.server.ng.model.ServiceOverrideRequest;
import io.harness.spec.server.ng.model.ServiceOverrideResponse;

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

@Path("/v1/orgs/{org}/projects/{project}/environments")


public interface ProjectEnvironmentsApi {

    @POST
    @Path("/{environment}/services/{service}")
    @Consumes({ "application/json", "application/yaml" })
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "createEnvServiceOverride", summary = "Create Service Override", description = "Creates a Service Override", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Project Environments" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "201", description = "Service Override Response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ServiceOverrideResponse.class))) })
    Response createEnvServiceOverride( @PathParam("org")

 @Parameter(description = "Slug field of the organization the resource is scoped to") String org
, @PathParam("project")

 @Parameter(description = "Slug field of the project the resource is scoped to") String project
, @PathParam("environment")

 @Parameter(description = "Slug field of the environemnt the resource is scoped to") String environment
, @PathParam("service")

 @Parameter(description = "Slug field of the service the resource is scoped to") String service
,@Valid ServiceOverrideRequest body,  @HeaderParam("Harness-Account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.") String harnessAccount
);
    @POST
    @Consumes({ "application/json", "application/yaml" })
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "createEnviroment", summary = "Create an Environment", description = "Creates an Environment", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Project Environments" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "201", description = "Environment Response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = EnvironmentResponse.class))) })
    Response createEnviroment(@Valid EnvironmentRequest body, @PathParam("org")

 @Parameter(description = "Slug field of the organization the resource is scoped to") String org
, @PathParam("project")

 @Parameter(description = "Slug field of the project the resource is scoped to") String project
,  @HeaderParam("Harness-Account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.") String harnessAccount
);
    @DELETE
    @Path("/{environment}")
    @Operation(operationId = "deleteEnviroment", summary = "Delete an Environment", description = "Deletes the requested environment", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Project Environments" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "204", description = "No Content") })
    Response deleteEnviroment( @PathParam("org")

 @Parameter(description = "Slug field of the organization the resource is scoped to") String org
, @PathParam("project")

 @Parameter(description = "Slug field of the project the resource is scoped to") String project
, @PathParam("environment")

 @Parameter(description = "Slug field of the environemnt the resource is scoped to") String environment
,  @HeaderParam("Harness-Account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.") String harnessAccount
);
    @DELETE
    @Path("/{environment}/services/{service}")
    @Operation(operationId = "deleteServEnv", summary = "Delete Service Override", description = "Deletes Service Override", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Project Environments" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "204", description = "No Content") })
    Response deleteServEnv( @PathParam("org")

 @Parameter(description = "Slug field of the organization the resource is scoped to") String org
, @PathParam("project")

 @Parameter(description = "Slug field of the project the resource is scoped to") String project
, @PathParam("environment")

 @Parameter(description = "Slug field of the environemnt the resource is scoped to") String environment
, @PathParam("service")

 @Parameter(description = "Slug field of the service the resource is scoped to") String service
,  @HeaderParam("Harness-Account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.") String harnessAccount
);
    @GET
    @Path("/{environment}/services/{service}")
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "getEnvServiceOverride", summary = "Retrieve a Service Override", description = "Gets a Service Override", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Project Environments" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Service Override Response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ServiceOverrideResponse.class))) })
    Response getEnvServiceOverride( @PathParam("org")

 @Parameter(description = "Slug field of the organization the resource is scoped to") String org
, @PathParam("project")

 @Parameter(description = "Slug field of the project the resource is scoped to") String project
, @PathParam("environment")

 @Parameter(description = "Slug field of the environemnt the resource is scoped to") String environment
, @PathParam("service")

 @Parameter(description = "Slug field of the service the resource is scoped to") String service
,  @QueryParam("sort") 

 @Parameter(description = "Parameter on the basis of which sorting is done.")  String sort
,  @HeaderParam("Harness-Account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.") String harnessAccount
,  @QueryParam("order") 

 @Parameter(description = "Order on the basis of which sorting is done.")  String order
);
    @GET
    @Path("/{environment}/services")
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "getEnvServiceOverrides", summary = "Retrieve Service Overrides list", description = "Gets Service Override List", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Project Environments" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Serivce Order List Response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ServiceOverrideListResponse.class))) })
    Response getEnvServiceOverrides( @PathParam("org")

 @Parameter(description = "Slug field of the organization the resource is scoped to") String org
, @PathParam("project")

 @Parameter(description = "Slug field of the project the resource is scoped to") String project
, @PathParam("environment")

 @Parameter(description = "Slug field of the environemnt the resource is scoped to") String environment
,  @QueryParam("sort") 

 @Parameter(description = "Parameter on the basis of which sorting is done.")  String sort
,  @HeaderParam("Harness-Account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.") String harnessAccount
,  @QueryParam("order") 

 @Parameter(description = "Order on the basis of which sorting is done.")  String order
);
    @GET
    @Path("/{environment}")
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "getEnviroment", summary = "Retrieve an Environment", description = "Retrieves specified Environment", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Project Environments" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Environment Response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = EnvironmentResponse.class))) })
    Response getEnviroment( @PathParam("org")

 @Parameter(description = "Slug field of the organization the resource is scoped to") String org
, @PathParam("project")

 @Parameter(description = "Slug field of the project the resource is scoped to") String project
, @PathParam("environment")

 @Parameter(description = "Slug field of the environemnt the resource is scoped to") String environment
,  @HeaderParam("Harness-Account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.") String harnessAccount
);
    @GET
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "getEnvironments", summary = "List Environments", description = "Returns all environments that the current user has view permissions for given project.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Project Environments" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Environment List Response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = EnvironmentListResponse.class))) })
    Response getEnvironments( @PathParam("org")

 @Parameter(description = "Slug field of the organization the resource is scoped to") String org
, @PathParam("project")

 @Parameter(description = "Slug field of the project the resource is scoped to") String project
,  @HeaderParam("Harness-Account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.") String harnessAccount
,  @QueryParam("page") @DefaultValue("0") 

 @Parameter(description = "Pagination page number strategy: Specify the page number within the paginated collection related to the number of items in each page ")  Integer page
,  @QueryParam("limit") @DefaultValue("30") 

 @Parameter(description = "Pagination: Number of items to return")  Integer limit
,  @QueryParam("search_term") 

 @Parameter(description = "This would be used to filter resources having attributes matching with search term.")  String searchTerm
,  @QueryParam("environment_ids") 

 @Parameter(description = "List of Environment Identifiers")  List<String> environmentIds
,  @QueryParam("sort") 

 @Parameter(description = "Parameter on the basis of which sorting is done.")  String sort
,  @QueryParam("order") 

 @Parameter(description = "Order on the basis of which sorting is done.")  String order
,  @QueryParam("is_access_list") @DefaultValue("false") 

 @Parameter(description = "Specify whether list an access list or not. Access List refers to list of services that current user has permission to use in the pipeline.")  Boolean isAccessList
);
    @PUT
    @Path("/{environment}/services/{service}")
    @Consumes({ "application/json", "application/yaml" })
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "updateEnvServiceOverride", summary = "Update Service Override", description = "Update Service Override", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Project Environments" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Service Override Response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ServiceOverrideResponse.class))) })
    Response updateEnvServiceOverride( @PathParam("org")

 @Parameter(description = "Slug field of the organization the resource is scoped to") String org
, @PathParam("project")

 @Parameter(description = "Slug field of the project the resource is scoped to") String project
, @PathParam("environment")

 @Parameter(description = "Slug field of the environemnt the resource is scoped to") String environment
, @PathParam("service")

 @Parameter(description = "Slug field of the service the resource is scoped to") String service
,@Valid ServiceOverrideRequest body,  @HeaderParam("Harness-Account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.") String harnessAccount
);
    @PUT
    @Path("/{environment}")
    @Consumes({ "application/json", "application/yaml" })
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "updateEnviroment", summary = "Update Environment", description = "Update Environment", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Project Environments" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Environment Response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = EnvironmentResponse.class))) })
    Response updateEnviroment(@Valid EnvironmentRequest body, @PathParam("org")

 @Parameter(description = "Slug field of the organization the resource is scoped to") String org
, @PathParam("project")

 @Parameter(description = "Slug field of the project the resource is scoped to") String project
, @PathParam("environment")

 @Parameter(description = "Slug field of the environemnt the resource is scoped to") String environment
,  @HeaderParam("Harness-Account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.") String harnessAccount
);}
