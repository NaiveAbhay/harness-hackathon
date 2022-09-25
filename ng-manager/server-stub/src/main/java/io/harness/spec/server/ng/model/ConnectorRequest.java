package io.harness.spec.server.ng.model;

import io.harness.spec.server.ng.model.Connector;
import javax.validation.constraints.*;
import javax.validation.Valid;


import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.v3.oas.annotations.media.Schema;





public class ConnectorRequest   {

  private @Valid Connector connector = null;

  /**
   **/
  public ConnectorRequest connector(Connector connector) {
    this.connector = connector;
    return this;
  }

  
  @Schema(required = true, description = "")
  @JsonProperty("connector")
  @NotNull

  public Connector getConnector() {
    return connector;
  }
  public void setConnector(Connector connector) {
    this.connector = connector;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConnectorRequest connectorRequest = (ConnectorRequest) o;
    return Objects.equals(connector, connectorRequest.connector);
  }

  @Override
  public int hashCode() {
    return Objects.hash(connector);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConnectorRequest {\n");
    
    sb.append("    connector: ").append(toIndentedString(connector)).append("\n");
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
