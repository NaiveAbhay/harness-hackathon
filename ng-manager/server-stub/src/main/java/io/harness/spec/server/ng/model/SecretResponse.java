package io.harness.spec.server.ng.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.Valid;
import java.util.Objects;



@Schema(description = "Secret response model")

public class SecretResponse   {

  private @Valid Secret secret = null;

  private @Valid Long created = null;

  private @Valid Long updated = null;

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
  public SecretResponse created(Long created) {
    this.created = created;
    return this;
  }

  
  @Schema(description = "Creation timestamp for the secret")
  @JsonProperty("created")

  public Long getCreated() {
    return created;
  }
  public void setCreated(Long created) {
    this.created = created;
  }

  /**
   * Last modification timestamp for the secret
   **/
  public SecretResponse updated(Long updated) {
    this.updated = updated;
    return this;
  }

  
  @Schema(description = "Last modification timestamp for the secret")
  @JsonProperty("updated")

  public Long getUpdated() {
    return updated;
  }
  public void setUpdated(Long updated) {
    this.updated = updated;
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
        Objects.equals(created, secretResponse.created) &&
        Objects.equals(updated, secretResponse.updated) &&
        Objects.equals(draft, secretResponse.draft) &&
        Objects.equals(governanceMetadata, secretResponse.governanceMetadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(secret, created, updated, draft, governanceMetadata);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SecretResponse {\n");
    
    sb.append("    secret: ").append(toIndentedString(secret)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    updated: ").append(toIndentedString(updated)).append("\n");
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
