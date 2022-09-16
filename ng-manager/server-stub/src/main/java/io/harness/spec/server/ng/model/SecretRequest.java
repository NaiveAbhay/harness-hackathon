package io.harness.spec.server.ng.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;





public class SecretRequest   {

  private @Valid Secret secret = null;

  /**
   **/
  public SecretRequest secret(Secret secret) {
    this.secret = secret;
    return this;
  }

  
  @Schema(required = true, description = "")
  @JsonProperty("secret")
  @NotNull

  public Secret getSecret() {
    return secret;
  }
  public void setSecret(Secret secret) {
    this.secret = secret;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SecretRequest secretRequest = (SecretRequest) o;
    return Objects.equals(secret, secretRequest.secret);
  }

  @Override
  public int hashCode() {
    return Objects.hash(secret);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SecretRequest {\n");
    
    sb.append("    secret: ").append(toIndentedString(secret)).append("\n");
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
