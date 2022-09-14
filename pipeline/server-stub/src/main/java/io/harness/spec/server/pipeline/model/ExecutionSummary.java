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

  private @Valid Long lastExecuted = null;

public enum LastStatusEnum {

    RUNNING(String.valueOf("Running")), ASYNCWAITING(String.valueOf("AsyncWaiting")), TASKWAITING(String.valueOf("TaskWaiting")), TIMEDWAITING(String.valueOf("TimedWaiting")), FAILED(String.valueOf("Failed")), ERRORED(String.valueOf("Errored")), IGNOREFAILED(String.valueOf("IgnoreFailed")), NOTSTARTED(String.valueOf("NotStarted")), EXPIRED(String.valueOf("Expired")), ABORTED(String.valueOf("Aborted")), DISCONTINUING(String.valueOf("Discontinuing")), QUEUED(String.valueOf("Queued")), PAUSED(String.valueOf("Paused")), RESOURCEWAITING(String.valueOf("ResourceWaiting")), INTERVENTIONWAITING(String.valueOf("InterventionWaiting")), APPROVALWAITING(String.valueOf("ApprovalWaiting")), SUCCESS(String.valueOf("Success")), SUSPENDED(String.valueOf("Suspended")), SKIPPED(String.valueOf("Skipped")), PAUSING(String.valueOf("Pausing")), APPROVALREJECTED(String.valueOf("ApprovalRejected")), INPUTWAITING(String.valueOf("InputWaiting")), NOT_STARTED(String.valueOf("NOT_STARTED")), INTERVENTION_WAITING(String.valueOf("INTERVENTION_WAITING")), APPROVAL_WAITING(String.valueOf("APPROVAL_WAITING")), APPROVAL_REJECTED(String.valueOf("APPROVAL_REJECTED")), WAITING(String.valueOf("Waiting"));


    private String value;

    LastStatusEnum (String v) {
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
    public static LastStatusEnum fromValue(String v) {
        for (LastStatusEnum b : LastStatusEnum.values()) {
            if (String.valueOf(b.value).equals(v)) {
                return b;
            }
        }
        return null;
    }
}
  private @Valid LastStatusEnum lastStatus = null;

  private @Valid String lastExecution = null;

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

  /**
   * Timestamp of the last Execution of the Pipeline.
   **/
  public ExecutionSummary lastExecuted(Long lastExecuted) {
    this.lastExecuted = lastExecuted;
    return this;
  }

  
  @Schema(description = "Timestamp of the last Execution of the Pipeline.")
  @JsonProperty("last_executed")

  public Long getLastExecuted() {
    return lastExecuted;
  }
  public void setLastExecuted(Long lastExecuted) {
    this.lastExecuted = lastExecuted;
  }

  /**
   * This is the last Execution status of the Pipeline.
   **/
  public ExecutionSummary lastStatus(LastStatusEnum lastStatus) {
    this.lastStatus = lastStatus;
    return this;
  }

  
  @Schema(description = "This is the last Execution status of the Pipeline.")
  @JsonProperty("last_status")

  public LastStatusEnum getLastStatus() {
    return lastStatus;
  }
  public void setLastStatus(LastStatusEnum lastStatus) {
    this.lastStatus = lastStatus;
  }

  /**
   * Execution identifier of the last Execution.
   **/
  public ExecutionSummary lastExecution(String lastExecution) {
    this.lastExecution = lastExecution;
    return this;
  }

  
  @Schema(description = "Execution identifier of the last Execution.")
  @JsonProperty("last_execution")
 @Pattern(regexp="^[a-zA-Z_][0-9a-zA-Z_$]{0,63}$") @Size(min=1,max=64)
  public String getLastExecution() {
    return lastExecution;
  }
  public void setLastExecution(String lastExecution) {
    this.lastExecution = lastExecution;
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
        Objects.equals(deployments, executionSummary.deployments) &&
        Objects.equals(lastExecuted, executionSummary.lastExecuted) &&
        Objects.equals(lastStatus, executionSummary.lastStatus) &&
        Objects.equals(lastExecution, executionSummary.lastExecution);
  }

  @Override
  public int hashCode() {
    return Objects.hash(errorLastWeek, deployments, lastExecuted, lastStatus, lastExecution);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ExecutionSummary {\n");
    
    sb.append("    errorLastWeek: ").append(toIndentedString(errorLastWeek)).append("\n");
    sb.append("    deployments: ").append(toIndentedString(deployments)).append("\n");
    sb.append("    lastExecuted: ").append(toIndentedString(lastExecuted)).append("\n");
    sb.append("    lastStatus: ").append(toIndentedString(lastStatus)).append("\n");
    sb.append("    lastExecution: ").append(toIndentedString(lastExecution)).append("\n");
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
