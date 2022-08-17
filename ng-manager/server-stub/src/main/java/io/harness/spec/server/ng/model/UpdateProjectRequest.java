package io.harness.spec.server.ng.model;

import io.harness.spec.server.ng.model.ModuleType;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * Update project request
 **/
import io.swagger.annotations.*;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.v3.oas.annotations.media.Schema;



@Schema(description = "Update project request")

public class UpdateProjectRequest   {

  private @Valid String name = null;

  private @Valid String color = null;

  private @Valid List<ModuleType> modules = new ArrayList<>();

  private @Valid String description = null;

  private @Valid Map<String, String> tags = new HashMap<>();

  /**
   * Project name
   **/
  public UpdateProjectRequest name(String name) {
    this.name = name;
    return this;
  }

  
  @Schema(required = true, description = "Project name")
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
   * Project color
   **/
  public UpdateProjectRequest color(String color) {
    this.color = color;
    return this;
  }

  
  @Schema(description = "Project color")
  @JsonProperty("color")
 @Size(min=1)
  public String getColor() {
    return color;
  }
  public void setColor(String color) {
    this.color = color;
  }

  /**
   * List of modules for project
   **/
  public UpdateProjectRequest modules(List<ModuleType> modules) {
    this.modules = modules;
    return this;
  }

  
  @Schema(description = "List of modules for project")
  @JsonProperty("modules")
 @Size(max=1024)
  public List<ModuleType> getModules() {
    return modules;
  }
  public void setModules(List<ModuleType> modules) {
    this.modules = modules;
  }

  /**
   * Project description
   **/
  public UpdateProjectRequest description(String description) {
    this.description = description;
    return this;
  }

  
  @Schema(description = "Project description")
  @JsonProperty("description")
 @Size(min=1,max=1024)
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * Project tags
   **/
  public UpdateProjectRequest tags(Map<String, String> tags) {
    this.tags = tags;
    return this;
  }

  
  @Schema(description = "Project tags")
  @JsonProperty("tags")
 @Size(max=128)
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
    UpdateProjectRequest updateProjectRequest = (UpdateProjectRequest) o;
    return Objects.equals(name, updateProjectRequest.name) &&
        Objects.equals(color, updateProjectRequest.color) &&
        Objects.equals(modules, updateProjectRequest.modules) &&
        Objects.equals(description, updateProjectRequest.description) &&
        Objects.equals(tags, updateProjectRequest.tags);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, color, modules, description, tags);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateProjectRequest {\n");
    
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
