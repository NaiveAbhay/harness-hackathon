package io.harness.spec.server.commons.model;

import io.harness.spec.server.commons.model.ErrorMetadata;
import io.harness.spec.server.commons.model.FieldError;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * Contains information about the error
 **/
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.v3.oas.annotations.media.Schema;



@Schema(description = "Contains information about the error")

public class ErrorResponse   {

  private @Valid String message = null;

public enum CodeEnum {

    RESOURCE_NOT_FOUND(String.valueOf("RESOURCE_NOT_FOUND")), INVALID_ARGUMENT(String.valueOf("INVALID_ARGUMENT"));


    private String value;

    CodeEnum (String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    @Override
    @JsonValue
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static CodeEnum fromValue(String v) {
        for (CodeEnum b : CodeEnum.values()) {
            if (String.valueOf(b.value).equals(v)) {
                return b;
            }
        }
        return null;
    }
}
  private @Valid CodeEnum code = null;

  private @Valid List<FieldError> errors = new ArrayList<FieldError>();

  private @Valid ErrorMetadata errorMetadata = null;

  /**
   * Error Message
   **/
  public ErrorResponse message(String message) {
    this.message = message;
    return this;
  }

  
  @Schema(description = "Error Message")
  @JsonProperty("message")

  public String getMessage() {
    return message;
  }
  public void setMessage(String message) {
    this.message = message;
  }

  /**
   * Error code
   **/
  public ErrorResponse code(CodeEnum code) {
    this.code = code;
    return this;
  }

  
  @Schema(description = "Error code")
  @JsonProperty("code")

  public CodeEnum getCode() {
    return code;
  }
  public void setCode(CodeEnum code) {
    this.code = code;
  }

  /**
   * Contains field-wise error detail
   **/
  public ErrorResponse errors(List<FieldError> errors) {
    this.errors = errors;
    return this;
  }

  
  @Schema(description = "Contains field-wise error detail")
  @JsonProperty("errors")

  public List<FieldError> getErrors() {
    return errors;
  }
  public void setErrors(List<FieldError> errors) {
    this.errors = errors;
  }

  /**
   **/
  public ErrorResponse errorMetadata(ErrorMetadata errorMetadata) {
    this.errorMetadata = errorMetadata;
    return this;
  }

  
  @Schema(description = "")
  @JsonProperty("error_metadata")

  public ErrorMetadata getErrorMetadata() {
    return errorMetadata;
  }
  public void setErrorMetadata(ErrorMetadata errorMetadata) {
    this.errorMetadata = errorMetadata;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ErrorResponse errorResponse = (ErrorResponse) o;
    return Objects.equals(message, errorResponse.message) &&
        Objects.equals(code, errorResponse.code) &&
        Objects.equals(errors, errorResponse.errors) &&
        Objects.equals(errorMetadata, errorResponse.errorMetadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(message, code, errors, errorMetadata);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ErrorResponse {\n");
    
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    errors: ").append(toIndentedString(errors)).append("\n");
    sb.append("    errorMetadata: ").append(toIndentedString(errorMetadata)).append("\n");
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
