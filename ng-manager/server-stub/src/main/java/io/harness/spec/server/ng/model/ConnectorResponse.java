package io.harness.spec.server.ng.model;

import io.harness.spec.server.ng.model.Connector;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * Connector response model
 **/
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.v3.oas.annotations.media.Schema;



@Schema(description = "Connector response model")

public class ConnectorResponse   {

  private @Valid Connector connector = null;

  private @Valid Long created = null;

  private @Valid Long updated = null;

  private @Valid Boolean harnessManaged = null;

  private @Valid Object governanceMetadata = null;

  /**
   **/
  public ConnectorResponse connector(Connector connector) {
    this.connector = connector;
    return this;
  }

  
  @Schema(description = "")
  @JsonProperty("connector")

  public Connector getConnector() {
    return connector;
  }
  public void setConnector(Connector connector) {
    this.connector = connector;
  }

  /**
   * Creation timestamp for the connector
   **/
  public ConnectorResponse created(Long created) {
    this.created = created;
    return this;
  }

  
  @Schema(description = "Creation timestamp for the connector")
  @JsonProperty("created")

  public Long getCreated() {
    return created;
  }
  public void setCreated(Long created) {
    this.created = created;
  }

  /**
   * Updated timestamp for the connector
   **/
  public ConnectorResponse updated(Long updated) {
    this.updated = updated;
    return this;
  }

  
  @Schema(description = "Updated timestamp for the connector")
  @JsonProperty("updated")

  public Long getUpdated() {
    return updated;
  }
  public void setUpdated(Long updated) {
    this.updated = updated;
  }

  /**
   * This indicates if this Connector is managed by Harness or not. If True, Harness can manage and modify this Connector.
   **/
  public ConnectorResponse harnessManaged(Boolean harnessManaged) {
    this.harnessManaged = harnessManaged;
    return this;
  }

  
  @Schema(description = "This indicates if this Connector is managed by Harness or not. If True, Harness can manage and modify this Connector.")
  @JsonProperty("harness_managed")

  public Boolean isHarnessManaged() {
    return harnessManaged;
  }
  public void setHarnessManaged(Boolean harnessManaged) {
    this.harnessManaged = harnessManaged;
  }

  /**
   * Governance metadata information
   **/
  public ConnectorResponse governanceMetadata(Object governanceMetadata) {
    this.governanceMetadata = governanceMetadata;
    return this;
  }

  
  @Schema(description = "Governance metadata information")
  @JsonProperty("governance_metadata")

  public Object getGovernanceMetadata() {
    return governanceMetadata;
  }
  public void setGovernanceMetadata(Object governanceMetadata) {
    this.governanceMetadata = governanceMetadata;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConnectorResponse connectorResponse = (ConnectorResponse) o;
    return Objects.equals(connector, connectorResponse.connector) &&
        Objects.equals(created, connectorResponse.created) &&
        Objects.equals(updated, connectorResponse.updated) &&
        Objects.equals(harnessManaged, connectorResponse.harnessManaged) &&
        Objects.equals(governanceMetadata, connectorResponse.governanceMetadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(connector, created, updated, harnessManaged, governanceMetadata);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConnectorResponse {\n");
    
    sb.append("    connector: ").append(toIndentedString(connector)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    updated: ").append(toIndentedString(updated)).append("\n");
    sb.append("    harnessManaged: ").append(toIndentedString(harnessManaged)).append("\n");
    sb.append("    governanceMetadata: ").append(toIndentedString(governanceMetadata)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
