package io.harness.spec.server.ng.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;



@Schema(description = "Organization response Model")

public class OrganizationResponse   {

  private @Valid Long created = null;

  private @Valid Long updated = null;

  private @Valid Boolean harnessManaged = null;

  private @Valid String slug = null;

  private @Valid String name = null;

  private @Valid String description = null;

  private @Valid Map<String, String> tags = new HashMap<>();

  /**
   * Creation timestamp for organization
   **/
  public OrganizationResponse created(Long created) {
    this.created = created;
    return this;
  }

  
  @Schema(description = "Creation timestamp for organization")
  @JsonProperty("created")

  public Long getCreated() {
    return created;
  }
  public void setCreated(Long created) {
    this.created = created;
  }

  /**
   * Updated timestamp for organization
   **/
  public OrganizationResponse updated(Long updated) {
    this.updated = updated;
    return this;
  }

  
  @Schema(description = "Updated timestamp for organization")
  @JsonProperty("updated")

  public Long getUpdated() {
    return updated;
  }
  public void setUpdated(Long updated) {
    this.updated = updated;
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
    return Objects.equals(created, organizationResponse.created) &&
        Objects.equals(updated, organizationResponse.updated) &&
        Objects.equals(harnessManaged, organizationResponse.harnessManaged) &&
        Objects.equals(slug, organizationResponse.slug) &&
        Objects.equals(name, organizationResponse.name) &&
        Objects.equals(description, organizationResponse.description) &&
        Objects.equals(tags, organizationResponse.tags);
  }

  @Override
  public int hashCode() {
    return Objects.hash(created, updated, harnessManaged, slug, name, description, tags);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrganizationResponse {\n");
    
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    updated: ").append(toIndentedString(updated)).append("\n");
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
