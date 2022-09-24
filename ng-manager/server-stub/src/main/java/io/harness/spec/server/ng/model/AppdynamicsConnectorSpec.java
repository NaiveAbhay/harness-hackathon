package io.harness.spec.server.ng.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Schema(description = "This contains details of the appdynamics connector")

public class AppdynamicsConnectorSpec
    extends ConnectorSpec implements OneOfConnectorSpec {

  private @Valid List<String> delegateSelectors = new ArrayList<>();

  private @Valid String accountName = null;

  private @Valid String controllerUrl = null;

  private @Valid String username = null;

  private @Valid String passwordRef = null;

  /**
   * List of unique delegate selectors
   **/
  public AppdynamicsConnectorSpec
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
   * appdymanics account name
   **/
  public AppdynamicsConnectorSpec accountName(String accountName) {
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
  public AppdynamicsConnectorSpec controllerUrl(String controllerUrl) {
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
   * appdynamics username
   **/
  public AppdynamicsConnectorSpec username(String username) {
    this.username = username;
    return this;
  }

  @Schema(description = "appdynamics username")
  @JsonProperty("username")

  public String getUsername() {
    return username;
  }
  public void setUsername(String username) { this.username = username; }

  /**
   * Reference to encrypted Harness secret for appdynamics password secret
   **/
  public AppdynamicsConnectorSpec passwordRef(String passwordRef) {
    this.passwordRef = passwordRef;
    return this;
  }

  @Schema(
      description =
          "Reference to encrypted Harness secret for appdynamics password secret")
  @JsonProperty("password_ref")

  public String
  getPasswordRef() {
    return passwordRef;
  }
  public void setPasswordRef(String passwordRef) {
    this.passwordRef = passwordRef;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AppdynamicsConnectorSpec appdynamicsConnectorSpec =
        (AppdynamicsConnectorSpec)o;
    return Objects.equals(delegateSelectors,
                          appdynamicsConnectorSpec.delegateSelectors) &&
        Objects.equals(accountName, appdynamicsConnectorSpec.accountName) &&
        Objects.equals(controllerUrl, appdynamicsConnectorSpec.controllerUrl) &&
        Objects.equals(username, appdynamicsConnectorSpec.username) &&
        Objects.equals(passwordRef, appdynamicsConnectorSpec.passwordRef);
  }

  @Override
  public int hashCode() {
    return Objects.hash(delegateSelectors, accountName, controllerUrl, username,
                        passwordRef);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AppdynamicsConnectorSpec {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    delegateSelectors: ")
        .append(toIndentedString(delegateSelectors))
        .append("\n");
    sb.append("    accountName: ")
        .append(toIndentedString(accountName))
        .append("\n");
    sb.append("    controllerUrl: ")
        .append(toIndentedString(controllerUrl))
        .append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    passwordRef: ")
        .append(toIndentedString(passwordRef))
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
