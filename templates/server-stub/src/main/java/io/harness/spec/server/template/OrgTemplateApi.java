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

@Path("/v1/orgs/{org}/templates")


public interface OrgTemplateApi {

    @POST
    @Consumes({ "application/json", "application/yaml" })
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "createTemplatesOrg", summary = "Create Template", description = "Creates a Template in the Organization scope.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Org Template" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "201", description = "Template Response Body", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TemplateResponse.class))) })
    Response createTemplatesOrg( @PathParam("org")

 @Parameter(description = "Organization Identifier") String org
,@Valid TemplateCreateRequestBody body, @Pattern(regexp="^[a-zA-Z_][0-9a-zA-Z_$]{0,63}$") @Size(min=1,max=64)  @HeaderParam("Harness-Account") 

 @Parameter(description = "Account Identifier for the Entity.") String harnessAccount
,  @QueryParam("is_stable") @DefaultValue("false") 

 @Parameter(description = "True if given version for template to be set as stable")  Boolean isStable
,  @QueryParam("comments") 

 @Parameter(description = "Specify comment with respect to changes  ")  String comments
);
    @DELETE
    @Path("/{template}/versions/{version}")
    @Operation(operationId = "deleteTemplateOrg", summary = "Delete Template", description = "Deletes particular version of Template at Organization scope.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Org Template" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "204", description = "No Content") })
    Response deleteTemplateOrg( @PathParam("template")

 @Parameter(description = "Template Identifier") String template
, @PathParam("org")

 @Parameter(description = "Organization Identifier") String org
, @PathParam("version")

 @Parameter(description = "Version Label for Template") String version
, @Pattern(regexp="^[a-zA-Z_][0-9a-zA-Z_$]{0,63}$") @Size(min=1,max=64)  @HeaderParam("Harness-Account") 

 @Parameter(description = "Account Identifier for the Entity.") String harnessAccount
,  @QueryParam("comments") 

 @Parameter(description = "Specify comment with respect to changes  ")  String comments
);
    @GET
    @Path("/{template}/versions/{version}")
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "getTemplateOrg", summary = "Retrieve a Template", description = "Retrieves particular version of Template at Organization scope.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Org Template" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Template With Input reference", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TemplateWithInputsResponse.class))) })
    Response getTemplateOrg( @PathParam("template")

 @Parameter(description = "Template Identifier") String template
, @PathParam("org")

 @Parameter(description = "Organization Identifier") String org
, @PathParam("version")

 @Parameter(description = "Version Label for Template") String version
, @Pattern(regexp="^[a-zA-Z_][0-9a-zA-Z_$]{0,63}$") @Size(min=1,max=64)  @HeaderParam("Harness-Account") 

 @Parameter(description = "Account Identifier for the Entity.") String harnessAccount
,  @QueryParam("get_input_yaml") 

 @Parameter(description = "Use it to get Template along with Input Set YAML")  Boolean getInputYaml
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
    @Operation(operationId = "getTemplateStableOrg", summary = "Get Stable Template", description = "Retrieves stable version of Template at Organization scope.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Org Template" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Template With Input reference", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TemplateWithInputsResponse.class))) })
    Response getTemplateStableOrg( @PathParam("org")

 @Parameter(description = "Organization Identifier") String org
, @PathParam("template")

 @Parameter(description = "Template Identifier") String template
, @Pattern(regexp="^[a-zA-Z_][0-9a-zA-Z_$]{0,63}$") @Size(min=1,max=64)  @HeaderParam("Harness-Account") 

 @Parameter(description = "Account Identifier for the Entity.") String harnessAccount
,  @QueryParam("get_input_yaml") 

 @Parameter(description = "Use it to get Template along with Input Set YAML")  Boolean getInputYaml
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
    @Operation(operationId = "getTemplatesListOrg", summary = "Get Templates List", description = "Retrieves list of Template with meta-data at Organization scope.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Org Template" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Template Lists Meta Data Response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TemplateMetaDataList.class))) })
    Response getTemplatesListOrg( @PathParam("org")

 @Parameter(description = "Organization Identifier") String org
, @Pattern(regexp="^[a-zA-Z_][0-9a-zA-Z_$]{0,63}$") @Size(min=1,max=64)  @HeaderParam("Harness-Account") 

 @Parameter(description = "Account Identifier for the Entity.") String harnessAccount
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
,  @QueryParam("list_type") 

 @Parameter(description = "Template List Type")  String listType
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
    @Operation(operationId = "updateTemplateOrg", summary = "Update Template", description = "Updates particular version of Template at Organization scope.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Org Template" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Template Response Body", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TemplateResponse.class))) })
    Response updateTemplateOrg( @PathParam("template")

 @Parameter(description = "Template Identifier") String template
, @PathParam("org")

 @Parameter(description = "Organization Identifier") String org
, @PathParam("version")

 @Parameter(description = "Version Label for Template") String version
,@Valid TemplateUpdateRequestBody body, @Pattern(regexp="^[a-zA-Z_][0-9a-zA-Z_$]{0,63}$") @Size(min=1,max=64)  @HeaderParam("Harness-Account") 

 @Parameter(description = "Account Identifier for the Entity.") String harnessAccount
,  @QueryParam("is_stable") @DefaultValue("false") 

 @Parameter(description = "True if given version for template to be set as stable")  Boolean isStable
,  @QueryParam("comments") 

 @Parameter(description = "Specify comment with respect to changes  ")  String comments
);
    @PUT
    @Path("/{template}/versions/{version}/stable")
    @Consumes({ "application/json", "application/yaml" })
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "updateTemplateStableOrg", summary = "Update Stable Template", description = "Updates the stable version of Template at Organization scope.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Org Template" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Template stable version update Response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TemplateUpdateStableResponse.class))) })
    Response updateTemplateStableOrg( @PathParam("org")

 @Parameter(description = "Organization Identifier") String org
, @PathParam("template")

 @Parameter(description = "Template Identifier") String template
, @PathParam("version")

 @Parameter(description = "Version Label for Template") String version
,@Valid GitFindDetails body, @Pattern(regexp="^[a-zA-Z_][0-9a-zA-Z_$]{0,63}$") @Size(min=1,max=64)  @HeaderParam("Harness-Account") 

 @Parameter(description = "Account Identifier for the Entity.") String harnessAccount
,  @QueryParam("comments") 

 @Parameter(description = "Specify comment with respect to changes  ")  String comments
);}
