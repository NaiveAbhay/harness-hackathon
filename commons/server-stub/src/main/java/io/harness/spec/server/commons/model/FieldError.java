package io.harness.spec.server.commons.model;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * Contains Field-wise error detail
 **/
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.v3.oas.annotations.media.Schema;



@Schema(description = "Contains Field-wise error detail")

public class FieldError   {

  private @Valid String fieldName = null;

  private @Valid String message = null;

  /**
   * Name of the field
   **/
  public FieldError fieldName(String fieldName) {
    this.fieldName = fieldName;
    return this;
  }

  
  @Schema(description = "Name of the field")
  @JsonProperty("field_name")

  public String getFieldName() {
    return fieldName;
  }
  public void setFieldName(String fieldName) {
    this.fieldName = fieldName;
  }

  /**
   * Error message
   **/
  public FieldError message(String message) {
    this.message = message;
    return this;
  }

  
  @Schema(description = "Error message")
  @JsonProperty("message")

  public String getMessage() {
    return message;
  }
  public void setMessage(String message) {
    this.message = message;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FieldError fieldError = (FieldError) o;
    return Objects.equals(fieldName, fieldError.fieldName) &&
        Objects.equals(message, fieldError.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fieldName, message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FieldError {\n");
    
    sb.append("    fieldName: ").append(toIndentedString(fieldName)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
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
