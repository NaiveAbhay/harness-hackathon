package io.harness.spec.server.ng.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;



@Schema(description = "This is the SSH key authentication details defined in Harness.")

public class SecretFileSpec extends SecretSpec implements OneOfSecretSpec  {

  private @Valid String secretManagerIdentifier = null;

  /**
   * Identifier of the Secret Manager used to manage the secret
   **/
  public SecretFileSpec secretManagerIdentifier(String secretManagerIdentifier) {
    this.secretManagerIdentifier = secretManagerIdentifier;
    return this;
  }

  
  @Schema(required = true, description = "Identifier of the Secret Manager used to manage the secret")
  @JsonProperty("secret_manager_identifier")
  @NotNull

  public String getSecretManagerIdentifier() {
    return secretManagerIdentifier;
  }
  public void setSecretManagerIdentifier(String secretManagerIdentifier) {
    this.secretManagerIdentifier = secretManagerIdentifier;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SecretFileSpec secretFileSpec = (SecretFileSpec) o;
    return Objects.equals(secretManagerIdentifier, secretFileSpec.secretManagerIdentifier);
  }

  @Override
  public int hashCode() {
    return Objects.hash(secretManagerIdentifier);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SecretFileSpec {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    secretManagerIdentifier: ").append(toIndentedString(secretManagerIdentifier)).append("\n");
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
