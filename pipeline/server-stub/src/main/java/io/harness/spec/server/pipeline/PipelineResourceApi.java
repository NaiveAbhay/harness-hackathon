package io.harness.spec.server.pipeline;

import io.harness.spec.server.pipeline.model.PipelineCreateResponseBody;
import io.harness.spec.server.pipeline.model.PipelineGetResponseBody;
import io.harness.spec.server.pipeline.model.PipelineListRequestBody;
import io.harness.spec.server.pipeline.model.PipelineListResponseBody;
import io.harness.spec.server.pipeline.model.PipelineRequestBody;

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

@Path("/v1/orgs/{org}/projects/{project}/pipelines")


public interface PipelineResourceApi {

    @POST
    @Consumes({ "application/json", "application/yaml" })
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "createPipeline", summary = "Create a Pipeline", description = "Creates a Pipeline.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Pipeline Resource" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "201", description = "Pipeline response body", content = @Content(mediaType = "application/json", schema = @Schema(implementation = PipelineCreateResponseBody.class))) })
    Response createPipeline(@Valid PipelineRequestBody body, @PathParam("org")

 @Parameter(description = "Organization identifier") String org
, @PathParam("project")

 @Parameter(description = "Project identifier") String project
,  @HeaderParam("account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.") String account
,  @QueryParam("branch") 

 @Parameter(description = "Name of the branch (for Git Experience).")  String branch
,  @QueryParam("file_path") 

 @Parameter(description = "File path of the Entity in the repository (for Git Experience).")  String filePath
,  @QueryParam("commit_message") 

 @Parameter(description = "Commit message used for the merge commit (for Git Experience).")  String commitMessage
,  @QueryParam("create_new_branch") @DefaultValue("false") 

 @Parameter(description = "Checks out a new branch in the repository (for Git Experience).")  Boolean createNewBranch
,  @QueryParam("base_branch") 

 @Parameter(description = "Name of the default branch (for Git Experience).")  String baseBranch
,  @QueryParam("connector_ref") 

 @Parameter(description = "Identifier of the Harness Connector used for CRUD operations on the Entity (for Git Experience).")  String connectorRef
,  @QueryParam("store_type") 

 @Parameter(description = "Specifies whether the Entity is to be stored in Git or not (for Git Experience).")  String storeType
,  @QueryParam("repo_name") 

 @Parameter(description = "Name of the repository (for Git Experience).")  String repoName
);
    @DELETE
    @Path("/{pipeline}")
    @Operation(operationId = "deletePipeline", summary = "Delete a Pipeline", description = "Deletes a Pipeline.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Pipeline Resource" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "204", description = "No Content") })
    Response deletePipeline( @PathParam("org")

 @Parameter(description = "Organization identifier") String org
, @PathParam("project")

 @Parameter(description = "Project identifier") String project
, @PathParam("pipeline")

 @Parameter(description = "Pipeline identifier") String pipeline
,  @HeaderParam("account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.") String account
);
    @GET
    @Path("/{pipeline}")
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "getPipeline", summary = "Retrieve a Pipeline", description = "Retrieves a Pipeline.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Pipeline Resource" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Pipeline response body", content = @Content(mediaType = "application/json", schema = @Schema(implementation = PipelineGetResponseBody.class))) })
    Response getPipeline( @PathParam("org")

 @Parameter(description = "Organization identifier") String org
, @PathParam("project")

 @Parameter(description = "Project identifier") String project
, @PathParam("pipeline")

 @Parameter(description = "Pipeline identifier") String pipeline
,  @HeaderParam("account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.") String account
,  @QueryParam("branch") 

 @Parameter(description = "Name of the branch (for Git Experience).")  String branch
,  @QueryParam("template_resolved") @DefaultValue("false") 

 @Parameter(description = "If true, returns Pipeline YAML with Templates resolved.")  Boolean templateResolved
);
    @GET
    @Consumes({ "application/json", "application/yaml" })
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "listPipelines", summary = "List Pipelines", description = "Returns a list of Pipelines.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Pipeline Resource" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Response body for List Pipelines.", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = PipelineListResponseBody.class)))) })
    Response listPipelines(@Valid PipelineListRequestBody body, @PathParam("org")

 @Parameter(description = "Organization identifier") String org
, @PathParam("project")

 @Parameter(description = "Project identifier") String project
,  @HeaderParam("account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.") String account
,  @QueryParam("page") @DefaultValue("0") 

 @Parameter(description = "Pagination page number strategy: Specify the page number within the paginated collection related to the number of items on each page.")  Integer page
, @Max(100)  @QueryParam("limit") @DefaultValue("30") 

 @Parameter(description = "Pagination: Number of items to return.")  Integer limit
,  @QueryParam("search_term") 

 @Parameter(description = "This would be used to filter resources having attributes matching the search term.")  String searchTerm
,  @QueryParam("module") 

 @Parameter(description = "Harness module which is part of the Pipeline.")  String module
,  @QueryParam("filter_identifier") 

 @Parameter(description = "Identifier of an existing Filter.")  String filterIdentifier
,  @QueryParam("template_resolved") @DefaultValue("false") 

 @Parameter(description = "In YAML view, if true, returns Pipeline YAML with Templates resolved.")  Boolean templateResolved
,  @QueryParam("view_options") @DefaultValue("YAML") 

 @Parameter(description = "This specifies the view option for Pipeline Resource.")  String viewOptions
);
    @PUT
    @Path("/{pipeline}")
    @Consumes({ "application/json", "application/yaml" })
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "updatePipeline", summary = "Update a Pipeline", description = "Updates a Pipeline.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Pipeline Resource" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Pipeline response body", content = @Content(mediaType = "application/json", schema = @Schema(implementation = PipelineCreateResponseBody.class))) })
    Response updatePipeline(@Valid PipelineRequestBody body, @PathParam("org")

 @Parameter(description = "Organization identifier") String org
, @PathParam("project")

 @Parameter(description = "Project identifier") String project
, @PathParam("pipeline")

 @Parameter(description = "Pipeline identifier") String pipeline
,  @HeaderParam("account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.") String account
,  @QueryParam("branch") 

 @Parameter(description = "Name of the branch (for Git Experience).")  String branch
,  @QueryParam("commit_message") 

 @Parameter(description = "Commit message used for the merge commit (for Git Experience).")  String commitMessage
,  @QueryParam("last_object_id") 

 @Parameter(description = "Last object identifier (for Github).")  String lastObjectId
,  @QueryParam("base_branch") 

 @Parameter(description = "Name of the default branch (for Git Experience).")  String baseBranch
,  @QueryParam("last_commit_id") 

 @Parameter(description = "Last commit identifier (for Git Repositories other than Github).")  String lastCommitId
);}
