package io.harness.spec.server.ng;

import io.harness.spec.server.ng.model.CreateOrganizationRequest;
import java.util.List;
import io.harness.spec.server.ng.model.OrganizationResponse;
import io.harness.spec.server.ng.model.UpdateOrganizationRequest;

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

@Path("/v1/organizations")

public interface OrganizationsApi {

    @POST
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @Operation(summary = "Create Organization", description = "Create a new Organization.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Organization" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Organization response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = OrganizationResponse.class))) })
    OrganizationResponse createOrganization(@Valid CreateOrganizationRequest body,  @QueryParam("account") 

 @Parameter(description = "Slug field of the account the resource is scoped to")  String account
);
    @DELETE
    @Path("/{id}")
    @Produces({ "application/json" })
    @Operation(summary = "Delete Organization", description = "Delete the information of the organization with the matching organization identifier.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Organization" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Organization response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = OrganizationResponse.class))) })
    OrganizationResponse deleteOrganization( @PathParam("id")

 @Parameter(description = "Organization identifier") String id
,  @QueryParam("account") 

 @Parameter(description = "Slug field of the account the resource is scoped to")  String account
);
    @GET
    @Path("/{id}")
    @Produces({ "application/json" })
    @Operation(summary = "Get Organization", description = "Retrieve the information of the organization with the matching organization identifier.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Organization" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Organization response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = OrganizationResponse.class))) })
    OrganizationResponse getOrganization( @PathParam("id")

 @Parameter(description = "Organization identifier") String id
,  @QueryParam("account") 

 @Parameter(description = "Slug field of the account the resource is scoped to")  String account
);
    @GET
    @Produces({ "application/json" })
    @Operation(summary = "Get Organizations", description = "Retrieve the information of the Organizations.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Organization" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Organization lsit response", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = OrganizationResponse.class)))) })
    List<OrganizationResponse> getOrganizations(  @QueryParam("account") 

 @Parameter(description = "Slug field of the account the resource is scoped to")  String account
,  @QueryParam("org") 

 @Parameter(description = "Slug field of the organizations the resource is scoped to")  List org
,  @QueryParam("search_term") 

 @Parameter(description = "This would be used to filter resources having attributes matching with search term.")  String searchTerm
,  @QueryParam("page") @DefaultValue("0") 

 @Parameter(description = "Pagination page number strategy: Specify the page number within the paginated collection related to the number of items in each page ")  Integer page
,  @QueryParam("limit") @DefaultValue("30") 

 @Parameter(description = "Pagination: Number of items to return")  Integer limit
);
    @PUT
    @Path("/{id}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @Operation(summary = "Update Organization", description = "Update the information of the organization with the matching organization identifier.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Organization" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Organization response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = OrganizationResponse.class))) })
    OrganizationResponse updateOrganization( @PathParam("id")

 @Parameter(description = "Organization identifier") String id
,@Valid UpdateOrganizationRequest body,  @QueryParam("account") 

 @Parameter(description = "Slug field of the account the resource is scoped to")  String account
);}
