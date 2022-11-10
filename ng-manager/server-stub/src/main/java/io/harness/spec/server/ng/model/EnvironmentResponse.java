package io.harness.spec.server.ng.model;

import io.harness.spec.server.ng.model.Environment;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * Default response when a environment is returned
 **/
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.v3.oas.annotations.media.Schema;



@Schema(description = "Default response when a environment is returned")

public class EnvironmentResponse   {

  private @Valid Environment environment = null;

  private @Valid Long created = null;

  private @Valid Long updated = null;

  /**
   **/
  public EnvironmentResponse environment(Environment environment) {
    this.environment = environment;
    return this;
  }

  
  @Schema(description = "")
  @JsonProperty("environment")

  public Environment getEnvironment() {
    return environment;
  }
  public void setEnvironment(Environment environment) {
    this.environment = environment;
  }

  /**
   * Creation timestamp for Environment.
   **/
  public EnvironmentResponse created(Long created) {
    this.created = created;
    return this;
  }

  
  @Schema(description = "Creation timestamp for Environment.")
  @JsonProperty("created")

  public Long getCreated() {
    return created;
  }
  public void setCreated(Long created) {
    this.created = created;
  }

  /**
   * Last modification timestamp for Environment.
   **/
  public EnvironmentResponse updated(Long updated) {
    this.updated = updated;
    return this;
  }

  
  @Schema(description = "Last modification timestamp for Environment.")
  @JsonProperty("updated")

  public Long getUpdated() {
    return updated;
  }
  public void setUpdated(Long updated) {
    this.updated = updated;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EnvironmentResponse environmentResponse = (EnvironmentResponse) o;
    return Objects.equals(environment, environmentResponse.environment) &&
        Objects.equals(created, environmentResponse.created) &&
        Objects.equals(updated, environmentResponse.updated);
  }

  @Override
  public int hashCode() {
    return Objects.hash(environment, created, updated);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EnvironmentResponse {\n");
    
    sb.append("    environment: ").append(toIndentedString(environment)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    updated: ").append(toIndentedString(updated)).append("\n");
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
