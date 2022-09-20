package io.harness.spec.server.pipeline.model;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * Execution Summary
 **/
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

@Schema(description = "Execution Summary")

public class ExecutionSummary   {

  private @Valid List<Integer> errorLastWeek = new ArrayList<>();

  private @Valid List<Integer> deployments = new ArrayList<>();

  /**
   * Number of errors on each of the last 7 days.
   **/
  public ExecutionSummary errorLastWeek(List<Integer> errorLastWeek) {
    this.errorLastWeek = errorLastWeek;
    return this;
  }

  
  @Schema(description = "Number of errors on each of the last 7 days.")
  @JsonProperty("error_last_week")

  public List<Integer> getErrorLastWeek() {
    return errorLastWeek;
  }
  public void setErrorLastWeek(List<Integer> errorLastWeek) {
    this.errorLastWeek = errorLastWeek;
  }

  /**
   * Number of deployments on each of the last 7 days.
   **/
  public ExecutionSummary deployments(List<Integer> deployments) {
    this.deployments = deployments;
    return this;
  }

  
  @Schema(description = "Number of deployments on each of the last 7 days.")
  @JsonProperty("deployments")

  public List<Integer> getDeployments() {
    return deployments;
  }
  public void setDeployments(List<Integer> deployments) {
    this.deployments = deployments;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ExecutionSummary executionSummary = (ExecutionSummary) o;
    return Objects.equals(errorLastWeek, executionSummary.errorLastWeek) &&
        Objects.equals(deployments, executionSummary.deployments);
  }

  @Override
  public int hashCode() {
    return Objects.hash(errorLastWeek, deployments);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ExecutionSummary {\n");
    
    sb.append("    errorLastWeek: ").append(toIndentedString(errorLastWeek)).append("\n");
    sb.append("    deployments: ").append(toIndentedString(deployments)).append("\n");
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
