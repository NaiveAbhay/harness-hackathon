package io.harness.spec.server.pipeline.model;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * Module Properties on which the filter will be applied.
 **/
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

@Schema(description = "Module Properties on which the filter will be applied.")

public class ModuleProperties   {

  private @Valid Boolean empty = null;

  private @Valid Object propertyName = null;

  /**
   * Specifies if Property is empty or not.
   **/
  public ModuleProperties empty(Boolean empty) {
    this.empty = empty;
    return this;
  }

  
  @Schema(description = "Specifies if Property is empty or not.")
  @JsonProperty("empty")

  public Boolean isEmpty() {
    return empty;
  }
  public void setEmpty(Boolean empty) {
    this.empty = empty;
  }

  /**
   * Module Properties on which the filter will be applied.
   **/
  public ModuleProperties propertyName(Object propertyName) {
    this.propertyName = propertyName;
    return this;
  }

  
  @Schema(description = "Module Properties on which the filter will be applied.")
  @JsonProperty("property_name")

  public Object getPropertyName() {
    return propertyName;
  }
  public void setPropertyName(Object propertyName) {
    this.propertyName = propertyName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ModuleProperties moduleProperties = (ModuleProperties) o;
    return Objects.equals(empty, moduleProperties.empty) &&
        Objects.equals(propertyName, moduleProperties.propertyName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(empty, propertyName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ModuleProperties {\n");
    
    sb.append("    empty: ").append(toIndentedString(empty)).append("\n");
    sb.append("    propertyName: ").append(toIndentedString(propertyName)).append("\n");
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
