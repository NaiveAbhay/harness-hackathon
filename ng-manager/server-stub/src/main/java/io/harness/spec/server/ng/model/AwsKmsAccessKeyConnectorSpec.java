package io.harness.spec.server.ng.model;

import io.harness.spec.server.ng.model.ConnectorSpec;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * This contains details of the AWS and needs AWS encrypted access and secret keys for the AWS KMS.
 **/
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.v3.oas.annotations.media.Schema;



@Schema(description = "This contains details of the AWS and needs AWS encrypted access and secret keys for the AWS KMS.")

public class AwsKmsAccessKeyConnectorSpec extends ConnectorSpec implements OneOfConnectorSpec  {

  private @Valid String kmsArn = null;

  private @Valid String region = null;

  private @Valid Boolean _default = null;

  private @Valid String accessKey = null;

  private @Valid String secretKey = null;

  private @Valid List<String> delegateSelectors = new ArrayList<>();

  /**
   * Amazon Resource Name (ARN)
   **/
  public AwsKmsAccessKeyConnectorSpec kmsArn(String kmsArn) {
    this.kmsArn = kmsArn;
    return this;
  }

  
  @Schema(required = true, description = "Amazon Resource Name (ARN)")
  @JsonProperty("kms_arn")
  @NotNull

  public String getKmsArn() {
    return kmsArn;
  }
  public void setKmsArn(String kmsArn) {
    this.kmsArn = kmsArn;
  }

  /**
   * AWS Region for kms
   **/
  public AwsKmsAccessKeyConnectorSpec region(String region) {
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
  public AwsKmsAccessKeyConnectorSpec _default(Boolean _default) {
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
   * Access Key for AWS authentication
   **/
  public AwsKmsAccessKeyConnectorSpec accessKey(String accessKey) {
    this.accessKey = accessKey;
    return this;
  }

  
  @Schema(required = true, description = "Access Key for AWS authentication")
  @JsonProperty("access_key")
  @NotNull

  public String getAccessKey() {
    return accessKey;
  }
  public void setAccessKey(String accessKey) {
    this.accessKey = accessKey;
  }

  /**
   * Secret Key for AWS authentication
   **/
  public AwsKmsAccessKeyConnectorSpec secretKey(String secretKey) {
    this.secretKey = secretKey;
    return this;
  }

  
  @Schema(required = true, description = "Secret Key for AWS authentication")
  @JsonProperty("secret_key")
  @NotNull

  public String getSecretKey() {
    return secretKey;
  }
  public void setSecretKey(String secretKey) {
    this.secretKey = secretKey;
  }

  /**
   * List of Delegate Selectors that belong to the same Delegate and are used to connect to the Secret Manager
   **/
  public AwsKmsAccessKeyConnectorSpec delegateSelectors(List<String> delegateSelectors) {
    this.delegateSelectors = delegateSelectors;
    return this;
  }

  
  @Schema(description = "List of Delegate Selectors that belong to the same Delegate and are used to connect to the Secret Manager")
  @JsonProperty("delegate_selectors")

  public List<String> getDelegateSelectors() {
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
    AwsKmsAccessKeyConnectorSpec awsKmsAccessKeyConnectorSpec = (AwsKmsAccessKeyConnectorSpec) o;
    return Objects.equals(kmsArn, awsKmsAccessKeyConnectorSpec.kmsArn) &&
        Objects.equals(region, awsKmsAccessKeyConnectorSpec.region) &&
        Objects.equals(_default, awsKmsAccessKeyConnectorSpec._default) &&
        Objects.equals(accessKey, awsKmsAccessKeyConnectorSpec.accessKey) &&
        Objects.equals(secretKey, awsKmsAccessKeyConnectorSpec.secretKey) &&
        Objects.equals(delegateSelectors, awsKmsAccessKeyConnectorSpec.delegateSelectors);
  }

  @Override
  public int hashCode() {
    return Objects.hash(kmsArn, region, _default, accessKey, secretKey, delegateSelectors);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AwsKmsAccessKeyConnectorSpec {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    kmsArn: ").append(toIndentedString(kmsArn)).append("\n");
    sb.append("    region: ").append(toIndentedString(region)).append("\n");
    sb.append("    _default: ").append(toIndentedString(_default)).append("\n");
    sb.append("    accessKey: ").append(toIndentedString(accessKey)).append("\n");
    sb.append("    secretKey: ").append(toIndentedString(secretKey)).append("\n");
    sb.append("    delegateSelectors: ").append(toIndentedString(delegateSelectors)).append("\n");
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
