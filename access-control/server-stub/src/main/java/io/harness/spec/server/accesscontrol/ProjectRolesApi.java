package io.harness.spec.server.accesscontrol;

import io.harness.spec.server.accesscontrol.model.CreateRoleRequest;
import io.harness.spec.server.accesscontrol.model.RolesResponse;
import io.harness.spec.server.accesscontrol.model.SortRoles;

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

@Path("/v1/orgs/{org}/projects/{project}/roles")


public interface ProjectRolesApi {

    @POST
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @Operation(operationId = "createRoleProject", summary = "Create a Role [Project]", description = "Creates a custom Role in the Project scope.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Project Roles" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Example Role Response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RolesResponse.class))) })
    Response createRoleProject( @PathParam("org")

 @Parameter(description = "Organization identifier") String org
, @PathParam("project")

 @Parameter(description = "Project identifier") String project
,@Valid CreateRoleRequest body,  @QueryParam("account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.")  String account
);
    @DELETE
    @Path("/{role}")
    @Produces({ "application/json" })
    @Operation(operationId = "deleteRoleProject", summary = "Delete a Role [Project]", description = "Deletes a custom Role from Project scope.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Project Roles" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Example Role Response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RolesResponse.class))) })
    Response deleteRoleProject( @PathParam("org")

 @Parameter(description = "Organization identifier") String org
, @PathParam("project")

 @Parameter(description = "Project identifier") String project
, @PathParam("role")

 @Parameter(description = "Role identifier") String role
,  @QueryParam("account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.")  String account
);
    @GET
    @Path("/{role}")
    @Produces({ "application/json" })
    @Operation(operationId = "getRoleProject", summary = "Retrieve a Role [Project]", description = "Retrieves a Role from Project scope.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Project Roles" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Example Role Response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RolesResponse.class))) })
    Response getRoleProject( @PathParam("org")

 @Parameter(description = "Organization identifier") String org
, @PathParam("project")

 @Parameter(description = "Project identifier") String project
, @PathParam("role")

 @Parameter(description = "Role identifier") String role
,  @QueryParam("account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.")  String account
);
    @GET
    @Produces({ "application/json" })
    @Operation(operationId = "listRolesProject", summary = "List Roles [Project]", description = "Returns a list of Roles present in the Project scope.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Project Roles" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Roles List Response", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = RolesResponse.class)))) })
    Response listRolesProject( @PathParam("org")

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
    @Path("/{role}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @Operation(operationId = "updateRoleProject", summary = "Update a Role [Project]", description = "Updates a Role from Project scope.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Project Roles" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Example Role Response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RolesResponse.class))) })
    Response updateRoleProject( @PathParam("org")

 @Parameter(description = "Organization identifier") String org
, @PathParam("project")

 @Parameter(description = "Project identifier") String project
, @PathParam("role")

 @Parameter(description = "Role identifier") String role
,@Valid CreateRoleRequest body);}
