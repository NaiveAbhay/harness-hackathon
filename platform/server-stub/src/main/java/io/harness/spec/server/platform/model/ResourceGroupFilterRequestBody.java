package io.harness.spec.server.platform.model;

import io.harness.spec.server.platform.model.ResourceSelectorFilter;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * Filter request body for Resource Groups.
 **/
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

@Schema(description = "Filter request body for Resource Groups.")

public class ResourceGroupFilterRequestBody   {

  private @Valid String account = null;

  private @Valid String org = null;

  private @Valid String project = null;

  private @Valid String searchTerm = null;

  private @Valid List<String> identifierFilter = new ArrayList<>();

  private @Valid List<ResourceSelectorFilter> resourceSelectorFilter = new ArrayList<>();

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
   * Filter by Account identifier.
   **/
  public ResourceGroupFilterRequestBody account(String account) {
    this.account = account;
    return this;
  }

  
  @Schema(description = "Filter by Account identifier.")
  @JsonProperty("account")
 @Pattern(regexp="^[a-zA-Z_][0-9a-zA-Z_$]{0,63}$") @Size(min=1,max=64)
  public String getAccount() {
    return account;
  }
  public void setAccount(String account) {
    this.account = account;
  }

  /**
   * Filter by Organization identifier.
   **/
  public ResourceGroupFilterRequestBody org(String org) {
    this.org = org;
    return this;
  }

  
  @Schema(description = "Filter by Organization identifier.")
  @JsonProperty("org")
 @Pattern(regexp="^[a-zA-Z_][0-9a-zA-Z_$]{0,63}$") @Size(min=1,max=64)
  public String getOrg() {
    return org;
  }
  public void setOrg(String org) {
    this.org = org;
  }

  /**
   * Filter by Project identifier.
   **/
  public ResourceGroupFilterRequestBody project(String project) {
    this.project = project;
    return this;
  }

  
  @Schema(description = "Filter by Project identifier.")
  @JsonProperty("project")
 @Pattern(regexp="^[a-zA-Z_][0-9a-zA-Z_$]{0,63}$") @Size(min=1,max=64)
  public String getProject() {
    return project;
  }
  public void setProject(String project) {
    this.project = project;
  }

  /**
   * Filter Resource Group matching by identifier/name.
   **/
  public ResourceGroupFilterRequestBody searchTerm(String searchTerm) {
    this.searchTerm = searchTerm;
    return this;
  }

  
  @Schema(description = "Filter Resource Group matching by identifier/name.")
  @JsonProperty("search_term")

  public String getSearchTerm() {
    return searchTerm;
  }
  public void setSearchTerm(String searchTerm) {
    this.searchTerm = searchTerm;
  }

  /**
   * Filter by Resource Group identifiers
   **/
  public ResourceGroupFilterRequestBody identifierFilter(List<String> identifierFilter) {
    this.identifierFilter = identifierFilter;
    return this;
  }

  
  @Schema(description = "Filter by Resource Group identifiers")
  @JsonProperty("identifier_filter")

  public List<String> getIdentifierFilter() {
    return identifierFilter;
  }
  public void setIdentifierFilter(List<String> identifierFilter) {
    this.identifierFilter = identifierFilter;
  }

  /**
   * Filter based on whether it has a particular Resource.
   **/
  public ResourceGroupFilterRequestBody resourceSelectorFilter(List<ResourceSelectorFilter> resourceSelectorFilter) {
    this.resourceSelectorFilter = resourceSelectorFilter;
    return this;
  }

  
  @Schema(description = "Filter based on whether it has a particular Resource.")
  @JsonProperty("resource_selector_filter")

  public List<ResourceSelectorFilter> getResourceSelectorFilter() {
    return resourceSelectorFilter;
  }
  public void setResourceSelectorFilter(List<ResourceSelectorFilter> resourceSelectorFilter) {
    this.resourceSelectorFilter = resourceSelectorFilter;
  }

  /**
   * Filter based on whether the Resource Group is Harness Managed.
   **/
  public ResourceGroupFilterRequestBody managedFilter(ManagedFilterEnum managedFilter) {
    this.managedFilter = managedFilter;
    return this;
  }

  
  @Schema(description = "Filter based on whether the Resource Group is Harness Managed.")
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
    ResourceGroupFilterRequestBody resourceGroupFilterRequestBody = (ResourceGroupFilterRequestBody) o;
    return Objects.equals(account, resourceGroupFilterRequestBody.account) &&
        Objects.equals(org, resourceGroupFilterRequestBody.org) &&
        Objects.equals(project, resourceGroupFilterRequestBody.project) &&
        Objects.equals(searchTerm, resourceGroupFilterRequestBody.searchTerm) &&
        Objects.equals(identifierFilter, resourceGroupFilterRequestBody.identifierFilter) &&
        Objects.equals(resourceSelectorFilter, resourceGroupFilterRequestBody.resourceSelectorFilter) &&
        Objects.equals(managedFilter, resourceGroupFilterRequestBody.managedFilter);
  }

  @Override
  public int hashCode() {
    return Objects.hash(account, org, project, searchTerm, identifierFilter, resourceSelectorFilter, managedFilter);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResourceGroupFilterRequestBody {\n");
    
    sb.append("    account: ").append(toIndentedString(account)).append("\n");
    sb.append("    org: ").append(toIndentedString(org)).append("\n");
    sb.append("    project: ").append(toIndentedString(project)).append("\n");
    sb.append("    searchTerm: ").append(toIndentedString(searchTerm)).append("\n");
    sb.append("    identifierFilter: ").append(toIndentedString(identifierFilter)).append("\n");
    sb.append("    resourceSelectorFilter: ").append(toIndentedString(resourceSelectorFilter)).append("\n");
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
