package io.harness.spec.server.ng.model;

import io.harness.spec.server.ng.model.ConnectorSpec;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * This contains details of the artifactory connector with encrypted username/password
 **/
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.v3.oas.annotations.media.Schema;



@Schema(description = "This contains details of the artifactory connector with encrypted username/password")

public class ArtifactoryEncryptedConnectorSpec extends ConnectorSpec implements OneOfConnectorSpec  {

  private @Valid String url = null;

  private @Valid String usernameRef = null;

  private @Valid String passwordRef = null;

  private @Valid List<String> delegateSelectors = new ArrayList<>();

  private @Valid Boolean executeOnDelegate = null;

  /**
   * artifactory repo url
   **/
  public ArtifactoryEncryptedConnectorSpec url(String url) {
    this.url = url;
    return this;
  }

  
  @Schema(required = true, description = "artifactory repo url")
  @JsonProperty("url")
  @NotNull

  public String getUrl() {
    return url;
  }
  public void setUrl(String url) {
    this.url = url;
  }

  /**
   * Reference to encrypted Harness secret for artifactory username
   **/
  public ArtifactoryEncryptedConnectorSpec usernameRef(String usernameRef) {
    this.usernameRef = usernameRef;
    return this;
  }

  
  @Schema(required = true, description = "Reference to encrypted Harness secret for artifactory username")
  @JsonProperty("username_ref")
  @NotNull

  public String getUsernameRef() {
    return usernameRef;
  }
  public void setUsernameRef(String usernameRef) {
    this.usernameRef = usernameRef;
  }

  /**
   * Reference to encrypted Harness secret for artifactory password
   **/
  public ArtifactoryEncryptedConnectorSpec passwordRef(String passwordRef) {
    this.passwordRef = passwordRef;
    return this;
  }

  
  @Schema(required = true, description = "Reference to encrypted Harness secret for artifactory password")
  @JsonProperty("password_ref")
  @NotNull

  public String getPasswordRef() {
    return passwordRef;
  }
  public void setPasswordRef(String passwordRef) {
    this.passwordRef = passwordRef;
  }

  /**
   * List of unique delegate selectors
   **/
  public ArtifactoryEncryptedConnectorSpec delegateSelectors(List<String> delegateSelectors) {
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
  public ArtifactoryEncryptedConnectorSpec executeOnDelegate(Boolean executeOnDelegate) {
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
    ArtifactoryEncryptedConnectorSpec artifactoryEncryptedConnectorSpec = (ArtifactoryEncryptedConnectorSpec) o;
    return Objects.equals(url, artifactoryEncryptedConnectorSpec.url) &&
        Objects.equals(usernameRef, artifactoryEncryptedConnectorSpec.usernameRef) &&
        Objects.equals(passwordRef, artifactoryEncryptedConnectorSpec.passwordRef) &&
        Objects.equals(delegateSelectors, artifactoryEncryptedConnectorSpec.delegateSelectors) &&
        Objects.equals(executeOnDelegate, artifactoryEncryptedConnectorSpec.executeOnDelegate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(url, usernameRef, passwordRef, delegateSelectors, executeOnDelegate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ArtifactoryEncryptedConnectorSpec {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    usernameRef: ").append(toIndentedString(usernameRef)).append("\n");
    sb.append("    passwordRef: ").append(toIndentedString(passwordRef)).append("\n");
    sb.append("    delegateSelectors: ").append(toIndentedString(delegateSelectors)).append("\n");
    sb.append("    executeOnDelegate: ").append(toIndentedString(executeOnDelegate)).append("\n");
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
