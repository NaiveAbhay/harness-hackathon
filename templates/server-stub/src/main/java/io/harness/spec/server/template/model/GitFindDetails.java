package io.harness.spec.server.template.model;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * Contains parameters related to Fetching an Entity for Git Experience.
 **/
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.v3.oas.annotations.media.Schema;



@Schema(description = "Contains parameters related to Fetching an Entity for Git Experience.")

public class GitFindDetails   {

  private @Valid String branchName = null;

  private @Valid String parentConnectorRef = null;

  private @Valid String parentRepoName = null;

  private @Valid String parentAccountId = null;

  private @Valid String parentOrgId = null;

  private @Valid String parentProjectId = null;

  /**
   * Name of the branch.
   **/
  public GitFindDetails branchName(String branchName) {
    this.branchName = branchName;
    return this;
  }

  
  @Schema(description = "Name of the branch.")
  @JsonProperty("branch_name")

  public String getBranchName() {
    return branchName;
  }
  public void setBranchName(String branchName) {
    this.branchName = branchName;
  }

  /**
   * Connector ref of parent template if its remote
   **/
  public GitFindDetails parentConnectorRef(String parentConnectorRef) {
    this.parentConnectorRef = parentConnectorRef;
    return this;
  }

  
  @Schema(description = "Connector ref of parent template if its remote")
  @JsonProperty("parent_connector_ref")

  public String getParentConnectorRef() {
    return parentConnectorRef;
  }
  public void setParentConnectorRef(String parentConnectorRef) {
    this.parentConnectorRef = parentConnectorRef;
  }

  /**
   * Repo name of parent template if its remote
   **/
  public GitFindDetails parentRepoName(String parentRepoName) {
    this.parentRepoName = parentRepoName;
    return this;
  }

  
  @Schema(description = "Repo name of parent template if its remote")
  @JsonProperty("parent_repo_name")

  public String getParentRepoName() {
    return parentRepoName;
  }
  public void setParentRepoName(String parentRepoName) {
    this.parentRepoName = parentRepoName;
  }

  /**
   * Account name of parent template if its remote
   **/
  public GitFindDetails parentAccountId(String parentAccountId) {
    this.parentAccountId = parentAccountId;
    return this;
  }

  
  @Schema(description = "Account name of parent template if its remote")
  @JsonProperty("parent_account_id")

  public String getParentAccountId() {
    return parentAccountId;
  }
  public void setParentAccountId(String parentAccountId) {
    this.parentAccountId = parentAccountId;
  }

  /**
   * Organization name of parent template if its remote
   **/
  public GitFindDetails parentOrgId(String parentOrgId) {
    this.parentOrgId = parentOrgId;
    return this;
  }

  
  @Schema(description = "Organization name of parent template if its remote")
  @JsonProperty("parent_org_id")

  public String getParentOrgId() {
    return parentOrgId;
  }
  public void setParentOrgId(String parentOrgId) {
    this.parentOrgId = parentOrgId;
  }

  /**
   * Project name of parent entity if its remote 
   **/
  public GitFindDetails parentProjectId(String parentProjectId) {
    this.parentProjectId = parentProjectId;
    return this;
  }

  
  @Schema(description = "Project name of parent entity if its remote ")
  @JsonProperty("parent_project_id")

  public String getParentProjectId() {
    return parentProjectId;
  }
  public void setParentProjectId(String parentProjectId) {
    this.parentProjectId = parentProjectId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GitFindDetails gitFindDetails = (GitFindDetails) o;
    return Objects.equals(branchName, gitFindDetails.branchName) &&
        Objects.equals(parentConnectorRef, gitFindDetails.parentConnectorRef) &&
        Objects.equals(parentRepoName, gitFindDetails.parentRepoName) &&
        Objects.equals(parentAccountId, gitFindDetails.parentAccountId) &&
        Objects.equals(parentOrgId, gitFindDetails.parentOrgId) &&
        Objects.equals(parentProjectId, gitFindDetails.parentProjectId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(branchName, parentConnectorRef, parentRepoName, parentAccountId, parentOrgId, parentProjectId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GitFindDetails {\n");
    
    sb.append("    branchName: ").append(toIndentedString(branchName)).append("\n");
    sb.append("    parentConnectorRef: ").append(toIndentedString(parentConnectorRef)).append("\n");
    sb.append("    parentRepoName: ").append(toIndentedString(parentRepoName)).append("\n");
    sb.append("    parentAccountId: ").append(toIndentedString(parentAccountId)).append("\n");
    sb.append("    parentOrgId: ").append(toIndentedString(parentOrgId)).append("\n");
    sb.append("    parentProjectId: ").append(toIndentedString(parentProjectId)).append("\n");
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
