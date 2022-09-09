package io.harness.spec.server.accesscontrol;

import io.harness.spec.server.accesscontrol.model.CreateRoleRequest;
import io.harness.spec.server.accesscontrol.model.RolesResponse;

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

@Path("/v1/orgs/{org}/roles")


public interface OrganizationRolesApi {

    @POST
    @Consumes({ "application/json", "application/yaml" })
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "createRoleOrg", summary = "Create a Role", description = "Creates a custom Role in the Organization scope.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Organization Roles" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "201", description = "Example Role Response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RolesResponse.class))) })
    Response createRoleOrg(@Valid CreateRoleRequest body, @PathParam("org")

 @Parameter(description = "Organization identifier") String org
,  @QueryParam("account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.")  String account
);
    @DELETE
    @Path("/{role}")
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "deleteRoleOrg", summary = "Delete a Role", description = "Deletes a custom Role from Organization scope.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Organization Roles" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Example Role Response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RolesResponse.class))) })
    Response deleteRoleOrg( @PathParam("org")

 @Parameter(description = "Organization identifier") String org
, @PathParam("role")

 @Parameter(description = "Role identifier") String role
,  @QueryParam("account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.")  String account
);
    @GET
    @Path("/{role}")
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "getRoleOrg", summary = "Retrieve a Role", description = "Retrieves a Role from Organization scope.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Organization Roles" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Example Role Response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RolesResponse.class))) })
    Response getRoleOrg( @PathParam("org")

 @Parameter(description = "Organization identifier") String org
, @PathParam("role")

 @Parameter(description = "Role identifier") String role
,  @QueryParam("account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.")  String account
);
    @GET
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "listRolesOrg", summary = "List Roles", description = "Returns a list of Roles present in the Organization scope.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Organization Roles" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Roles List Response", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = RolesResponse.class)))) })
    Response listRolesOrg( @PathParam("org")

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
    @Path("/{role}")
    @Consumes({ "application/json", "application/yaml" })
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "updateRoleOrg", summary = "Update a Role", description = "Updates a Role from Organization scope.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Organization Roles" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Example Role Response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RolesResponse.class))) })
    Response updateRoleOrg(@Valid CreateRoleRequest body, @PathParam("org")

 @Parameter(description = "Organization identifier") String org
, @PathParam("role")

 @Parameter(description = "Role identifier") String role
,  @QueryParam("account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.")  String account
);}
