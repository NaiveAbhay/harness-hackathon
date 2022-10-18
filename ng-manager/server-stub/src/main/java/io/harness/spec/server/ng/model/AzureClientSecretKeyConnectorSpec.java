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
* This contains details of the Azure connector and uses Azure client secret key details
**/


@Schema(description = "This contains details of the Azure connector and uses Azure client secret key details")

public class AzureClientSecretKeyConnectorSpec extends ConnectorSpec implements OneOfConnectorSpec  {

  private @Valid List<String> delegateSelectors = new ArrayList<>();

public enum AzureEnvironmentTypeEnum {

    AZURE(String.valueOf("AZURE")), AZURE_US_GOVERNMENT(String.valueOf("AZURE_US_GOVERNMENT"));


    private String value;

    AzureEnvironmentTypeEnum (String v) {
        value = v;
    }

    public String value() {
        return value;
    }

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
  private @Valid AzureEnvironmentTypeEnum azureEnvironmentType = AzureEnvironmentTypeEnum.AZURE;

  private @Valid Boolean executeOnDelegate = true;

  private @Valid String applicationId = null;

  private @Valid String tenantId = null;

  private @Valid String secretRef = null;

  /**
   * List of Delegate Selectors that belong to the same Delegate and are used to connect to the Secret Manager
   **/
  public AzureClientSecretKeyConnectorSpec delegateSelectors(List<String> delegateSelectors) {
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
   * This specifies the Azure Environment type, which is AZURE by default.
   **/
  public AzureClientSecretKeyConnectorSpec azureEnvironmentType(AzureEnvironmentTypeEnum azureEnvironmentType) {
    this.azureEnvironmentType = azureEnvironmentType;
    return this;
  }

  
  @Schema(required = true, description = "This specifies the Azure Environment type, which is AZURE by default.")
  @JsonProperty("azure_environment_type")
  @NotNull

  public AzureEnvironmentTypeEnum getAzureEnvironmentType() {
    return azureEnvironmentType;
  }
  public void setAzureEnvironmentType(AzureEnvironmentTypeEnum azureEnvironmentType) {
    this.azureEnvironmentType = azureEnvironmentType;
  }

  /**
   * execute on delegate
   **/
  public AzureClientSecretKeyConnectorSpec executeOnDelegate(Boolean executeOnDelegate) {
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
  public AzureClientSecretKeyConnectorSpec applicationId(String applicationId) {
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
   * The Azure Active Directory (AAD) directory ID where you created your application
   **/
  public AzureClientSecretKeyConnectorSpec tenantId(String tenantId) {
    this.tenantId = tenantId;
    return this;
  }

  
  @Schema(required = true, description = "The Azure Active Directory (AAD) directory ID where you created your application")
  @JsonProperty("tenant_id")
  @NotNull

  public String getTenantId() {
    return tenantId;
  }
  public void setTenantId(String tenantId) {
    this.tenantId = tenantId;
  }

  /**
   * Reference to encrypted Harness secret for Azure client secret
   **/
  public AzureClientSecretKeyConnectorSpec secretRef(String secretRef) {
    this.secretRef = secretRef;
    return this;
  }

  
  @Schema(required = true, description = "Reference to encrypted Harness secret for Azure client secret")
  @JsonProperty("secret_ref")
  @NotNull

  public String getSecretRef() {
    return secretRef;
  }
  public void setSecretRef(String secretRef) {
    this.secretRef = secretRef;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AzureClientSecretKeyConnectorSpec azureClientSecretKeyConnectorSpec = (AzureClientSecretKeyConnectorSpec) o;
    return Objects.equals(delegateSelectors, azureClientSecretKeyConnectorSpec.delegateSelectors) &&
        Objects.equals(azureEnvironmentType, azureClientSecretKeyConnectorSpec.azureEnvironmentType) &&
        Objects.equals(executeOnDelegate, azureClientSecretKeyConnectorSpec.executeOnDelegate) &&
        Objects.equals(applicationId, azureClientSecretKeyConnectorSpec.applicationId) &&
        Objects.equals(tenantId, azureClientSecretKeyConnectorSpec.tenantId) &&
        Objects.equals(secretRef, azureClientSecretKeyConnectorSpec.secretRef);
  }

  @Override
  public int hashCode() {
    return Objects.hash(delegateSelectors, azureEnvironmentType, executeOnDelegate, applicationId, tenantId, secretRef);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AzureClientSecretKeyConnectorSpec {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    delegateSelectors: ").append(toIndentedString(delegateSelectors)).append("\n");
    sb.append("    azureEnvironmentType: ").append(toIndentedString(azureEnvironmentType)).append("\n");
    sb.append("    executeOnDelegate: ").append(toIndentedString(executeOnDelegate)).append("\n");
    sb.append("    applicationId: ").append(toIndentedString(applicationId)).append("\n");
    sb.append("    tenantId: ").append(toIndentedString(tenantId)).append("\n");
    sb.append("    secretRef: ").append(toIndentedString(secretRef)).append("\n");
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
