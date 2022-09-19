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
 * Resource Group request body
 **/
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

@Schema(description = "Resource Group request body")

public class CreateResourceGroupRequest   {

  private @Valid String slug = null;

  private @Valid String name = null;

  private @Valid String color = null;

  private @Valid Map<String, String> tags = new HashMap<>();

  private @Valid String description = null;

  private @Valid List<ResourceGroupScope> includedScope = new ArrayList<>();

  private @Valid List<ResourceFilter> resourceFilter = new ArrayList<>();

  private @Valid Boolean includeAllResources = null;

  /**
   * Resource Group identifier
   **/
  public CreateResourceGroupRequest slug(String slug) {
    this.slug = slug;
    return this;
  }

  
  @Schema(required = true, description = "Resource Group identifier")
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
   * Resource Group name
   **/
  public CreateResourceGroupRequest name(String name) {
    this.name = name;
    return this;
  }

  
  @Schema(required = true, description = "Resource Group name")
  @JsonProperty("name")
  @NotNull
 @Pattern(regexp="^[a-zA-Z_][0-9a-zA-Z-_ ]{0,63}$") @Size(min=1,max=64)
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Color associated with the Resource Group.
   **/
  public CreateResourceGroupRequest color(String color) {
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
  public CreateResourceGroupRequest tags(Map<String, String> tags) {
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
  public CreateResourceGroupRequest description(String description) {
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
   * Included scopes for the resources belonging to the Resource Group.
   **/
  public CreateResourceGroupRequest includedScope(List<ResourceGroupScope> includedScope) {
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
  public CreateResourceGroupRequest resourceFilter(List<ResourceFilter> resourceFilter) {
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
  public CreateResourceGroupRequest includeAllResources(Boolean includeAllResources) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateResourceGroupRequest createResourceGroupRequest = (CreateResourceGroupRequest) o;
    return Objects.equals(slug, createResourceGroupRequest.slug) &&
        Objects.equals(name, createResourceGroupRequest.name) &&
        Objects.equals(color, createResourceGroupRequest.color) &&
        Objects.equals(tags, createResourceGroupRequest.tags) &&
        Objects.equals(description, createResourceGroupRequest.description) &&
        Objects.equals(includedScope, createResourceGroupRequest.includedScope) &&
        Objects.equals(resourceFilter, createResourceGroupRequest.resourceFilter) &&
        Objects.equals(includeAllResources, createResourceGroupRequest.includeAllResources);
  }

  @Override
  public int hashCode() {
    return Objects.hash(slug, name, color, tags, description, includedScope, resourceFilter, includeAllResources);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateResourceGroupRequest {\n");
    
    sb.append("    slug: ").append(toIndentedString(slug)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    color: ").append(toIndentedString(color)).append("\n");
    sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    includedScope: ").append(toIndentedString(includedScope)).append("\n");
    sb.append("    resourceFilter: ").append(toIndentedString(resourceFilter)).append("\n");
    sb.append("    includeAllResources: ").append(toIndentedString(includeAllResources)).append("\n");
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
