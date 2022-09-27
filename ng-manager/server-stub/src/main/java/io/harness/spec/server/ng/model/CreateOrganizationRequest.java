package io.harness.spec.server.ng.model;

import io.harness.spec.server.ng.model.Organization;
import javax.validation.constraints.*;
import javax.validation.Valid;


import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.v3.oas.annotations.media.Schema;





public class CreateOrganizationRequest   {

  private @Valid Organization org = null;

  /**
   **/
  public CreateOrganizationRequest org(Organization org) {
    this.org = org;
    return this;
  }

  
  @Schema(required = true, description = "")
  @JsonProperty("org")
  @NotNull

  public Organization getOrg() {
    return org;
  }
  public void setOrg(Organization org) {
    this.org = org;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateOrganizationRequest createOrganizationRequest = (CreateOrganizationRequest) o;
    return Objects.equals(org, createOrganizationRequest.org);
  }

  @Override
  public int hashCode() {
    return Objects.hash(org);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateOrganizationRequest {\n");
    
    sb.append("    org: ").append(toIndentedString(org)).append("\n");
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
