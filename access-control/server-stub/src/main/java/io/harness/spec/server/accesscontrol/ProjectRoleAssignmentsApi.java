package io.harness.spec.server.accesscontrol;

import io.harness.spec.server.accesscontrol.model.RoleAssignment;
import io.harness.spec.server.accesscontrol.model.RoleAssignmentResponse;

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

@Path("/v1/orgs/{org}/projects/{project}/roleassignments")


public interface ProjectRoleAssignmentsApi {

    @POST
    @Consumes({ "application/json", "application/yaml" })
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "createProjectScopedRoleAssignments", summary = "Create a role assignment", description = "Create a role assignment", tags={ "Project Role Assignments" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "201", description = "Role assignment response body", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RoleAssignmentResponse.class))) })
    Response createProjectScopedRoleAssignments(@Valid RoleAssignment body, @PathParam("org")

 @Parameter(description = "Organization identifier") String org
, @PathParam("project")

 @Parameter(description = "Project identifier") String project
,  @HeaderParam("Harness-Account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.") String harnessAccount
);
    @DELETE
    @Path("/{roleassignment}")
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "deleteProjectScopedRoleAssignment", summary = "Delete a role assignment", description = "Deletes the information of the role assignment with the matching role assignment slug.", tags={ "Project Role Assignments" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Role assignment response body", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RoleAssignmentResponse.class))) })
    Response deleteProjectScopedRoleAssignment( @PathParam("roleassignment")

 @Parameter(description = "Role assignment slug") String roleassignment
, @PathParam("org")

 @Parameter(description = "Organization identifier") String org
, @PathParam("project")

 @Parameter(description = "Project identifier") String project
,  @HeaderParam("Harness-Account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.") String harnessAccount
);
    @GET
    @Path("/{roleassignment}")
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "getProjectScopedRoleAssignment", summary = "Retrieve a role assignment", description = "Retrieves the information of the role assignment with the matching role assignment slug.", tags={ "Project Role Assignments" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Role assignment response body", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RoleAssignmentResponse.class))) })
    Response getProjectScopedRoleAssignment( @PathParam("roleassignment")

 @Parameter(description = "Role assignment slug") String roleassignment
, @PathParam("org")

 @Parameter(description = "Organization identifier") String org
, @PathParam("project")

 @Parameter(description = "Project identifier") String project
,  @HeaderParam("Harness-Account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.") String harnessAccount
);
    @GET
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "getProjectScopedRoleAssignments", summary = "List role assignments", description = "Retrieves the information of the role assignments", tags={ "Project Role Assignments" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Role Assignment List Response body", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = RoleAssignmentResponse.class)))) })
    Response getProjectScopedRoleAssignments( @PathParam("org")

 @Parameter(description = "Organization identifier") String org
, @PathParam("project")

 @Parameter(description = "Project identifier") String project
,  @HeaderParam("Harness-Account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.") String harnessAccount
,  @QueryParam("page") @DefaultValue("0") 

 @Parameter(description = "Pagination page number strategy: Specify the page number within the paginated collection related to the number of items on each page.")  Integer page
, @Max(100)  @QueryParam("limit") @DefaultValue("30") 

 @Parameter(description = "Pagination: Number of items to return.")  Integer limit
,  @QueryParam("sort") 

 @Parameter(description = "Parameter on the basis of which sorting is done.")  String sort
,  @QueryParam("order") 

 @Parameter(description = "Order on the basis of which sorting is done.")  String order
);}
