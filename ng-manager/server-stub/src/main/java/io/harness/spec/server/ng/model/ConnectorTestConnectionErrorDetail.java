package io.harness.spec.server.ng.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Objects;
import javax.validation.Valid;

@Schema(description = "Connector test connection errors and their details.")

public class ConnectorTestConnectionErrorDetail {

  private @Valid String reason = null;

  private @Valid String message = null;

  private @Valid String code = null;

  /**
   * Reason of test connection error
   **/
  public ConnectorTestConnectionErrorDetail reason(String reason) {
    this.reason = reason;
    return this;
  }

  @Schema(description = "Reason of test connection error")
  @JsonProperty("reason")

  public String getReason() {
    return reason;
  }
  public void setReason(String reason) { this.reason = reason; }

  /**
   * Test connection error message
   **/
  public ConnectorTestConnectionErrorDetail message(String message) {
    this.message = message;
    return this;
  }

  @Schema(description = "Test connection error message")
  @JsonProperty("message")

  public String getMessage() {
    return message;
  }
  public void setMessage(String message) { this.message = message; }

  /**
   * Test connection error code
   **/
  public ConnectorTestConnectionErrorDetail code(String code) {
    this.code = code;
    return this;
  }

  @Schema(description = "Test connection error code")
  @JsonProperty("code")

  public String getCode() {
    return code;
  }
  public void setCode(String code) { this.code = code; }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConnectorTestConnectionErrorDetail connectorTestConnectionErrorDetail =
        (ConnectorTestConnectionErrorDetail)o;
    return Objects.equals(reason, connectorTestConnectionErrorDetail.reason) &&
        Objects.equals(message, connectorTestConnectionErrorDetail.message) &&
        Objects.equals(code, connectorTestConnectionErrorDetail.code);
  }

  @Override
  public int hashCode() {
    return Objects.hash(reason, message, code);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConnectorTestConnectionErrorDetail {\n");

    sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
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
