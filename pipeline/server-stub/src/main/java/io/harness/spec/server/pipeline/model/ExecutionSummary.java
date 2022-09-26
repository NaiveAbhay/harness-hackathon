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

  private @Valid List<Integer> errorsCount = new ArrayList<>();

  private @Valid List<Integer> deploymentsCount = new ArrayList<>();

  /**
   * Number of errors on each of the last 7 days.
   **/
  public ExecutionSummary errorsCount(List<Integer> errorsCount) {
    this.errorsCount = errorsCount;
    return this;
  }

  
  @Schema(description = "Number of errors on each of the last 7 days.")
  @JsonProperty("errors_count")

  public List<Integer> getErrorsCount() {
    return errorsCount;
  }
  public void setErrorsCount(List<Integer> errorsCount) {
    this.errorsCount = errorsCount;
  }

  /**
   * Number of deployments on each of the last 7 days.
   **/
  public ExecutionSummary deploymentsCount(List<Integer> deploymentsCount) {
    this.deploymentsCount = deploymentsCount;
    return this;
  }

  
  @Schema(description = "Number of deployments on each of the last 7 days.")
  @JsonProperty("deployments_count")

  public List<Integer> getDeploymentsCount() {
    return deploymentsCount;
  }
  public void setDeploymentsCount(List<Integer> deploymentsCount) {
    this.deploymentsCount = deploymentsCount;
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
    return Objects.equals(errorsCount, executionSummary.errorsCount) &&
        Objects.equals(deploymentsCount, executionSummary.deploymentsCount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(errorsCount, deploymentsCount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ExecutionSummary {\n");
    
    sb.append("    errorsCount: ").append(toIndentedString(errorsCount)).append("\n");
    sb.append("    deploymentsCount: ").append(toIndentedString(deploymentsCount)).append("\n");
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
