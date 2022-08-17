package io.harness.spec.server.accesscontrol.model;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * Create Role request
 **/
import io.swagger.annotations.*;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

@Schema(description = "Create Role request")

public class CreateRoleRequest   {

  private @Valid String slug = null;

  private @Valid String name = null;

  private @Valid List<String> permissions = new ArrayList<String>();

  private @Valid String description = null;

  private @Valid Object tags = null;

  /**
   * Role identifier
   **/
  public CreateRoleRequest slug(String slug) {
    this.slug = slug;
    return this;
  }

  
  @Schema(required = true, description = "Role identifier")
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
   * Role name
   **/
  public CreateRoleRequest name(String name) {
    this.name = name;
    return this;
  }

  
  @Schema(required = true, description = "Role name")
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
   * List of the permission identifiers.
   **/
  public CreateRoleRequest permissions(List<String> permissions) {
    this.permissions = permissions;
    return this;
  }

  
  @Schema(description = "List of the permission identifiers.")
  @JsonProperty("permissions")

  public List<String> getPermissions() {
    return permissions;
  }
  public void setPermissions(List<String> permissions) {
    this.permissions = permissions;
  }

  /**
   * Role description
   **/
  public CreateRoleRequest description(String description) {
    this.description = description;
    return this;
  }

  
  @Schema(description = "Role description")
  @JsonProperty("description")
 @Size(max=1024)
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * Role tags
   **/
  public CreateRoleRequest tags(Object tags) {
    this.tags = tags;
    return this;
  }

  
  @Schema(description = "Role tags")
  @JsonProperty("tags")

  public Object getTags() {
    return tags;
  }
  public void setTags(Object tags) {
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
    CreateRoleRequest createRoleRequest = (CreateRoleRequest) o;
    return Objects.equals(slug, createRoleRequest.slug) &&
        Objects.equals(name, createRoleRequest.name) &&
        Objects.equals(permissions, createRoleRequest.permissions) &&
        Objects.equals(description, createRoleRequest.description) &&
        Objects.equals(tags, createRoleRequest.tags);
  }

  @Override
  public int hashCode() {
    return Objects.hash(slug, name, permissions, description, tags);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateRoleRequest {\n");
    
    sb.append("    slug: ").append(toIndentedString(slug)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    permissions: ").append(toIndentedString(permissions)).append("\n");
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
