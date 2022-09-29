package io.harness.spec.server.pipeline;

import io.harness.spec.server.pipeline.model.PipelineCreateRequestBody;
import io.harness.spec.server.pipeline.model.PipelineCreateResponseBody;
import io.harness.spec.server.pipeline.model.PipelineGetResponseBody;
import io.harness.spec.server.pipeline.model.PipelineListResponseBody;
import io.harness.spec.server.pipeline.model.PipelineUpdateRequestBody;

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


public interface PipelinesApi {

    @POST
    @Consumes({ "application/json", "application/yaml" })
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "createPipeline", summary = "Create a Pipeline", description = "Creates a Pipeline.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Pipelines" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "201", description = "Pipeline response body", content = @Content(mediaType = "application/json", schema = @Schema(implementation = PipelineCreateResponseBody.class))) })
    Response createPipeline(@Valid PipelineCreateRequestBody body, @PathParam("org")

 @Parameter(description = "Organization identifier") String org
, @PathParam("project")

 @Parameter(description = "Project identifier") String project
,  @HeaderParam("Harness-Account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.") String harnessAccount
);
    @DELETE
    @Path("/{pipeline}")
    @Operation(operationId = "deletePipeline", summary = "Delete a Pipeline", description = "Deletes a Pipeline.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Pipelines" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "204", description = "No Content") })
    Response deletePipeline( @PathParam("org")

 @Parameter(description = "Organization identifier") String org
, @PathParam("project")

 @Parameter(description = "Project identifier") String project
, @PathParam("pipeline")

 @Parameter(description = "Pipeline identifier") String pipeline
,  @HeaderParam("Harness-Account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.") String harnessAccount
);
    @GET
    @Path("/{pipeline}")
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "getPipeline", summary = "Retrieve a Pipeline", description = "Retrieves a Pipeline.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Pipelines" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Pipeline response body", content = @Content(mediaType = "application/json", schema = @Schema(implementation = PipelineGetResponseBody.class))) })
    Response getPipeline( @PathParam("org")

 @Parameter(description = "Organization identifier") String org
, @PathParam("project")

 @Parameter(description = "Project identifier") String project
, @PathParam("pipeline")

 @Parameter(description = "Pipeline identifier") String pipeline
,  @HeaderParam("Harness-Account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.") String harnessAccount
,  @QueryParam("branch_name") 

 @Parameter(description = "Name of the branch (for Git Experience).")  String branchName
,  @QueryParam("template_applied") @DefaultValue("false") 

 @Parameter(description = "If true, returns Pipeline YAML with Templates applied on it.")  Boolean templateApplied
);
    @GET
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "listPipelines", summary = "List Pipelines", description = "Returns a list of Pipelines.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Pipelines" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Response body for List Pipelines.", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = PipelineListResponseBody.class)))) })
    Response listPipelines( @PathParam("org")

 @Parameter(description = "Organization identifier") String org
, @PathParam("project")

 @Parameter(description = "Project identifier") String project
,  @HeaderParam("Harness-Account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.") String harnessAccount
,  @QueryParam("page") @DefaultValue("0") 

 @Parameter(description = "Pagination page number strategy: Specify the page number within the paginated collection related to the number of items on each page.")  Integer page
, @Max(100)  @QueryParam("limit") @DefaultValue("30") 

 @Parameter(description = "Pagination: Number of items to return.")  Integer limit
,  @QueryParam("search_term") 

 @Parameter(description = "This would be used to filter resources having attributes matching the search term.")  String searchTerm
,  @QueryParam("sort") 

 @Parameter(description = "Parameter on the basis of which sorting is done.")  String sort
,  @QueryParam("order") 

 @Parameter(description = "Order on the basis of which sorting is done.")  String order
,  @QueryParam("module") 

 @Parameter(description = "Harness module which is part of the Pipeline.")  String module
,  @QueryParam("filter_identifier") 

 @Parameter(description = "Identifier of a saved Filter.")  String filterIdentifier
,  @QueryParam("pipeline_identifiers") 

 @Parameter(description = "List of Pipeline identifiers on the basis of which the Pipelines are filtered.")  List<String> pipelineIdentifiers
, @Pattern(regexp="^[a-zA-Z_][0-9a-zA-Z_$]{0,63}$") @Size(min=1,max=64)  @QueryParam("name") 

 @Parameter(description = "Pipeline Name on the basis of which the Pipelines are filtered.")  String name
, @Size(max=1024)  @QueryParam("description") 

 @Parameter(description = "Pipeline Description on the basis of which the Pipelines are filtered.")  String description
, @Size(max=128)  @QueryParam("tags") 

 @Parameter(description = "Filter tags as a key:value pair.")  List<String> tags
,  @QueryParam("service_names") 

 @Parameter(description = "Service names on the basis of which the Pipelines are filtered.")  List<String> serviceNames
,  @QueryParam("env_names") 

 @Parameter(description = "Names of Environments on the basis of which the Pipelines are filtered.")  List<String> envNames
,  @QueryParam("deployment_type") 

 @Parameter(description = "Deployment type on the basis of which the Pipelines are filtered.")  String deploymentType
,  @QueryParam("repository") 

 @Parameter(description = "Repository name on the basis of which the Pipelines are filtered.")  String repository
);
    @PUT
    @Path("/{pipeline}")
    @Consumes({ "application/json", "application/yaml" })
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "updatePipeline", summary = "Update a Pipeline", description = "Updates a Pipeline.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Pipelines" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Pipeline response body", content = @Content(mediaType = "application/json", schema = @Schema(implementation = PipelineCreateResponseBody.class))) })
    Response updatePipeline(@Valid PipelineUpdateRequestBody body, @PathParam("org")

 @Parameter(description = "Organization identifier") String org
, @PathParam("project")

 @Parameter(description = "Project identifier") String project
, @PathParam("pipeline")

 @Parameter(description = "Pipeline identifier") String pipeline
,  @HeaderParam("Harness-Account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.") String harnessAccount
);}
