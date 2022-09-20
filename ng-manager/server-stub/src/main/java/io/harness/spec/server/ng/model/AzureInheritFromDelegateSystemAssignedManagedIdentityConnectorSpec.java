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
        "This contains details of the Azure connector for contains azure MSI auth details")

public class AzureInheritFromDelegateSystemAssignedManagedIdentityConnectorSpec
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

  /**
   * List of Delegate Selectors that belong to the same Delegate and are used to
   *connect to the Secret Manager
   **/
  public AzureInheritFromDelegateSystemAssignedManagedIdentityConnectorSpec
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
  public AzureInheritFromDelegateSystemAssignedManagedIdentityConnectorSpec
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
  public AzureInheritFromDelegateSystemAssignedManagedIdentityConnectorSpec
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
    AzureInheritFromDelegateSystemAssignedManagedIdentityConnectorSpec
        azureInheritFromDelegateSystemAssignedManagedIdentityConnectorSpec =
            (AzureInheritFromDelegateSystemAssignedManagedIdentityConnectorSpec)
                o;
    return Objects.equals(
               delegateSelectors,
               azureInheritFromDelegateSystemAssignedManagedIdentityConnectorSpec
                   .delegateSelectors) &&
        Objects.equals(
            azureEnvironmentType,
            azureInheritFromDelegateSystemAssignedManagedIdentityConnectorSpec
                .azureEnvironmentType) &&
        Objects.equals(
            executeOnDelegate,
            azureInheritFromDelegateSystemAssignedManagedIdentityConnectorSpec
                .executeOnDelegate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(delegateSelectors, azureEnvironmentType,
                        executeOnDelegate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(
        "class AzureInheritFromDelegateSystemAssignedManagedIdentityConnectorSpec {\n");
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
