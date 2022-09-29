package io.harness.spec.server.ng.model;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * This is the Service entity defined in Harness
 **/
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

@Schema(description = "This is the Service entity defined in Harness")

public class Service   {

  private @Valid String account = null;

  private @Valid String slug = null;

  private @Valid String org = null;

  private @Valid String project = null;

  private @Valid String name = null;

  private @Valid String description = null;

  private @Valid Map<String, String> tags = new HashMap<>();

  private @Valid String yaml = null;

  /**
   * Account Identifier
   **/
  public Service account(String account) {
    this.account = account;
    return this;
  }

  
  @Schema(description = "Account Identifier")
  @JsonProperty("account")
 @Pattern(regexp="^[a-zA-Z_][0-9a-zA-Z_$]{0,63}$") @Size(min=1,max=64)
  public String getAccount() {
    return account;
  }
  public void setAccount(String account) {
    this.account = account;
  }

  /**
   * Identifier of the Service Request.
   **/
  public Service slug(String slug) {
    this.slug = slug;
    return this;
  }

  
  @Schema(required = true, description = "Identifier of the Service Request.")
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
   * Organization Identifier for the Entity.
   **/
  public Service org(String org) {
    this.org = org;
    return this;
  }

  
  @Schema(description = "Organization Identifier for the Entity.")
  @JsonProperty("org")
 @Pattern(regexp="^[a-zA-Z_][0-9a-zA-Z_$]{0,63}$") @Size(min=1,max=64)
  public String getOrg() {
    return org;
  }
  public void setOrg(String org) {
    this.org = org;
  }

  /**
   * Project Identifier for the Entity.
   **/
  public Service project(String project) {
    this.project = project;
    return this;
  }

  
  @Schema(description = "Project Identifier for the Entity.")
  @JsonProperty("project")
 @Pattern(regexp="^[a-zA-Z_][0-9a-zA-Z_$]{0,63}$") @Size(min=1,max=64)
  public String getProject() {
    return project;
  }
  public void setProject(String project) {
    this.project = project;
  }

  /**
   * Name of the Service Request.
   **/
  public Service name(String name) {
    this.name = name;
    return this;
  }

  
  @Schema(required = true, description = "Name of the Service Request.")
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
   * Description of the entity
   **/
  public Service description(String description) {
    this.description = description;
    return this;
  }

  
  @Schema(description = "Description of the entity")
  @JsonProperty("description")
 @Size(max=1024)
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * Service tags
   **/
  public Service tags(Map<String, String> tags) {
    this.tags = tags;
    return this;
  }

  
  @Schema(description = "Service tags")
  @JsonProperty("tags")
 @Size(max=128)
  public Map<String, String> getTags() {
    return tags;
  }
  public void setTags(Map<String, String> tags) {
    this.tags = tags;
  }

  /**
   * Yaml related to service
   **/
  public Service yaml(String yaml) {
    this.yaml = yaml;
    return this;
  }

  
  @Schema(description = "Yaml related to service")
  @JsonProperty("yaml")

  public String getYaml() {
    return yaml;
  }
  public void setYaml(String yaml) {
    this.yaml = yaml;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Service service = (Service) o;
    return Objects.equals(account, service.account) &&
        Objects.equals(slug, service.slug) &&
        Objects.equals(org, service.org) &&
        Objects.equals(project, service.project) &&
        Objects.equals(name, service.name) &&
        Objects.equals(description, service.description) &&
        Objects.equals(tags, service.tags) &&
        Objects.equals(yaml, service.yaml);
  }

  @Override
  public int hashCode() {
    return Objects.hash(account, slug, org, project, name, description, tags, yaml);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Service {\n");
    
    sb.append("    account: ").append(toIndentedString(account)).append("\n");
    sb.append("    slug: ").append(toIndentedString(slug)).append("\n");
    sb.append("    org: ").append(toIndentedString(org)).append("\n");
    sb.append("    project: ").append(toIndentedString(project)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
    sb.append("    yaml: ").append(toIndentedString(yaml)).append("\n");
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
