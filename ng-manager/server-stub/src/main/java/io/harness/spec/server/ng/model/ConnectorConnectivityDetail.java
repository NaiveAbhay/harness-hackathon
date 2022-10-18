/*
* Copyright 2022 Harness Inc. All rights reserved.
* Use of this source code is governed by the PolyForm Free Trial 1.0.0 license
* that can be found in the licenses directory at the root of this repository, also available at
* https://polyformproject.org/wp-content/uploads/2020/05/PolyForm-Free-Trial-1.0.0.txt.
*/

package io.harness.spec.server.ng.model;

import io.harness.spec.server.ng.model.ConnectorTestConnectionErrorDetail;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.Valid;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.v3.oas.annotations.media.Schema;
/**
* This has details of the connectivity status of the Connector.
**/


@Schema(description = "This has details of the connectivity status of the Connector.")

public class ConnectorConnectivityDetail   {

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

  private @Valid Long connectedAt = null;

  /**
   * Connectivity status of a Connector
   **/
  public ConnectorConnectivityDetail status(StatusEnum status) {
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
   * List of errors and their details
   **/
  public ConnectorConnectivityDetail errors(List<ConnectorTestConnectionErrorDetail> errors) {
    this.errors = errors;
    return this;
  }

  
  @Schema(description = "List of errors and their details")
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
  public ConnectorConnectivityDetail errorSummary(String errorSummary) {
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
  public ConnectorConnectivityDetail testedAt(Long testedAt) {
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
   * This is the last time at which the Connector was successfully connected
   **/
  public ConnectorConnectivityDetail connectedAt(Long connectedAt) {
    this.connectedAt = connectedAt;
    return this;
  }

  
  @Schema(description = "This is the last time at which the Connector was successfully connected")
  @JsonProperty("connected_at")

  public Long getConnectedAt() {
    return connectedAt;
  }
  public void setConnectedAt(Long connectedAt) {
    this.connectedAt = connectedAt;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConnectorConnectivityDetail connectorConnectivityDetail = (ConnectorConnectivityDetail) o;
    return Objects.equals(status, connectorConnectivityDetail.status) &&
        Objects.equals(errors, connectorConnectivityDetail.errors) &&
        Objects.equals(errorSummary, connectorConnectivityDetail.errorSummary) &&
        Objects.equals(testedAt, connectorConnectivityDetail.testedAt) &&
        Objects.equals(connectedAt, connectorConnectivityDetail.connectedAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, errors, errorSummary, testedAt, connectedAt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConnectorConnectivityDetail {\n");
    
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    errors: ").append(toIndentedString(errors)).append("\n");
    sb.append("    errorSummary: ").append(toIndentedString(errorSummary)).append("\n");
    sb.append("    testedAt: ").append(toIndentedString(testedAt)).append("\n");
    sb.append("    connectedAt: ").append(toIndentedString(connectedAt)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
