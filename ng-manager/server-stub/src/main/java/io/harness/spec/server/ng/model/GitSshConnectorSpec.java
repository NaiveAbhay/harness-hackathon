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
* This contains details of the Generic Git ssh connector
**/


@Schema(description = "This contains details of the Generic Git ssh connector")

public class GitSshConnectorSpec extends ConnectorSpec implements OneOfConnectorSpec  {

  private @Valid String url = null;

  private @Valid String branch = null;

public enum ConnectionTypeEnum {

    ACCOUNT(String.valueOf("Account")), REPO(String.valueOf("Repo")), PROJECT(String.valueOf("Project"));


    private String value;

    ConnectionTypeEnum (String v) {
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

  private @Valid String sshKeyRef = null;

  private @Valid String validationRepo = null;

  private @Valid List<String> delegateSelectors = new ArrayList<>();

  private @Valid Boolean executeOnDelegate = null;

  /**
   * Git repo url
   **/
  public GitSshConnectorSpec url(String url) {
    this.url = url;
    return this;
  }

  
  @Schema(required = true, description = "Git repo url")
  @JsonProperty("url")
  @NotNull

  public String getUrl() {
    return url;
  }
  public void setUrl(String url) {
    this.url = url;
  }

  /**
   * branch name
   **/
  public GitSshConnectorSpec branch(String branch) {
    this.branch = branch;
    return this;
  }

  
  @Schema(description = "branch name")
  @JsonProperty("branch")

  public String getBranch() {
    return branch;
  }
  public void setBranch(String branch) {
    this.branch = branch;
  }

  /**
   **/
  public GitSshConnectorSpec connectionType(ConnectionTypeEnum connectionType) {
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
   * Reference to encrypted Harness secret for git ssh key
   **/
  public GitSshConnectorSpec sshKeyRef(String sshKeyRef) {
    this.sshKeyRef = sshKeyRef;
    return this;
  }

  
  @Schema(required = true, description = "Reference to encrypted Harness secret for git ssh key")
  @JsonProperty("ssh_key_ref")
  @NotNull

  public String getSshKeyRef() {
    return sshKeyRef;
  }
  public void setSshKeyRef(String sshKeyRef) {
    this.sshKeyRef = sshKeyRef;
  }

  /**
   * validation repo
   **/
  public GitSshConnectorSpec validationRepo(String validationRepo) {
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
  public GitSshConnectorSpec delegateSelectors(List<String> delegateSelectors) {
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
  public GitSshConnectorSpec executeOnDelegate(Boolean executeOnDelegate) {
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
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GitSshConnectorSpec gitSshConnectorSpec = (GitSshConnectorSpec) o;
    return Objects.equals(url, gitSshConnectorSpec.url) &&
        Objects.equals(branch, gitSshConnectorSpec.branch) &&
        Objects.equals(connectionType, gitSshConnectorSpec.connectionType) &&
        Objects.equals(sshKeyRef, gitSshConnectorSpec.sshKeyRef) &&
        Objects.equals(validationRepo, gitSshConnectorSpec.validationRepo) &&
        Objects.equals(delegateSelectors, gitSshConnectorSpec.delegateSelectors) &&
        Objects.equals(executeOnDelegate, gitSshConnectorSpec.executeOnDelegate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(url, branch, connectionType, sshKeyRef, validationRepo, delegateSelectors, executeOnDelegate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GitSshConnectorSpec {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    branch: ").append(toIndentedString(branch)).append("\n");
    sb.append("    connectionType: ").append(toIndentedString(connectionType)).append("\n");
    sb.append("    sshKeyRef: ").append(toIndentedString(sshKeyRef)).append("\n");
    sb.append("    validationRepo: ").append(toIndentedString(validationRepo)).append("\n");
    sb.append("    delegateSelectors: ").append(toIndentedString(delegateSelectors)).append("\n");
    sb.append("    executeOnDelegate: ").append(toIndentedString(executeOnDelegate)).append("\n");
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
