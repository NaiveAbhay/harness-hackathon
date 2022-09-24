package io.harness.spec.server.ng.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Schema(
    description =
        "This contains details of the Azure connector and uses Azure client certificate details")

public class AzureClientCertificateConnectorSpec
    extends ConnectorSpec implements OneOfConnectorSpec {

  private @Valid List<String> delegateSelectors = new ArrayList<>();

  public enum AzureEnvironmentTypeEnum {

    AZURE(String.valueOf("AZURE")),
    AZURE_US_GOVERNMENT(String.valueOf("AZURE_US_GOVERNMENT"));

    private String value;

    AzureEnvironmentTypeEnum(String v) { value = v; }

    public String value() { return value; }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static AzureEnvironmentTypeEnum fromValue(String v) {
      for (AzureEnvironmentTypeEnum b : AzureEnvironmentTypeEnum.values()) {
        if (String.valueOf(b.value).equals(v)) {
          return b;
        }
      }
      return null;
    }
  }
  private @Valid AzureEnvironmentTypeEnum azureEnvironmentType =
      AzureEnvironmentTypeEnum.AZURE;

  private @Valid Boolean executeOnDelegate = true;

  private @Valid String applicationId = null;

  private @Valid String tenantId = null;

  private @Valid String certificateRef = null;

  /**
   * List of Delegate Selectors that belong to the same Delegate and are used to
   *connect to the Secret Manager
   **/
  public AzureClientCertificateConnectorSpec
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

  /**
   * This specifies the Azure Environment type, which is AZURE by default.
   **/
  public AzureClientCertificateConnectorSpec
  azureEnvironmentType(AzureEnvironmentTypeEnum azureEnvironmentType) {
    this.azureEnvironmentType = azureEnvironmentType;
    return this;
  }

  @Schema(
      required = true,
      description =
          "This specifies the Azure Environment type, which is AZURE by default.")
  @JsonProperty("azure_environment_type")
  @NotNull

  public AzureEnvironmentTypeEnum
  getAzureEnvironmentType() {
    return azureEnvironmentType;
  }
  public void
  setAzureEnvironmentType(AzureEnvironmentTypeEnum azureEnvironmentType) {
    this.azureEnvironmentType = azureEnvironmentType;
  }

  /**
   * execute on delegate
   **/
  public AzureClientCertificateConnectorSpec
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

  /**
   * Application ID of the Azure App
   **/
  public AzureClientCertificateConnectorSpec
  applicationId(String applicationId) {
    this.applicationId = applicationId;
    return this;
  }

  @Schema(required = true, description = "Application ID of the Azure App")
  @JsonProperty("application_id")
  @NotNull

  public String getApplicationId() {
    return applicationId;
  }
  public void setApplicationId(String applicationId) {
    this.applicationId = applicationId;
  }

  /**
   * The Azure Active Directory (AAD) directory ID where you created your
   *application
   **/
  public AzureClientCertificateConnectorSpec tenantId(String tenantId) {
    this.tenantId = tenantId;
    return this;
  }

  @Schema(
      required = true,
      description =
          "The Azure Active Directory (AAD) directory ID where you created your application")
  @JsonProperty("tenant_id")
  @NotNull

  public String
  getTenantId() {
    return tenantId;
  }
  public void setTenantId(String tenantId) { this.tenantId = tenantId; }

  /**
   * Reference to encrypted Harness secret for Azure client secret
   **/
  public AzureClientCertificateConnectorSpec
  certificateRef(String certificateRef) {
    this.certificateRef = certificateRef;
    return this;
  }

  @Schema(required = true,
          description =
              "Reference to encrypted Harness secret for Azure client secret")
  @JsonProperty("certificate_ref")
  @NotNull

  public String
  getCertificateRef() {
    return certificateRef;
  }
  public void setCertificateRef(String certificateRef) {
    this.certificateRef = certificateRef;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AzureClientCertificateConnectorSpec azureClientCertificateConnectorSpec =
        (AzureClientCertificateConnectorSpec)o;
    return Objects.equals(
               delegateSelectors,
               azureClientCertificateConnectorSpec.delegateSelectors) &&
        Objects.equals(
            azureEnvironmentType,
            azureClientCertificateConnectorSpec.azureEnvironmentType) &&
        Objects.equals(executeOnDelegate,
                       azureClientCertificateConnectorSpec.executeOnDelegate) &&
        Objects.equals(applicationId,
                       azureClientCertificateConnectorSpec.applicationId) &&
        Objects.equals(tenantId,
                       azureClientCertificateConnectorSpec.tenantId) &&
        Objects.equals(certificateRef,
                       azureClientCertificateConnectorSpec.certificateRef);
  }

  @Override
  public int hashCode() {
    return Objects.hash(delegateSelectors, azureEnvironmentType,
                        executeOnDelegate, applicationId, tenantId,
                        certificateRef);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AzureClientCertificateConnectorSpec {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    delegateSelectors: ")
        .append(toIndentedString(delegateSelectors))
        .append("\n");
    sb.append("    azureEnvironmentType: ")
        .append(toIndentedString(azureEnvironmentType))
        .append("\n");
    sb.append("    executeOnDelegate: ")
        .append(toIndentedString(executeOnDelegate))
        .append("\n");
    sb.append("    applicationId: ")
        .append(toIndentedString(applicationId))
        .append("\n");
    sb.append("    tenantId: ").append(toIndentedString(tenantId)).append("\n");
    sb.append("    certificateRef: ")
        .append(toIndentedString(certificateRef))
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
