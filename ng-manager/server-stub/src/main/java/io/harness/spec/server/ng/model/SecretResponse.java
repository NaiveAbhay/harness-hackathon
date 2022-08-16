package io.harness.spec.server.ng.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.Valid;
import java.util.Objects;



@Schema(description = "Secret Response Model")

public class SecretResponse   {

  private @Valid Secret secret = null;

  private @Valid Long createdAt = null;

  private @Valid Long updatedAt = null;

  private @Valid Boolean draft = null;

  private @Valid Object governanceMetadata = null;

  /**
   **/
  public SecretResponse secret(Secret secret) {
    this.secret = secret;
    return this;
  }

  
  @Schema(description = "")
  @JsonProperty("secret")

  public Secret getSecret() {
    return secret;
  }
  public void setSecret(Secret secret) {
    this.secret = secret;
  }

  /**
   * Creation timestamp for the secret
   **/
  public SecretResponse createdAt(Long createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  
  @Schema(description = "Creation timestamp for the secret")
  @JsonProperty("created_at")

  public Long getCreatedAt() {
    return createdAt;
  }
  public void setCreatedAt(Long createdAt) {
    this.createdAt = createdAt;
  }

  /**
   * Last modification timestamp for the secret
   **/
  public SecretResponse updatedAt(Long updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }

  
  @Schema(description = "Last modification timestamp for the secret")
  @JsonProperty("updated_at")

  public Long getUpdatedAt() {
    return updatedAt;
  }
  public void setUpdatedAt(Long updatedAt) {
    this.updatedAt = updatedAt;
  }

  /**
   **/
  public SecretResponse draft(Boolean draft) {
    this.draft = draft;
    return this;
  }

  
  @Schema(description = "")
  @JsonProperty("draft")

  public Boolean isDraft() {
    return draft;
  }
  public void setDraft(Boolean draft) {
    this.draft = draft;
  }

  /**
   **/
  public SecretResponse governanceMetadata(Object governanceMetadata) {
    this.governanceMetadata = governanceMetadata;
    return this;
  }

  
  @Schema(description = "")
  @JsonProperty("governance_metadata")

  public Object getGovernanceMetadata() {
    return governanceMetadata;
  }
  public void setGovernanceMetadata(Object governanceMetadata) {
    this.governanceMetadata = governanceMetadata;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SecretResponse secretResponse = (SecretResponse) o;
    return Objects.equals(secret, secretResponse.secret) &&
        Objects.equals(createdAt, secretResponse.createdAt) &&
        Objects.equals(updatedAt, secretResponse.updatedAt) &&
        Objects.equals(draft, secretResponse.draft) &&
        Objects.equals(governanceMetadata, secretResponse.governanceMetadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(secret, createdAt, updatedAt, draft, governanceMetadata);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SecretResponse {\n");
    
    sb.append("    secret: ").append(toIndentedString(secret)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
    sb.append("    draft: ").append(toIndentedString(draft)).append("\n");
    sb.append("    governanceMetadata: ").append(toIndentedString(governanceMetadata)).append("\n");
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
