package io.harness.spec.server.ng.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.validation.Valid;

@Schema(
    description =
        "This contains details of the AWS connector. This uses IRSA and forces the Harness kubernetes delegate in AWS EKS to use a specific IAM role.")

public class AwsIRSAConnectorSpec
    extends ConnectorSpec implements OneOfConnectorSpec {

  private @Valid String crossAccountRoleArn = null;

  private @Valid String externalId = null;

  private @Valid String testRegion = null;

  private @Valid List<String> delegateSelectors = new ArrayList<>();

  private @Valid Boolean executeOnDelegate = true;

  /**
   * If you want to use one AWS account for the connection, but you want to
   *deploy or build in a different AWS account. In this scenario, the AWS
   *account used for AWS access in Credentials will assume the IAM role you
   *specify in Cross-account role ARN setting. This option uses the AWS Security
   *Token Service (STS) feature.
   **/
  public AwsIRSAConnectorSpec crossAccountRoleArn(String crossAccountRoleArn) {
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
  public AwsIRSAConnectorSpec externalId(String externalId) {
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
  public AwsIRSAConnectorSpec testRegion(String testRegion) {
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
  public AwsIRSAConnectorSpec
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
  public AwsIRSAConnectorSpec executeOnDelegate(Boolean executeOnDelegate) {
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
    AwsIRSAConnectorSpec awsIRSAConnectorSpec = (AwsIRSAConnectorSpec)o;
    return Objects.equals(crossAccountRoleArn,
                          awsIRSAConnectorSpec.crossAccountRoleArn) &&
        Objects.equals(externalId, awsIRSAConnectorSpec.externalId) &&
        Objects.equals(testRegion, awsIRSAConnectorSpec.testRegion) &&
        Objects.equals(delegateSelectors,
                       awsIRSAConnectorSpec.delegateSelectors) &&
        Objects.equals(executeOnDelegate,
                       awsIRSAConnectorSpec.executeOnDelegate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(crossAccountRoleArn, externalId, testRegion,
                        delegateSelectors, executeOnDelegate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AwsIRSAConnectorSpec {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
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
