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

@Path("/v1/resource-groups")


public interface AccountResourceGroupsApi {

    @POST
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @Operation(operationId = "createResourceGroupAcc", summary = "Create a Resource Group", description = "Creates a custom Resource Group in the Account scope.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Account Resource Groups" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Resource Group Response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResourceGroupsResponse.class))) })
    Response createResourceGroupAcc(@Valid CreateResourceGroupRequest body,  @QueryParam("account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.")  String account
);
    @DELETE
    @Path("/{resource-group}")
    @Produces({ "application/json" })
    @Operation(operationId = "deleteResourceGroupAcc", summary = "Delete a Resource Group", description = "Deletes a custom Resource Group from Account scope.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Account Resource Groups" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Resource Group Response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResourceGroupsResponse.class))) })
    Response deleteResourceGroupAcc( @PathParam("resource-group")

 @Parameter(description = "Resource Group identifier") String resourceGroup
,  @QueryParam("account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.")  String account
);
    @GET
    @Path("/{resource-group}")
    @Produces({ "application/json" })
    @Operation(operationId = "getResourceGroupAcc", summary = "Retrieve a Resource Group", description = "Retrieves a Resource Group from Account scope.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Account Resource Groups" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Resource Group Response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResourceGroupsResponse.class))) })
    Response getResourceGroupAcc( @PathParam("resource-group")

 @Parameter(description = "Resource Group identifier") String resourceGroup
,  @QueryParam("account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.")  String account
);
    @GET
    @Produces({ "application/json" })
    @Operation(operationId = "listResourceGroupsAcc", summary = "List Resource Groups", description = "Returns a list of Resource Groups present in the Account scope.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Account Resource Groups" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Resource Groups List Response", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ResourceGroupsResponse.class)))) })
    Response listResourceGroupsAcc(  @QueryParam("account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.")  String account
,  @QueryParam("page") @DefaultValue("0") 

 @Parameter(description = "Pagination page number strategy: Specify the page number within the paginated collection related to the number of items on each page.")  Integer page
, @Max(100)  @QueryParam("limit") @DefaultValue("30") 

 @Parameter(description = "Pagination: Number of items to return.")  Integer limit
,  @QueryParam("search_term") 

 @Parameter(description = "This would be used to filter resources having attributes matching the search term.")  String searchTerm
,  @QueryParam("identifier_filter") 

 @Parameter(description = "Filter by Identifiers")  List<String> identifierFilter
,  @QueryParam("managed_filter") 

 @Parameter(description = "Filter by Harness Managed")  String managedFilter
,  @QueryParam("resource_type") 

 @Parameter(description = "Filter by Resource type")  List<String> resourceType
,  @QueryParam("resource_slug") 

 @Parameter(description = "Filter by Resource identifier")  List<String> resourceSlug
);
    @PUT
    @Path("/{resource-group}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @Operation(operationId = "updateResourceGroupAcc", summary = "Update a Resource Group", description = "Updates a Resource Group from Account scope.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Account Resource Groups" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Resource Group Response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResourceGroupsResponse.class))) })
    Response updateResourceGroupAcc( @PathParam("resource-group")

 @Parameter(description = "Resource Group identifier") String resourceGroup
,@Valid CreateResourceGroupRequest body,  @QueryParam("account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.")  String account
);}
