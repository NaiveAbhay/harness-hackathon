package io.harness.spec.server.accesscontrol.model;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * Specify how items are to be sorted while listing them.
 **/
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

@Schema(description = "Specify how items are to be sorted while listing them.")

public class Sorting   {

  private @Valid String fieldName = null;

public enum OrderTypeEnum {

    ASC(String.valueOf("ASC")), DESC(String.valueOf("DESC"));


    private String value;

    OrderTypeEnum (String v) {
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
    public static OrderTypeEnum fromValue(String v) {
        for (OrderTypeEnum b : OrderTypeEnum.values()) {
            if (String.valueOf(b.value).equals(v)) {
                return b;
            }
        }
        return null;
    }
}
  private @Valid OrderTypeEnum orderType = null;

  /**
   * Attribute used for sorting.
   **/
  public Sorting fieldName(String fieldName) {
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
   * Sorting types when listing items.
   **/
  public Sorting orderType(OrderTypeEnum orderType) {
    this.orderType = orderType;
    return this;
  }

  
  @Schema(description = "Sorting types when listing items.")
  @JsonProperty("order_type")

  public OrderTypeEnum getOrderType() {
    return orderType;
  }
  public void setOrderType(OrderTypeEnum orderType) {
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
    Sorting sorting = (Sorting) o;
    return Objects.equals(fieldName, sorting.fieldName) &&
        Objects.equals(orderType, sorting.orderType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fieldName, orderType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Sorting {\n");
    
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
