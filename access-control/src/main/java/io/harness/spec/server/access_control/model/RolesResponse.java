package io.harness.spec.server.access_control.model;

import io.harness.spec.server.access_control.model.RoleScope;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * Role Response Model
 **/
import io.swagger.annotations.*;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
@Schema(description = "Role Response Model")

public class RolesResponse   {

  private @Valid String slug = null;

  private @Valid String name = null;

  private @Valid List<String> permissions = new ArrayList<String>();

public enum AllowedScopeLevelsEnum {

    ACCOUNT(String.valueOf("account")), ORGANIZATION(String.valueOf("organization")), PROJECT(String.valueOf("project"));


    private String value;

    AllowedScopeLevelsEnum (String v) {
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
    public static AllowedScopeLevelsEnum fromValue(String v) {
        for (AllowedScopeLevelsEnum b : AllowedScopeLevelsEnum.values()) {
            if (String.valueOf(b.value).equals(v)) {
                return b;
            }
        }
        return null;
    }
}
  private @Valid List<AllowedScopeLevelsEnum> allowedScopeLevels = new ArrayList<AllowedScopeLevelsEnum>();

  private @Valid String description = null;

  private @Valid Object tags = null;

  private @Valid RoleScope scope = null;

  private @Valid Boolean harnessManaged = null;

  private @Valid Long createdAt = null;

  private @Valid Long lastModifiedAt = null;

  /**
   * Role Identifier
   **/
  public RolesResponse slug(String slug) {
    this.slug = slug;
    return this;
  }

  
  @ApiModelProperty(value = "Role Identifier")
  @JsonProperty("slug")

  public String getSlug() {
    return slug;
  }
  public void setSlug(String slug) {
    this.slug = slug;
  }

  /**
   * Role Name
   **/
  public RolesResponse name(String name) {
    this.name = name;
    return this;
  }

  
  @ApiModelProperty(value = "Role Name")
  @JsonProperty("name")

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Permissions for this Role.
   **/
  public RolesResponse permissions(List<String> permissions) {
    this.permissions = permissions;
    return this;
  }

  
  @ApiModelProperty(value = "Permissions for this Role.")
  @JsonProperty("permissions")

  public List<String> getPermissions() {
    return permissions;
  }
  public void setPermissions(List<String> permissions) {
    this.permissions = permissions;
  }

  /**
   * Allowed Scope Levels for this Role.
   **/
  public RolesResponse allowedScopeLevels(List<AllowedScopeLevelsEnum> allowedScopeLevels) {
    this.allowedScopeLevels = allowedScopeLevels;
    return this;
  }

  
  @ApiModelProperty(value = "Allowed Scope Levels for this Role.")
  @JsonProperty("allowed_scope_levels")

  public List<AllowedScopeLevelsEnum> getAllowedScopeLevels() {
    return allowedScopeLevels;
  }
  public void setAllowedScopeLevels(List<AllowedScopeLevelsEnum> allowedScopeLevels) {
    this.allowedScopeLevels = allowedScopeLevels;
  }

  /**
   * Role description
   **/
  public RolesResponse description(String description) {
    this.description = description;
    return this;
  }

  
  @ApiModelProperty(value = "Role description")
  @JsonProperty("description")

  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * Role tags
   **/
  public RolesResponse tags(Object tags) {
    this.tags = tags;
    return this;
  }

  
  @ApiModelProperty(value = "Role tags")
  @JsonProperty("tags")

  public Object getTags() {
    return tags;
  }
  public void setTags(Object tags) {
    this.tags = tags;
  }

  /**
   **/
  public RolesResponse scope(RoleScope scope) {
    this.scope = scope;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("scope")

  public RoleScope getScope() {
    return scope;
  }
  public void setScope(RoleScope scope) {
    this.scope = scope;
  }

  /**
   * This indicates if this Role is managed by Harness or not. If True, Harness can manage and modify this Role.
   **/
  public RolesResponse harnessManaged(Boolean harnessManaged) {
    this.harnessManaged = harnessManaged;
    return this;
  }

  
  @ApiModelProperty(value = "This indicates if this Role is managed by Harness or not. If True, Harness can manage and modify this Role.")
  @JsonProperty("harness_managed")

  public Boolean isHarnessManaged() {
    return harnessManaged;
  }
  public void setHarnessManaged(Boolean harnessManaged) {
    this.harnessManaged = harnessManaged;
  }

  /**
   * Creation timestamp for Role.
   **/
  public RolesResponse createdAt(Long createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  
  @ApiModelProperty(value = "Creation timestamp for Role.")
  @JsonProperty("created_at")

  public Long getCreatedAt() {
    return createdAt;
  }
  public void setCreatedAt(Long createdAt) {
    this.createdAt = createdAt;
  }

  /**
   * Last modification timestamp for Role.
   **/
  public RolesResponse lastModifiedAt(Long lastModifiedAt) {
    this.lastModifiedAt = lastModifiedAt;
    return this;
  }

  
  @ApiModelProperty(value = "Last modification timestamp for Role.")
  @JsonProperty("last_modified_at")

  public Long getLastModifiedAt() {
    return lastModifiedAt;
  }
  public void setLastModifiedAt(Long lastModifiedAt) {
    this.lastModifiedAt = lastModifiedAt;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RolesResponse rolesResponse = (RolesResponse) o;
    return Objects.equals(slug, rolesResponse.slug) &&
        Objects.equals(name, rolesResponse.name) &&
        Objects.equals(permissions, rolesResponse.permissions) &&
        Objects.equals(allowedScopeLevels, rolesResponse.allowedScopeLevels) &&
        Objects.equals(description, rolesResponse.description) &&
        Objects.equals(tags, rolesResponse.tags) &&
        Objects.equals(scope, rolesResponse.scope) &&
        Objects.equals(harnessManaged, rolesResponse.harnessManaged) &&
        Objects.equals(createdAt, rolesResponse.createdAt) &&
        Objects.equals(lastModifiedAt, rolesResponse.lastModifiedAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(slug, name, permissions, allowedScopeLevels, description, tags, scope, harnessManaged, createdAt, lastModifiedAt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RolesResponse {\n");
    
    sb.append("    slug: ").append(toIndentedString(slug)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    permissions: ").append(toIndentedString(permissions)).append("\n");
    sb.append("    allowedScopeLevels: ").append(toIndentedString(allowedScopeLevels)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
    sb.append("    scope: ").append(toIndentedString(scope)).append("\n");
    sb.append("    harnessManaged: ").append(toIndentedString(harnessManaged)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    lastModifiedAt: ").append(toIndentedString(lastModifiedAt)).append("\n");
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
