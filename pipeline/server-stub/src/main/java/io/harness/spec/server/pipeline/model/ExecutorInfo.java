package io.harness.spec.server.pipeline.model;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * Information regarding Executor of Pipeline.
 **/
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

@Schema(description = "Information regarding Executor of Pipeline.")

public class ExecutorInfo   {

public enum TriggerTypeEnum {

    NOOP(String.valueOf("NOOP")), MANUAL(String.valueOf("MANUAL")), WEBHOOK(String.valueOf("WEBHOOK")), WEBHOOK_CUSTOM(String.valueOf("WEBHOOK_CUSTOM")), SCHEDULER_CRON(String.valueOf("SCHEDULER_CRON"));


    private String value;

    TriggerTypeEnum (String v) {
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
    public static TriggerTypeEnum fromValue(String v) {
        for (TriggerTypeEnum b : TriggerTypeEnum.values()) {
            if (String.valueOf(b.value).equals(v)) {
                return b;
            }
        }
        return null;
    }
}
  private @Valid TriggerTypeEnum triggerType = null;

  private @Valid String username = null;

  private @Valid String email = null;

  /**
   * Trigger type
   **/
  public ExecutorInfo triggerType(TriggerTypeEnum triggerType) {
    this.triggerType = triggerType;
    return this;
  }

  
  @Schema(description = "Trigger type")
  @JsonProperty("trigger_type")

  public TriggerTypeEnum getTriggerType() {
    return triggerType;
  }
  public void setTriggerType(TriggerTypeEnum triggerType) {
    this.triggerType = triggerType;
  }

  /**
   * Username of the Executor.
   **/
  public ExecutorInfo username(String username) {
    this.username = username;
    return this;
  }

  
  @Schema(description = "Username of the Executor.")
  @JsonProperty("username")
 @Pattern(regexp="^[a-zA-Z_][0-9a-zA-Z_$]{0,63}$") @Size(min=1,max=64)
  public String getUsername() {
    return username;
  }
  public void setUsername(String username) {
    this.username = username;
  }

  /**
   * Email address of the Executor.
   **/
  public ExecutorInfo email(String email) {
    this.email = email;
    return this;
  }

  
  @Schema(description = "Email address of the Executor.")
  @JsonProperty("email")

  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ExecutorInfo executorInfo = (ExecutorInfo) o;
    return Objects.equals(triggerType, executorInfo.triggerType) &&
        Objects.equals(username, executorInfo.username) &&
        Objects.equals(email, executorInfo.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(triggerType, username, email);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ExecutorInfo {\n");
    
    sb.append("    triggerType: ").append(toIndentedString(triggerType)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
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
