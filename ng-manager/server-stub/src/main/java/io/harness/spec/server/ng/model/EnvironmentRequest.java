package io.harness.spec.server.ng.model;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * Environment Request Body 
 **/
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.v3.oas.annotations.media.Schema;



@Schema(description = "Environment Request Body ")

public class EnvironmentRequest   {

  private @Valid String slug = null;

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
   * Identifier of the Environment
   **/
  public EnvironmentRequest slug(String slug) {
    this.slug = slug;
    return this;
  }

  
  @Schema(required = true, description = "Identifier of the Environment")
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
   * Name of the Environment
   **/
  public EnvironmentRequest name(String name) {
    this.name = name;
    return this;
  }

  
  @Schema(required = true, description = "Name of the Environment")
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
  public EnvironmentRequest description(String description) {
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
  public EnvironmentRequest tags(Map<String, String> tags) {
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
   * YAML for the Environment Request
   **/
  public EnvironmentRequest yaml(String yaml) {
    this.yaml = yaml;
    return this;
  }

  
  @Schema(required = true, description = "YAML for the Environment Request")
  @JsonProperty("yaml")
  @NotNull

  public String getYaml() {
    return yaml;
  }
  public void setYaml(String yaml) {
    this.yaml = yaml;
  }

  /**
   * Color of the Environment
   **/
  public EnvironmentRequest color(String color) {
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
  public EnvironmentRequest type(TypeEnum type) {
    this.type = type;
    return this;
  }

  
  @Schema(required = true, description = "Specify the environment type whether production or Preproduction.")
  @JsonProperty("type")
  @NotNull

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
    EnvironmentRequest environmentRequest = (EnvironmentRequest) o;
    return Objects.equals(slug, environmentRequest.slug) &&
        Objects.equals(name, environmentRequest.name) &&
        Objects.equals(description, environmentRequest.description) &&
        Objects.equals(tags, environmentRequest.tags) &&
        Objects.equals(yaml, environmentRequest.yaml) &&
        Objects.equals(color, environmentRequest.color) &&
        Objects.equals(type, environmentRequest.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(slug, name, description, tags, yaml, color, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EnvironmentRequest {\n");
    
    sb.append("    slug: ").append(toIndentedString(slug)).append("\n");
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
