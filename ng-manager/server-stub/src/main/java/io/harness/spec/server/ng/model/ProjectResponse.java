package io.harness.spec.server.ng.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;



@Schema(description = "Project response model")

public class ProjectResponse   {

  private @Valid Long created = null;

  private @Valid Long updated = null;

  private @Valid String org = null;

  private @Valid String slug = null;

  private @Valid String name = null;

  private @Valid String color = null;

  private @Valid List<ModuleType> modules = new ArrayList<>();

  private @Valid String description = null;

  private @Valid Map<String, String> tags = new HashMap<>();

  /**
   * Creation timestamp for the project
   **/
  public ProjectResponse created(Long created) {
    this.created = created;
    return this;
  }

  
  @Schema(description = "Creation timestamp for the project")
  @JsonProperty("created")

  public Long getCreated() {
    return created;
  }
  public void setCreated(Long created) {
    this.created = created;
  }

  /**
   * Updated timestamp for the project
   **/
  public ProjectResponse updated(Long updated) {
    this.updated = updated;
    return this;
  }

  
  @Schema(description = "Updated timestamp for the project")
  @JsonProperty("updated")

  public Long getUpdated() {
    return updated;
  }
  public void setUpdated(Long updated) {
    this.updated = updated;
  }

  /**
   * Organization slug for the project
   **/
  public ProjectResponse org(String org) {
    this.org = org;
    return this;
  }

  
  @Schema(description = "Organization slug for the project")
  @JsonProperty("org")

  public String getOrg() {
    return org;
  }
  public void setOrg(String org) {
    this.org = org;
  }

  /**
   * Project slug
   **/
  public ProjectResponse slug(String slug) {
    this.slug = slug;
    return this;
  }

  
  @Schema(description = "Project slug")
  @JsonProperty("slug")

  public String getSlug() {
    return slug;
  }
  public void setSlug(String slug) {
    this.slug = slug;
  }

  /**
   * Project name
   **/
  public ProjectResponse name(String name) {
    this.name = name;
    return this;
  }

  
  @Schema(description = "Project name")
  @JsonProperty("name")

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Project color
   **/
  public ProjectResponse color(String color) {
    this.color = color;
    return this;
  }

  
  @Schema(description = "Project color")
  @JsonProperty("color")

  public String getColor() {
    return color;
  }
  public void setColor(String color) {
    this.color = color;
  }

  /**
   * List of module for project
   **/
  public ProjectResponse modules(List<ModuleType> modules) {
    this.modules = modules;
    return this;
  }

  
  @Schema(description = "List of module for project")
  @JsonProperty("modules")

  public List<ModuleType> getModules() {
    return modules;
  }
  public void setModules(List<ModuleType> modules) {
    this.modules = modules;
  }

  /**
   * Project description
   **/
  public ProjectResponse description(String description) {
    this.description = description;
    return this;
  }

  
  @Schema(description = "Project description")
  @JsonProperty("description")

  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * Project tags
   **/
  public ProjectResponse tags(Map<String, String> tags) {
    this.tags = tags;
    return this;
  }

  
  @Schema(description = "Project tags")
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
    ProjectResponse projectResponse = (ProjectResponse) o;
    return Objects.equals(created, projectResponse.created) &&
        Objects.equals(updated, projectResponse.updated) &&
        Objects.equals(org, projectResponse.org) &&
        Objects.equals(slug, projectResponse.slug) &&
        Objects.equals(name, projectResponse.name) &&
        Objects.equals(color, projectResponse.color) &&
        Objects.equals(modules, projectResponse.modules) &&
        Objects.equals(description, projectResponse.description) &&
        Objects.equals(tags, projectResponse.tags);
  }

  @Override
  public int hashCode() {
    return Objects.hash(created, updated, org, slug, name, color, modules, description, tags);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProjectResponse {\n");
    
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    updated: ").append(toIndentedString(updated)).append("\n");
    sb.append("    org: ").append(toIndentedString(org)).append("\n");
    sb.append("    slug: ").append(toIndentedString(slug)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    color: ").append(toIndentedString(color)).append("\n");
    sb.append("    modules: ").append(toIndentedString(modules)).append("\n");
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
