package io.harness.spec.server.access_control.model;

import io.harness.spec.server.access_control.model.RolesResponse;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.*;
import javax.validation.Valid;


import io.swagger.annotations.*;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;


public class InlineResponse200   {

  private @Valid Integer totalPages = null;

  private @Valid Integer totalItems = null;

  private @Valid Integer pageItemCount = null;

  private @Valid Integer pageSize = null;

  private @Valid List<RolesResponse> roles = new ArrayList<RolesResponse>();

  private @Valid Integer pageIndex = null;

  private @Valid Boolean empty = null;

  /**
   * Total pages in response.
   **/
  public InlineResponse200 totalPages(Integer totalPages) {
    this.totalPages = totalPages;
    return this;
  }

  
  @ApiModelProperty(value = "Total pages in response.")
  @JsonProperty("totalPages")

  public Integer getTotalPages() {
    return totalPages;
  }
  public void setTotalPages(Integer totalPages) {
    this.totalPages = totalPages;
  }

  /**
   * Total items in the response.
   **/
  public InlineResponse200 totalItems(Integer totalItems) {
    this.totalItems = totalItems;
    return this;
  }

  
  @ApiModelProperty(value = "Total items in the response.")
  @JsonProperty("totalItems")

  public Integer getTotalItems() {
    return totalItems;
  }
  public void setTotalItems(Integer totalItems) {
    this.totalItems = totalItems;
  }

  /**
   * Number of items per page.
   **/
  public InlineResponse200 pageItemCount(Integer pageItemCount) {
    this.pageItemCount = pageItemCount;
    return this;
  }

  
  @ApiModelProperty(value = "Number of items per page.")
  @JsonProperty("pageItemCount")

  public Integer getPageItemCount() {
    return pageItemCount;
  }
  public void setPageItemCount(Integer pageItemCount) {
    this.pageItemCount = pageItemCount;
  }

  /**
   * Size of page.
   **/
  public InlineResponse200 pageSize(Integer pageSize) {
    this.pageSize = pageSize;
    return this;
  }

  
  @ApiModelProperty(value = "Size of page.")
  @JsonProperty("pageSize")

  public Integer getPageSize() {
    return pageSize;
  }
  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
  }

  /**
   **/
  public InlineResponse200 roles(List<RolesResponse> roles) {
    this.roles = roles;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("roles")

  public List<RolesResponse> getRoles() {
    return roles;
  }
  public void setRoles(List<RolesResponse> roles) {
    this.roles = roles;
  }

  /**
   * Index of the page returned.
   **/
  public InlineResponse200 pageIndex(Integer pageIndex) {
    this.pageIndex = pageIndex;
    return this;
  }

  
  @ApiModelProperty(value = "Index of the page returned.")
  @JsonProperty("pageIndex")

  public Integer getPageIndex() {
    return pageIndex;
  }
  public void setPageIndex(Integer pageIndex) {
    this.pageIndex = pageIndex;
  }

  /**
   * Returns true when page is empty.
   **/
  public InlineResponse200 empty(Boolean empty) {
    this.empty = empty;
    return this;
  }

  
  @ApiModelProperty(value = "Returns true when page is empty.")
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
    InlineResponse200 inlineResponse200 = (InlineResponse200) o;
    return Objects.equals(totalPages, inlineResponse200.totalPages) &&
        Objects.equals(totalItems, inlineResponse200.totalItems) &&
        Objects.equals(pageItemCount, inlineResponse200.pageItemCount) &&
        Objects.equals(pageSize, inlineResponse200.pageSize) &&
        Objects.equals(roles, inlineResponse200.roles) &&
        Objects.equals(pageIndex, inlineResponse200.pageIndex) &&
        Objects.equals(empty, inlineResponse200.empty);
  }

  @Override
  public int hashCode() {
    return Objects.hash(totalPages, totalItems, pageItemCount, pageSize, roles, pageIndex, empty);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse200 {\n");
    
    sb.append("    totalPages: ").append(toIndentedString(totalPages)).append("\n");
    sb.append("    totalItems: ").append(toIndentedString(totalItems)).append("\n");
    sb.append("    pageItemCount: ").append(toIndentedString(pageItemCount)).append("\n");
    sb.append("    pageSize: ").append(toIndentedString(pageSize)).append("\n");
    sb.append("    roles: ").append(toIndentedString(roles)).append("\n");
    sb.append("    pageIndex: ").append(toIndentedString(pageIndex)).append("\n");
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
