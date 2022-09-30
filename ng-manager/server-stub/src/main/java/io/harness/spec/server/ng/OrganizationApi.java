package io.harness.spec.server.ng;

import io.harness.spec.server.ng.model.CreateOrganizationRequest;
import io.harness.spec.server.ng.model.OrganizationResponse;
import io.harness.spec.server.ng.model.UpdateOrganizationRequest;

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

@Path("/v1/orgs")


public interface OrganizationApi {

    @POST
    @Consumes({ "application/json", "application/yaml" })
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "createOrganization", summary = "Create an organization", description = "Creates a new organization.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Organization" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "201", description = "Organization response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = OrganizationResponse.class))) })
    Response createOrganization(@Valid CreateOrganizationRequest body,  @HeaderParam("Harness-Account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.") String harnessAccount
);
    @DELETE
    @Path("/{org}")
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "deleteOrganization", summary = "Delete an organization", description = "Deletes the information of the organization with the matching organization slug.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Organization" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Organization response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = OrganizationResponse.class))) })
    Response deleteOrganization( @PathParam("org")

 @Parameter(description = "Organization slug") String org
,  @HeaderParam("Harness-Account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.") String harnessAccount
);
    @GET
    @Path("/{org}")
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "getOrganization", summary = "Retrieve an organization", description = "Retrieves the information of the organization with the matching organization slug.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Organization" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Organization response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = OrganizationResponse.class))) })
    Response getOrganization( @PathParam("org")

 @Parameter(description = "Organization slug") String org
,  @HeaderParam("Harness-Account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.") String harnessAccount
);
    @GET
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "getOrganizations", summary = "List organizations", description = "Retrieves the information of the organizations.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Organization" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Organization list response", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = OrganizationResponse.class)))) })
    Response getOrganizations(  @QueryParam("org") 

 @Parameter(description = "Slug field of the organizations the resource is scoped to")  List<String> org
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
    @Path("/{org}")
    @Consumes({ "application/json", "application/yaml" })
    @Produces({ "application/json", "application/yaml" })
    @Operation(operationId = "updateOrganization", summary = "Update an organization", description = "Updates the information of the organization with the matching organization slug.", security = {
        @SecurityRequirement(name = "x-api-key")    }, tags={ "Organization" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Organization response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = OrganizationResponse.class))) })
    Response updateOrganization(@Valid UpdateOrganizationRequest body, @PathParam("org")

 @Parameter(description = "Organization slug") String org
,  @HeaderParam("Harness-Account") 

 @Parameter(description = "Slug field of the account the resource is scoped to. This is required for Authorization methods other than the x-api-key header. If you are using the x-api-key header, this can be skipped.") String harnessAccount
);}
