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
        "This contains details of the AWS connector and needs AWS encrypted access and secret keys for an AWS IAM user.")

public class AwsEncryptedAccessKeyConnectorSpec
    extends ConnectorSpec implements OneOfConnectorSpec {

  private @Valid String accessKeyRef = null;

  private @Valid String secretKeyRef = null;

  private @Valid String crossAccountRoleArn = null;

  private @Valid String externalId = null;

  private @Valid String testRegion = null;

  private @Valid List<String> delegateSelectors = new ArrayList<>();

  private @Valid Boolean executeOnDelegate = true;

  /**
   * Reference to encrypted Harness secret for AWS access key
   **/
  public AwsEncryptedAccessKeyConnectorSpec accessKeyRef(String accessKeyRef) {
    this.accessKeyRef = accessKeyRef;
    return this;
  }

  @Schema(
      required = true,
      description = "Reference to encrypted Harness secret for AWS access key")
  @JsonProperty("access_key_ref")
  @NotNull

  public String
  getAccessKeyRef() {
    return accessKeyRef;
  }
  public void setAccessKeyRef(String accessKeyRef) {
    this.accessKeyRef = accessKeyRef;
  }

  /**
   * Reference to encrypted Harness secret for AWS secret key
   **/
  public AwsEncryptedAccessKeyConnectorSpec secretKeyRef(String secretKeyRef) {
    this.secretKeyRef = secretKeyRef;
    return this;
  }

  @Schema(
      required = true,
      description = "Reference to encrypted Harness secret for AWS secret key")
  @JsonProperty("secret_key_ref")
  @NotNull

  public String
  getSecretKeyRef() {
    return secretKeyRef;
  }
  public void setSecretKeyRef(String secretKeyRef) {
    this.secretKeyRef = secretKeyRef;
  }

  /**
   * If you want to use one AWS account for the connection, but you want to
   *deploy or build in a different AWS account. In this scenario, the AWS
   *account used for AWS access in Credentials will assume the IAM role you
   *specify in Cross-account role ARN setting. This option uses the AWS Security
   *Token Service (STS) feature.
   **/
  public AwsEncryptedAccessKeyConnectorSpec
  crossAccountRoleArn(String crossAccountRoleArn) {
    this.crossAccountRoleArn = crossAccountRoleArn;
    return this;
  }

  @Schema(
      description =
          "If you want to use one AWS account for the connection, but you want to deploy or build in a different AWS account. In this scenario, the AWS account used for AWS access in Credentials will assume the IAM role you specify in Cross-account role ARN setting. This option uses the AWS Security Token Service (STS) feature.")
  @JsonProperty("cross_account_role_arn")

  public String
  getCrossAccountRoleArn() {
    return crossAccountRoleArn;
  }
  public void setCrossAccountRoleArn(String crossAccountRoleArn) {
    this.crossAccountRoleArn = crossAccountRoleArn;
  }

  /**
   * If the administrator of the account to which the role belongs provided you
   *with an external ID, then enter that value.
   **/
  public AwsEncryptedAccessKeyConnectorSpec externalId(String externalId) {
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
   * By default, Harness uses the us-east-1 region to test the credentials for
   *this Connector. If you want to use an AWS GovCloud account for this
   *Connector, select it in Test Region. GovCloud is used by organizations such
   *as government agencies at the federal, state, and local level, as well as
   *contractors, educational institutions. It is also used for regulatory
   *compliance with these organizations.
   **/
  public AwsEncryptedAccessKeyConnectorSpec testRegion(String testRegion) {
    this.testRegion = testRegion;
    return this;
  }

  @Schema(
      description =
          "By default, Harness uses the us-east-1 region to test the credentials for this Connector. If you want to use an AWS GovCloud account for this Connector, select it in Test Region. GovCloud is used by organizations such as government agencies at the federal, state, and local level, as well as contractors, educational institutions. It is also used for regulatory compliance with these organizations.")
  @JsonProperty("test_region")

  public String
  getTestRegion() {
    return testRegion;
  }
  public void setTestRegion(String testRegion) { this.testRegion = testRegion; }

  /**
   * List of unique delegate selectors
   **/
  public AwsEncryptedAccessKeyConnectorSpec
  delegateSelectors(List<String> delegateSelectors) {
    this.delegateSelectors = delegateSelectors;
    return this;
  }

  @Schema(description = "List of unique delegate selectors")
  @JsonProperty("delegate_selectors")

  public List<String> getDelegateSelectors() {
    return delegateSelectors;
  }
  public void setDelegateSelectors(List<String> delegateSelectors) {
    this.delegateSelectors = delegateSelectors;
  }

  /**
   * execute on delegate
   **/
  public AwsEncryptedAccessKeyConnectorSpec
  executeOnDelegate(Boolean executeOnDelegate) {
    this.executeOnDelegate = executeOnDelegate;
    return this;
  }

  @Schema(description = "execute on delegate")
  @JsonProperty("execute_on_delegate")

  public Boolean isExecuteOnDelegate() {
    return executeOnDelegate;
  }
  public void setExecuteOnDelegate(Boolean executeOnDelegate) {
    this.executeOnDelegate = executeOnDelegate;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AwsEncryptedAccessKeyConnectorSpec awsEncryptedAccessKeyConnectorSpec =
        (AwsEncryptedAccessKeyConnectorSpec)o;
    return Objects.equals(accessKeyRef,
                          awsEncryptedAccessKeyConnectorSpec.accessKeyRef) &&
        Objects.equals(secretKeyRef,
                       awsEncryptedAccessKeyConnectorSpec.secretKeyRef) &&
        Objects.equals(
            crossAccountRoleArn,
            awsEncryptedAccessKeyConnectorSpec.crossAccountRoleArn) &&
        Objects.equals(externalId,
                       awsEncryptedAccessKeyConnectorSpec.externalId) &&
        Objects.equals(testRegion,
                       awsEncryptedAccessKeyConnectorSpec.testRegion) &&
        Objects.equals(delegateSelectors,
                       awsEncryptedAccessKeyConnectorSpec.delegateSelectors) &&
        Objects.equals(executeOnDelegate,
                       awsEncryptedAccessKeyConnectorSpec.executeOnDelegate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accessKeyRef, secretKeyRef, crossAccountRoleArn,
                        externalId, testRegion, delegateSelectors,
                        executeOnDelegate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AwsEncryptedAccessKeyConnectorSpec {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    accessKeyRef: ")
        .append(toIndentedString(accessKeyRef))
        .append("\n");
    sb.append("    secretKeyRef: ")
        .append(toIndentedString(secretKeyRef))
        .append("\n");
    sb.append("    crossAccountRoleArn: ")
        .append(toIndentedString(crossAccountRoleArn))
        .append("\n");
    sb.append("    externalId: ")
        .append(toIndentedString(externalId))
        .append("\n");
    sb.append("    testRegion: ")
        .append(toIndentedString(testRegion))
        .append("\n");
    sb.append("    delegateSelectors: ")
        .append(toIndentedString(delegateSelectors))
        .append("\n");
    sb.append("    executeOnDelegate: ")
        .append(toIndentedString(executeOnDelegate))
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
