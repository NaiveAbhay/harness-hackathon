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

@Schema(description = "This contains details of the Generic Git http connector")

public class GitHttpConnectorSpec
    extends ConnectorSpec implements OneOfConnectorSpec {

  private @Valid String url = null;

  private @Valid String branch = null;

  public enum ConnectionTypeEnum {

    ACCOUNT(String.valueOf("Account")),
    REPO(String.valueOf("Repo")),
    PROJECT(String.valueOf("Project"));

    private String value;

    ConnectionTypeEnum(String v) { value = v; }

    public String value() { return value; }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static ConnectionTypeEnum fromValue(String v) {
      for (ConnectionTypeEnum b : ConnectionTypeEnum.values()) {
        if (String.valueOf(b.value).equals(v)) {
          return b;
        }
      }
      return null;
    }
  }
  private @Valid ConnectionTypeEnum connectionType = null;

  private @Valid String username = null;

  private @Valid String passwordRef = null;

  private @Valid String validationRepo = null;

  private @Valid List<String> delegateSelectors = new ArrayList<>();

  private @Valid Boolean executeOnDelegate = null;

  /**
   * Git repo url
   **/
  public GitHttpConnectorSpec url(String url) {
    this.url = url;
    return this;
  }

  @Schema(required = true, description = "Git repo url")
  @JsonProperty("url")
  @NotNull

  public String getUrl() {
    return url;
  }
  public void setUrl(String url) { this.url = url; }

  /**
   * branch name
   **/
  public GitHttpConnectorSpec branch(String branch) {
    this.branch = branch;
    return this;
  }

  @Schema(description = "branch name")
  @JsonProperty("branch")

  public String getBranch() {
    return branch;
  }
  public void setBranch(String branch) { this.branch = branch; }

  /**
   **/
  public GitHttpConnectorSpec
  connectionType(ConnectionTypeEnum connectionType) {
    this.connectionType = connectionType;
    return this;
  }

  @Schema(required = true, description = "")
  @JsonProperty("connection_type")
  @NotNull

  public ConnectionTypeEnum getConnectionType() {
    return connectionType;
  }
  public void setConnectionType(ConnectionTypeEnum connectionType) {
    this.connectionType = connectionType;
  }

  /**
   * git username
   **/
  public GitHttpConnectorSpec username(String username) {
    this.username = username;
    return this;
  }

  @Schema(required = true, description = "git username")
  @JsonProperty("username")
  @NotNull

  public String getUsername() {
    return username;
  }
  public void setUsername(String username) { this.username = username; }

  /**
   * Reference to encrypted Harness secret for git password
   **/
  public GitHttpConnectorSpec passwordRef(String passwordRef) {
    this.passwordRef = passwordRef;
    return this;
  }

  @Schema(
      required = true,
      description = "Reference to encrypted Harness secret for git password")
  @JsonProperty("password_ref")
  @NotNull

  public String
  getPasswordRef() {
    return passwordRef;
  }
  public void setPasswordRef(String passwordRef) {
    this.passwordRef = passwordRef;
  }

  /**
   * validation repo
   **/
  public GitHttpConnectorSpec validationRepo(String validationRepo) {
    this.validationRepo = validationRepo;
    return this;
  }

  @Schema(description = "validation repo")
  @JsonProperty("validation_repo")

  public String getValidationRepo() {
    return validationRepo;
  }
  public void setValidationRepo(String validationRepo) {
    this.validationRepo = validationRepo;
  }

  /**
   * List of unique delegate selectors
   **/
  public GitHttpConnectorSpec
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
  public GitHttpConnectorSpec executeOnDelegate(Boolean executeOnDelegate) {
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
    GitHttpConnectorSpec gitHttpConnectorSpec = (GitHttpConnectorSpec)o;
    return Objects.equals(url, gitHttpConnectorSpec.url) &&
        Objects.equals(branch, gitHttpConnectorSpec.branch) &&
        Objects.equals(connectionType, gitHttpConnectorSpec.connectionType) &&
        Objects.equals(username, gitHttpConnectorSpec.username) &&
        Objects.equals(passwordRef, gitHttpConnectorSpec.passwordRef) &&
        Objects.equals(validationRepo, gitHttpConnectorSpec.validationRepo) &&
        Objects.equals(delegateSelectors,
                       gitHttpConnectorSpec.delegateSelectors) &&
        Objects.equals(executeOnDelegate,
                       gitHttpConnectorSpec.executeOnDelegate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(url, branch, connectionType, username, passwordRef,
                        validationRepo, delegateSelectors, executeOnDelegate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GitHttpConnectorSpec {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    branch: ").append(toIndentedString(branch)).append("\n");
    sb.append("    connectionType: ")
        .append(toIndentedString(connectionType))
        .append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    passwordRef: ")
        .append(toIndentedString(passwordRef))
        .append("\n");
    sb.append("    validationRepo: ")
        .append(toIndentedString(validationRepo))
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
