package io.harness.spec.server.accesscontrol.model;

import io.harness.spec.server.accesscontrol.model.RoleScope;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * Role Response Model
 **/
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

@Schema(description = "Role Response Model")

public class RolesResponse   {

  private @Valid String slug = null;

  private @Valid String name = null;

  private @Valid List<String> permissions = new ArrayList<>();

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
  private @Valid List<AllowedScopeLevelsEnum> allowedScopeLevels = new ArrayList<>();

  private @Valid String description = null;

  private @Valid Map<String, String> tags = new HashMap<>();

  private @Valid RoleScope scope = null;

  private @Valid Long created = null;

  private @Valid Long updated = null;

  private @Valid Boolean harnessManaged = null;

  /**
   * Role Identifier
   **/
  public RolesResponse slug(String slug) {
    this.slug = slug;
    return this;
  }

  
  @Schema(required = true, description = "Role Identifier")
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
   * Role Name
   **/
  public RolesResponse name(String name) {
    this.name = name;
    return this;
  }

  
  @Schema(required = true, description = "Role Name")
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
   * Permissions for this Role.
   **/
  public RolesResponse permissions(List<String> permissions) {
    this.permissions = permissions;
    return this;
  }

  
  @Schema(description = "Permissions for this Role.")
  @JsonProperty("permissions")

  public List<String> getPermissions() {
    return permissions;
  }
  public void setPermissions(List<String> permissions) {
    this.permissions = permissions;
  }

  /**
   * The Scope levels at which this Role can be used.
   **/
  public RolesResponse allowedScopeLevels(List<AllowedScopeLevelsEnum> allowedScopeLevels) {
    this.allowedScopeLevels = allowedScopeLevels;
    return this;
  }

  
  @Schema(description = "The Scope levels at which this Role can be used.")
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
  public RolesResponse tags(Map<String, String> tags) {
    this.tags = tags;
    return this;
  }

  
  @Schema(description = "Role tags")
  @JsonProperty("tags")
 @Size(max=128)
  public Map<String, String> getTags() {
    return tags;
  }
  public void setTags(Map<String, String> tags) {
    this.tags = tags;
  }

  /**
   **/
  public RolesResponse scope(RoleScope scope) {
    this.scope = scope;
    return this;
  }

  
  @Schema(description = "")
  @JsonProperty("scope")

  public RoleScope getScope() {
    return scope;
  }
  public void setScope(RoleScope scope) {
    this.scope = scope;
  }

  /**
   * Creation timestamp for Role.
   **/
  public RolesResponse created(Long created) {
    this.created = created;
    return this;
  }

  
  @Schema(description = "Creation timestamp for Role.")
  @JsonProperty("created")

  public Long getCreated() {
    return created;
  }
  public void setCreated(Long created) {
    this.created = created;
  }

  /**
   * Last modification timestamp for Role.
   **/
  public RolesResponse updated(Long updated) {
    this.updated = updated;
    return this;
  }

  
  @Schema(description = "Last modification timestamp for Role.")
  @JsonProperty("updated")

  public Long getUpdated() {
    return updated;
  }
  public void setUpdated(Long updated) {
    this.updated = updated;
  }

  /**
   * This indicates if this Role is managed by Harness or not. If true, Harness can manage and modify this Role.
   **/
  public RolesResponse harnessManaged(Boolean harnessManaged) {
    this.harnessManaged = harnessManaged;
    return this;
  }

  
  @Schema(description = "This indicates if this Role is managed by Harness or not. If true, Harness can manage and modify this Role.")
  @JsonProperty("harness_managed")

  public Boolean isHarnessManaged() {
    return harnessManaged;
  }
  public void setHarnessManaged(Boolean harnessManaged) {
    this.harnessManaged = harnessManaged;
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
        Objects.equals(created, rolesResponse.created) &&
        Objects.equals(updated, rolesResponse.updated) &&
        Objects.equals(harnessManaged, rolesResponse.harnessManaged);
  }

  @Override
  public int hashCode() {
    return Objects.hash(slug, name, permissions, allowedScopeLevels, description, tags, scope, created, updated, harnessManaged);
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
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    updated: ").append(toIndentedString(updated)).append("\n");
    sb.append("    harnessManaged: ").append(toIndentedString(harnessManaged)).append("\n");
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
