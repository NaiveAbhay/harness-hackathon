package io.harness.spec.server.ng.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.Valid;
import java.util.Objects;



@Schema(description = "Validate unique secret slug response model")

public class ValidateSecretSlugResponse   {

  private @Valid Boolean valid = null;

  /**
   **/
  public ValidateSecretSlugResponse valid(Boolean valid) {
    this.valid = valid;
    return this;
  }

  
  @Schema(description = "")
  @JsonProperty("valid")

  public Boolean isValid() {
    return valid;
  }
  public void setValid(Boolean valid) {
    this.valid = valid;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ValidateSecretSlugResponse validateSecretSlugResponse = (ValidateSecretSlugResponse) o;
    return Objects.equals(valid, validateSecretSlugResponse.valid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(valid);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ValidateSecretSlugResponse {\n");
    
    sb.append("    valid: ").append(toIndentedString(valid)).append("\n");
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
