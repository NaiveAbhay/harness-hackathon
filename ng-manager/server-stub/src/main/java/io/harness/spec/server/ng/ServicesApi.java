package io.harness.spec.server.ng;

import io.harness.spec.server.ng.model.ServiceListResponse;
import io.harness.spec.server.ng.model.ServiceRequest;
import io.harness.spec.server.ng.model.ServiceResponse;

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
import javax.validation.constraints.*;
import javax.validation.Valid;

@Path("/v1/orgs/{org}/projects/{project}/services")


public interface ServicesApi {

    @POST
    @Consumes({ "application/json", "application/yaml" })
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "createService", summary = "Create a Service", description = "Creates a Service", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Services" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "201", description = "Example response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ServiceResponse.class))) })
    Response createService(@Valid ServiceRequest body, @PathParam("org")

 @Parameter(description = "Slug field of the organization the resource is scoped to") String org
, @PathParam("project")

 @Parameter(description = "Slug field of the project the resource is scoped to") String project
,  @HeaderParam("account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization method other than x-api-key header. If you are using x-api-key header this can be skipped.") String account
);
    @POST
    @Path("/batch")
    @Consumes({ "application/json", "application/yaml" })
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "createServicesBatch", summary = "Create Services", description = "Creates Multiple Services", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Services" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "201", description = "Example response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ServiceListResponse.class))) })
    Response createServicesBatch(@Valid List<ServiceRequest> body, @PathParam("org")

 @Parameter(description = "Slug field of the organization the resource is scoped to") String org
, @PathParam("project")

 @Parameter(description = "Slug field of the project the resource is scoped to") String project
,  @HeaderParam("account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization method other than x-api-key header. If you are using x-api-key header this can be skipped.") String account
,  @QueryParam("page") @DefaultValue("0") 

 @Parameter(description = "Pagination page number strategy: Specify the page number within the paginated collection related to the number of items in each page ")  Integer page
,  @QueryParam("limit") @DefaultValue("30") 

 @Parameter(description = "Pagination: Number of items to return")  Integer limit
);
    @DELETE
    @Path("/{service}")
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "deleteService", summary = "Delete a Service", description = "Deletes the requested service", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Services" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Example response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ServiceResponse.class))) })
    Response deleteService( @PathParam("org")

 @Parameter(description = "Slug field of the organization the resource is scoped to") String org
, @PathParam("project")

 @Parameter(description = "Slug field of the project the resource is scoped to") String project
, @PathParam("service")

 @Parameter(description = "Slug field of the service the resource is scoped to") String service
,  @HeaderParam("account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization method other than x-api-key header. If you are using x-api-key header this can be skipped.") String account
);
    @GET
    @Path("/{service}")
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "getService", summary = "Retrieve a Service", description = "Retrieves specified Service ", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Services" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Example response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ServiceResponse.class))) })
    Response getService( @PathParam("org")

 @Parameter(description = "Slug field of the organization the resource is scoped to") String org
, @PathParam("project")

 @Parameter(description = "Slug field of the project the resource is scoped to") String project
, @PathParam("service")

 @Parameter(description = "Slug field of the service the resource is scoped to") String service
,  @HeaderParam("account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization method other than x-api-key header. If you are using x-api-key header this can be skipped.") String account
);
    @GET
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "getServices", summary = "List Services", description = "Returns all services that the current user has view permissions for given project.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Services" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Example response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ServiceListResponse.class))) })
    Response getServices( @PathParam("org")

 @Parameter(description = "Slug field of the organization the resource is scoped to") String org
, @PathParam("project")

 @Parameter(description = "Slug field of the project the resource is scoped to") String project
,  @QueryParam("page") @DefaultValue("0") 

 @Parameter(description = "Pagination page number strategy: Specify the page number within the paginated collection related to the number of items in each page ")  Integer page
,  @QueryParam("limit") @DefaultValue("30") 

 @Parameter(description = "Pagination: Number of items to return")  Integer limit
,  @QueryParam("search_term") 

 @Parameter(description = "This would be used to filter resources having attributes matching with search term.")  String searchTerm
,  @QueryParam("service_ids") 

 @Parameter(description = "List of Service Identifiers")  List<String> serviceIds
,  @QueryParam("sort") 

 @Parameter(description = "Parameter on the basis of which sorting is done.")  String sort
,  @QueryParam("is_access_list") 

 @Parameter(description = "Specify whether list an access list or not. Access List refers to list of services that current user has permission to use in the pipeline.")  Boolean isAccessList
,  @QueryParam("type") 

 @Parameter(description = "Service Definition type")  String type
,  @QueryParam("git_ops_enabled") 

 @Parameter(description = "Enables use of this service in Harness GitOps PR Pipelines")  Boolean gitOpsEnabled
,  @HeaderParam("account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization method other than x-api-key header. If you are using x-api-key header this can be skipped.") String account
,  @QueryParam("order") 

 @Parameter(description = "Order on the basis of which sorting is done.")  String order
);
    @PUT
    @Path("/{service}")
    @Consumes({ "application/json", "application/yaml" })
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "updateService", summary = "Update Service", description = "Update Services", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Services" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Example response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ServiceResponse.class))) })
    Response updateService(@Valid ServiceRequest body, @PathParam("org")

 @Parameter(description = "Slug field of the organization the resource is scoped to") String org
, @PathParam("project")

 @Parameter(description = "Slug field of the project the resource is scoped to") String project
, @PathParam("service")

 @Parameter(description = "Slug field of the service the resource is scoped to") String service
,  @HeaderParam("account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization method other than x-api-key header. If you are using x-api-key header this can be skipped.") String account
);}
