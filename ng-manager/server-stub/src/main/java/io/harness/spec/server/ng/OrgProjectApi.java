package io.harness.spec.server.ng;

import io.harness.spec.server.ng.model.CreateProjectRequest;
import io.harness.spec.server.ng.model.ProjectResponse;
import io.harness.spec.server.ng.model.UpdateProjectRequest;

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

@Path("/v1/orgs/{org}/projects")


public interface OrgProjectApi {

    @POST
    @Consumes({ "application/json", "application/yaml" })
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "createOrgScopedProject", summary = "Creates a project", description = "Creates a new project", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Org Project" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "201", description = "Project response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProjectResponse.class))) })
    Response createOrgScopedProject(@Valid CreateProjectRequest body, @PathParam("org")

 @Parameter(description = "Slug field of the organization the resource is scoped to") String org
,  @HeaderParam("Harness-Account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.") String harnessAccount
);
    @DELETE
    @Path("/{project}")
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "deleteOrgScopedProject", summary = "Delete a project", description = "Deletes the information of the project with the matching project slug.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Org Project" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Project response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProjectResponse.class))) })
    Response deleteOrgScopedProject( @PathParam("org")

 @Parameter(description = "Slug field of the organization the resource is scoped to") String org
, @PathParam("project")

 @Parameter(description = "Slug field of the project the resource is scoped to") String project
,  @HeaderParam("Harness-Account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.") String harnessAccount
);
    @GET
    @Path("/{project}")
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "getOrgScopedProject", summary = "Retrieve a project", description = "Retrieves the information of the project with the matching project slug.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Org Project" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Project response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProjectResponse.class))) })
    Response getOrgScopedProject( @PathParam("org")

 @Parameter(description = "Slug field of the organization the resource is scoped to") String org
, @PathParam("project")

 @Parameter(description = "Slug field of the project the resource is scoped to") String project
,  @HeaderParam("Harness-Account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.") String harnessAccount
);
    @GET
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "getOrgScopedProjects", summary = "List projects", description = "Retrieves the information of the projects.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Org Project" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Project list response", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ProjectResponse.class)))) })
    Response getOrgScopedProjects( @PathParam("org")

 @Parameter(description = "Slug field of the organization the resource is scoped to") String org
,  @QueryParam("project") 

 @Parameter(description = "Slug field of the projects the resource is scoped to")  List<String> project
,  @QueryParam("has_module") @DefaultValue("true") 

 @Parameter(description = "This boolean specifies whether to filter projects which has the module of type passed in the moduleType parameter or not")  Boolean hasModule
,  @QueryParam("module_type") 

 @Parameter(description = "Project&#x27;s module type")  String moduleType
,  @QueryParam("search_term") 

 @Parameter(description = "This would be used to filter resources having attributes matching with search term.")  String searchTerm
,  @QueryParam("page") @DefaultValue("0") 

 @Parameter(description = "Pagination page number strategy: Specify the page number within the paginated collection related to the number of items in each page ")  Integer page
,  @QueryParam("limit") @DefaultValue("30") 

 @Parameter(description = "Pagination: Number of items to return")  Integer limit
,  @HeaderParam("Harness-Account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.") String harnessAccount
,  @QueryParam("sort") 

 @Parameter(description = "Parameter on the basis of which sorting is done.")  String sort
,  @QueryParam("order") 

 @Parameter(description = "Order on the basis of which sorting is done.")  String order
);
    @PUT
    @Path("/{project}")
    @Consumes({ "application/json", "application/yaml" })
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "updateOrgScopedProject", summary = "Update a project", description = "Updates the information of the project with the matching project slug.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Org Project" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Project response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProjectResponse.class))) })
    Response updateOrgScopedProject(@Valid UpdateProjectRequest body, @PathParam("org")

 @Parameter(description = "Slug field of the organization the resource is scoped to") String org
, @PathParam("project")

 @Parameter(description = "Slug field of the project the resource is scoped to") String project
,  @HeaderParam("Harness-Account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.") String harnessAccount
);}
