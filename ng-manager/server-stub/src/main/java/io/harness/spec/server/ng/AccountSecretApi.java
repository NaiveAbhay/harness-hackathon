package io.harness.spec.server.ng;

import io.harness.spec.server.ng.model.SecretRequest;
import io.harness.spec.server.ng.model.SecretResponse;
import io.harness.spec.server.ng.model.ValidateSecretSlugResponse;
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
import javax.ws.rs.HEAD;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/v1/secrets")


public interface AccountSecretApi {

    @POST
    @Consumes({ "application/json", "application/yaml" })
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "createAccountScopedSecret", summary = "Create a secret", description = "Creates a new secret", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Account Secret" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "201", description = "Secret response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = SecretResponse.class))) })
    Response createAccountScopedSecret(@Valid SecretRequest body,  @QueryParam("account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization method other than x-api-key header. If you are using x-api-key header this can be skipped.")  String account
,  @QueryParam("private_secret") @DefaultValue("false") 

 @Parameter(description = "This would be used to define secret as private.")  Boolean privateSecret
);
    @DELETE
    @Path("/{secret}")
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "deleteAccountScopedSecret", summary = "Deletes a secret", description = "Deletes the information of the secret with the matching secret slug.", tags={ "Account Secret" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Secret response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = SecretResponse.class))) })
    Response deleteAccountScopedSecret( @PathParam("secret")

 @Parameter(description = "Slug field of the secret") String secret
,  @QueryParam("account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization method other than x-api-key header. If you are using x-api-key header this can be skipped.")  String account
);
    @GET
    @Path("/{secret}")
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "getAccountScopedSecret", summary = "Retrieve a secret", description = "Retrieves the information of the secret.", tags={ "Account Secret" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Secret response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = SecretResponse.class))) })
    Response getAccountScopedSecret( @PathParam("secret")

 @Parameter(description = "Slug field of the secret") String secret
,  @QueryParam("account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization method other than x-api-key header. If you are using x-api-key header this can be skipped.")  String account
);
    @GET
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "getAccountScopedSecrets", summary = "List secrets", description = "Retrieves the information of the secrets.", tags={ "Account Secret" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Secret list response", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = SecretResponse.class)))) })
    Response getAccountScopedSecrets(  @QueryParam("account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization method other than x-api-key header. If you are using x-api-key header this can be skipped.")  String account
,  @QueryParam("org") 

 @Parameter(description = "Slug field of the organization the resource is scoped to")  String org
,  @QueryParam("project") 

 @Parameter(description = "Slug field of the project the resource is scoped to")  String project
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
    @Path("/{secret}")
    @Consumes({ "application/json", "application/yaml" })
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "updateAccountScopedSecret", summary = "Update a secret", description = "Updates the information of the secret with the matching secret slug.", tags={ "Account Secret" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Secret response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = SecretResponse.class))) })
    Response updateAccountScopedSecret(@Valid SecretRequest body, @PathParam("secret")

 @Parameter(description = "Slug field of the secret") String secret
,  @QueryParam("account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization method other than x-api-key header. If you are using x-api-key header this can be skipped.")  String account
);
    @HEAD
    @Path("/{secret}")
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "validateUniqueAccountScopedSecretSlug", summary = "Validate unique secret slug", description = "Validates secret slug is unique", tags={ "Account Secret" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Example response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ValidateSecretSlugResponse.class))) })
    Response validateUniqueAccountScopedSecretSlug( @PathParam("secret")

 @Parameter(description = "Slug field of the secret") String secret
,  @QueryParam("account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization method other than x-api-key header. If you are using x-api-key header this can be skipped.")  String account
);}
