package io.harness.spec.server.ng.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Schema(
    description =
        "This contains details of the AWS connector and Harness will authenticate using the IAM role assigned to the AWS host running the Delegate, you select using a Delegate Selector.")

public class AwsKmsAssumeSTSConnectorSpec
    extends ConnectorSpec implements OneOfConnectorSpec {

  private @Valid String kmsArn = null;

  private @Valid String region = null;

  private @Valid Boolean _default = null;

  private @Valid List<String> delegateSelectors = new ArrayList<>();

  private @Valid String roleArn = null;

  private @Valid String externalId = null;

  private @Valid String assumeStsRoleDuration = null;

  /**
   * Amazon Resource Name (ARN)
   **/
  public AwsKmsAssumeSTSConnectorSpec kmsArn(String kmsArn) {
    this.kmsArn = kmsArn;
    return this;
  }

  @Schema(required = true, description = "Amazon Resource Name (ARN)")
  @JsonProperty("kms_arn")
  @NotNull

  public String getKmsArn() {
    return kmsArn;
  }
  public void setKmsArn(String kmsArn) { this.kmsArn = kmsArn; }

  /**
   * AWS Region for kms
   **/
  public AwsKmsAssumeSTSConnectorSpec region(String region) {
    this.region = region;
    return this;
  }

  @Schema(required = true, description = "AWS Region for kms")
  @JsonProperty("region")
  @NotNull

  public String getRegion() {
    return region;
  }
  public void setRegion(String region) { this.region = region; }

  /**
   * Boolean value to indicate if the Secret Manager is your default Secret
   *Manager
   **/
  public AwsKmsAssumeSTSConnectorSpec _default(Boolean _default) {
    this._default = _default;
    return this;
  }

  @Schema(
      description =
          "Boolean value to indicate if the Secret Manager is your default Secret Manager")
  @JsonProperty("default")

  public Boolean
  isDefault() {
    return _default;
  }
  public void setDefault(Boolean _default) { this._default = _default; }

  /**
   * List of Delegate Selectors that belong to the same Delegate and are used to
   *connect to the Secret Manager
   **/
  public AwsKmsAssumeSTSConnectorSpec
  delegateSelectors(List<String> delegateSelectors) {
    this.delegateSelectors = delegateSelectors;
    return this;
  }

  @Schema(
      required = true,
      description =
          "List of Delegate Selectors that belong to the same Delegate and are used to connect to the Secret Manager")
  @JsonProperty("delegate_selectors")
  @NotNull
  @Size(min = 1)
  public List<String>
  getDelegateSelectors() {
    return delegateSelectors;
  }
  public void setDelegateSelectors(List<String> delegateSelectors) {
    this.delegateSelectors = delegateSelectors;
  }

  /**
   * Role ARN for the Delegate with STS Role
   **/
  public AwsKmsAssumeSTSConnectorSpec roleArn(String roleArn) {
    this.roleArn = roleArn;
    return this;
  }

  @Schema(description = "Role ARN for the Delegate with STS Role")
  @JsonProperty("role_arn")

  public String getRoleArn() {
    return roleArn;
  }
  public void setRoleArn(String roleArn) { this.roleArn = roleArn; }

  /**
   * If the administrator of the account to which the role belongs provided you
   *with an external ID, then enter that value.
   **/
  public AwsKmsAssumeSTSConnectorSpec externalId(String externalId) {
    this.externalId = externalId;
    return this;
  }

  @Schema(
      description =
          "If the administrator of the account to which the role belongs provided you with an external ID, then enter that value.")
  @JsonProperty("external_id")

  public String
  getExternalId() {
    return externalId;
  }
  public void setExternalId(String externalId) { this.externalId = externalId; }

  /**
   * This is the AssumeRole Session Duration
   **/
  public AwsKmsAssumeSTSConnectorSpec
  assumeStsRoleDuration(String assumeStsRoleDuration) {
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
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AwsKmsAssumeSTSConnectorSpec awsKmsAssumeSTSConnectorSpec =
        (AwsKmsAssumeSTSConnectorSpec)o;
    return Objects.equals(kmsArn, awsKmsAssumeSTSConnectorSpec.kmsArn) &&
        Objects.equals(region, awsKmsAssumeSTSConnectorSpec.region) &&
        Objects.equals(_default, awsKmsAssumeSTSConnectorSpec._default) &&
        Objects.equals(delegateSelectors,
                       awsKmsAssumeSTSConnectorSpec.delegateSelectors) &&
        Objects.equals(roleArn, awsKmsAssumeSTSConnectorSpec.roleArn) &&
        Objects.equals(externalId, awsKmsAssumeSTSConnectorSpec.externalId) &&
        Objects.equals(assumeStsRoleDuration,
                       awsKmsAssumeSTSConnectorSpec.assumeStsRoleDuration);
  }

  @Override
  public int hashCode() {
    return Objects.hash(kmsArn, region, _default, delegateSelectors, roleArn,
                        externalId, assumeStsRoleDuration);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AwsKmsAssumeSTSConnectorSpec {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    kmsArn: ").append(toIndentedString(kmsArn)).append("\n");
    sb.append("    region: ").append(toIndentedString(region)).append("\n");
    sb.append("    _default: ").append(toIndentedString(_default)).append("\n");
    sb.append("    delegateSelectors: ")
        .append(toIndentedString(delegateSelectors))
        .append("\n");
    sb.append("    roleArn: ").append(toIndentedString(roleArn)).append("\n");
    sb.append("    externalId: ")
        .append(toIndentedString(externalId))
        .append("\n");
    sb.append("    assumeStsRoleDuration: ")
        .append(toIndentedString(assumeStsRoleDuration))
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
