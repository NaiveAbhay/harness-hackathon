package io.harness.spec.server.commons.model;

import io.harness.spec.server.commons.model.GovernanceStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * Contains Details about Policy
 **/
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.v3.oas.annotations.media.Schema;



@Schema(description = "Contains Details about Policy")

public class Policy   {

  private @Valid Object identifier = null;

  private @Valid Object name = null;

  private @Valid Object org = null;

  private @Valid Object project = null;

  private @Valid Object evaluationError = null;

  private @Valid Object denyMessages = null;

  private @Valid GovernanceStatus status = null;

  /**
   * Policy Identifier
   **/
  public Policy identifier(Object identifier) {
    this.identifier = identifier;
    return this;
  }

  
  @Schema(description = "Policy Identifier")
  @JsonProperty("identifier")

  public Object getIdentifier() {
    return identifier;
  }
  public void setIdentifier(Object identifier) {
    this.identifier = identifier;
  }

  /**
   * Policy Name
   **/
  public Policy name(Object name) {
    this.name = name;
    return this;
  }

  
  @Schema(description = "Policy Name")
  @JsonProperty("name")

  public Object getName() {
    return name;
  }
  public void setName(Object name) {
    this.name = name;
  }

  /**
   * Organization identifier where the Policy is defined
   **/
  public Policy org(Object org) {
    this.org = org;
    return this;
  }

  
  @Schema(description = "Organization identifier where the Policy is defined")
  @JsonProperty("org")

  public Object getOrg() {
    return org;
  }
  public void setOrg(Object org) {
    this.org = org;
  }

  /**
   * Project Identifier where the Policy is defined
   **/
  public Policy project(Object project) {
    this.project = project;
    return this;
  }

  
  @Schema(description = "Project Identifier where the Policy is defined")
  @JsonProperty("project")

  public Object getProject() {
    return project;
  }
  public void setProject(Object project) {
    this.project = project;
  }

  /**
   * Error message in Policy Evaluation
   **/
  public Policy evaluationError(Object evaluationError) {
    this.evaluationError = evaluationError;
    return this;
  }

  
  @Schema(description = "Error message in Policy Evaluation")
  @JsonProperty("evaluation_error")

  public Object getEvaluationError() {
    return evaluationError;
  }
  public void setEvaluationError(Object evaluationError) {
    this.evaluationError = evaluationError;
  }

  /**
   * Deny messages
   **/
  public Policy denyMessages(Object denyMessages) {
    this.denyMessages = denyMessages;
    return this;
  }

  
  @Schema(description = "Deny messages")
  @JsonProperty("deny_messages")

  public Object getDenyMessages() {
    return denyMessages;
  }
  public void setDenyMessages(Object denyMessages) {
    this.denyMessages = denyMessages;
  }

  /**
   * Governance Status
   **/
  public Policy status(GovernanceStatus status) {
    this.status = status;
    return this;
  }

  
  @Schema(description = "Governance Status")
  @JsonProperty("status")

  public GovernanceStatus getStatus() {
    return status;
  }
  public void setStatus(GovernanceStatus status) {
    this.status = status;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Policy policy = (Policy) o;
    return Objects.equals(identifier, policy.identifier) &&
        Objects.equals(name, policy.name) &&
        Objects.equals(org, policy.org) &&
        Objects.equals(project, policy.project) &&
        Objects.equals(evaluationError, policy.evaluationError) &&
        Objects.equals(denyMessages, policy.denyMessages) &&
        Objects.equals(status, policy.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(identifier, name, org, project, evaluationError, denyMessages, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Policy {\n");
    
    sb.append("    identifier: ").append(toIndentedString(identifier)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    org: ").append(toIndentedString(org)).append("\n");
    sb.append("    project: ").append(toIndentedString(project)).append("\n");
    sb.append("    evaluationError: ").append(toIndentedString(evaluationError)).append("\n");
    sb.append("    denyMessages: ").append(toIndentedString(denyMessages)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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
