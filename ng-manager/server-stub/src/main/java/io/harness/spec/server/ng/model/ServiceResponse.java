/*
* Copyright 2022 Harness Inc. All rights reserved.
* Use of this source code is governed by the PolyForm Free Trial 1.0.0 license
* that can be found in the licenses directory at the root of this repository, also available at
* https://polyformproject.org/wp-content/uploads/2020/05/PolyForm-Free-Trial-1.0.0.txt.
*/

package io.harness.spec.server.ng.model;

import io.harness.spec.server.ng.model.Service;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.Valid;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.v3.oas.annotations.media.Schema;
/**
* Default response when a service is returned
**/


@Schema(description = "Default response when a service is returned")

public class ServiceResponse   {

  private @Valid Service service = null;

  private @Valid Long created = null;

  private @Valid Long updated = null;

  /**
   **/
  public ServiceResponse service(Service service) {
    this.service = service;
    return this;
  }

  
  @Schema(description = "")
  @JsonProperty("service")

  public Service getService() {
    return service;
  }
  public void setService(Service service) {
    this.service = service;
  }

  /**
   * Creation timestamp for Service.
   **/
  public ServiceResponse created(Long created) {
    this.created = created;
    return this;
  }

  
  @Schema(description = "Creation timestamp for Service.")
  @JsonProperty("created")

  public Long getCreated() {
    return created;
  }
  public void setCreated(Long created) {
    this.created = created;
  }

  /**
   * Last modification timestamp for Service.
   **/
  public ServiceResponse updated(Long updated) {
    this.updated = updated;
    return this;
  }

  
  @Schema(description = "Last modification timestamp for Service.")
  @JsonProperty("updated")

  public Long getUpdated() {
    return updated;
  }
  public void setUpdated(Long updated) {
    this.updated = updated;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServiceResponse serviceResponse = (ServiceResponse) o;
    return Objects.equals(service, serviceResponse.service) &&
        Objects.equals(created, serviceResponse.created) &&
        Objects.equals(updated, serviceResponse.updated);
  }

  @Override
  public int hashCode() {
    return Objects.hash(service, created, updated);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceResponse {\n");
    
    sb.append("    service: ").append(toIndentedString(service)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    updated: ").append(toIndentedString(updated)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
