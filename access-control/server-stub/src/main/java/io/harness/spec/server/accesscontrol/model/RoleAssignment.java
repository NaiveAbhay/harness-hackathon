package io.harness.spec.server.accesscontrol.model;

import io.harness.spec.server.accesscontrol.model.Principal;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * Role assignment request model
 **/
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.v3.oas.annotations.media.Schema;



@Schema(description = "Role assignment request model")

public class RoleAssignment   {

  private @Valid String slug = null;

  private @Valid String resourceGroup = null;

  private @Valid String role = null;

  private @Valid Principal principal = null;

  private @Valid Boolean disabled = null;

  private @Valid Boolean managed = null;

  /**
   * Role assignment slug
   **/
  public RoleAssignment slug(String slug) {
    this.slug = slug;
    return this;
  }

  
  @Schema(required = true, description = "Role assignment slug")
  @JsonProperty("slug")
  @NotNull

  public String getSlug() {
    return slug;
  }
  public void setSlug(String slug) {
    this.slug = slug;
  }

  /**
   * Resource group name
   **/
  public RoleAssignment resourceGroup(String resourceGroup) {
    this.resourceGroup = resourceGroup;
    return this;
  }

  
  @Schema(required = true, description = "Resource group name")
  @JsonProperty("resource_group")
  @NotNull

  public String getResourceGroup() {
    return resourceGroup;
  }
  public void setResourceGroup(String resourceGroup) {
    this.resourceGroup = resourceGroup;
  }

  /**
   * Role slug
   **/
  public RoleAssignment role(String role) {
    this.role = role;
    return this;
  }

  
  @Schema(required = true, description = "Role slug")
  @JsonProperty("role")
  @NotNull

  public String getRole() {
    return role;
  }
  public void setRole(String role) {
    this.role = role;
  }

  /**
   **/
  public RoleAssignment principal(Principal principal) {
    this.principal = principal;
    return this;
  }

  
  @Schema(required = true, description = "")
  @JsonProperty("principal")
  @NotNull

  public Principal getPrincipal() {
    return principal;
  }
  public void setPrincipal(Principal principal) {
    this.principal = principal;
  }

  /**
   * Role assignment is disabled or not
   **/
  public RoleAssignment disabled(Boolean disabled) {
    this.disabled = disabled;
    return this;
  }

  
  @Schema(description = "Role assignment is disabled or not")
  @JsonProperty("disabled")

  public Boolean isDisabled() {
    return disabled;
  }
  public void setDisabled(Boolean disabled) {
    this.disabled = disabled;
  }

  /**
   * Role assignment is managed or not
   **/
  public RoleAssignment managed(Boolean managed) {
    this.managed = managed;
    return this;
  }

  
  @Schema(description = "Role assignment is managed or not")
  @JsonProperty("managed")

  public Boolean isManaged() {
    return managed;
  }
  public void setManaged(Boolean managed) {
    this.managed = managed;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RoleAssignment roleAssignment = (RoleAssignment) o;
    return Objects.equals(slug, roleAssignment.slug) &&
        Objects.equals(resourceGroup, roleAssignment.resourceGroup) &&
        Objects.equals(role, roleAssignment.role) &&
        Objects.equals(principal, roleAssignment.principal) &&
        Objects.equals(disabled, roleAssignment.disabled) &&
        Objects.equals(managed, roleAssignment.managed);
  }

  @Override
  public int hashCode() {
    return Objects.hash(slug, resourceGroup, role, principal, disabled, managed);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RoleAssignment {\n");
    
    sb.append("    slug: ").append(toIndentedString(slug)).append("\n");
    sb.append("    resourceGroup: ").append(toIndentedString(resourceGroup)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
    sb.append("    principal: ").append(toIndentedString(principal)).append("\n");
    sb.append("    disabled: ").append(toIndentedString(disabled)).append("\n");
    sb.append("    managed: ").append(toIndentedString(managed)).append("\n");
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
