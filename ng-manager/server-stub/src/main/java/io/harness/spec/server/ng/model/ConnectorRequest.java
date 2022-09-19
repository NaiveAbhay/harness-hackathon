package io.harness.spec.server.ng.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;





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
