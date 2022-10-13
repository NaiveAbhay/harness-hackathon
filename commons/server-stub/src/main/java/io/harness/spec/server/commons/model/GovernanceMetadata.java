package io.harness.spec.server.commons.model;

import io.harness.spec.server.commons.model.GovernanceStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * Governace Error Details
 **/
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.v3.oas.annotations.media.Schema;



@Schema(description = "Governace Error Details")

public class GovernanceMetadata   {

  private @Valid Object deny = null;

  private @Valid Object message = null;

  private @Valid GovernanceStatus status = null;

  private @Valid Object policySets = null;

  /**
   * Indicate whether the action is denied or not based on Governance rules
   **/
  public GovernanceMetadata deny(Object deny) {
    this.deny = deny;
    return this;
  }

  
  @Schema(description = "Indicate whether the action is denied or not based on Governance rules")
  @JsonProperty("deny")

  public Object getDeny() {
    return deny;
  }
  public void setDeny(Object deny) {
    this.deny = deny;
  }

  /**
   * Governance Message
   **/
  public GovernanceMetadata message(Object message) {
    this.message = message;
    return this;
  }

  
  @Schema(description = "Governance Message")
  @JsonProperty("message")

  public Object getMessage() {
    return message;
  }
  public void setMessage(Object message) {
    this.message = message;
  }

  /**
   * Governace Status
   **/
  public GovernanceMetadata status(GovernanceStatus status) {
    this.status = status;
    return this;
  }

  
  @Schema(description = "Governace Status")
  @JsonProperty("status")

  public GovernanceStatus getStatus() {
    return status;
  }
  public void setStatus(GovernanceStatus status) {
    this.status = status;
  }

  /**
   **/
  public GovernanceMetadata policySets(Object policySets) {
    this.policySets = policySets;
    return this;
  }

  
  @Schema(description = "")
  @JsonProperty("policy_sets")

  public Object getPolicySets() {
    return policySets;
  }
  public void setPolicySets(Object policySets) {
    this.policySets = policySets;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GovernanceMetadata governanceMetadata = (GovernanceMetadata) o;
    return Objects.equals(deny, governanceMetadata.deny) &&
        Objects.equals(message, governanceMetadata.message) &&
        Objects.equals(status, governanceMetadata.status) &&
        Objects.equals(policySets, governanceMetadata.policySets);
  }

  @Override
  public int hashCode() {
    return Objects.hash(deny, message, status, policySets);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GovernanceMetadata {\n");
    
    sb.append("    deny: ").append(toIndentedString(deny)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    policySets: ").append(toIndentedString(policySets)).append("\n");
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
