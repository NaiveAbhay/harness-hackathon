package io.harness.spec.server.pipeline.model;

import io.harness.spec.server.pipeline.model.ExecutorInfo;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * Recent Execution information of the Pipeline.
 **/
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

@Schema(description = "Recent Execution information of the Pipeline.")

public class RecentExecutionInfo   {

  private @Valid ExecutorInfo executorInfo = null;

  private @Valid String executionId = null;

public enum ExecutionStatusEnum {

    RUNNING(String.valueOf("Running")), ASYNCWAITING(String.valueOf("AsyncWaiting")), TASKWAITING(String.valueOf("TaskWaiting")), TIMEDWAITING(String.valueOf("TimedWaiting")), FAILED(String.valueOf("Failed")), ERRORED(String.valueOf("Errored")), IGNOREFAILED(String.valueOf("IgnoreFailed")), NOTSTARTED(String.valueOf("NotStarted")), EXPIRED(String.valueOf("Expired")), ABORTED(String.valueOf("Aborted")), DISCONTINUING(String.valueOf("Discontinuing")), QUEUED(String.valueOf("Queued")), PAUSED(String.valueOf("Paused")), RESOURCEWAITING(String.valueOf("ResourceWaiting")), INTERVENTIONWAITING(String.valueOf("InterventionWaiting")), APPROVALWAITING(String.valueOf("ApprovalWaiting")), SUCCESS(String.valueOf("Success")), SUSPENDED(String.valueOf("Suspended")), SKIPPED(String.valueOf("Skipped")), PAUSING(String.valueOf("Pausing")), APPROVALREJECTED(String.valueOf("ApprovalRejected")), INPUTWAITING(String.valueOf("InputWaiting")), NOT_STARTED(String.valueOf("NOT_STARTED")), INTERVENTION_WAITING(String.valueOf("INTERVENTION_WAITING")), APPROVAL_WAITING(String.valueOf("APPROVAL_WAITING")), APPROVAL_REJECTED(String.valueOf("APPROVAL_REJECTED")), WAITING(String.valueOf("Waiting"));


    private String value;

    ExecutionStatusEnum (String v) {
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
    public static ExecutionStatusEnum fromValue(String v) {
        for (ExecutionStatusEnum b : ExecutionStatusEnum.values()) {
            if (String.valueOf(b.value).equals(v)) {
                return b;
            }
        }
        return null;
    }
}
  private @Valid ExecutionStatusEnum executionStatus = null;

  private @Valid Long started = null;

  private @Valid Long ended = null;

  private @Valid Integer runNumber = null;

  /**
   **/
  public RecentExecutionInfo executorInfo(ExecutorInfo executorInfo) {
    this.executorInfo = executorInfo;
    return this;
  }

  
  @Schema(description = "")
  @JsonProperty("executor_info")

  public ExecutorInfo getExecutorInfo() {
    return executorInfo;
  }
  public void setExecutorInfo(ExecutorInfo executorInfo) {
    this.executorInfo = executorInfo;
  }

  /**
   * Execution identifier
   **/
  public RecentExecutionInfo executionId(String executionId) {
    this.executionId = executionId;
    return this;
  }

  
  @Schema(description = "Execution identifier")
  @JsonProperty("execution_id")
 @Pattern(regexp="^[a-zA-Z_][0-9a-zA-Z-_$]{0,63}$") @Size(min=1,max=64)
  public String getExecutionId() {
    return executionId;
  }
  public void setExecutionId(String executionId) {
    this.executionId = executionId;
  }

  /**
   * Last Execution status of the Pipeline.
   **/
  public RecentExecutionInfo executionStatus(ExecutionStatusEnum executionStatus) {
    this.executionStatus = executionStatus;
    return this;
  }

  
  @Schema(description = "Last Execution status of the Pipeline.")
  @JsonProperty("execution_status")

  public ExecutionStatusEnum getExecutionStatus() {
    return executionStatus;
  }
  public void setExecutionStatus(ExecutionStatusEnum executionStatus) {
    this.executionStatus = executionStatus;
  }

  /**
   * Start timestamp of Execution
   **/
  public RecentExecutionInfo started(Long started) {
    this.started = started;
    return this;
  }

  
  @Schema(description = "Start timestamp of Execution")
  @JsonProperty("started")

  public Long getStarted() {
    return started;
  }
  public void setStarted(Long started) {
    this.started = started;
  }

  /**
   * End timestamp of Execution
   **/
  public RecentExecutionInfo ended(Long ended) {
    this.ended = ended;
    return this;
  }

  
  @Schema(description = "End timestamp of Execution")
  @JsonProperty("ended")

  public Long getEnded() {
    return ended;
  }
  public void setEnded(Long ended) {
    this.ended = ended;
  }

  /**
   * The Execution number of this Pipeline.
   **/
  public RecentExecutionInfo runNumber(Integer runNumber) {
    this.runNumber = runNumber;
    return this;
  }

  
  @Schema(description = "The Execution number of this Pipeline.")
  @JsonProperty("run_number")

  public Integer getRunNumber() {
    return runNumber;
  }
  public void setRunNumber(Integer runNumber) {
    this.runNumber = runNumber;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RecentExecutionInfo recentExecutionInfo = (RecentExecutionInfo) o;
    return Objects.equals(executorInfo, recentExecutionInfo.executorInfo) &&
        Objects.equals(executionId, recentExecutionInfo.executionId) &&
        Objects.equals(executionStatus, recentExecutionInfo.executionStatus) &&
        Objects.equals(started, recentExecutionInfo.started) &&
        Objects.equals(ended, recentExecutionInfo.ended) &&
        Objects.equals(runNumber, recentExecutionInfo.runNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(executorInfo, executionId, executionStatus, started, ended, runNumber);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RecentExecutionInfo {\n");
    
    sb.append("    executorInfo: ").append(toIndentedString(executorInfo)).append("\n");
    sb.append("    executionId: ").append(toIndentedString(executionId)).append("\n");
    sb.append("    executionStatus: ").append(toIndentedString(executionStatus)).append("\n");
    sb.append("    started: ").append(toIndentedString(started)).append("\n");
    sb.append("    ended: ").append(toIndentedString(ended)).append("\n");
    sb.append("    runNumber: ").append(toIndentedString(runNumber)).append("\n");
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
