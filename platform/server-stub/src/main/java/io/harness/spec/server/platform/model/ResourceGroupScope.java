package io.harness.spec.server.platform.model;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * Included scopes for the Resources belonging to the Resource Group
 **/
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

@Schema(description = "Included scopes for the Resources belonging to the Resource Group")

public class ResourceGroupScope   {

public enum FilterEnum {

    EXCLUDING_CHILD_SCOPES(String.valueOf("EXCLUDING_CHILD_SCOPES")), INCLUDING_CHILD_SCOPES(String.valueOf("INCLUDING_CHILD_SCOPES"));


    private String value;

    FilterEnum (String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    @Override
    @JsonValue
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static FilterEnum fromValue(String v) {
        for (FilterEnum b : FilterEnum.values()) {
            if (String.valueOf(b.value).equals(v)) {
                return b;
            }
        }
        return null;
    }
}
  private @Valid FilterEnum filter = null;

  private @Valid String account = null;

  private @Valid String org = null;

  private @Valid String project = null;

  /**
   * Including or Excluding Child scopes.
   **/
  public ResourceGroupScope filter(FilterEnum filter) {
    this.filter = filter;
    return this;
  }

  
  @Schema(required = true, description = "Including or Excluding Child scopes.")
  @JsonProperty("filter")
  @NotNull

  public FilterEnum getFilter() {
    return filter;
  }
  public void setFilter(FilterEnum filter) {
    this.filter = filter;
  }

  /**
   * Account identifier
   **/
  public ResourceGroupScope account(String account) {
    this.account = account;
    return this;
  }

  
  @Schema(description = "Account identifier")
  @JsonProperty("account")
 @Pattern(regexp="^[a-zA-Z_][0-9a-zA-Z_$]{0,63}$") @Size(min=1,max=64)
  public String getAccount() {
    return account;
  }
  public void setAccount(String account) {
    this.account = account;
  }

  /**
   * Organization identifier
   **/
  public ResourceGroupScope org(String org) {
    this.org = org;
    return this;
  }

  
  @Schema(description = "Organization identifier")
  @JsonProperty("org")
 @Pattern(regexp="^[a-zA-Z_][0-9a-zA-Z_$]{0,63}$") @Size(min=1,max=64)
  public String getOrg() {
    return org;
  }
  public void setOrg(String org) {
    this.org = org;
  }

  /**
   * Project identifier
   **/
  public ResourceGroupScope project(String project) {
    this.project = project;
    return this;
  }

  
  @Schema(description = "Project identifier")
  @JsonProperty("project")
 @Pattern(regexp="^[a-zA-Z_][0-9a-zA-Z_$]{0,63}$") @Size(min=1,max=64)
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
    ResourceGroupScope resourceGroupScope = (ResourceGroupScope) o;
    return Objects.equals(filter, resourceGroupScope.filter) &&
        Objects.equals(account, resourceGroupScope.account) &&
        Objects.equals(org, resourceGroupScope.org) &&
        Objects.equals(project, resourceGroupScope.project);
  }

  @Override
  public int hashCode() {
    return Objects.hash(filter, account, org, project);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResourceGroupScope {\n");
    
    sb.append("    filter: ").append(toIndentedString(filter)).append("\n");
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
