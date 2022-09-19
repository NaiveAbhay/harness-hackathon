package io.harness.spec.server.platform.model;

import io.harness.spec.server.platform.model.ResourceFilter;
import io.harness.spec.server.platform.model.ResourceGroupScope;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * Resource Group response body
 **/
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

@Schema(description = "Resource Group response body")

public class ResourceGroupsResponse   {

  private @Valid String slug = null;

  private @Valid String name = null;

  private @Valid String color = null;

  private @Valid Map<String, String> tags = new HashMap<>();

  private @Valid String description = null;

public enum AllowedScopeLevelsEnum {

    ACCOUNT(String.valueOf("account")), ORGANIZATION(String.valueOf("organization")), PROJECT(String.valueOf("project"));


    private String value;

    AllowedScopeLevelsEnum (String v) {
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
    public static AllowedScopeLevelsEnum fromValue(String v) {
        for (AllowedScopeLevelsEnum b : AllowedScopeLevelsEnum.values()) {
            if (String.valueOf(b.value).equals(v)) {
                return b;
            }
        }
        return null;
    }
}
  private @Valid List<AllowedScopeLevelsEnum> allowedScopeLevels = new ArrayList<>();

  private @Valid List<ResourceGroupScope> includedScope = new ArrayList<>();

  private @Valid List<ResourceFilter> resourceFilter = new ArrayList<>();

  private @Valid Boolean includeAllResources = null;

  private @Valid Boolean harnessManaged = null;

  private @Valid Long created = null;

  private @Valid Long updated = null;

  /**
   * Resource Group Identifier
   **/
  public ResourceGroupsResponse slug(String slug) {
    this.slug = slug;
    return this;
  }

  
  @Schema(required = true, description = "Resource Group Identifier")
  @JsonProperty("slug")
  @NotNull
 @Pattern(regexp="^[a-zA-Z_][0-9a-zA-Z_$]{0,63}$") @Size(min=1,max=64)
  public String getSlug() {
    return slug;
  }
  public void setSlug(String slug) {
    this.slug = slug;
  }

  /**
   * Resource Group Name
   **/
  public ResourceGroupsResponse name(String name) {
    this.name = name;
    return this;
  }

  
  @Schema(required = true, description = "Resource Group Name")
  @JsonProperty("name")
  @NotNull
 @Pattern(regexp="^[a-zA-Z_][0-9a-zA-Z_$]{0,63}$") @Size(min=1,max=64)
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Color associated with the Resource Group.
   **/
  public ResourceGroupsResponse color(String color) {
    this.color = color;
    return this;
  }

  
  @Schema(description = "Color associated with the Resource Group.")
  @JsonProperty("color")

  public String getColor() {
    return color;
  }
  public void setColor(String color) {
    this.color = color;
  }

  /**
   * Resource Group tags
   **/
  public ResourceGroupsResponse tags(Map<String, String> tags) {
    this.tags = tags;
    return this;
  }

  
  @Schema(description = "Resource Group tags")
  @JsonProperty("tags")
 @Size(max=128)
  public Map<String, String> getTags() {
    return tags;
  }
  public void setTags(Map<String, String> tags) {
    this.tags = tags;
  }

  /**
   * Resource Group description
   **/
  public ResourceGroupsResponse description(String description) {
    this.description = description;
    return this;
  }

  
  @Schema(description = "Resource Group description")
  @JsonProperty("description")
 @Size(max=1024)
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * Allowed scope levels for this Resource Group.
   **/
  public ResourceGroupsResponse allowedScopeLevels(List<AllowedScopeLevelsEnum> allowedScopeLevels) {
    this.allowedScopeLevels = allowedScopeLevels;
    return this;
  }

  
  @Schema(description = "Allowed scope levels for this Resource Group.")
  @JsonProperty("allowed_scope_levels")

  public List<AllowedScopeLevelsEnum> getAllowedScopeLevels() {
    return allowedScopeLevels;
  }
  public void setAllowedScopeLevels(List<AllowedScopeLevelsEnum> allowedScopeLevels) {
    this.allowedScopeLevels = allowedScopeLevels;
  }

  /**
   * Included scopes for the resources belonging to the Resource Group.
   **/
  public ResourceGroupsResponse includedScope(List<ResourceGroupScope> includedScope) {
    this.includedScope = includedScope;
    return this;
  }

  
  @Schema(description = "Included scopes for the resources belonging to the Resource Group.")
  @JsonProperty("included_scope")

