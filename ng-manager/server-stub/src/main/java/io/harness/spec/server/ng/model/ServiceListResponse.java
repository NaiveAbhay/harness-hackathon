package io.harness.spec.server.ng.model;

import io.harness.spec.server.ng.model.ServiceResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * Response when a list of services are created 
 **/
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

@Schema(description = "Response when a list of services are created ")

public class ServiceListResponse   {

  private @Valid List<ServiceResponse> content = new ArrayList<>();

  private @Valid Boolean empty = null;

  /**
   **/
  public ServiceListResponse content(List<ServiceResponse> content) {
    this.content = content;
    return this;
  }

  
  @Schema(description = "")
  @JsonProperty("content")

  public List<ServiceResponse> getContent() {
    return content;
  }
  public void setContent(List<ServiceResponse> content) {
    this.content = content;
  }

  /**
   **/
  public ServiceListResponse empty(Boolean empty) {
    this.empty = empty;
    return this;
  }

  
  @Schema(description = "")
  @JsonProperty("empty")

  public Boolean isEmpty() {
    return empty;
  }
  public void setEmpty(Boolean empty) {
    this.empty = empty;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServiceListResponse serviceListResponse = (ServiceListResponse) o;
    return Objects.equals(content, serviceListResponse.content) &&
        Objects.equals(empty, serviceListResponse.empty);
  }

  @Override
  public int hashCode() {
    return Objects.hash(content, empty);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceListResponse {\n");
    
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
    sb.append("    empty: ").append(toIndentedString(empty)).append("\n");
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
