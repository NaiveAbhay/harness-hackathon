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
import javax.validation.constraints.*;
import javax.validation.Valid;

@Path("/v1")


public interface ProjectApi {

    @POST
    @Path("/projects")
    @Consumes({ "application/json", "application/yaml" })
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "createAccountScopedProject", summary = "Create Project", description = "Creates a new Project", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Project" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Project response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProjectResponse.class))) })
    Response createAccountScopedProject(@Valid CreateProjectRequest body,  @QueryParam("account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization method other than x-api-key header. If you are using x-api-key header this can be skipped.")  String account
);
    @POST
    @Path("/orgs/{org}/projects")
    @Consumes({ "application/json", "application/yaml" })
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "createOrgScopedProject", summary = "Create Project", description = "Creates a new Project", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Project" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Project response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProjectResponse.class))) })
    Response createOrgScopedProject( @PathParam("org")

 @Parameter(description = "Slug field of the organization the resource is scoped to") String org
,@Valid CreateProjectRequest body,  @QueryParam("account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization method other than x-api-key header. If you are using x-api-key header this can be skipped.")  String account
);
    @DELETE
    @Path("/projects/{id}")
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "deleteAccountScopedProject", summary = "Delete Project", description = "Deletes the information of the Project with the matching Project identifier.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Project" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Project response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProjectResponse.class))) })
    Response deleteAccountScopedProject( @PathParam("id")

 @Parameter(description = "Project identifier") String id
,  @QueryParam("account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization method other than x-api-key header. If you are using x-api-key header this can be skipped.")  String account
);
    @DELETE
    @Path("/orgs/{org}/projects/{id}")
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "deleteOrgScopedProject", summary = "Delete Project", description = "Deletes the information of the Project with the matching Project identifier.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Project" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Project response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProjectResponse.class))) })
    Response deleteOrgScopedProject( @PathParam("org")

 @Parameter(description = "Slug field of the organization the resource is scoped to") String org
, @PathParam("id")

 @Parameter(description = "Project identifier") String id
,  @QueryParam("account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization method other than x-api-key header. If you are using x-api-key header this can be skipped.")  String account
);
    @GET
    @Path("/projects/{id}")
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "getAccountScopedProject", summary = "Get Project", description = "Retrieve the information of the Project with the matching Project identifier.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Project" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Project response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProjectResponse.class))) })
    Response getAccountScopedProject( @PathParam("id")

 @Parameter(description = "Project identifier") String id
,  @QueryParam("account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization method other than x-api-key header. If you are using x-api-key header this can be skipped.")  String account
);
    @GET
    @Path("/projects")
    @Produces({ "application/json" })
    @Operation(operationId = "getAccountScopedProjects", summary = "Get Projects", description = "Retrieves the information of the Projects.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Project" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Project list response", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ProjectResponse.class)))) })
    Response getAccountScopedProjects(  @QueryParam("account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization method other than x-api-key header. If you are using x-api-key header this can be skipped.")  String account
,  @QueryParam("org") 

 @Parameter(description = "Slug field of the organizations the resource is scoped to")  List<String> org
,  @QueryParam("project") 

 @Parameter(description = "Slug field of the projects the resource is scoped to")  List<String> project
,  @QueryParam("has_module") @DefaultValue("true") 

 @Parameter(description = "This boolean specifies whether to Filter Projects which has the Module of type passed in the moduleType parameter or not")  Boolean hasModule
,  @QueryParam("module_type") 

 @Parameter(description = "Project&#x27;s module type")  String moduleType
,  @QueryParam("search_term") 

 @Parameter(description = "This would be used to filter resources having attributes matching with search term.")  String searchTerm
,  @QueryParam("page") @DefaultValue("0") 

 @Parameter(description = "Pagination page number strategy: Specify the page number within the paginated collection related to the number of items in each page ")  Integer page
,  @QueryParam("limit") @DefaultValue("30") 

 @Parameter(description = "Pagination: Number of items to return")  Integer limit
);
    @GET
    @Path("/orgs/{org}/projects/{id}")
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "getOrgScopedProject", summary = "Get Project", description = "Retrieve the information of the Project with the matching Project identifier.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Project" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Project response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProjectResponse.class))) })
    Response getOrgScopedProject( @PathParam("org")

 @Parameter(description = "Slug field of the organization the resource is scoped to") String org
, @PathParam("id")

 @Parameter(description = "Project identifier") String id
,  @QueryParam("account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization method other than x-api-key header. If you are using x-api-key header this can be skipped.")  String account
);
    @GET
    @Path("/orgs/{org}/projects")
    @Produces({ "application/json" })
    @Operation(operationId = "getOrgScopedProjects", summary = "Get Projects", description = "Retrieves the information of the Projects.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Project" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Project list response", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ProjectResponse.class)))) })
    Response getOrgScopedProjects( @PathParam("org")

 @Parameter(description = "Slug field of the organization the resource is scoped to") String org
,  @QueryParam("account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization method other than x-api-key header. If you are using x-api-key header this can be skipped.")  String account
,  @QueryParam("project") 

 @Parameter(description = "Slug field of the projects the resource is scoped to")  List<String> project
,  @QueryParam("has_module") @DefaultValue("true") 

 @Parameter(description = "This boolean specifies whether to Filter Projects which has the Module of type passed in the moduleType parameter or not")  Boolean hasModule
,  @QueryParam("module_type") 

 @Parameter(description = "Project&#x27;s module type")  String moduleType
,  @QueryParam("search_term") 

 @Parameter(description = "This would be used to filter resources having attributes matching with search term.")  String searchTerm
,  @QueryParam("page") @DefaultValue("0") 

 @Parameter(description = "Pagination page number strategy: Specify the page number within the paginated collection related to the number of items in each page ")  Integer page
,  @QueryParam("limit") @DefaultValue("30") 

 @Parameter(description = "Pagination: Number of items to return")  Integer limit
);
    @PUT
    @Path("/projects/{id}")
    @Consumes({ "application/json" })
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "updateAccountScopedProject", summary = "Update Project", description = "Updates the information of the Project with the matching Project identifier.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Project" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Project response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProjectResponse.class))) })
    Response updateAccountScopedProject( @PathParam("id")

 @Parameter(description = "Project identifier") String id
,@Valid UpdateProjectRequest body,  @QueryParam("account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization method other than x-api-key header. If you are using x-api-key header this can be skipped.")  String account
);
    @PUT
    @Path("/orgs/{org}/projects/{id}")
    @Consumes({ "application/json" })
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "updateOrgScopedProject", summary = "Update Project", description = "Updates the information of the Project with the matching Project identifier.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Project" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Project response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProjectResponse.class))) })
    Response updateOrgScopedProject( @PathParam("org")

 @Parameter(description = "Slug field of the organization the resource is scoped to") String org
, @PathParam("id")

 @Parameter(description = "Project identifier") String id
,@Valid UpdateProjectRequest body,  @QueryParam("account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization method other than x-api-key header. If you are using x-api-key header this can be skipped.")  String account
);}
