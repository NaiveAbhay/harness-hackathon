package io.harness.spec.server.ng.model;

import io.harness.spec.server.ng.model.ConnectorTestConnectionErrorDetail;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * This has test connection details for the Connector defined in Harness.
 **/
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.v3.oas.annotations.media.Schema;



@Schema(description = "This has test connection details for the Connector defined in Harness.")

public class ConnectorTestConnectionResponse   {

public enum StatusEnum {

    SUCCESS(String.valueOf("SUCCESS")), PARTIAL(String.valueOf("PARTIAL")), FAILURE(String.valueOf("FAILURE")), UNKNOWN(String.valueOf("UNKNOWN"));


    private String value;

    StatusEnum (String v) {
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
    public static StatusEnum fromValue(String v) {
        for (StatusEnum b : StatusEnum.values()) {
            if (String.valueOf(b.value).equals(v)) {
                return b;
            }
        }
        return null;
    }
}
  private @Valid StatusEnum status = null;

  private @Valid List<ConnectorTestConnectionErrorDetail> errors = new ArrayList<>();

  private @Valid String errorSummary = null;

  private @Valid Long testedAt = null;

  private @Valid String delegateId = null;

  /**
   * Connectivity status of a Connector
   **/
  public ConnectorTestConnectionResponse status(StatusEnum status) {
    this.status = status;
    return this;
  }

  
  @Schema(description = "Connectivity status of a Connector")
  @JsonProperty("status")

  public StatusEnum getStatus() {
    return status;
  }
  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  /**
   **/
  public ConnectorTestConnectionResponse errors(List<ConnectorTestConnectionErrorDetail> errors) {
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
   * Summary of errors
   **/
  public ConnectorTestConnectionResponse errorSummary(String errorSummary) {
    this.errorSummary = errorSummary;
    return this;
  }

  
  @Schema(description = "Summary of errors")
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
  public void setTestedAt(Long testedAt) {
    this.testedAt = testedAt;
  }

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
  public void setDelegateId(String delegateId) {
    this.delegateId = delegateId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConnectorTestConnectionResponse connectorTestConnectionResponse = (ConnectorTestConnectionResponse) o;
    return Objects.equals(status, connectorTestConnectionResponse.status) &&
        Objects.equals(errors, connectorTestConnectionResponse.errors) &&
        Objects.equals(errorSummary, connectorTestConnectionResponse.errorSummary) &&
        Objects.equals(testedAt, connectorTestConnectionResponse.testedAt) &&
        Objects.equals(delegateId, connectorTestConnectionResponse.delegateId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, errors, errorSummary, testedAt, delegateId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConnectorTestConnectionResponse {\n");
    
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    errors: ").append(toIndentedString(errors)).append("\n");
    sb.append("    errorSummary: ").append(toIndentedString(errorSummary)).append("\n");
    sb.append("    testedAt: ").append(toIndentedString(testedAt)).append("\n");
    sb.append("    delegateId: ").append(toIndentedString(delegateId)).append("\n");
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
