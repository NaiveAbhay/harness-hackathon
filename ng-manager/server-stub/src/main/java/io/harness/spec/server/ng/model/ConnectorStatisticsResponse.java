package io.harness.spec.server.ng.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.validation.Valid;

@Schema(description = "Connector statistics response model")

public class ConnectorStatisticsResponse {

  private @Valid List<ConnectorTypeStatistics> typesStats = new ArrayList<>();

  private @Valid List<ConnectorStatusStatistics> statusStats =
      new ArrayList<>();

  /**
   **/
  public ConnectorStatisticsResponse
  typesStats(List<ConnectorTypeStatistics> typesStats) {
    this.typesStats = typesStats;
    return this;
  }

  @Schema(description = "")
  @JsonProperty("types_stats")

  public List<ConnectorTypeStatistics> getTypesStats() {
    return typesStats;
  }
  public void setTypesStats(List<ConnectorTypeStatistics> typesStats) {
    this.typesStats = typesStats;
  }

  /**
   **/
  public ConnectorStatisticsResponse
  statusStats(List<ConnectorStatusStatistics> statusStats) {
    this.statusStats = statusStats;
    return this;
  }

  @Schema(description = "")
  @JsonProperty("status_stats")

  public List<ConnectorStatusStatistics> getStatusStats() {
    return statusStats;
  }
  public void setStatusStats(List<ConnectorStatusStatistics> statusStats) {
    this.statusStats = statusStats;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConnectorStatisticsResponse connectorStatisticsResponse =
        (ConnectorStatisticsResponse)o;
    return Objects.equals(typesStats, connectorStatisticsResponse.typesStats) &&
        Objects.equals(statusStats, connectorStatisticsResponse.statusStats);
  }

  @Override
  public int hashCode() {
    return Objects.hash(typesStats, statusStats);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConnectorStatisticsResponse {\n");

    sb.append("    typesStats: ")
        .append(toIndentedString(typesStats))
        .append("\n");
    sb.append("    statusStats: ")
        .append(toIndentedString(statusStats))
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
