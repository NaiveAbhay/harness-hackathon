package io.harness.spec.server.template;

import io.harness.spec.server.template.model.GitFindDetails;
import io.harness.spec.server.template.model.TemplateCreateRequestBody;
import io.harness.spec.server.template.model.TemplateMetaDataList;
import io.harness.spec.server.template.model.TemplateResponse;
import io.harness.spec.server.template.model.TemplateUpdateRequestBody;
import io.harness.spec.server.template.model.TemplateUpdateStableResponse;
import io.harness.spec.server.template.model.TemplateWithInputsResponse;

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
import javax.validation.constraints.*;
import javax.validation.Valid;

@Path("/v1/templates")


public interface AccountTemplateApi {

    @POST
    @Consumes({ "application/json", "application/yaml" })
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "createTemplatesAcc", summary = "Create Template", description = "Creates a Template in the Account scope.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Account Template" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "201", description = "Template Response Body", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TemplateResponse.class))) })
    Response createTemplatesAcc(@Valid TemplateCreateRequestBody body,  @HeaderParam("Harness-Account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.") String harnessAccount
);
    @DELETE
    @Path("/{template}/versions/{version}")
    @Operation(operationId = "deleteTemplateAcc", summary = "Delete Template", description = "Deletes particular version of Template at Account scope.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Account Template" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "204", description = "No Content") })
    Response deleteTemplateAcc( @PathParam("template")

 @Parameter(description = "Template Identifier") String template
, @PathParam("version")

 @Parameter(description = "Version Label for Template") String version
,  @HeaderParam("Harness-Account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.") String harnessAccount
,  @QueryParam("comments") 

 @Parameter(description = "Specify comment with respect to changes  ")  String comments
);
    @GET
    @Path("/{template}/versions/{version}")
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "getTemplateAcc", summary = "Retrieve a Template", description = "Retrieves particular version of Template at Account scope.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Account Template" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Template With Input reference", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TemplateWithInputsResponse.class))) })
    Response getTemplateAcc( @PathParam("template")

 @Parameter(description = "Template Identifier") String template
, @PathParam("version")

 @Parameter(description = "Version Label for Template") String version
,  @HeaderParam("Harness-Account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.") String harnessAccount
,  @QueryParam("include_yaml") 

 @Parameter(description = "Use it to get Template along with Input Set YAML")  Boolean includeYaml
,  @QueryParam("branch_name") 

 @Parameter(description = "Name of the branch")  String branchName
,  @QueryParam("parent_connector_ref") 

 @Parameter(description = "Connector ref of parent template if its remote")  String parentConnectorRef
,  @QueryParam("parent_repo_name") 

 @Parameter(description = "Repo name of parent template if its remote")  String parentRepoName
,  @QueryParam("parent_account_id") 

 @Parameter(description = "Account name of parent template if its remote")  String parentAccountId
,  @QueryParam("parent_org_id") 

 @Parameter(description = "Organization name of parent template if its remote")  String parentOrgId
,  @QueryParam("parent_project_id") 

 @Parameter(description = "Project name of parent entity if its remote")  String parentProjectId
);
    @GET
    @Path("/{template}")
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "getTemplateStableAcc", summary = "Get Stable Template", description = "Retrieves stable version of Template at Account scope.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Account Template" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Template With Input reference", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TemplateWithInputsResponse.class))) })
    Response getTemplateStableAcc( @PathParam("template")

 @Parameter(description = "Template Identifier") String template
,  @HeaderParam("Harness-Account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.") String harnessAccount
,  @QueryParam("include_yaml") 

 @Parameter(description = "Use it to get Template along with Input Set YAML")  Boolean includeYaml
,  @QueryParam("branch_name") 

 @Parameter(description = "Name of the branch")  String branchName
,  @QueryParam("parent_connector_ref") 

 @Parameter(description = "Connector ref of parent template if its remote")  String parentConnectorRef
,  @QueryParam("parent_repo_name") 

 @Parameter(description = "Repo name of parent template if its remote")  String parentRepoName
,  @QueryParam("parent_account_id") 

 @Parameter(description = "Account name of parent template if its remote")  String parentAccountId
,  @QueryParam("parent_org_id") 

 @Parameter(description = "Organization name of parent template if its remote")  String parentOrgId
,  @QueryParam("parent_project_id") 

 @Parameter(description = "Project name of parent entity if its remote")  String parentProjectId
);
    @GET
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "getTemplatesListAcc", summary = "Get Templates List", description = "Retrieves list of Template with meta-data at Account scope.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Account Template" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Template Lists Meta Data Response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TemplateMetaDataList.class))) })
    Response getTemplatesListAcc(  @HeaderParam("Harness-Account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.") String harnessAccount
,  @QueryParam("page") @DefaultValue("0") 

 @Parameter(description = "Pagination page number strategy: Specify the page number within the paginated collection related to the number of items in each page ")  Integer page
,  @QueryParam("limit") @DefaultValue("30") 

 @Parameter(description = "Pagination: Number of items to return")  Integer limit
,  @QueryParam("sort") 

 @Parameter(description = "Parameter on the basis of which sorting is done.")  String sort
,  @QueryParam("order") 

 @Parameter(description = "Order on the basis of which sorting is done.")  String order
,  @QueryParam("search_term") 

 @Parameter(description = "This would be used to filter resources having attributes matching with search term.")  String searchTerm
,  @QueryParam("type") 

 @Parameter(description = "Template List Type")  String type
,  @QueryParam("recursive") @DefaultValue("false") 

 @Parameter(description = "Specify true if all accessible Templates are to be included")  Boolean recursive
,  @QueryParam("names") 

 @Parameter(description = "Template names for filtering")  List<String> names
,  @QueryParam("identifiers") 

 @Parameter(description = "Template Ids for Filtering")  List<String> identifiers
,  @QueryParam("description") 

 @Parameter(description = "Filter properties description")  String description
,  @QueryParam("entity_types") 

 @Parameter(description = "Type of Template")  List<String> entityTypes
,  @QueryParam("child_types") 

 @Parameter(description = "Template Child Types for filtering")  List<String> childTypes
);
    @PUT
    @Path("/{template}/versions/{version}")
    @Consumes({ "application/json", "application/yaml" })
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "updateTemplateAcc", summary = "Update Template", description = "Updates particular version of Template at Account scope.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Account Template" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Template Response Body", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TemplateResponse.class))) })
    Response updateTemplateAcc( @PathParam("template")

 @Parameter(description = "Template Identifier") String template
, @PathParam("version")

 @Parameter(description = "Version Label for Template") String version
,@Valid TemplateUpdateRequestBody body,  @HeaderParam("Harness-Account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.") String harnessAccount
);
    @PUT
    @Path("/{template}/versions/{version}/stable")
    @Consumes({ "application/json", "application/yaml" })
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "updateTemplateStableAcc", summary = "Update Stable Template", description = "Updates the stable version of Template at Account scope.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Account Template" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Template stable version update Response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TemplateUpdateStableResponse.class))) })
    Response updateTemplateStableAcc( @PathParam("template")

 @Parameter(description = "Template Identifier") String template
, @PathParam("version")

 @Parameter(description = "Version Label for Template") String version
,@Valid GitFindDetails body,  @HeaderParam("Harness-Account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.") String harnessAccount
);}
