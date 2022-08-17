package io.harness.spec.server.ng.model;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * Organization response Model
 **/
import io.swagger.annotations.*;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.v3.oas.annotations.media.Schema;



@Schema(description = "Organization response Model")

public class OrganizationResponse   {

  private @Valid Long createdAt = null;

  private @Valid Long lastModifiedAt = null;

  private @Valid Boolean harnessManaged = null;

  private @Valid String slug = null;

  private @Valid String name = null;

  private @Valid String description = null;

  private @Valid Map<String, String> tags = new HashMap<>();

  /**
   * Creation timestamp for organization
   **/
  public OrganizationResponse createdAt(Long createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  
  @Schema(description = "Creation timestamp for organization")
  @JsonProperty("created_at")

  public Long getCreatedAt() {
    return createdAt;
  }
  public void setCreatedAt(Long createdAt) {
    this.createdAt = createdAt;
  }

  /**
   * Last modification timestamp for organization
   **/
  public OrganizationResponse lastModifiedAt(Long lastModifiedAt) {
    this.lastModifiedAt = lastModifiedAt;
    return this;
  }

  
  @Schema(description = "Last modification timestamp for organization")
  @JsonProperty("last_modified_at")

  public Long getLastModifiedAt() {
    return lastModifiedAt;
  }
  public void setLastModifiedAt(Long lastModifiedAt) {
    this.lastModifiedAt = lastModifiedAt;
  }

  /**
   * This indicates if this organization is managed by Harness or not. If true, Harness can manage and modify this organization.
   **/
  public OrganizationResponse harnessManaged(Boolean harnessManaged) {
    this.harnessManaged = harnessManaged;
    return this;
  }

  
  @Schema(description = "This indicates if this organization is managed by Harness or not. If true, Harness can manage and modify this organization.")
  @JsonProperty("harness_managed")

  public Boolean isHarnessManaged() {
    return harnessManaged;
  }
  public void setHarnessManaged(Boolean harnessManaged) {
    this.harnessManaged = harnessManaged;
  }

  /**
   * Organization slug
   **/
  public OrganizationResponse slug(String slug) {
    this.slug = slug;
    return this;
  }

  
  @Schema(description = "Organization slug")
  @JsonProperty("slug")

  public String getSlug() {
    return slug;
  }
  public void setSlug(String slug) {
    this.slug = slug;
  }

  /**
   * Organization name
   **/
  public OrganizationResponse name(String name) {
    this.name = name;
    return this;
  }

  
  @Schema(description = "Organization name")
  @JsonProperty("name")

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Organization description
   **/
  public OrganizationResponse description(String description) {
    this.description = description;
    return this;
  }

  
  @Schema(description = "Organization description")
  @JsonProperty("description")

  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * Organization tags
   **/
  public OrganizationResponse tags(Map<String, String> tags) {
    this.tags = tags;
    return this;
  }

  
  @Schema(description = "Organization tags")
  @JsonProperty("tags")

  public Map<String, String> getTags() {
    return tags;
  }
  public void setTags(Map<String, String> tags) {
    this.tags = tags;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrganizationResponse organizationResponse = (OrganizationResponse) o;
    return Objects.equals(createdAt, organizationResponse.createdAt) &&
        Objects.equals(lastModifiedAt, organizationResponse.lastModifiedAt) &&
        Objects.equals(harnessManaged, organizationResponse.harnessManaged) &&
        Objects.equals(slug, organizationResponse.slug) &&
        Objects.equals(name, organizationResponse.name) &&
        Objects.equals(description, organizationResponse.description) &&
        Objects.equals(tags, organizationResponse.tags);
  }

  @Override
  public int hashCode() {
    return Objects.hash(createdAt, lastModifiedAt, harnessManaged, slug, name, description, tags);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrganizationResponse {\n");
    
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    lastModifiedAt: ").append(toIndentedString(lastModifiedAt)).append("\n");
    sb.append("    harnessManaged: ").append(toIndentedString(harnessManaged)).append("\n");
    sb.append("    slug: ").append(toIndentedString(slug)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
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
