package io.harness.spec.server.platform;

import io.harness.spec.server.platform.model.CreateResourceGroupRequest;
import io.harness.spec.server.platform.model.FilterResourceGroupRequest;
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
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @Operation(operationId = "createResourceGroupOrg", summary = "Create a Resource Group", description = "Creates a custom Resource Group in the Organization scope.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Organization Resource Groups" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Resource Group Response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResourceGroupsResponse.class))) })
    Response createResourceGroupOrg( @PathParam("org")

 @Parameter(description = "Organization identifier") String org
,@Valid CreateResourceGroupRequest body,  @QueryParam("account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.")  String account
);
    @DELETE
    @Path("/{resource-group}")
    @Produces({ "application/json" })
    @Operation(operationId = "deleteResourceGroupOrg", summary = "Delete a Resource Group", description = "Deletes a custom Resource Group from Organization scope.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Organization Resource Groups" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Resource Group Response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResourceGroupsResponse.class))) })
    Response deleteResourceGroupOrg( @PathParam("org")

 @Parameter(description = "Organization identifier") String org
, @PathParam("resource-group")

 @Parameter(description = "Resource Group identifier") String resourceGroup
,  @QueryParam("account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.")  String account
);
    @PUT
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @Operation(operationId = "filterResourceGroupOrg", summary = "Filter Resource Groups", description = "Returns a filtered list of Resource Groups present in the Organization scope.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Organization Resource Groups" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Resource Groups List Response", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ResourceGroupsResponse.class)))) })
    Response filterResourceGroupOrg( @PathParam("org")

 @Parameter(description = "Organization identifier") String org
,@Valid FilterResourceGroupRequest body,  @QueryParam("account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.")  String account
, @Max(100)  @QueryParam("limit") @DefaultValue("30") 

 @Parameter(description = "Pagination: Number of items to return.")  Integer limit
,  @QueryParam("page") @DefaultValue("0") 

 @Parameter(description = "Pagination page number strategy: Specify the page number within the paginated collection related to the number of items on each page.")  Integer page
);
    @HEAD
    @Path("/{resource-group}")
    @Produces({ "application/json" })
    @Operation(operationId = "getResourceGroupInternalOrg", summary = "Retrieve a Resource Group [Internal]", description = "Retrieves a Resource Group from Organization scope. [Internal]", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Organization Resource Groups" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Resource Group Response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResourceGroupsResponse.class))) })
    Response getResourceGroupInternalOrg( @PathParam("org")

 @Parameter(description = "Organization identifier") String org
, @PathParam("resource-group")

 @Parameter(description = "Resource Group identifier") String resourceGroup
,  @QueryParam("account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.")  String account
);
    @GET
    @Path("/{resource-group}")
    @Produces({ "application/json" })
    @Operation(operationId = "getResourceGroupOrg", summary = "Retrieve a Resource Group", description = "Retrieves a Resource Group from Organization scope.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Organization Resource Groups" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Resource Group Response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResourceGroupsResponse.class))) })
    Response getResourceGroupOrg( @PathParam("org")

 @Parameter(description = "Organization identifier") String org
, @PathParam("resource-group")

 @Parameter(description = "Resource Group identifier") String resourceGroup
,  @QueryParam("account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.")  String account
);
    @GET
    @Produces({ "application/json" })
    @Operation(operationId = "listResourceGroupsOrg", summary = "List Resource Groups", description = "Returns a list of Resource Groups present in the Organization scope.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Organization Resource Groups" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Resource Groups List Response", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ResourceGroupsResponse.class)))) })
    Response listResourceGroupsOrg( @PathParam("org")

 @Parameter(description = "Organization identifier") String org
,  @QueryParam("account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.")  String account
,  @QueryParam("page") @DefaultValue("0") 

 @Parameter(description = "Pagination page number strategy: Specify the page number within the paginated collection related to the number of items on each page.")  Integer page
, @Max(100)  @QueryParam("limit") @DefaultValue("30") 

 @Parameter(description = "Pagination: Number of items to return.")  Integer limit
,  @QueryParam("search_term") 

 @Parameter(description = "This would be used to filter resources having attributes matching the search term.")  String searchTerm
);
    @PUT
    @Path("/{resource-group}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @Operation(operationId = "updateResourceGroupOrg", summary = "Update a Resource Group", description = "Updates a Resource Group from Organization scope.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Organization Resource Groups" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Resource Group Response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResourceGroupsResponse.class))) })
    Response updateResourceGroupOrg( @PathParam("org")

 @Parameter(description = "Organization identifier") String org
, @PathParam("resource-group")

 @Parameter(description = "Resource Group identifier") String resourceGroup
,@Valid CreateResourceGroupRequest body,  @QueryParam("account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.")  String account
);}
