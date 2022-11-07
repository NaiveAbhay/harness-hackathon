package io.harness.spec.server.commons.model;

import io.harness.spec.server.commons.model.ErrorMetadata;
import io.harness.spec.server.commons.model.GovernanceStatus;
import io.harness.spec.server.commons.model.PolicySet;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
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

public class GovernanceMetadata extends ErrorMetadata  {

  private @Valid Boolean deny = null;

  private @Valid String message = null;

  private @Valid GovernanceStatus status = null;

  private @Valid List<PolicySet> policySets = new ArrayList<PolicySet>();

  /**
   * Indicate whether the action is denied or not based on Governance rules
   **/
  public GovernanceMetadata deny(Boolean deny) {
    this.deny = deny;
    return this;
  }

  
  @Schema(description = "Indicate whether the action is denied or not based on Governance rules")
  @JsonProperty("deny")

  public Boolean isDeny() {
    return deny;
  }
  public void setDeny(Boolean deny) {
    this.deny = deny;
  }

  /**
   * Governance Message
   **/
  public GovernanceMetadata message(String message) {
    this.message = message;
    return this;
  }

  
  @Schema(description = "Governance Message")
  @JsonProperty("message")

  public String getMessage() {
    return message;
  }
  public void setMessage(String message) {
    this.message = message;
  }

  /**
   **/
  public GovernanceMetadata status(GovernanceStatus status) {
    this.status = status;
    return this;
  }

  
  @Schema(description = "")
  @JsonProperty("status")

  public GovernanceStatus getStatus() {
    return status;
  }
  public void setStatus(GovernanceStatus status) {
    this.status = status;
  }

  /**
   **/
  public GovernanceMetadata policySets(List<PolicySet> policySets) {
    this.policySets = policySets;
    return this;
  }

  
  @Schema(description = "")
  @JsonProperty("policy_sets")

  public List<PolicySet> getPolicySets() {
    return policySets;
  }
  public void setPolicySets(List<PolicySet> policySets) {
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
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
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
