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

public class AwsKmsAssumeIAMConnectorSpec
    extends ConnectorSpec implements OneOfConnectorSpec {

  private @Valid String kmsArn = null;

  private @Valid String region = null;

  private @Valid Boolean _default = null;

  private @Valid List<String> delegateSelectors = new ArrayList<>();

  /**
   * Amazon Resource Name (ARN)
   **/
  public AwsKmsAssumeIAMConnectorSpec kmsArn(String kmsArn) {
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
  public AwsKmsAssumeIAMConnectorSpec region(String region) {
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
  public AwsKmsAssumeIAMConnectorSpec _default(Boolean _default) {
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
  public AwsKmsAssumeIAMConnectorSpec
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

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AwsKmsAssumeIAMConnectorSpec awsKmsAssumeIAMConnectorSpec =
        (AwsKmsAssumeIAMConnectorSpec)o;
    return Objects.equals(kmsArn, awsKmsAssumeIAMConnectorSpec.kmsArn) &&
        Objects.equals(region, awsKmsAssumeIAMConnectorSpec.region) &&
        Objects.equals(_default, awsKmsAssumeIAMConnectorSpec._default) &&
        Objects.equals(delegateSelectors,
                       awsKmsAssumeIAMConnectorSpec.delegateSelectors);
  }

  @Override
  public int hashCode() {
    return Objects.hash(kmsArn, region, _default, delegateSelectors);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AwsKmsAssumeIAMConnectorSpec {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    kmsArn: ").append(toIndentedString(kmsArn)).append("\n");
    sb.append("    region: ").append(toIndentedString(region)).append("\n");
    sb.append("    _default: ").append(toIndentedString(_default)).append("\n");
    sb.append("    delegateSelectors: ")
        .append(toIndentedString(delegateSelectors))
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
