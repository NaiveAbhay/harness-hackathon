package io.harness.spec.server.commons.model;

import io.harness.spec.server.commons.model.GovernanceStatus;
import io.harness.spec.server.commons.model.Policy;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
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

  private @Valid String identifier = null;

  private @Valid String name = null;

  private @Valid String org = null;

  private @Valid String project = null;

  private @Valid List<String> denyMessages = new ArrayList<String>();

  private @Valid GovernanceStatus status = null;

  private @Valid List<Policy> policies = new ArrayList<Policy>();

  /**
   * Identifer of the Policy Set
   **/
  public PolicySet identifier(String identifier) {
    this.identifier = identifier;
    return this;
  }

  
  @Schema(description = "Identifer of the Policy Set")
  @JsonProperty("identifier")

  public String getIdentifier() {
    return identifier;
  }
  public void setIdentifier(String identifier) {
    this.identifier = identifier;
  }

  /**
   * Name of the Policy Set
   **/
  public PolicySet name(String name) {
    this.name = name;
    return this;
  }

  
  @Schema(description = "Name of the Policy Set")
  @JsonProperty("name")

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Organization Identifier where the Policy Set is defined
   **/
  public PolicySet org(String org) {
    this.org = org;
    return this;
  }

  
  @Schema(description = "Organization Identifier where the Policy Set is defined")
  @JsonProperty("org")

  public String getOrg() {
    return org;
  }
  public void setOrg(String org) {
    this.org = org;
  }

  /**
   * Project Identifier where the Policy Set is defined
   **/
  public PolicySet project(String project) {
    this.project = project;
    return this;
  }

  
  @Schema(description = "Project Identifier where the Policy Set is defined")
  @JsonProperty("project")

  public String getProject() {
    return project;
  }
  public void setProject(String project) {
    this.project = project;
  }

  /**
   * Deny messages
   **/
  public PolicySet denyMessages(List<String> denyMessages) {
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
  public PolicySet policies(List<Policy> policies) {
    this.policies = policies;
    return this;
  }

  
  @Schema(description = "List of policies defined inside Policy Set")
  @JsonProperty("policies")

  public List<Policy> getPolicies() {
    return policies;
  }
  public void setPolicies(List<Policy> policies) {
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
