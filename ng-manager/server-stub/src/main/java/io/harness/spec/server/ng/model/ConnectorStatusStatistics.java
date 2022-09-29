package io.harness.spec.server.ng.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Objects;
import javax.validation.Valid;

@Schema(description = "Count of Connectors grouped by status.")

public class ConnectorStatusStatistics {

  public enum TypeEnum {

    SUCCESS(String.valueOf("SUCCESS")),
    FALURE(String.valueOf("FALURE")),
    PARTIAL(String.valueOf("PARTIAL")),
    UNKNOWN(String.valueOf("UNKNOWN"));

    private String value;

    TypeEnum(String v) { value = v; }

    public String value() { return value; }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TypeEnum fromValue(String v) {
      for (TypeEnum b : TypeEnum.values()) {
        if (String.valueOf(b.value).equals(v)) {
          return b;
        }
      }
      return null;
    }
  }
  private @Valid TypeEnum type = null;

  private @Valid Integer count = null;

  /**
   **/
  public ConnectorStatusStatistics type(TypeEnum type) {
    this.type = type;
    return this;
  }

  @Schema(description = "")
  @JsonProperty("type")

  public TypeEnum getType() {
    return type;
  }
  public void setType(TypeEnum type) { this.type = type; }

  /**
   **/
  public ConnectorStatusStatistics count(Integer count) {
    this.count = count;
    return this;
  }

  @Schema(description = "")
  @JsonProperty("count")

  public Integer getCount() {
    return count;
  }
  public void setCount(Integer count) { this.count = count; }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConnectorStatusStatistics connectorStatusStatistics =
        (ConnectorStatusStatistics)o;
    return Objects.equals(type, connectorStatusStatistics.type) &&
        Objects.equals(count, connectorStatusStatistics.count);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, count);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConnectorStatusStatistics {\n");

    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    count: ").append(toIndentedString(count)).append("\n");
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
