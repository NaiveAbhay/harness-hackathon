package io.harness.spec.server.access_control.model;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * Scope of the Role.
 **/
import io.swagger.annotations.*;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
@Schema(description = "Scope of the Role.")

public class RoleScope   {

  private @Valid String account = null;

  private @Valid String org = null;

  private @Valid String project = null;

  /**
   * Account identifier
   **/
  public RoleScope account(String account) {
    this.account = account;
    return this;
  }

  
  @ApiModelProperty(value = "Account identifier")
  @JsonProperty("account")

  public String getAccount() {
    return account;
  }
  public void setAccount(String account) {
    this.account = account;
  }

  /**
   * Organization identifier
   **/
  public RoleScope org(String org) {
    this.org = org;
    return this;
  }

  
  @ApiModelProperty(value = "Organization identifier")
  @JsonProperty("org")

  public String getOrg() {
    return org;
  }
  public void setOrg(String org) {
    this.org = org;
  }

  /**
   * Project identifier
   **/
  public RoleScope project(String project) {
    this.project = project;
    return this;
  }

  
  @ApiModelProperty(value = "Project identifier")
  @JsonProperty("project")

  public String getProject() {
    return project;
  }
  public void setProject(String project) {
    this.project = project;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RoleScope roleScope = (RoleScope) o;
    return Objects.equals(account, roleScope.account) &&
        Objects.equals(org, roleScope.org) &&
        Objects.equals(project, roleScope.project);
  }

  @Override
  public int hashCode() {
    return Objects.hash(account, org, project);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RoleScope {\n");
    
    sb.append("    account: ").append(toIndentedString(account)).append("\n");
    sb.append("    org: ").append(toIndentedString(org)).append("\n");
    sb.append("    project: ").append(toIndentedString(project)).append("\n");
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
