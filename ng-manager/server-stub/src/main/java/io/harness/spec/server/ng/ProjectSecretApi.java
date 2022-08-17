package io.harness.spec.server.ng;

import io.harness.spec.server.ng.model.SecretRequest;
import io.harness.spec.server.ng.model.SecretResponse;
import io.harness.spec.server.ng.model.ValidateSecretSlugResponse;

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


public interface ProjectSecretApi {

    @POST
    @Path("/orgs/{org}/project/{project}/secrets")
    @Consumes({ "application/json", "application/yaml" })
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "createProjectScopedSecret", summary = "Create Secret", description = "Creates a new Secret", tags={ "Project Secret" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "201", description = "Secret Response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = SecretResponse.class))) })
    Response createProjectScopedSecret(@Valid SecretRequest body, @PathParam("org")

 @Parameter(description = "Slug field of the organization the resource is scoped to") String org
, @PathParam("project")

 @Parameter(description = "Slug field of the project the resource is scoped to") String project
,  @QueryParam("account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization method other than x-api-key header. If you are using x-api-key header this can be skipped.")  String account
,  @QueryParam("private_secret") @DefaultValue("false") 

 @Parameter(description = "This would be used to define secret as private.")  Boolean privateSecret
);
    @DELETE
    @Path("/org/{org}/project/{project}/secrets/{secret}")
    @Operation(operationId = "deleteProjectScopedSecret", summary = "Delete Secret", description = "Deletes the information of the Secret with the matching Secret identifier.", tags={ "Project Secret" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "OK") })
    Response deleteProjectScopedSecret( @PathParam("org")

 @Parameter(description = "Slug field of the organization the resource is scoped to") String org
, @PathParam("project")

 @Parameter(description = "Slug field of the project the resource is scoped to") String project
, @PathParam("secret")

 @Parameter(description = "Slug field of the Secret") String secret
,  @QueryParam("account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization method other than x-api-key header. If you are using x-api-key header this can be skipped.")  String account
);
    @GET
    @Path("/org/{org}/project/{project}/secrets/{secret}")
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "getProjectScopedSecret", summary = "Get Secret", description = "Retrieves the information of the Secret.", tags={ "Project Secret" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Secret Response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = SecretResponse.class))) })
    Response getProjectScopedSecret( @PathParam("org")

 @Parameter(description = "Slug field of the organization the resource is scoped to") String org
, @PathParam("project")

 @Parameter(description = "Slug field of the project the resource is scoped to") String project
, @PathParam("secret")

 @Parameter(description = "Slug field of the Secret") String secret
,  @QueryParam("account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization method other than x-api-key header. If you are using x-api-key header this can be skipped.")  String account
);
    @GET
    @Path("/orgs/{org}/project/{project}/secrets")
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "getProjectScopedSecrets", summary = "", description = "Retrieve the information of the Secrets.", tags={ "Project Secret" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Secret list response", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = SecretResponse.class)))) })
    Response getProjectScopedSecrets( @PathParam("org")

 @Parameter(description = "Slug field of the organization the resource is scoped to") String org
, @PathParam("project")

 @Parameter(description = "Slug field of the project the resource is scoped to") String project
,  @QueryParam("account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization method other than x-api-key header. If you are using x-api-key header this can be skipped.")  String account
,  @QueryParam("secret") 

 @Parameter(description = "Slug field of secrets")  List<String> secret
,  @QueryParam("type") 

 @Parameter(description = "Secret types on which the filter will be applied")  List<String> type
,  @QueryParam("recursive") @DefaultValue("false") 

 @Parameter(description = "Expand current scope to include all child scopes ")  Boolean recursive
,  @QueryParam("search_term") 

 @Parameter(description = "This would be used to filter resources having attributes matching with search term.")  String searchTerm
,  @QueryParam("page") @DefaultValue("0") 

 @Parameter(description = "Pagination page number strategy: Specify the page number within the paginated collection related to the number of items in each page ")  Integer page
,  @QueryParam("limit") @DefaultValue("30") 

 @Parameter(description = "Pagination: Number of items to return")  Integer limit
);
    @PUT
    @Path("/org/{org}/project/{project}/secrets/{secret}")
    @Consumes({ "application/json", "application/yaml" })
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "updateProjectScopedSecret", summary = "Update Secret", description = "Updates the information of the Secret with the matching secret identifier.", tags={ "Project Secret" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Secret Response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = SecretResponse.class))) })
    Response updateProjectScopedSecret(@Valid SecretRequest body, @PathParam("org")

 @Parameter(description = "Slug field of the organization the resource is scoped to") String org
, @PathParam("project")

 @Parameter(description = "Slug field of the project the resource is scoped to") String project
, @PathParam("secret")

 @Parameter(description = "Slug field of the Secret") String secret
,  @QueryParam("account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization method other than x-api-key header. If you are using x-api-key header this can be skipped.")  String account
);
    @HEAD
    @Path("/org/{org}/project/{project}/secrets/{secret}")
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "validateUniqueProjectScopedSecretSlug", summary = "Validate Secret slug", description = "Validates project scoped secret slug is unique", tags={ "Project Secret" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Example response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ValidateSecretSlugResponse.class))) })
    Response validateUniqueProjectScopedSecretSlug( @PathParam("org")

 @Parameter(description = "Slug field of the organization the resource is scoped to") String org
, @PathParam("project")

 @Parameter(description = "Slug field of the project the resource is scoped to") String project
, @PathParam("secret")

 @Parameter(description = "Slug field of the Secret") String secret
,  @QueryParam("account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization method other than x-api-key header. If you are using x-api-key header this can be skipped.")  String account
);}
