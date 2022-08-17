package io.harness.spec.server.ng.model;

import io.harness.spec.server.ng.model.SecretSpec;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.constraints.*;
import javax.validation.Valid;


import io.swagger.annotations.*;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.v3.oas.annotations.media.Schema;





public class Secret   {

  private @Valid String name = null;

  private @Valid String slug = null;

  private @Valid String org = null;

  private @Valid String project = null;

  private @Valid Map<String, String> tags = new HashMap<>();

  private @Valid String description = null;

  private @Valid SecretSpec spec = null;

  /**
   * Secret name
   **/
  public Secret name(String name) {
    this.name = name;
    return this;
  }

  
  @Schema(description = "Secret name")
  @JsonProperty("name")
 @Pattern(regexp="^[0-9a-zA-Z-_ ]{0,63}$")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Secret slug
   **/
  public Secret slug(String slug) {
    this.slug = slug;
    return this;
  }

  
  @Schema(description = "Secret slug")
  @JsonProperty("slug")
 @Pattern(regexp="^[a-zA-Z_][0-9a-zA-Z_$]{0,63}$") @Size(min=1,max=64)
  public String getSlug() {
    return slug;
  }
  public void setSlug(String slug) {
    this.slug = slug;
  }

  /**
   * Organization slug for secret
   **/
  public Secret org(String org) {
    this.org = org;
    return this;
  }

  
  @Schema(description = "Organization slug for secret")
  @JsonProperty("org")
 @Pattern(regexp="^[a-zA-Z_][0-9a-zA-Z-_ ]{0,63}$")
  public String getOrg() {
    return org;
  }
  public void setOrg(String org) {
    this.org = org;
  }

  /**
   * Project slug for secret
   **/
  public Secret project(String project) {
    this.project = project;
    return this;
  }

  
  @Schema(description = "Project slug for secret")
  @JsonProperty("project")
 @Pattern(regexp="^[a-zA-Z_][0-9a-zA-Z-_ ]{0,63}$")
  public String getProject() {
    return project;
  }
  public void setProject(String project) {
    this.project = project;
  }

  /**
   * Secret tags
   **/
  public Secret tags(Map<String, String> tags) {
    this.tags = tags;
    return this;
  }

  
  @Schema(description = "Secret tags")
  @JsonProperty("tags")

  public Map<String, String> getTags() {
    return tags;
  }
  public void setTags(Map<String, String> tags) {
    this.tags = tags;
  }

  /**
   * Secret description
   **/
  public Secret description(String description) {
    this.description = description;
    return this;
  }

  
  @Schema(description = "Secret description")
  @JsonProperty("description")

  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   **/
  public Secret spec(SecretSpec spec) {
    this.spec = spec;
    return this;
  }

  
  @Schema(description = "")
  @JsonProperty("spec")

  public SecretSpec getSpec() {
    return spec;
  }
  public void setSpec(SecretSpec spec) {
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
    Secret secret = (Secret) o;
    return Objects.equals(name, secret.name) &&
        Objects.equals(slug, secret.slug) &&
        Objects.equals(org, secret.org) &&
        Objects.equals(project, secret.project) &&
        Objects.equals(tags, secret.tags) &&
        Objects.equals(description, secret.description) &&
        Objects.equals(spec, secret.spec);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, slug, org, project, tags, description, spec);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Secret {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    slug: ").append(toIndentedString(slug)).append("\n");
    sb.append("    org: ").append(toIndentedString(org)).append("\n");
    sb.append("    project: ").append(toIndentedString(project)).append("\n");
    sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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
