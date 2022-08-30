package io.harness.spec.server.platform.model;

import io.harness.spec.server.platform.model.ResourceSelectorFilter;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * Filter Resource Groups based on multiple parameters.
 **/
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

@Schema(description = "Filter Resource Groups based on multiple parameters.")

public class FilterResourceGroupRequest   {

  private @Valid String account = null;

  private @Valid String organization = null;

  private @Valid String project = null;

  private @Valid String searchTerm = null;

  private @Valid List<String> identifierFilter = new ArrayList<>();

  private @Valid List<ResourceSelectorFilter> resourceListFilter = new ArrayList<>();

public enum ManagedFilterEnum {

    NO_FILTER(String.valueOf("NO_FILTER")), ONLY_MANAGED(String.valueOf("ONLY_MANAGED")), ONLY_CUSTOM(String.valueOf("ONLY_CUSTOM"));


    private String value;

    ManagedFilterEnum (String v) {
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
    public static ManagedFilterEnum fromValue(String v) {
        for (ManagedFilterEnum b : ManagedFilterEnum.values()) {
            if (String.valueOf(b.value).equals(v)) {
                return b;
            }
        }
        return null;
    }
}
  private @Valid ManagedFilterEnum managedFilter = null;

  /**
   * Filter by Account
   **/
  public FilterResourceGroupRequest account(String account) {
    this.account = account;
    return this;
  }

  
  @Schema(description = "Filter by Account")
  @JsonProperty("account")

  public String getAccount() {
    return account;
  }
  public void setAccount(String account) {
    this.account = account;
  }

  /**
   * Filter by Organization
   **/
  public FilterResourceGroupRequest organization(String organization) {
    this.organization = organization;
    return this;
  }

  
  @Schema(description = "Filter by Organization")
  @JsonProperty("organization")

  public String getOrganization() {
    return organization;
  }
  public void setOrganization(String organization) {
    this.organization = organization;
  }

  /**
   * Filter by Project
   **/
  public FilterResourceGroupRequest project(String project) {
    this.project = project;
    return this;
  }

  
  @Schema(description = "Filter by Project")
  @JsonProperty("project")

  public String getProject() {
    return project;
  }
  public void setProject(String project) {
    this.project = project;
  }

  /**
   * Filter by Identifier/Name
   **/
  public FilterResourceGroupRequest searchTerm(String searchTerm) {
    this.searchTerm = searchTerm;
    return this;
  }

  
  @Schema(description = "Filter by Identifier/Name")
  @JsonProperty("search_term")

  public String getSearchTerm() {
    return searchTerm;
  }
  public void setSearchTerm(String searchTerm) {
    this.searchTerm = searchTerm;
  }

  /**
   * Filter by Identifiers
   **/
  public FilterResourceGroupRequest identifierFilter(List<String> identifierFilter) {
    this.identifierFilter = identifierFilter;
    return this;
  }

  
  @Schema(description = "Filter by Identifiers")
  @JsonProperty("identifier_filter")

  public List<String> getIdentifierFilter() {
    return identifierFilter;
  }
  public void setIdentifierFilter(List<String> identifierFilter) {
    this.identifierFilter = identifierFilter;
  }

  /**
   * Filter by particular Resource
   **/
  public FilterResourceGroupRequest resourceListFilter(List<ResourceSelectorFilter> resourceListFilter) {
    this.resourceListFilter = resourceListFilter;
    return this;
  }

  
  @Schema(description = "Filter by particular Resource")
  @JsonProperty("resource_list_filter")

  public List<ResourceSelectorFilter> getResourceListFilter() {
    return resourceListFilter;
  }
  public void setResourceListFilter(List<ResourceSelectorFilter> resourceListFilter) {
    this.resourceListFilter = resourceListFilter;
  }

  /**
   * Filter by Harness Managed
   **/
  public FilterResourceGroupRequest managedFilter(ManagedFilterEnum managedFilter) {
    this.managedFilter = managedFilter;
    return this;
  }

  
  @Schema(description = "Filter by Harness Managed")
  @JsonProperty("managed_filter")

  public ManagedFilterEnum getManagedFilter() {
    return managedFilter;
  }
  public void setManagedFilter(ManagedFilterEnum managedFilter) {
    this.managedFilter = managedFilter;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FilterResourceGroupRequest filterResourceGroupRequest = (FilterResourceGroupRequest) o;
    return Objects.equals(account, filterResourceGroupRequest.account) &&
        Objects.equals(organization, filterResourceGroupRequest.organization) &&
        Objects.equals(project, filterResourceGroupRequest.project) &&
        Objects.equals(searchTerm, filterResourceGroupRequest.searchTerm) &&
        Objects.equals(identifierFilter, filterResourceGroupRequest.identifierFilter) &&
        Objects.equals(resourceListFilter, filterResourceGroupRequest.resourceListFilter) &&
        Objects.equals(managedFilter, filterResourceGroupRequest.managedFilter);
  }

  @Override
  public int hashCode() {
    return Objects.hash(account, organization, project, searchTerm, identifierFilter, resourceListFilter, managedFilter);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FilterResourceGroupRequest {\n");
    
    sb.append("    account: ").append(toIndentedString(account)).append("\n");
    sb.append("    organization: ").append(toIndentedString(organization)).append("\n");
    sb.append("    project: ").append(toIndentedString(project)).append("\n");
    sb.append("    searchTerm: ").append(toIndentedString(searchTerm)).append("\n");
    sb.append("    identifierFilter: ").append(toIndentedString(identifierFilter)).append("\n");
    sb.append("    resourceListFilter: ").append(toIndentedString(resourceListFilter)).append("\n");
    sb.append("    managedFilter: ").append(toIndentedString(managedFilter)).append("\n");
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
