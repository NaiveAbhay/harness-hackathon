/*
* Copyright 2022 Harness Inc. All rights reserved.
* Use of this source code is governed by the PolyForm Free Trial 1.0.0 license
* that can be found in the licenses directory at the root of this repository, also available at
* https://polyformproject.org/wp-content/uploads/2020/05/PolyForm-Free-Trial-1.0.0.txt.
*/

package io.harness.spec.server.ng;

import java.io.File;
import io.harness.spec.server.ng.model.SecretRequest;
import io.harness.spec.server.ng.model.SecretResponse;

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
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.Valid;

@Path("/v1/orgs/{org}/projects/{project}/secrets")


public interface ProjectSecretApi {

    @POST
    @Consumes({ "application/json", "application/yaml" })
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "createProjectScopedSecret", summary = "Create a secret", description = "Creates a new secret", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Project Secret" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "201", description = "Secret response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = SecretResponse.class))) })
    Response createProjectScopedSecret(@Valid SecretRequest body, @PathParam("org")

 @Parameter(description = "Slug field of the organization the resource is scoped to") String org
, @PathParam("project")

 @Parameter(description = "Slug field of the project the resource is scoped to") String project
,  @HeaderParam("Harness-Account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.") String harnessAccount
,  @QueryParam("private_secret") @DefaultValue("false") 

 @Parameter(description = "This would be used to define secret as private.")  Boolean privateSecret
);
    @POST
    @Consumes({ "multipart/form-data" })
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "createProjectScopedSecret", summary = "Create a secret", description = "Creates a new secret", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Project Secret" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "201", description = "Secret response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = SecretResponse.class))) })
    Response createProjectScopedSecret(@FormDataParam(value = "spec")  SecretRequest spec, @FormDataParam(value = "file") InputStream fileInputStream, @PathParam("org")

 @Parameter(description = "Slug field of the organization the resource is scoped to") String org
, @PathParam("project")

 @Parameter(description = "Slug field of the project the resource is scoped to") String project
,  @HeaderParam("Harness-Account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.") String harnessAccount
,  @QueryParam("private_secret") @DefaultValue("false") 

 @Parameter(description = "This would be used to define secret as private.")  Boolean privateSecret
);
    @DELETE
    @Path("/{secret}")
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "deleteProjectScopedSecret", summary = "Delete a secret", description = "Deletes the information of the secret with the matching secret slug.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Project Secret" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Secret response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = SecretResponse.class))) })
    Response deleteProjectScopedSecret( @PathParam("org")

 @Parameter(description = "Slug field of the organization the resource is scoped to") String org
, @PathParam("project")

 @Parameter(description = "Slug field of the project the resource is scoped to") String project
, @PathParam("secret")

 @Parameter(description = "Slug field of the secret") String secret
,  @HeaderParam("Harness-Account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.") String harnessAccount
);
    @GET
    @Path("/{secret}")
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "getProjectScopedSecret", summary = "Retrieve a secret", description = "Retrieves the information of the secret.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Project Secret" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Secret response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = SecretResponse.class))) })
    Response getProjectScopedSecret( @PathParam("org")

 @Parameter(description = "Slug field of the organization the resource is scoped to") String org
, @PathParam("project")

 @Parameter(description = "Slug field of the project the resource is scoped to") String project
, @PathParam("secret")

 @Parameter(description = "Slug field of the secret") String secret
,  @HeaderParam("Harness-Account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.") String harnessAccount
);
    @GET
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "getProjectScopedSecrets", summary = "List secrets", description = "Retrieves the information of the secrets.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Project Secret" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Secret list response", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = SecretResponse.class)))) })
    Response getProjectScopedSecrets( @PathParam("org")

 @Parameter(description = "Slug field of the organization the resource is scoped to") String org
, @PathParam("project")

 @Parameter(description = "Slug field of the project the resource is scoped to") String project
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
,  @HeaderParam("Harness-Account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.") String harnessAccount
);
    @PUT
    @Path("/{secret}")
    @Consumes({ "application/json", "application/yaml" })
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "updateProjectScopedSecret", summary = "Update a secret", description = "Updates the information of the secret with the matching secret slug.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Project Secret" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Secret response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = SecretResponse.class))) })
    Response updateProjectScopedSecret(@Valid SecretRequest body, @PathParam("org")

 @Parameter(description = "Slug field of the organization the resource is scoped to") String org
, @PathParam("project")

 @Parameter(description = "Slug field of the project the resource is scoped to") String project
, @PathParam("secret")

 @Parameter(description = "Slug field of the secret") String secret
,  @HeaderParam("Harness-Account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.") String harnessAccount
);
    @PUT
    @Path("/{secret}")
    @Consumes({ "multipart/form-data" })
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "updateProjectScopedSecret", summary = "Update a secret", description = "Updates the information of the secret with the matching secret slug.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Project Secret" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Secret response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = SecretResponse.class))) })
    Response updateProjectScopedSecret(@FormDataParam(value = "spec")  SecretRequest spec, @FormDataParam(value = "file") InputStream fileInputStream, @PathParam("org")

 @Parameter(description = "Slug field of the organization the resource is scoped to") String org
, @PathParam("project")

 @Parameter(description = "Slug field of the project the resource is scoped to") String project
, @PathParam("secret")

 @Parameter(description = "Slug field of the secret") String secret
,  @HeaderParam("Harness-Account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.") String harnessAccount
);}
