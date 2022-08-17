package io.harness.spec.server.accesscontrol.model;

import io.harness.spec.server.accesscontrol.model.SortType;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * Specify how Roles are to be sorted while listing them.
 **/
import io.swagger.annotations.*;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

@Schema(description = "Specify how Roles are to be sorted while listing them.")

public class SortRoles   {

  private @Valid String fieldName = null;

  private @Valid SortType orderType = null;

  /**
   * Attribute used for sorting.
   **/
  public SortRoles fieldName(String fieldName) {
    this.fieldName = fieldName;
    return this;
  }

  
  @Schema(description = "Attribute used for sorting.")
  @JsonProperty("field_name")

  public String getFieldName() {
    return fieldName;
  }
  public void setFieldName(String fieldName) {
    this.fieldName = fieldName;
  }

  /**
   **/
  public SortRoles orderType(SortType orderType) {
    this.orderType = orderType;
    return this;
  }

  
  @Schema(description = "")
  @JsonProperty("order_type")

  public SortType getOrderType() {
    return orderType;
  }
  public void setOrderType(SortType orderType) {
    this.orderType = orderType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SortRoles sortRoles = (SortRoles) o;
    return Objects.equals(fieldName, sortRoles.fieldName) &&
        Objects.equals(orderType, sortRoles.orderType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fieldName, orderType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SortRoles {\n");
    
    sb.append("    fieldName: ").append(toIndentedString(fieldName)).append("\n");
    sb.append("    orderType: ").append(toIndentedString(orderType)).append("\n");
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
