package io.harness.spec.server.platform.model;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * Filter by whether the Resource Group has a particular Resource.
 **/
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

@Schema(description = "Filter by whether the Resource Group has a particular Resource.")

public class ResourceSelectorFilter   {

  private @Valid String resourceType = null;

  private @Valid String resourceSlug = null;

  /**
   * Filter by Resource type
   **/
  public ResourceSelectorFilter resourceType(String resourceType) {
    this.resourceType = resourceType;
    return this;
  }

  
  @Schema(required = true, description = "Filter by Resource type")
  @JsonProperty("resource_type")
  @NotNull

  public String getResourceType() {
    return resourceType;
  }
  public void setResourceType(String resourceType) {
    this.resourceType = resourceType;
  }

  /**
   * Filter by Resource identifier
   **/
  public ResourceSelectorFilter resourceSlug(String resourceSlug) {
    this.resourceSlug = resourceSlug;
    return this;
  }

  
  @Schema(description = "Filter by Resource identifier")
  @JsonProperty("resource_slug")
 @Pattern(regexp="^[a-zA-Z_][0-9a-zA-Z_$]{0,63}$") @Size(min=1,max=64)
  public String getResourceSlug() {
    return resourceSlug;
  }
  public void setResourceSlug(String resourceSlug) {
    this.resourceSlug = resourceSlug;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResourceSelectorFilter resourceSelectorFilter = (ResourceSelectorFilter) o;
    return Objects.equals(resourceType, resourceSelectorFilter.resourceType) &&
        Objects.equals(resourceSlug, resourceSelectorFilter.resourceSlug);
  }

  @Override
  public int hashCode() {
    return Objects.hash(resourceType, resourceSlug);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResourceSelectorFilter {\n");
    
    sb.append("    resourceType: ").append(toIndentedString(resourceType)).append("\n");
    sb.append("    resourceSlug: ").append(toIndentedString(resourceSlug)).append("\n");
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
