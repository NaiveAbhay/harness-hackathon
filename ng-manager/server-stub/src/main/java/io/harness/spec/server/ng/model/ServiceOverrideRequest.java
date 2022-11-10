package io.harness.spec.server.ng.model;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * Service Override Request Body
 **/
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.v3.oas.annotations.media.Schema;



@Schema(description = "Service Override Request Body")

public class ServiceOverrideRequest   {

  private @Valid String yaml = null;

  /**
   * Yaml related to service override
   **/
  public ServiceOverrideRequest yaml(String yaml) {
    this.yaml = yaml;
    return this;
  }

  
  @Schema(required = true, description = "Yaml related to service override")
  @JsonProperty("yaml")
  @NotNull

  public String getYaml() {
    return yaml;
  }
  public void setYaml(String yaml) {
    this.yaml = yaml;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServiceOverrideRequest serviceOverrideRequest = (ServiceOverrideRequest) o;
    return Objects.equals(yaml, serviceOverrideRequest.yaml);
  }

  @Override
  public int hashCode() {
    return Objects.hash(yaml);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceOverrideRequest {\n");
    
    sb.append("    yaml: ").append(toIndentedString(yaml)).append("\n");
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
