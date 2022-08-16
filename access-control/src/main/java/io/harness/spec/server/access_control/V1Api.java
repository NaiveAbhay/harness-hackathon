package io.harness.spec.server.access_control;

import io.harness.spec.server.access_control.model.CreateRoleRequest;
import io.harness.spec.server.access_control.model.InlineResponse200;
import io.harness.spec.server.access_control.model.RolesResponse;
import io.harness.spec.server.access_control.model.SortRoles;

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

@Path("/v1")

public interface V1Api {

    @POST
    @Path("/roles")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @Operation(summary = "Create a Role [Account]", description = "Creates a custom Role in the Account scope.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Account Roles" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Example Role Response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RolesResponse.class))) })
    RolesResponse createRoleAcc(@Valid CreateRoleRequest body,  @QueryParam("account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.")  String account
);
    @POST
    @Path("/orgs/{org}/roles")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @Operation(summary = "Create a Role [Organization]", description = "Creates a custom Role in the Organization scope.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Organization Roles" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Example Role Response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RolesResponse.class))) })
    RolesResponse createRoleOrg( @PathParam("org")

 @Parameter(description = "Organization identifier") String org
,@Valid CreateRoleRequest body,  @QueryParam("account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.")  String account
);
    @POST
    @Path("/orgs/{org}/projects/{project}/roles")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @Operation(summary = "Create a Role [Project]", description = "Creates a custom Role in the Project scope.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Project Roles" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Example Role Response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RolesResponse.class))) })
    RolesResponse createRoleProject( @PathParam("org")

 @Parameter(description = "Organization identifier") String org
, @PathParam("project")

 @Parameter(description = "Project identifier") String project
,@Valid CreateRoleRequest body,  @QueryParam("account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.")  String account
);
    @DELETE
    @Path("/roles/{role}")
    @Produces({ "application/json" })
    @Operation(summary = "Delete a Role [Account]", description = "Deletes a custom Role from Account scope.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Account Roles" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Example Role Response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RolesResponse.class))) })
    RolesResponse deleteRoleAcc( @PathParam("role")

 @Parameter(description = "Role identifier") String role
,  @QueryParam("account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.")  String account
);
    @DELETE
    @Path("/orgs/{org}/roles/{role}")
    @Produces({ "application/json" })
    @Operation(summary = "Delete a Role [Organization]", description = "Deletes a custom Role from Organization scope.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Organization Roles" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Example Role Response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RolesResponse.class))) })
    RolesResponse deleteRoleOrg( @PathParam("org")

 @Parameter(description = "Organization identifier") String org
, @PathParam("role")

 @Parameter(description = "Role identifier") String role
,  @QueryParam("account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.")  String account
);
    @DELETE
    @Path("/orgs/{org}/projects/{project}/roles/{role}")
    @Produces({ "application/json" })
    @Operation(summary = "Delete a Role [Project]", description = "Deletes a custom Role from Project scope.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Project Roles" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Example Role Response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RolesResponse.class))) })
    RolesResponse deleteRoleProject( @PathParam("org")

 @Parameter(description = "Organization identifier") String org
, @PathParam("project")

 @Parameter(description = "Project identifier") String project
, @PathParam("role")

 @Parameter(description = "Role identifier") String role
,  @QueryParam("account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.")  String account
);
    @GET
    @Path("/roles/{role}")
    @Produces({ "application/json" })
    @Operation(summary = "Retrieve a Role [Account]", description = "Retrieves a Role from Account scope.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Account Roles" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Example Role Response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RolesResponse.class))) })
    RolesResponse getRoleAcc( @PathParam("role")

 @Parameter(description = "Role identifier") String role
,  @QueryParam("account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.")  String account
);
    @GET
    @Path("/orgs/{org}/roles/{role}")
    @Produces({ "application/json" })
    @Operation(summary = "Retrieve a Role [Organization]", description = "Retrieves a Role from Organization scope.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Organization Roles" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Example Role Response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RolesResponse.class))) })
    RolesResponse getRoleOrg( @PathParam("org")

 @Parameter(description = "Organization identifier") String org
, @PathParam("role")

 @Parameter(description = "Role identifier") String role
,  @QueryParam("account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.")  String account
);
    @GET
    @Path("/orgs/{org}/projects/{project}/roles/{role}")
    @Produces({ "application/json" })
    @Operation(summary = "Retrieve a Role [Project]", description = "Retrieves a Role from Project scope.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Project Roles" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Example Role Response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RolesResponse.class))) })
    RolesResponse getRoleProject( @PathParam("org")

 @Parameter(description = "Organization identifier") String org
, @PathParam("project")

 @Parameter(description = "Project identifier") String project
, @PathParam("role")

 @Parameter(description = "Role identifier") String role
,  @QueryParam("account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.")  String account
);
    @GET
    @Path("/roles")
    @Produces({ "application/json" })
    @Operation(summary = "List Roles [Account]", description = "Returns a list of Roles present in the Account scope.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Account Roles" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Roles List Response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse200.class))) })
    InlineResponse200 listRolesAcc(  @QueryParam("account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.")  String account
,  @QueryParam("page") @DefaultValue("0") 

 @Parameter(description = "Pagination page number strategy: Specify the page number within the paginated collection related to the number of items on each page.")  Integer page
, @Max(100)  @QueryParam("limit") @DefaultValue("50") 

 @Parameter(description = "Pagination: Number of items to return.")  Integer limit
,  @QueryParam("search_term") 

 @Parameter(description = "This would be used to filter resources having attributes matching the search term.")  String searchTerm
,  @QueryParam("sort_orders") 

 @Parameter(description = "Sort criteria for the items.")  List<SortRoles> sortOrders
);
    @GET
    @Path("/orgs/{org}/roles")
    @Produces({ "application/json" })
    @Operation(summary = "List Roles [Organization]", description = "Returns a list of Roles present in the Organization scope.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Organization Roles" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Roles List Response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse200.class))) })
    InlineResponse200 listRolesOrg( @PathParam("org")

 @Parameter(description = "Organization identifier") String org
,  @QueryParam("account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.")  String account
,  @QueryParam("page") @DefaultValue("0") 

 @Parameter(description = "Pagination page number strategy: Specify the page number within the paginated collection related to the number of items on each page.")  Integer page
, @Max(100)  @QueryParam("limit") @DefaultValue("50") 

 @Parameter(description = "Pagination: Number of items to return.")  Integer limit
,  @QueryParam("search_term") 

 @Parameter(description = "This would be used to filter resources having attributes matching the search term.")  String searchTerm
,  @QueryParam("sort_orders") 

 @Parameter(description = "Sort criteria for the items.")  List<SortRoles> sortOrders
);
    @GET
    @Path("/orgs/{org}/projects/{project}/roles")
    @Produces({ "application/json" })
    @Operation(summary = "List Roles [Project]", description = "Returns a list of Roles present in the Project scope.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Project Roles" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Roles List Response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse200.class))) })
    InlineResponse200 listRolesProject( @PathParam("org")

 @Parameter(description = "Organization identifier") String org
, @PathParam("project")

 @Parameter(description = "Project identifier") String project
,  @QueryParam("account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.")  String account
,  @QueryParam("page") @DefaultValue("0") 

 @Parameter(description = "Pagination page number strategy: Specify the page number within the paginated collection related to the number of items on each page.")  Integer page
, @Max(100)  @QueryParam("limit") @DefaultValue("50") 

 @Parameter(description = "Pagination: Number of items to return.")  Integer limit
,  @QueryParam("search_term") 

 @Parameter(description = "This would be used to filter resources having attributes matching the search term.")  String searchTerm
,  @QueryParam("sort_orders") 

 @Parameter(description = "Sort criteria for the items.")  List<SortRoles> sortOrders
);
    @PUT
    @Path("/roles/{role}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @Operation(summary = "Update a Role [Account]", description = "Updates a Role from Account scope.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Account Roles" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Example Role Response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RolesResponse.class))) })
    RolesResponse updateRoleAcc( @PathParam("role")

 @Parameter(description = "Role identifier") String role
,@Valid CreateRoleRequest body,  @QueryParam("account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.")  String account
);
    @PUT
    @Path("/orgs/{org}/roles/{role}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @Operation(summary = "Update a Role [Organization]", description = "Updates a Role from Organization scope.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Organization Roles" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Example Role Response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RolesResponse.class))) })
    RolesResponse updateRoleOrg( @PathParam("org")

 @Parameter(description = "Organization identifier") String org
, @PathParam("role")

 @Parameter(description = "Role identifier") String role
,@Valid CreateRoleRequest body,  @QueryParam("account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.")  String account
);
    @PUT
    @Path("/orgs/{org}/projects/{project}/roles/{role}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @Operation(summary = "Update a Role [Project]", description = "Updates a Role from Project scope.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Project Roles" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Example Role Response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RolesResponse.class))) })
    RolesResponse updateRoleProject( @PathParam("org")

 @Parameter(description = "Organization identifier") String org
, @PathParam("project")

 @Parameter(description = "Project identifier") String project
, @PathParam("role")

 @Parameter(description = "Role identifier") String role
,@Valid CreateRoleRequest body);}
