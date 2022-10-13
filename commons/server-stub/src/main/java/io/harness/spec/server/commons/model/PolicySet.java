package io.harness.spec.server.commons.model;

import io.harness.spec.server.commons.model.GovernanceStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * Contains Policy Set Detail
 **/
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.v3.oas.annotations.media.Schema;



@Schema(description = "Contains Policy Set Detail")

public class PolicySet   {

  private @Valid Object identifier = null;

  private @Valid Object name = null;

  private @Valid Object org = null;

  private @Valid Object project = null;

  private @Valid Object denyMessages = null;

  private @Valid GovernanceStatus status = null;

  private @Valid Object policies = null;

  /**
   * Identifer of the Policy Set
   **/
  public PolicySet identifier(Object identifier) {
    this.identifier = identifier;
    return this;
  }

  
  @Schema(description = "Identifer of the Policy Set")
  @JsonProperty("identifier")

  public Object getIdentifier() {
    return identifier;
  }
  public void setIdentifier(Object identifier) {
    this.identifier = identifier;
  }

  /**
   * Name of the Policy Set
   **/
  public PolicySet name(Object name) {
    this.name = name;
    return this;
  }

  
  @Schema(description = "Name of the Policy Set")
  @JsonProperty("name")

  public Object getName() {
    return name;
  }
  public void setName(Object name) {
    this.name = name;
  }

  /**
   * Organization Identifier where the Policy Set is defined
   **/
  public PolicySet org(Object org) {
    this.org = org;
    return this;
  }

  
  @Schema(description = "Organization Identifier where the Policy Set is defined")
  @JsonProperty("org")

  public Object getOrg() {
    return org;
  }
  public void setOrg(Object org) {
    this.org = org;
  }

  /**
   * Project Identifier where the Policy Set is defined
   **/
  public PolicySet project(Object project) {
    this.project = project;
    return this;
  }

  
  @Schema(description = "Project Identifier where the Policy Set is defined")
  @JsonProperty("project")

  public Object getProject() {
    return project;
  }
  public void setProject(Object project) {
    this.project = project;
  }

  /**
   * Deny messages
   **/
  public PolicySet denyMessages(Object denyMessages) {
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
   **/
  public PolicySet status(GovernanceStatus status) {
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
   * List of policies defined inside Policy Set
   **/
  public PolicySet policies(Object policies) {
    this.policies = policies;
    return this;
  }

  
  @Schema(description = "List of policies defined inside Policy Set")
  @JsonProperty("policies")

  public Object getPolicies() {
    return policies;
  }
  public void setPolicies(Object policies) {
    this.policies = policies;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PolicySet policySet = (PolicySet) o;
    return Objects.equals(identifier, policySet.identifier) &&
        Objects.equals(name, policySet.name) &&
        Objects.equals(org, policySet.org) &&
        Objects.equals(project, policySet.project) &&
        Objects.equals(denyMessages, policySet.denyMessages) &&
        Objects.equals(status, policySet.status) &&
        Objects.equals(policies, policySet.policies);
  }

  @Override
  public int hashCode() {
    return Objects.hash(identifier, name, org, project, denyMessages, status, policies);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PolicySet {\n");
    
    sb.append("    identifier: ").append(toIndentedString(identifier)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    org: ").append(toIndentedString(org)).append("\n");
    sb.append("    project: ").append(toIndentedString(project)).append("\n");
    sb.append("    denyMessages: ").append(toIndentedString(denyMessages)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    policies: ").append(toIndentedString(policies)).append("\n");
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
