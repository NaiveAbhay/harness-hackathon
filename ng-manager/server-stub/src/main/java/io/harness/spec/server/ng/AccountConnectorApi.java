package io.harness.spec.server.ng;

import io.harness.spec.server.ng.model.ConnectorRequest;
import io.harness.spec.server.ng.model.ConnectorResponse;
import io.harness.spec.server.ng.model.ConnectorStatisticsResponse;
import io.harness.spec.server.ng.model.ConnectorTestConnectionResponse;
import io.harness.spec.server.ng.model.ValidateConnectorSlugResponse;
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
import javax.ws.rs.HEAD;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/v1/connectors")

public interface AccountConnectorApi {

  @POST
  @Consumes({"application/json", "application/yaml"})
  @Produces({"application/json", "application/yaml"})
  @Operation(operationId = "createAccountScopedConnector",
             summary = "Create a Connector",
             description = "Creates a new connector",
             security = { @SecurityRequirement(name = "x-api-key") },
             tags = {"Account Connector"})
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
  createAccountScopedConnector(
      @Valid ConnectorRequest body,
      @QueryParam("account")

      @Parameter(
          description =
              "Slug field of the account the resource is scoped to. This is required for Authorization method other than x-api-key header. If you are using x-api-key header this can be skipped.")
      String account);
  @DELETE
  @Path("/{connector}")
  @Operation(
      operationId = "deleteAccountScopedConnector",
      summary = "Delete a connector",
      description =
          "Deletes the information of the connector with the matching connector slug.",
      tags = {"Account Connector"})
  @ApiResponses(
      value = { @ApiResponse(responseCode = "200", description = "OK") })
  Response
  deleteAccountScopedConnector(
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
      operationId = "getAccountScopedConnector",
      summary = "Retrieve a connector",
      description =
          "Retrieves the information of the connector with the matching connector slug. ",
      tags = {"Account Connector"})
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
  getAccountScopedConnector(
      @PathParam("connector")

      @Parameter(description = "Connector slug") String connector,
      @QueryParam("account")

      @Parameter(
          description =
              "Slug field of the account the resource is scoped to. This is required for Authorization method other than x-api-key header. If you are using x-api-key header this can be skipped.")
      String account);
  @GET
  @Produces({"application/json", "application/yaml"})
  @Operation(operationId = "getAccountScopedConnectors",
             summary = "List connectors",
             description = "Retrieves the information of the connectors.",
             tags = {"Account Connector"})
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
  getAccountScopedConnectors(
      @QueryParam("account")

      @Parameter(
          description =
              "Slug field of the account the resource is scoped to. This is required for Authorization method other than x-api-key header. If you are using x-api-key header this can be skipped.")
      String account);
  @GET
  @Path("/stats")
  @Produces({"application/json", "application/yaml"})
  @Operation(operationId = "getAccountScopedConnectorsStatistics",
             summary = "Retrieve connectors statistics",
             description = "Retrieves the statistics of the connectors.",
             tags = {"Account Connector"})
  @ApiResponses(value =
                {
                  @ApiResponse(responseCode = "200",
                               description = "Connector statistics response",
                               content = @Content(
                                   mediaType = "application/json",
                                   schema = @Schema(
                                       implementation =
                                           ConnectorStatisticsResponse.class)))
                })
  Response
  getAccountScopedConnectorsStatistics(
      @QueryParam("account")

      @Parameter(
          description =
              "Slug field of the account the resource is scoped to. This is required for Authorization method other than x-api-key header. If you are using x-api-key header this can be skipped.")
      String account);
  @GET
  @Path("/{connector}/test-connection")
  @Produces({"application/json", "application/yaml"})
  @Operation(
      operationId = "testAccountScopedConnector", summary = "Test a connector",
      description =
          "Tests connection of the connector with the matching connector slug. ",
      tags = {"Account Connector"})
  @ApiResponses(
      value =
      {
        @ApiResponse(
            responseCode = "200",
            description =
                "This has test connection details for the Connector defined in Harness.",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation =
                                     ConnectorTestConnectionResponse.class)))
      })
  Response
  testAccountScopedConnector(
      @PathParam("connector")

      @Parameter(description = "Connector slug") String connector,
      @QueryParam("account")

      @Parameter(
          description =
              "Slug field of the account the resource is scoped to. This is required for Authorization method other than x-api-key header. If you are using x-api-key header this can be skipped.")
      String account);
  @PUT
  @Path("/{connector}")
  @Consumes({"application/json", "application/yaml"})
  @Produces({"application/json", "application/yaml"})
  @Operation(
      operationId = "updateAccountScopedConnector",
      summary = "Update a connector",
      description =
          "Updates the information of the secret with the matching secret slug.",
      tags = {"Account Connector"})
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
  updateAccountScopedConnector(
      @Valid ConnectorRequest body,
      @PathParam("connector")

      @Parameter(description = "Connector slug") String connector,
      @QueryParam("account")

      @Parameter(
          description =
              "Slug field of the account the resource is scoped to. This is required for Authorization method other than x-api-key header. If you are using x-api-key header this can be skipped.")
      String account);
  @HEAD
  @Path("/{connector}")
  @Produces({"application/json", "application/yaml"})
  @Operation(operationId = "validateUniqueAccountScopedConnectorSlug",
             summary = "Validate unique connector slug",
             description = "Validates connector slug is unique",
             tags = {"Account Connector"})
  @ApiResponses(value =
                {
                  @ApiResponse(
                      responseCode = "200",
                      description = "Validate connector slug response",
                      content = @Content(
                          mediaType = "application/json",
                          schema =
                              @Schema(implementation =
                                          ValidateConnectorSlugResponse.class)))
                })
  Response
  validateUniqueAccountScopedConnectorSlug(
      @PathParam("connector")

      @Parameter(description = "Connector slug") String connector,
      @QueryParam("account")

      @Parameter(
          description =
              "Slug field of the account the resource is scoped to. This is required for Authorization method other than x-api-key header. If you are using x-api-key header this can be skipped.")
      String account);
}
