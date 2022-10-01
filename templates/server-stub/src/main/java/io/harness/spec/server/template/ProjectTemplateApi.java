package io.harness.spec.server.template;

import io.harness.spec.server.template.model.GitFindDetails;
import io.harness.spec.server.template.model.TemplateCreateRequestBody;
import io.harness.spec.server.template.model.TemplateFilterProperties;
import io.harness.spec.server.template.model.TemplateUpdateRequestBody;

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

@Path("/v1/orgs/{org}/projects/{project}/templates")


public interface ProjectTemplateApi {

    @DELETE
    @Path("/{template}/versions/{version}")
    @Operation(operationId = "deleteTemplateProject", summary = "Delete Template", description = "Deletes particular version of Template at Project scope.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Project Template" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "204", description = "No Content") })
    Response deleteTemplateProject( @Pattern(regexp="^[a-zA-Z_][0-9a-zA-Z_$]{0,63}$") @Size(min=1,max=64)  @HeaderParam("Harness-Account") 

 @Parameter(description = "Account Identifier for the Entity.") String harnessAccount
,  @QueryParam("comments") 

 @Parameter(description = "Specify comment with respect to changes  ")  String comments
);
    @GET
    @Path("/{template}/versions/{version}")
    @Consumes({ "application/json", "application/yaml" })
    @Operation(operationId = "getTemplateProject", summary = "Retrieve a Template", description = "Retrieves particular version of Template at Project scope.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Project Template" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "") })
    Response getTemplateProject(@Valid GitFindDetails body, @Pattern(regexp="^[a-zA-Z_][0-9a-zA-Z_$]{0,63}$") @Size(min=1,max=64)  @HeaderParam("Harness-Account") 

 @Parameter(description = "Account Identifier for the Entity.") String harnessAccount
,  @QueryParam("get_input_yaml") 

 @Parameter(description = "Use it to get Template along with Input Set YAML")  Boolean getInputYaml
);
    @GET
    @Path("/{template}")
    @Consumes({ "application/json", "application/yaml" })
    @Operation(operationId = "getTemplateStableProject", summary = "Get Stable Template", description = "Retrieves stable version of Template at Project scope.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Project Template" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "") })
    Response getTemplateStableProject(@Valid GitFindDetails body, @Pattern(regexp="^[a-zA-Z_][0-9a-zA-Z_$]{0,63}$") @Size(min=1,max=64)  @HeaderParam("Harness-Account") 

 @Parameter(description = "Account Identifier for the Entity.") String harnessAccount
,  @QueryParam("get_input_yaml") 

 @Parameter(description = "Use it to get Template along with Input Set YAML")  Boolean getInputYaml
);
    @GET
    @Path("/list")
    @Consumes({ "application/json", "application/yaml" })
    @Operation(operationId = "getTemplatesListProject", summary = "Get Templates List", description = "Retrieves list of Template with meta-data at Project scope.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Project Template" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "") })
    Response getTemplatesListProject(@Valid TemplateFilterProperties body, @Pattern(regexp="^[a-zA-Z_][0-9a-zA-Z_$]{0,63}$") @Size(min=1,max=64)  @HeaderParam("Harness-Account") 

 @Parameter(description = "Account Identifier for the Entity.") String harnessAccount
,  @QueryParam("page") 

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
,  @QueryParam("recursive") 

 @Parameter(description = "Specify true if all accessible Templates are to be included")  Boolean recursive
);
    @POST
    @Consumes({ "application/json", "application/yaml" })
    @Operation(operationId = "postTemplatesProject", summary = "Create Template", description = "Creates a Template in the Project scope.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Project Template" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "201", description = "") })
    Response postTemplatesProject(@Valid TemplateCreateRequestBody body, @Pattern(regexp="^[a-zA-Z_][0-9a-zA-Z_$]{0,63}$") @Size(min=1,max=64)  @HeaderParam("Harness-Account") 

 @Parameter(description = "Account Identifier for the Entity.") String harnessAccount
,  @QueryParam("is_stable") @DefaultValue("false") 

 @Parameter(description = "True if given version for template to be set as stable")  Boolean isStable
,  @QueryParam("comments") 

 @Parameter(description = "Specify comment with respect to changes  ")  String comments
);
    @PUT
    @Path("/{template}/versions/{version}")
    @Consumes({ "application/json", "application/yaml" })
    @Operation(operationId = "putTemplateProject", summary = "Update Template", description = "Updates particular version of Template at Project scope.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Project Template" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "") })
    Response putTemplateProject(@Valid TemplateUpdateRequestBody body, @Pattern(regexp="^[a-zA-Z_][0-9a-zA-Z_$]{0,63}$") @Size(min=1,max=64)  @HeaderParam("Harness-Account") 

 @Parameter(description = "Account Identifier for the Entity.") String harnessAccount
,  @QueryParam("is_stable") @DefaultValue("false") 

 @Parameter(description = "True if given version for template to be set as stable")  Boolean isStable
,  @QueryParam("comments") 

 @Parameter(description = "Specify comment with respect to changes  ")  String comments
);
    @PUT
    @Path("/{template}/versions/{version}/stable")
    @Consumes({ "application/json", "application/yaml" })
    @Operation(operationId = "putTemplateStableProject", summary = "Update Stable Template", description = "Updates the stable version of Template at Project scope.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Project Template" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "") })
    Response putTemplateStableProject(@Valid GitFindDetails body, @Pattern(regexp="^[a-zA-Z_][0-9a-zA-Z_$]{0,63}$") @Size(min=1,max=64)  @HeaderParam("Harness-Account") 

 @Parameter(description = "Account Identifier for the Entity.") String harnessAccount
,  @QueryParam("comments") 

 @Parameter(description = "Specify comment with respect to changes  ")  String comments
);}
