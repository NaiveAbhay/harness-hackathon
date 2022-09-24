package io.harness.spec.server.ng.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Schema(
    description =
        "This contains details of the AWS and needs AWS encrypted access and secret keys for the AWS Secret Manager.")

public class AwsSecretManagerAccessKeyConnectorSpec
    extends ConnectorSpec implements OneOfConnectorSpec {

  private @Valid String region = null;

  private @Valid Boolean _default = null;

  private @Valid String accessKey = null;

  private @Valid String secretKey = null;

  private @Valid String secretNamePrefix = null;

  private @Valid List<String> delegateSelectors = new ArrayList<>();

  /**
   * AWS Region for kms
   **/
  public AwsSecretManagerAccessKeyConnectorSpec region(String region) {
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
  public AwsSecretManagerAccessKeyConnectorSpec _default(Boolean _default) {
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
   * Access Key for AWS authentication
   **/
  public AwsSecretManagerAccessKeyConnectorSpec accessKey(String accessKey) {
    this.accessKey = accessKey;
    return this;
  }

  @Schema(required = true, description = "Access Key for AWS authentication")
  @JsonProperty("access_key")
  @NotNull

  public String getAccessKey() {
    return accessKey;
  }
  public void setAccessKey(String accessKey) { this.accessKey = accessKey; }

  /**
   * Secret Key for AWS authentication
   **/
  public AwsSecretManagerAccessKeyConnectorSpec secretKey(String secretKey) {
    this.secretKey = secretKey;
    return this;
  }

  @Schema(required = true, description = "Secret Key for AWS authentication")
  @JsonProperty("secret_key")
  @NotNull

  public String getSecretKey() {
    return secretKey;
  }
  public void setSecretKey(String secretKey) { this.secretKey = secretKey; }

  /**
   * Text that is prepended to the Secret name as a prefix
   **/
  public AwsSecretManagerAccessKeyConnectorSpec
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
  public AwsSecretManagerAccessKeyConnectorSpec
  delegateSelectors(List<String> delegateSelectors) {
    this.delegateSelectors = delegateSelectors;
    return this;
  }

  @Schema(
      description =
          "List of Delegate Selectors that belong to the same Delegate and are used to connect to the Secret Manager")
  @JsonProperty("delegate_selectors")

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
    AwsSecretManagerAccessKeyConnectorSpec
        awsSecretManagerAccessKeyConnectorSpec =
            (AwsSecretManagerAccessKeyConnectorSpec)o;
    return Objects.equals(region,
                          awsSecretManagerAccessKeyConnectorSpec.region) &&
        Objects.equals(_default,
                       awsSecretManagerAccessKeyConnectorSpec._default) &&
        Objects.equals(accessKey,
                       awsSecretManagerAccessKeyConnectorSpec.accessKey) &&
        Objects.equals(secretKey,
                       awsSecretManagerAccessKeyConnectorSpec.secretKey) &&
        Objects.equals(
            secretNamePrefix,
            awsSecretManagerAccessKeyConnectorSpec.secretNamePrefix) &&
        Objects.equals(
            delegateSelectors,
            awsSecretManagerAccessKeyConnectorSpec.delegateSelectors);
  }

  @Override
  public int hashCode() {
    return Objects.hash(region, _default, accessKey, secretKey,
                        secretNamePrefix, delegateSelectors);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AwsSecretManagerAccessKeyConnectorSpec {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    region: ").append(toIndentedString(region)).append("\n");
    sb.append("    _default: ").append(toIndentedString(_default)).append("\n");
    sb.append("    accessKey: ")
        .append(toIndentedString(accessKey))
        .append("\n");
    sb.append("    secretKey: ")
        .append(toIndentedString(secretKey))
        .append("\n");
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
