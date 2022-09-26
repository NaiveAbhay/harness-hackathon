package io.harness.spec.server.pipeline.model;

import io.harness.spec.server.pipeline.model.NodeInfo;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * YAML schema error.
 **/
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

@Schema(description = "YAML schema error.")

public class YAMLSchemaErrorWrapper   {

  private @Valid String message = null;

  private @Valid String messageFqn = null;

  private @Valid NodeInfo stageInfo = null;

  private @Valid NodeInfo stepInfo = null;

  private @Valid String fqn = null;

  private @Valid String hintMessage = null;

  /**
   * Error message
   **/
  public YAMLSchemaErrorWrapper message(String message) {
    this.message = message;
    return this;
  }

  
  @Schema(description = "Error message")
  @JsonProperty("message")

  public String getMessage() {
    return message;
  }
  public void setMessage(String message) {
    this.message = message;
  }

  /**
   * Error message with FQN
   **/
  public YAMLSchemaErrorWrapper messageFqn(String messageFqn) {
    this.messageFqn = messageFqn;
    return this;
  }

  
  @Schema(description = "Error message with FQN")
  @JsonProperty("message_fqn")

  public String getMessageFqn() {
    return messageFqn;
  }
  public void setMessageFqn(String messageFqn) {
    this.messageFqn = messageFqn;
  }

  /**
   **/
  public YAMLSchemaErrorWrapper stageInfo(NodeInfo stageInfo) {
    this.stageInfo = stageInfo;
    return this;
  }

  
  @Schema(description = "")
  @JsonProperty("stage_info")

  public NodeInfo getStageInfo() {
    return stageInfo;
  }
  public void setStageInfo(NodeInfo stageInfo) {
    this.stageInfo = stageInfo;
  }

  /**
   **/
  public YAMLSchemaErrorWrapper stepInfo(NodeInfo stepInfo) {
    this.stepInfo = stepInfo;
    return this;
  }

  
  @Schema(description = "")
  @JsonProperty("step_info")

  public NodeInfo getStepInfo() {
    return stepInfo;
  }
  public void setStepInfo(NodeInfo stepInfo) {
    this.stepInfo = stepInfo;
  }

  /**
   * Fully Qualified Name as per YAML
   **/
  public YAMLSchemaErrorWrapper fqn(String fqn) {
    this.fqn = fqn;
    return this;
  }

  
  @Schema(description = "Fully Qualified Name as per YAML")
  @JsonProperty("fqn")

  public String getFqn() {
    return fqn;
  }
  public void setFqn(String fqn) {
    this.fqn = fqn;
  }

  /**
   * Hint message
   **/
  public YAMLSchemaErrorWrapper hintMessage(String hintMessage) {
    this.hintMessage = hintMessage;
    return this;
  }

  
  @Schema(description = "Hint message")
  @JsonProperty("hint_message")

  public String getHintMessage() {
    return hintMessage;
  }
  public void setHintMessage(String hintMessage) {
    this.hintMessage = hintMessage;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    YAMLSchemaErrorWrapper yaMLSchemaErrorWrapper = (YAMLSchemaErrorWrapper) o;
    return Objects.equals(message, yaMLSchemaErrorWrapper.message) &&
        Objects.equals(messageFqn, yaMLSchemaErrorWrapper.messageFqn) &&
        Objects.equals(stageInfo, yaMLSchemaErrorWrapper.stageInfo) &&
        Objects.equals(stepInfo, yaMLSchemaErrorWrapper.stepInfo) &&
        Objects.equals(fqn, yaMLSchemaErrorWrapper.fqn) &&
        Objects.equals(hintMessage, yaMLSchemaErrorWrapper.hintMessage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(message, messageFqn, stageInfo, stepInfo, fqn, hintMessage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class YAMLSchemaErrorWrapper {\n");
    
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    messageFqn: ").append(toIndentedString(messageFqn)).append("\n");
    sb.append("    stageInfo: ").append(toIndentedString(stageInfo)).append("\n");
    sb.append("    stepInfo: ").append(toIndentedString(stepInfo)).append("\n");
    sb.append("    fqn: ").append(toIndentedString(fqn)).append("\n");
    sb.append("    hintMessage: ").append(toIndentedString(hintMessage)).append("\n");
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
