package io.harness.spec.server.ng;

import io.harness.spec.server.ng.model.SecretRequest;
import io.harness.spec.server.ng.model.SecretResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/v1")


public interface SecretApi {

    @POST
    @Path("/secrets")
    @Consumes({ "application/json", "application/yaml" })
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "createAccountScopedSecret", summary = "Create Secret", description = "Creates a new Secret", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Secret" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "201", description = "Secret Response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = SecretResponse.class))) })
    Response createAccountScopedSecret(@Valid SecretRequest body,  @QueryParam("account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization method other than x-api-key header. If you are using x-api-key header this can be skipped.")  String account
,  @QueryParam("private_secret") @DefaultValue("false") 

 @Parameter(description = "This would be used to define secret as private.")  Boolean privateSecret
);
    @POST
    @Path("/orgs/{org}/secrets")
    @Consumes({ "application/json", "application/yaml" })
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "createOrgScopedSecret", summary = "Create Secret", description = "Creates a new Secret", tags={ "Secret" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "201", description = "Secret Response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = SecretResponse.class))) })
    Response createOrgScopedSecret(@Valid SecretRequest body, @PathParam("org")

 @Parameter(description = "Slug field of the organization the resource is scoped to") String org
,  @QueryParam("account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization method other than x-api-key header. If you are using x-api-key header this can be skipped.")  String account
,  @QueryParam("private_secret") @DefaultValue("false") 

 @Parameter(description = "This would be used to define secret as private.")  Boolean privateSecret
);
    @POST
    @Path("/orgs/{org}/project/{project}/secrets")
    @Consumes({ "application/json", "application/yaml" })
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "createProjectScopedSecret", summary = "Create Secret", description = "Creates a new Secret", tags={ "Secret" })
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
    @Path("/secrets/{secret}")
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "deleteAccountScopedSecret", summary = "Delete Secret", description = "Deletes the information of the Secret with the matching Secret identifier.", tags={ "Secret" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Secret Response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = SecretResponse.class))) })
    Response deleteAccountScopedSecret( @PathParam("secret")

 @Parameter(description = "Slug field of the Secret") String secret
,  @QueryParam("account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization method other than x-api-key header. If you are using x-api-key header this can be skipped.")  String account
);
    @DELETE
    @Path("/org/{org}/secrets/{secret}")
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "deleteOrgScopedSecret", summary = "Delete Secret", description = "Deletes the information of the Secret with the matching Secret identifier.", tags={ "Secret" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Secret Response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = SecretResponse.class))) })
    Response deleteOrgScopedSecret( @PathParam("org")

 @Parameter(description = "Slug field of the organization the resource is scoped to") String org
, @PathParam("secret")

 @Parameter(description = "Slug field of the Secret") String secret
,  @QueryParam("account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization method other than x-api-key header. If you are using x-api-key header this can be skipped.")  String account
);
    @DELETE
    @Path("/org/{org}/project/{project}/secrets/{secret}")
    @Operation(operationId = "deleteProjectScopedSecret", summary = "Delete Secret", description = "Deletes the information of the Secret with the matching Secret identifier.", tags={ "Secret" })
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
    @Path("/secrets/{secret}")
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "getAccountScopedSecret", summary = "Get Secret", description = "Retrieves the information of the Secret.", tags={ "Secret" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Secret Response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = SecretResponse.class))) })
    Response getAccountScopedSecret( @PathParam("secret")

 @Parameter(description = "Slug field of the Secret") String secret
,  @QueryParam("account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization method other than x-api-key header. If you are using x-api-key header this can be skipped.")  String account
);
    @GET
    @Path("/secrets")
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "getAccountScopedSecrets", summary = "Get Secrets", description = "Retrieve the information of the Secrets.", tags={ "Secret" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Secret list response", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = SecretResponse.class)))) })
    Response getAccountScopedSecrets(  @QueryParam("account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization method other than x-api-key header. If you are using x-api-key header this can be skipped.")  String account
);
    @GET
    @Path("/org/{org}/secrets/{secret}")
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "getOrgScopedSecret", summary = "Get Secret", description = "Retrieves the information of the Secret.", tags={ "Secret" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Secret Response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = SecretResponse.class))) })
    Response getOrgScopedSecret( @PathParam("org")

 @Parameter(description = "Slug field of the organization the resource is scoped to") String org
, @PathParam("secret")

 @Parameter(description = "Slug field of the Secret") String secret
,  @QueryParam("account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization method other than x-api-key header. If you are using x-api-key header this can be skipped.")  String account
);
    @GET
    @Path("/org/{org}/project/{project}/secrets/{secret}")
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "getProjectScopedSecret", summary = "Get Secret", description = "Retrieves the information of the Secret.", tags={ "Secret" })
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
    @PUT
    @Path("/secrets/{secret}")
    @Consumes({ "application/json", "application/yaml" })
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "updateAccountScopedSecret", summary = "Update Secret", description = "Updates the information of the Secret with the matching secret identifier.", tags={ "Secret" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Secret Response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = SecretResponse.class))) })
    Response updateAccountScopedSecret(@Valid SecretRequest body, @PathParam("secret")

 @Parameter(description = "Slug field of the Secret") String secret
,  @QueryParam("account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization method other than x-api-key header. If you are using x-api-key header this can be skipped.")  String account
);
    @PUT
    @Path("/org/{org}/secrets/{secret}")
    @Consumes({ "application/json", "application/yaml" })
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "updateOrgScopedSecret", summary = "Update Secret", description = "Updates the information of the Secret with the matching secret identifier.", tags={ "Secret" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Secret Response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = SecretResponse.class))) })
    Response updateOrgScopedSecret(@Valid SecretRequest body, @PathParam("org")

 @Parameter(description = "Slug field of the organization the resource is scoped to") String org
, @PathParam("secret")

 @Parameter(description = "Slug field of the Secret") String secret
,  @QueryParam("account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization method other than x-api-key header. If you are using x-api-key header this can be skipped.")  String account
);
    @PUT
    @Path("/org/{org}/project/{project}/secrets/{secret}")
    @Consumes({ "application/json", "application/yaml" })
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "updateProjectScopedSecret", summary = "Update Secret", description = "Updates the information of the Secret with the matching secret identifier.", tags={ "Secret" })
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
);}
