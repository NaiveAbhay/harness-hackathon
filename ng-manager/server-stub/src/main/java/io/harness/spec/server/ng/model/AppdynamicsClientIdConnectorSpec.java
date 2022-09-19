package io.harness.spec.server.ng.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;



@Schema(description = "This contains details of the appdynamics connector with client secrets")

public class AppdynamicsClientIdConnectorSpec extends ConnectorSpec implements OneOfConnectorSpec  {

  private @Valid List<String> delegateSelectors = new ArrayList<>();

  private @Valid String accountName = null;

  private @Valid String controllerUrl = null;

  private @Valid String clientId = null;

  private @Valid String clientSecretRef = null;

  /**
   * List of unique delegate selectors
   **/
  public AppdynamicsClientIdConnectorSpec delegateSelectors(List<String> delegateSelectors) {
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
   * appdymanics account name
   **/
  public AppdynamicsClientIdConnectorSpec accountName(String accountName) {
    this.accountName = accountName;
    return this;
  }

  
  @Schema(required = true, description = "appdymanics account name")
  @JsonProperty("account_name")
  @NotNull

  public String getAccountName() {
    return accountName;
  }
  public void setAccountName(String accountName) {
    this.accountName = accountName;
  }

  /**
   * appdynamics controller url
   **/
  public AppdynamicsClientIdConnectorSpec controllerUrl(String controllerUrl) {
    this.controllerUrl = controllerUrl;
    return this;
  }

  
  @Schema(required = true, description = "appdynamics controller url")
  @JsonProperty("controller_url")
  @NotNull

  public String getControllerUrl() {
    return controllerUrl;
  }
  public void setControllerUrl(String controllerUrl) {
    this.controllerUrl = controllerUrl;
  }

  /**
   * appdynamics client id
   **/
  public AppdynamicsClientIdConnectorSpec clientId(String clientId) {
    this.clientId = clientId;
    return this;
  }

  
  @Schema(description = "appdynamics client id")
  @JsonProperty("client_id")

  public String getClientId() {
    return clientId;
  }
  public void setClientId(String clientId) {
    this.clientId = clientId;
  }

  /**
   * Reference to encrypted Harness secret for appdynamics client secret
   **/
  public AppdynamicsClientIdConnectorSpec clientSecretRef(String clientSecretRef) {
    this.clientSecretRef = clientSecretRef;
    return this;
  }

  
  @Schema(description = "Reference to encrypted Harness secret for appdynamics client secret")
  @JsonProperty("client_secret_ref")

  public String getClientSecretRef() {
    return clientSecretRef;
  }
  public void setClientSecretRef(String clientSecretRef) {
    this.clientSecretRef = clientSecretRef;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AppdynamicsClientIdConnectorSpec appdynamicsClientIdConnectorSpec = (AppdynamicsClientIdConnectorSpec) o;
    return Objects.equals(delegateSelectors, appdynamicsClientIdConnectorSpec.delegateSelectors) &&
        Objects.equals(accountName, appdynamicsClientIdConnectorSpec.accountName) &&
        Objects.equals(controllerUrl, appdynamicsClientIdConnectorSpec.controllerUrl) &&
        Objects.equals(clientId, appdynamicsClientIdConnectorSpec.clientId) &&
        Objects.equals(clientSecretRef, appdynamicsClientIdConnectorSpec.clientSecretRef);
  }

  @Override
  public int hashCode() {
    return Objects.hash(delegateSelectors, accountName, controllerUrl, clientId, clientSecretRef);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AppdynamicsClientIdConnectorSpec {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    delegateSelectors: ").append(toIndentedString(delegateSelectors)).append("\n");
    sb.append("    accountName: ").append(toIndentedString(accountName)).append("\n");
    sb.append("    controllerUrl: ").append(toIndentedString(controllerUrl)).append("\n");
    sb.append("    clientId: ").append(toIndentedString(clientId)).append("\n");
    sb.append("    clientSecretRef: ").append(toIndentedString(clientSecretRef)).append("\n");
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
