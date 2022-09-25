package io.harness.spec.server.ng.model;

import io.harness.spec.server.ng.model.ConnectorSpec;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.constraints.*;
import javax.validation.Valid;


import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.v3.oas.annotations.media.Schema;





public class Connector   {

  private @Valid String name = null;

  private @Valid String slug = null;

  private @Valid String description = null;

  private @Valid String org = null;

  private @Valid String project = null;

  private @Valid Map<String, String> tags = new HashMap<>();

  private @Valid ConnectorSpec spec = null;

  /**
   * Connector name
   **/
  public Connector name(String name) {
    this.name = name;
    return this;
  }

  
  @Schema(required = true, description = "Connector name")
  @JsonProperty("name")
  @NotNull
 @Pattern(regexp="^[0-9a-zA-Z-_ ]{0,63}$")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Connector slug
   **/
  public Connector slug(String slug) {
    this.slug = slug;
    return this;
  }

  
  @Schema(required = true, description = "Connector slug")
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
   * Connector description
   **/
  public Connector description(String description) {
    this.description = description;
    return this;
  }

  
  @Schema(description = "Connector description")
  @JsonProperty("description")

  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * Organization slug for connector
   **/
  public Connector org(String org) {
    this.org = org;
    return this;
  }

  
  @Schema(description = "Organization slug for connector")
  @JsonProperty("org")
 @Pattern(regexp="^[a-zA-Z_][0-9a-zA-Z-_ ]{0,63}$")
  public String getOrg() {
    return org;
  }
  public void setOrg(String org) {
    this.org = org;
  }

  /**
   * Project slug for connector
   **/
  public Connector project(String project) {
    this.project = project;
    return this;
  }

  
  @Schema(description = "Project slug for connector")
  @JsonProperty("project")
 @Pattern(regexp="^[a-zA-Z_][0-9a-zA-Z-_ ]{0,63}$")
  public String getProject() {
    return project;
  }
  public void setProject(String project) {
    this.project = project;
  }

  /**
   * Connector tags
   **/
  public Connector tags(Map<String, String> tags) {
    this.tags = tags;
    return this;
  }

  
  @Schema(description = "Connector tags")
  @JsonProperty("tags")

  public Map<String, String> getTags() {
    return tags;
  }
  public void setTags(Map<String, String> tags) {
    this.tags = tags;
  }

  /**
   **/
  public Connector spec(ConnectorSpec spec) {
    this.spec = spec;
    return this;
  }

  
  @Schema(required = true, description = "")
  @JsonProperty("spec")
  @NotNull

  public ConnectorSpec getSpec() {
    return spec;
  }
  public void setSpec(ConnectorSpec spec) {
    this.spec = spec;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Connector connector = (Connector) o;
    return Objects.equals(name, connector.name) &&
        Objects.equals(slug, connector.slug) &&
        Objects.equals(description, connector.description) &&
        Objects.equals(org, connector.org) &&
        Objects.equals(project, connector.project) &&
        Objects.equals(tags, connector.tags) &&
        Objects.equals(spec, connector.spec);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, slug, description, org, project, tags, spec);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Connector {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    slug: ").append(toIndentedString(slug)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    org: ").append(toIndentedString(org)).append("\n");
    sb.append("    project: ").append(toIndentedString(project)).append("\n");
    sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
    sb.append("    spec: ").append(toIndentedString(spec)).append("\n");
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
