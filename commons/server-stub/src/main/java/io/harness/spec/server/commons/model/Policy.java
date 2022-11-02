package io.harness.spec.server.commons.model;

import io.harness.spec.server.commons.model.GovernanceStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
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

  private @Valid String identifier = null;

  private @Valid String name = null;

  private @Valid String org = null;

  private @Valid String project = null;

  private @Valid String evaluationError = null;

  private @Valid List<String> denyMessages = new ArrayList<String>();

  private @Valid GovernanceStatus status = null;

  /**
   * Policy Identifier
   **/
  public Policy identifier(String identifier) {
    this.identifier = identifier;
    return this;
  }

  
  @Schema(description = "Policy Identifier")
  @JsonProperty("identifier")

  public String getIdentifier() {
    return identifier;
  }
  public void setIdentifier(String identifier) {
    this.identifier = identifier;
  }

  /**
   * Policy Name
   **/
  public Policy name(String name) {
    this.name = name;
    return this;
  }

  
  @Schema(description = "Policy Name")
  @JsonProperty("name")

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Organization identifier where the Policy is defined
   **/
  public Policy org(String org) {
    this.org = org;
    return this;
  }

  
  @Schema(description = "Organization identifier where the Policy is defined")
  @JsonProperty("org")

  public String getOrg() {
    return org;
  }
  public void setOrg(String org) {
    this.org = org;
  }

  /**
   * Project Identifier where the Policy is defined
   **/
  public Policy project(String project) {
    this.project = project;
    return this;
  }

  
  @Schema(description = "Project Identifier where the Policy is defined")
  @JsonProperty("project")

  public String getProject() {
    return project;
  }
  public void setProject(String project) {
    this.project = project;
  }

  /**
   * Error message in Policy Evaluation
   **/
  public Policy evaluationError(String evaluationError) {
    this.evaluationError = evaluationError;
    return this;
  }

  
  @Schema(description = "Error message in Policy Evaluation")
  @JsonProperty("evaluation_error")

  public String getEvaluationError() {
    return evaluationError;
  }
  public void setEvaluationError(String evaluationError) {
    this.evaluationError = evaluationError;
  }

  /**
   * Deny messages
   **/
  public Policy denyMessages(List<String> denyMessages) {
    this.denyMessages = denyMessages;
    return this;
  }

  
  @Schema(description = "Deny messages")
  @JsonProperty("deny_messages")

  public List<String> getDenyMessages() {
    return denyMessages;
  }
  public void setDenyMessages(List<String> denyMessages) {
    this.denyMessages = denyMessages;
  }

  /**
   **/
  public Policy status(GovernanceStatus status) {
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
