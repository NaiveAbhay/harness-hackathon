package io.harness.spec.server.ng;

import io.harness.spec.server.ng.model.ConnectorRequest;
import io.harness.spec.server.ng.model.ConnectorResponse;
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
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/v1/orgs/{org}/projects/{project}/connectors")

public interface ProjectConnectorApi {

  @POST
  @Consumes({"application/json", "application/yaml"})
  @Produces({"application/json", "application/yaml"})
  @Operation(operationId = "createProjectScopedConnector",
             summary = "Create a Connector",
             description = "Creates a new connector",
             security = { @SecurityRequirement(name = "x-api-key") },
             tags = {"Project Connector"})
  @ApiResponses(value =
                {
                  @ApiResponse(
                      responseCode = "201", description = "Connector response",
                      content = @Content(
                          mediaType = "application/json",
                          schema = @Schema(implementation =
                                               ConnectorResponse.class)))
                })
  Response
  createProjectScopedConnector(
      @Valid ConnectorRequest body,
      @PathParam("org")

      @Parameter(description =
                     "Slug field of the organization the resource is scoped to")
      String org,
      @PathParam("project")

      @Parameter(
          description = "Slug field of the project the resource is scoped to")
      String project,
      @QueryParam("account")

      @Parameter(
          description =
              "Slug field of the account the resource is scoped to. This is required for Authorization method other than x-api-key header. If you are using x-api-key header this can be skipped.")
      String account);
  @DELETE
  @Path("/{connector}")
  @Operation(
      operationId = "deleteProjectScopedConnector",
      summary = "Delete a connector",
      description =
          "Deletes the information of the connector with the matching connector slug.",
      tags = {"Project Connector"})
  @ApiResponses(
      value = { @ApiResponse(responseCode = "200", description = "OK") })
  Response
  deleteProjectScopedConnector(
      @PathParam("org")

      @Parameter(description =
                     "Slug field of the organization the resource is scoped to")
      String org,
      @PathParam("project")

      @Parameter(
          description = "Slug field of the project the resource is scoped to")
      String project,
      @PathParam("connector")

      @Parameter(description = "Connector slug") String connector,
      @QueryParam("account")

      @Parameter(
          description =
              "Slug field of the account the resource is scoped to. This is required for Authorization method other than x-api-key header. If you are using x-api-key header this can be skipped.")
      String account);
  @GET
  @Path("/{connector}")
  @Produces({"application/json", "application/yaml"})
  @Operation(
      operationId = "getProjectScopedConnector",
      summary = "Retrieve a connector",
      description =
          "Retrieves the information of the connector with the matching connector slug. ",
      tags = {"Project Connector"})
  @ApiResponses(value =
                {
                  @ApiResponse(
                      responseCode = "200", description = "Connector response",
                      content = @Content(
                          mediaType = "application/json",
                          schema = @Schema(implementation =
                                               ConnectorResponse.class)))
                })
  Response
  getProjectScopedConnector(
      @PathParam("org")

      @Parameter(description =
                     "Slug field of the organization the resource is scoped to")
      String org,
      @PathParam("project")

      @Parameter(
          description = "Slug field of the project the resource is scoped to")
      String project,
      @PathParam("connector")

      @Parameter(description = "Connector slug") String connector,
      @QueryParam("account")

      @Parameter(
          description =
              "Slug field of the account the resource is scoped to. This is required for Authorization method other than x-api-key header. If you are using x-api-key header this can be skipped.")
      String account);
  @GET
  @Produces({"application/json", "application/yaml"})
  @Operation(operationId = "getProjectScopedConnectors",
             summary = "List connectors",
             description = "Retrieves the information of the connectors.",
             tags = {"Project Connector"})
  @ApiResponses(value =
                {
                  @ApiResponse(
                      responseCode = "200",
                      description = "Connector list response",
                      content = @Content(
                          mediaType = "application/json",
                          array = @ArraySchema(
                              schema = @Schema(implementation =
                                                   ConnectorResponse.class))))
                })
  Response
  getProjectScopedConnectors(
      @PathParam("org")

      @Parameter(description =
                     "Slug field of the organization the resource is scoped to")
      String org,
      @PathParam("project")

      @Parameter(
          description = "Slug field of the project the resource is scoped to")
      String project);
  @PUT
  @Path("/{connector}")
  @Consumes({"application/json", "application/yaml"})
  @Produces({"application/json", "application/yaml"})
  @Operation(
      operationId = "updateProjectScopedConnector",
      summary = "Update a connector",
      description =
          "Updates the information of the secret with the matching secret slug.",
      tags = {"Project Connector"})
  @ApiResponses(value =
                {
                  @ApiResponse(
                      responseCode = "200", description = "Connector response",
                      content = @Content(
                          mediaType = "application/json",
                          schema = @Schema(implementation =
                                               ConnectorResponse.class)))
                })
  Response
  updateProjectScopedConnector(
      @Valid ConnectorRequest body,
      @PathParam("org")

      @Parameter(description =
                     "Slug field of the organization the resource is scoped to")
      String org,
      @PathParam("project")

      @Parameter(
          description = "Slug field of the project the resource is scoped to")
      String project,
      @PathParam("connector")

      @Parameter(description = "Connector slug") String connector,
      @QueryParam("account")

      @Parameter(
          description =
              "Slug field of the account the resource is scoped to. This is required for Authorization method other than x-api-key header. If you are using x-api-key header this can be skipped.")
      String account);
}
