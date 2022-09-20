package io.harness.spec.server.platform;

import io.harness.spec.server.platform.model.CreateResourceGroupRequest;
import io.harness.spec.server.platform.model.ResourceGroupsResponse;

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

@Path("/v1/orgs/{org}/resource-groups")


public interface OrganizationResourceGroupsApi {

    @POST
    @Consumes({ "application/json", "application/yaml" })
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "createResourceGroupOrg", summary = "Create a Resource Group", description = "Creates a custom Resource Group in the Organization scope.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Organization Resource Groups" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "201", description = "Resource Group response body", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResourceGroupsResponse.class))) })
    Response createResourceGroupOrg(@Valid CreateResourceGroupRequest body, @PathParam("org")

 @Parameter(description = "Organization identifier") String org
,  @HeaderParam("Harness-Account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.") String harnessAccount
);
    @DELETE
    @Path("/{resource-group}")
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "deleteResourceGroupOrg", summary = "Delete a Resource Group", description = "Deletes a custom Resource Group from Organization scope.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Organization Resource Groups" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Resource Group response body", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResourceGroupsResponse.class))) })
    Response deleteResourceGroupOrg( @PathParam("org")

 @Parameter(description = "Organization identifier") String org
, @PathParam("resource-group")

 @Parameter(description = "Resource Group identifier") String resourceGroup
,  @HeaderParam("Harness-Account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.") String harnessAccount
);
    @GET
    @Path("/{resource-group}")
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "getResourceGroupOrg", summary = "Retrieve a Resource Group", description = "Retrieves a Resource Group from Organization scope.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Organization Resource Groups" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Resource Group response body", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResourceGroupsResponse.class))) })
    Response getResourceGroupOrg( @PathParam("org")

 @Parameter(description = "Organization identifier") String org
, @PathParam("resource-group")

 @Parameter(description = "Resource Group identifier") String resourceGroup
,  @HeaderParam("Harness-Account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.") String harnessAccount
);
    @GET
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "listResourceGroupsOrg", summary = "List Resource Groups", description = "Returns a list of Resource Groups present in the Organization scope.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Organization Resource Groups" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Resource Groups List response body", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ResourceGroupsResponse.class)))) })
    Response listResourceGroupsOrg( @PathParam("org")

 @Parameter(description = "Organization identifier") String org
,  @QueryParam("page") @DefaultValue("0") 

 @Parameter(description = "Pagination page number strategy: Specify the page number within the paginated collection related to the number of items on each page.")  Integer page
, @Max(100)  @QueryParam("limit") @DefaultValue("30") 

 @Parameter(description = "Pagination: Number of items to return.")  Integer limit
,  @QueryParam("search_term") 

 @Parameter(description = "This would be used to filter resources having attributes matching the search term.")  String searchTerm
,  @HeaderParam("Harness-Account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.") String harnessAccount
,  @QueryParam("sort") 

 @Parameter(description = "Parameter on the basis of which sorting is done.")  String sort
,  @QueryParam("order") 

 @Parameter(description = "Order on the basis of which sorting is done.")  String order
);
    @PUT
    @Path("/{resource-group}")
    @Consumes({ "application/json", "application/yaml" })
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "updateResourceGroupOrg", summary = "Update a Resource Group", description = "Updates a Resource Group from Organization scope.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Organization Resource Groups" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Resource Group response body", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResourceGroupsResponse.class))) })
    Response updateResourceGroupOrg(@Valid CreateResourceGroupRequest body, @PathParam("org")

 @Parameter(description = "Organization identifier") String org
, @PathParam("resource-group")

 @Parameter(description = "Resource Group identifier") String resourceGroup
,  @HeaderParam("Harness-Account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.") String harnessAccount
);}