  public List<ResourceGroupScope> getIncludedScope() {
    return includedScope;
  }
  public void setIncludedScope(List<ResourceGroupScope> includedScope) {
    this.includedScope = includedScope;
  }

  /**
   * Specifies the actual resources present in the Resource Group.
   **/
  public ResourceGroupsResponse resourceFilter(List<ResourceFilter> resourceFilter) {
    this.resourceFilter = resourceFilter;
    return this;
  }

  
  @Schema(description = "Specifies the actual resources present in the Resource Group.")
  @JsonProperty("resource_filter")

  public List<ResourceFilter> getResourceFilter() {
    return resourceFilter;
  }
  public void setResourceFilter(List<ResourceFilter> resourceFilter) {
    this.resourceFilter = resourceFilter;
  }

  /**
   * Boolean value for including all resources in Resource Group.
   **/
  public ResourceGroupsResponse includeAllResources(Boolean includeAllResources) {
    this.includeAllResources = includeAllResources;
    return this;
  }

  
  @Schema(description = "Boolean value for including all resources in Resource Group.")
  @JsonProperty("include_all_resources")

  public Boolean isIncludeAllResources() {
    return includeAllResources;
  }
  public void setIncludeAllResources(Boolean includeAllResources) {
    this.includeAllResources = includeAllResources;
  }

  /**
   * This indicates if this Resource Group is managed by Harness or not. If true, Harness can manage and modify this Resource Group.
   **/
  public ResourceGroupsResponse harnessManaged(Boolean harnessManaged) {
    this.harnessManaged = harnessManaged;
    return this;
  }

  
  @Schema(description = "This indicates if this Resource Group is managed by Harness or not. If true, Harness can manage and modify this Resource Group.")
  @JsonProperty("harness_managed")

  public Boolean isHarnessManaged() {
    return harnessManaged;
  }
  public void setHarnessManaged(Boolean harnessManaged) {
    this.harnessManaged = harnessManaged;
  }

  /**
   * Creation timestamp for Resource Group.
   **/
  public ResourceGroupsResponse created(Long created) {
    this.created = created;
    return this;
  }

  
  @Schema(description = "Creation timestamp for Resource Group.")
  @JsonProperty("created")

  public Long getCreated() {
    return created;
  }
  public void setCreated(Long created) {
    this.created = created;
  }

  /**
   * Last modification timestamp for Resource Group.
   **/
  public ResourceGroupsResponse updated(Long updated) {
    this.updated = updated;
    return this;
  }

  
  @Schema(description = "Last modification timestamp for Resource Group.")
  @JsonProperty("updated")

  public Long getUpdated() {
    return updated;
  }
  public void setUpdated(Long updated) {
    this.updated = updated;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResourceGroupsResponse resourceGroupsResponse = (ResourceGroupsResponse) o;
    return Objects.equals(slug, resourceGroupsResponse.slug) &&
        Objects.equals(name, resourceGroupsResponse.name) &&
        Objects.equals(color, resourceGroupsResponse.color) &&
        Objects.equals(tags, resourceGroupsResponse.tags) &&
        Objects.equals(description, resourceGroupsResponse.description) &&
        Objects.equals(allowedScopeLevels, resourceGroupsResponse.allowedScopeLevels) &&
        Objects.equals(includedScope, resourceGroupsResponse.includedScope) &&
        Objects.equals(resourceFilter, resourceGroupsResponse.resourceFilter) &&
        Objects.equals(includeAllResources, resourceGroupsResponse.includeAllResources) &&
        Objects.equals(harnessManaged, resourceGroupsResponse.harnessManaged) &&
        Objects.equals(created, resourceGroupsResponse.created) &&
        Objects.equals(updated, resourceGroupsResponse.updated);
  }

  @Override
  public int hashCode() {
    return Objects.hash(slug, name, color, tags, description, allowedScopeLevels, includedScope, resourceFilter, includeAllResources, harnessManaged, created, updated);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResourceGroupsResponse {\n");
    
    sb.append("    slug: ").append(toIndentedString(slug)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    color: ").append(toIndentedString(color)).append("\n");
    sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    allowedScopeLevels: ").append(toIndentedString(allowedScopeLevels)).append("\n");
    sb.append("    includedScope: ").append(toIndentedString(includedScope)).append("\n");
    sb.append("    resourceFilter: ").append(toIndentedString(resourceFilter)).append("\n");
    sb.append("    includeAllResources: ").append(toIndentedString(includeAllResources)).append("\n");
    sb.append("    harnessManaged: ").append(toIndentedString(harnessManaged)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    updated: ").append(toIndentedString(updated)).append("\n");
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
