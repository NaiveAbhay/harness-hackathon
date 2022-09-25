package io.harness.spec.server.ng.model;

import io.harness.spec.server.ng.model.Organization;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * Organization response Model
 **/
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.v3.oas.annotations.media.Schema;



@Schema(description = "Organization response Model")

public class OrganizationResponse   {

  private @Valid Organization org = null;

  private @Valid Long created = null;

  private @Valid Long updated = null;

  private @Valid Boolean harnessManaged = null;

  /**
   **/
  public OrganizationResponse org(Organization org) {
    this.org = org;
    return this;
  }

  
  @Schema(description = "")
  @JsonProperty("org")

  public Organization getOrg() {
    return org;
  }
  public void setOrg(Organization org) {
    this.org = org;
  }

  /**
   * Creation timestamp for organization
   **/
  public OrganizationResponse created(Long created) {
    this.created = created;
    return this;
  }

  
  @Schema(description = "Creation timestamp for organization")
  @JsonProperty("created")

  public Long getCreated() {
    return created;
  }
  public void setCreated(Long created) {
    this.created = created;
  }

  /**
   * Updated timestamp for organization
   **/
  public OrganizationResponse updated(Long updated) {
    this.updated = updated;
    return this;
  }

  
  @Schema(description = "Updated timestamp for organization")
  @JsonProperty("updated")

  public Long getUpdated() {
    return updated;
  }
  public void setUpdated(Long updated) {
    this.updated = updated;
  }

  /**
   * This indicates if this organization is managed by Harness or not. If true, Harness can manage and modify this organization.
   **/
  public OrganizationResponse harnessManaged(Boolean harnessManaged) {
    this.harnessManaged = harnessManaged;
    return this;
  }

  
  @Schema(description = "This indicates if this organization is managed by Harness or not. If true, Harness can manage and modify this organization.")
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
    OrganizationResponse organizationResponse = (OrganizationResponse) o;
    return Objects.equals(org, organizationResponse.org) &&
        Objects.equals(created, organizationResponse.created) &&
        Objects.equals(updated, organizationResponse.updated) &&
        Objects.equals(harnessManaged, organizationResponse.harnessManaged);
  }

  @Override
  public int hashCode() {
    return Objects.hash(org, created, updated, harnessManaged);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrganizationResponse {\n");
    
    sb.append("    org: ").append(toIndentedString(org)).append("\n");
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
