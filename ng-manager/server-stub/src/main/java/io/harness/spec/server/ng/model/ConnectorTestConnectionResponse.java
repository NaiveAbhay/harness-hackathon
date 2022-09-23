package io.harness.spec.server.ng.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.validation.Valid;

@Schema(
    description =
        "This has test connection details for the Connector defined in Harness.")

public class ConnectorTestConnectionResponse {

  public enum StatsEnum {

    SUCCESS(String.valueOf("SUCCESS")),
    PARTIAL(String.valueOf("PARTIAL")),
    FAILURE(String.valueOf("FAILURE")),
    UNKNOWN(String.valueOf("UNKNOWN"));

    private String value;

    StatsEnum(String v) { value = v; }

    public String value() { return value; }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StatsEnum fromValue(String v) {
      for (StatsEnum b : StatsEnum.values()) {
        if (String.valueOf(b.value).equals(v)) {
          return b;
        }
      }
      return null;
    }
  }
  private @Valid StatsEnum stats = null;

  private @Valid List<ConnectorTestConnectionErrorDetail> errors =
      new ArrayList<>();

  private @Valid String errorSummary = null;

  private @Valid Long testedAt = null;

  private @Valid String delegateId = null;

  /**
   **/
  public ConnectorTestConnectionResponse stats(StatsEnum stats) {
    this.stats = stats;
    return this;
  }

  @Schema(description = "")
  @JsonProperty("stats")

  public StatsEnum getStats() {
    return stats;
  }
  public void setStats(StatsEnum stats) { this.stats = stats; }

  /**
   **/
  public ConnectorTestConnectionResponse
  errors(List<ConnectorTestConnectionErrorDetail> errors) {
    this.errors = errors;
    return this;
  }

  @Schema(description = "")
  @JsonProperty("errors")

  public List<ConnectorTestConnectionErrorDetail> getErrors() {
    return errors;
  }
  public void setErrors(List<ConnectorTestConnectionErrorDetail> errors) {
    this.errors = errors;
  }

  /**
   * Error summary
   **/
  public ConnectorTestConnectionResponse errorSummary(String errorSummary) {
    this.errorSummary = errorSummary;
    return this;
  }

  @Schema(description = "Error summary")
  @JsonProperty("error_summary")

  public String getErrorSummary() {
    return errorSummary;
  }
  public void setErrorSummary(String errorSummary) {
    this.errorSummary = errorSummary;
  }

  /**
   * Time at which Test Connection was completed
   **/
  public ConnectorTestConnectionResponse testedAt(Long testedAt) {
    this.testedAt = testedAt;
    return this;
  }

  @Schema(description = "Time at which Test Connection was completed")
  @JsonProperty("tested_at")

  public Long getTestedAt() {
    return testedAt;
  }
  public void setTestedAt(Long testedAt) { this.testedAt = testedAt; }

  /**
   * ID of Delegate on which Test Connection is executed
   **/
  public ConnectorTestConnectionResponse delegateId(String delegateId) {
    this.delegateId = delegateId;
    return this;
  }

  @Schema(description = "ID of Delegate on which Test Connection is executed")
  @JsonProperty("delegate_id")

  public String getDelegateId() {
    return delegateId;
  }
  public void setDelegateId(String delegateId) { this.delegateId = delegateId; }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConnectorTestConnectionResponse connectorTestConnectionResponse =
        (ConnectorTestConnectionResponse)o;
    return Objects.equals(stats, connectorTestConnectionResponse.stats) &&
        Objects.equals(errors, connectorTestConnectionResponse.errors) &&
        Objects.equals(errorSummary,
                       connectorTestConnectionResponse.errorSummary) &&
        Objects.equals(testedAt, connectorTestConnectionResponse.testedAt) &&
        Objects.equals(delegateId, connectorTestConnectionResponse.delegateId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(stats, errors, errorSummary, testedAt, delegateId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConnectorTestConnectionResponse {\n");

    sb.append("    stats: ").append(toIndentedString(stats)).append("\n");
    sb.append("    errors: ").append(toIndentedString(errors)).append("\n");
    sb.append("    errorSummary: ")
        .append(toIndentedString(errorSummary))
        .append("\n");
    sb.append("    testedAt: ").append(toIndentedString(testedAt)).append("\n");
    sb.append("    delegateId: ")
        .append(toIndentedString(delegateId))
        .append("\n");
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
