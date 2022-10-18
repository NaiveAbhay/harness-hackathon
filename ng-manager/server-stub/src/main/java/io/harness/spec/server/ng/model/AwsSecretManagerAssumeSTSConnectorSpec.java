/*
* Copyright 2022 Harness Inc. All rights reserved.
* Use of this source code is governed by the PolyForm Free Trial 1.0.0 license
* that can be found in the licenses directory at the root of this repository, also available at
* https://polyformproject.org/wp-content/uploads/2020/05/PolyForm-Free-Trial-1.0.0.txt.
*/

package io.harness.spec.server.ng.model;

import io.harness.spec.server.ng.model.ConnectorSpec;
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
* This contains details of the AWS connector and Harness will authenticate using the STS role assigned to the AWS host running the Delegate, you select using a Delegate Selector.
**/


@Schema(description = "This contains details of the AWS connector and Harness will authenticate using the STS role assigned to the AWS host running the Delegate, you select using a Delegate Selector.")

public class AwsSecretManagerAssumeSTSConnectorSpec extends ConnectorSpec implements OneOfConnectorSpec  {

  private @Valid String region = null;

  private @Valid Boolean _default = null;

  private @Valid String secretNamePrefix = null;

  private @Valid List<String> delegateSelectors = new ArrayList<>();

  private @Valid String roleArn = null;

  private @Valid String externalId = null;

  private @Valid String assumeStsRoleDuration = null;

  /**
   * AWS Region for kms
   **/
  public AwsSecretManagerAssumeSTSConnectorSpec region(String region) {
    this.region = region;
    return this;
  }

  
  @Schema(required = true, description = "AWS Region for kms")
  @JsonProperty("region")
  @NotNull

  public String getRegion() {
    return region;
  }
  public void setRegion(String region) {
    this.region = region;
  }

  /**
   * Boolean value to indicate if the Secret Manager is your default Secret Manager
   **/
  public AwsSecretManagerAssumeSTSConnectorSpec _default(Boolean _default) {
    this._default = _default;
    return this;
  }

  
  @Schema(description = "Boolean value to indicate if the Secret Manager is your default Secret Manager")
  @JsonProperty("default")

  public Boolean isDefault() {
    return _default;
  }
  public void setDefault(Boolean _default) {
    this._default = _default;
  }

  /**
   * Text that is prepended to the Secret name as a prefix
   **/
  public AwsSecretManagerAssumeSTSConnectorSpec secretNamePrefix(String secretNamePrefix) {
    this.secretNamePrefix = secretNamePrefix;
    return this;
  }

  
  @Schema(description = "Text that is prepended to the Secret name as a prefix")
  @JsonProperty("secret_name_prefix")

  public String getSecretNamePrefix() {
    return secretNamePrefix;
  }
  public void setSecretNamePrefix(String secretNamePrefix) {
    this.secretNamePrefix = secretNamePrefix;
  }

  /**
   * List of Delegate Selectors that belong to the same Delegate and are used to connect to the Secret Manager
   **/
  public AwsSecretManagerAssumeSTSConnectorSpec delegateSelectors(List<String> delegateSelectors) {
    this.delegateSelectors = delegateSelectors;
    return this;
  }

  
  @Schema(description = "List of Delegate Selectors that belong to the same Delegate and are used to connect to the Secret Manager")
  @JsonProperty("delegate_selectors")
 @Size(min=1)
  public List<String> getDelegateSelectors() {
    return delegateSelectors;
  }
  public void setDelegateSelectors(List<String> delegateSelectors) {
    this.delegateSelectors = delegateSelectors;
  }

  /**
   * Role ARN for the Delegate with STS Role
   **/
  public AwsSecretManagerAssumeSTSConnectorSpec roleArn(String roleArn) {
    this.roleArn = roleArn;
    return this;
  }

  
  @Schema(required = true, description = "Role ARN for the Delegate with STS Role")
  @JsonProperty("role_arn")
  @NotNull

  public String getRoleArn() {
    return roleArn;
  }
  public void setRoleArn(String roleArn) {
    this.roleArn = roleArn;
  }

  /**
   * If the administrator of the account to which the role belongs provided you with an external ID, then enter that value.
   **/
  public AwsSecretManagerAssumeSTSConnectorSpec externalId(String externalId) {
    this.externalId = externalId;
    return this;
  }

  
  @Schema(description = "If the administrator of the account to which the role belongs provided you with an external ID, then enter that value.")
  @JsonProperty("external_id")

  public String getExternalId() {
    return externalId;
  }
  public void setExternalId(String externalId) {
    this.externalId = externalId;
  }

  /**
   * This is the AssumeRole Session Duration
   **/
  public AwsSecretManagerAssumeSTSConnectorSpec assumeStsRoleDuration(String assumeStsRoleDuration) {
    this.assumeStsRoleDuration = assumeStsRoleDuration;
    return this;
  }

  
  @Schema(description = "This is the AssumeRole Session Duration")
  @JsonProperty("assume_sts_role_duration")

  public String getAssumeStsRoleDuration() {
    return assumeStsRoleDuration;
  }
  public void setAssumeStsRoleDuration(String assumeStsRoleDuration) {
    this.assumeStsRoleDuration = assumeStsRoleDuration;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AwsSecretManagerAssumeSTSConnectorSpec awsSecretManagerAssumeSTSConnectorSpec = (AwsSecretManagerAssumeSTSConnectorSpec) o;
    return Objects.equals(region, awsSecretManagerAssumeSTSConnectorSpec.region) &&
        Objects.equals(_default, awsSecretManagerAssumeSTSConnectorSpec._default) &&
        Objects.equals(secretNamePrefix, awsSecretManagerAssumeSTSConnectorSpec.secretNamePrefix) &&
        Objects.equals(delegateSelectors, awsSecretManagerAssumeSTSConnectorSpec.delegateSelectors) &&
        Objects.equals(roleArn, awsSecretManagerAssumeSTSConnectorSpec.roleArn) &&
        Objects.equals(externalId, awsSecretManagerAssumeSTSConnectorSpec.externalId) &&
        Objects.equals(assumeStsRoleDuration, awsSecretManagerAssumeSTSConnectorSpec.assumeStsRoleDuration);
  }

  @Override
  public int hashCode() {
    return Objects.hash(region, _default, secretNamePrefix, delegateSelectors, roleArn, externalId, assumeStsRoleDuration);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AwsSecretManagerAssumeSTSConnectorSpec {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    region: ").append(toIndentedString(region)).append("\n");
    sb.append("    _default: ").append(toIndentedString(_default)).append("\n");
    sb.append("    secretNamePrefix: ").append(toIndentedString(secretNamePrefix)).append("\n");
    sb.append("    delegateSelectors: ").append(toIndentedString(delegateSelectors)).append("\n");
    sb.append("    roleArn: ").append(toIndentedString(roleArn)).append("\n");
    sb.append("    externalId: ").append(toIndentedString(externalId)).append("\n");
    sb.append("    assumeStsRoleDuration: ").append(toIndentedString(assumeStsRoleDuration)).append("\n");
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
