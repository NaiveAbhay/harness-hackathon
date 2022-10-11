package io.harness.spec.server.accesscontrol.model;

import io.harness.spec.server.accesscontrol.model.RoleAssignment;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * Role assignment response model
 **/
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.v3.oas.annotations.media.Schema;



@Schema(description = "Role assignment response model")

public class RoleAssignmentResponse   {

  private @Valid RoleAssignment roleassignment = null;

  private @Valid Long created = null;

  private @Valid Long updated = null;

  private @Valid Boolean harnessManaged = null;

  /**
   **/
  public RoleAssignmentResponse roleassignment(RoleAssignment roleassignment) {
    this.roleassignment = roleassignment;
    return this;
  }

  
  @Schema(description = "")
  @JsonProperty("roleassignment")

  public RoleAssignment getRoleassignment() {
    return roleassignment;
  }
  public void setRoleassignment(RoleAssignment roleassignment) {
    this.roleassignment = roleassignment;
  }

  /**
   * Creation timestamp for Role.
   **/
  public RoleAssignmentResponse created(Long created) {
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
  public RoleAssignmentResponse updated(Long updated) {
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
   * Is harness managed
   **/
  public RoleAssignmentResponse harnessManaged(Boolean harnessManaged) {
    this.harnessManaged = harnessManaged;
    return this;
  }

  
  @Schema(description = "Is harness managed")
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
    RoleAssignmentResponse roleAssignmentResponse = (RoleAssignmentResponse) o;
    return Objects.equals(roleassignment, roleAssignmentResponse.roleassignment) &&
        Objects.equals(created, roleAssignmentResponse.created) &&
        Objects.equals(updated, roleAssignmentResponse.updated) &&
        Objects.equals(harnessManaged, roleAssignmentResponse.harnessManaged);
  }

  @Override
  public int hashCode() {
    return Objects.hash(roleassignment, created, updated, harnessManaged);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RoleAssignmentResponse {\n");
    
    sb.append("    roleassignment: ").append(toIndentedString(roleassignment)).append("\n");
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
