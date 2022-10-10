package io.harness.spec.server.ng.model;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * This is the Environment entity defined in Harness
 **/
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.v3.oas.annotations.media.Schema;



@Schema(description = "This is the Environment entity defined in Harness")

public class Environment   {

  private @Valid String account = null;

  private @Valid String slug = null;

  private @Valid String org = null;

  private @Valid String project = null;

  private @Valid String name = null;

  private @Valid String description = null;

  private @Valid Map<String, String> tags = new HashMap<>();

  private @Valid String yaml = null;

  private @Valid String color = null;

public enum TypeEnum {

    PREPRODUCTION(String.valueOf("PreProduction")), PRODUCTION(String.valueOf("Production"));


    private String value;

    TypeEnum (String v) {
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
    public static TypeEnum fromValue(String v) {
        for (TypeEnum b : TypeEnum.values()) {
            if (String.valueOf(b.value).equals(v)) {
                return b;
            }
        }
        return null;
    }
}
  private @Valid TypeEnum type = null;

  /**
   * Account Identifier
   **/
  public Environment account(String account) {
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
   * Identifier of the Environment Request.
   **/
  public Environment slug(String slug) {
    this.slug = slug;
    return this;
  }

  
  @Schema(required = true, description = "Identifier of the Environment Request.")
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
  public Environment org(String org) {
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
  public Environment project(String project) {
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
   * Name of the Environment Request.
   **/
  public Environment name(String name) {
    this.name = name;
    return this;
  }

  
  @Schema(required = true, description = "Name of the Environment Request.")
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
  public Environment description(String description) {
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
   * Environment tags
   **/
  public Environment tags(Map<String, String> tags) {
    this.tags = tags;
    return this;
  }

  
  @Schema(description = "Environment tags")
  @JsonProperty("tags")
 @Size(max=128)
  public Map<String, String> getTags() {
    return tags;
  }
  public void setTags(Map<String, String> tags) {
    this.tags = tags;
  }

  /**
   * Yaml related to environment
   **/
  public Environment yaml(String yaml) {
    this.yaml = yaml;
    return this;
  }

  
  @Schema(description = "Yaml related to environment")
  @JsonProperty("yaml")

  public String getYaml() {
    return yaml;
  }
  public void setYaml(String yaml) {
    this.yaml = yaml;
  }

  /**
   * Color of the Environment
   **/
  public Environment color(String color) {
    this.color = color;
    return this;
  }

  
  @Schema(description = "Color of the Environment")
  @JsonProperty("color")

  public String getColor() {
    return color;
  }
  public void setColor(String color) {
    this.color = color;
  }

  /**
   * Specify the environment type whether production or Preproduction.
   **/
  public Environment type(TypeEnum type) {
    this.type = type;
    return this;
  }

  
  @Schema(description = "Specify the environment type whether production or Preproduction.")
  @JsonProperty("type")

  public TypeEnum getType() {
    return type;
  }
  public void setType(TypeEnum type) {
    this.type = type;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Environment environment = (Environment) o;
    return Objects.equals(account, environment.account) &&
        Objects.equals(slug, environment.slug) &&
        Objects.equals(org, environment.org) &&
        Objects.equals(project, environment.project) &&
        Objects.equals(name, environment.name) &&
        Objects.equals(description, environment.description) &&
        Objects.equals(tags, environment.tags) &&
        Objects.equals(yaml, environment.yaml) &&
        Objects.equals(color, environment.color) &&
        Objects.equals(type, environment.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(account, slug, org, project, name, description, tags, yaml, color, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Environment {\n");
    
    sb.append("    account: ").append(toIndentedString(account)).append("\n");
    sb.append("    slug: ").append(toIndentedString(slug)).append("\n");
    sb.append("    org: ").append(toIndentedString(org)).append("\n");
    sb.append("    project: ").append(toIndentedString(project)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
    sb.append("    yaml: ").append(toIndentedString(yaml)).append("\n");
    sb.append("    color: ").append(toIndentedString(color)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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
