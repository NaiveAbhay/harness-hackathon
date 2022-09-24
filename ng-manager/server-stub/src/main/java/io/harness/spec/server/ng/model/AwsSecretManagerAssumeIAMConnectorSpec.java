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

public class AwsSecretManagerAssumeIAMConnectorSpec
    extends ConnectorSpec implements OneOfConnectorSpec {

  private @Valid String region = null;

  private @Valid Boolean _default = null;

  private @Valid String secretNamePrefix = null;

  private @Valid List<String> delegateSelectors = new ArrayList<>();

  /**
   * AWS Region for kms
   **/
  public AwsSecretManagerAssumeIAMConnectorSpec region(String region) {
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
  public AwsSecretManagerAssumeIAMConnectorSpec _default(Boolean _default) {
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
   * Text that is prepended to the Secret name as a prefix
   **/
  public AwsSecretManagerAssumeIAMConnectorSpec
  secretNamePrefix(String secretNamePrefix) {
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
   * List of Delegate Selectors that belong to the same Delegate and are used to
   *connect to the Secret Manager
   **/
  public AwsSecretManagerAssumeIAMConnectorSpec
  delegateSelectors(List<String> delegateSelectors) {
    this.delegateSelectors = delegateSelectors;
    return this;
  }

  @Schema(
      description =
          "List of Delegate Selectors that belong to the same Delegate and are used to connect to the Secret Manager")
  @JsonProperty("delegate_selectors")
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
    AwsSecretManagerAssumeIAMConnectorSpec
        awsSecretManagerAssumeIAMConnectorSpec =
            (AwsSecretManagerAssumeIAMConnectorSpec)o;
    return Objects.equals(region,
                          awsSecretManagerAssumeIAMConnectorSpec.region) &&
        Objects.equals(_default,
                       awsSecretManagerAssumeIAMConnectorSpec._default) &&
        Objects.equals(
            secretNamePrefix,
            awsSecretManagerAssumeIAMConnectorSpec.secretNamePrefix) &&
        Objects.equals(
            delegateSelectors,
            awsSecretManagerAssumeIAMConnectorSpec.delegateSelectors);
  }

  @Override
  public int hashCode() {
    return Objects.hash(region, _default, secretNamePrefix, delegateSelectors);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AwsSecretManagerAssumeIAMConnectorSpec {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    region: ").append(toIndentedString(region)).append("\n");
    sb.append("    _default: ").append(toIndentedString(_default)).append("\n");
    sb.append("    secretNamePrefix: ")
        .append(toIndentedString(secretNamePrefix))
        .append("\n");
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
