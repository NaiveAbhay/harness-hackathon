package io.harness.spec.server.pipeline.model;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * Contains parameters related to creating an Entity for Git Experience.
 **/
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

@Schema(description = "Contains parameters related to creating an Entity for Git Experience.")

public class GitCreateDetails   {

  private @Valid String branchName = null;

  private @Valid String filePath = null;

  private @Valid String commitMessage = null;

  private @Valid String baseBranch = null;

  private @Valid String connectorRef = null;

public enum StoreTypeEnum {

    INLINE(String.valueOf("INLINE")), REMOTE(String.valueOf("REMOTE"));


    private String value;

    StoreTypeEnum (String v) {
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
    public static StoreTypeEnum fromValue(String v) {
        for (StoreTypeEnum b : StoreTypeEnum.values()) {
            if (String.valueOf(b.value).equals(v)) {
                return b;
            }
        }
        return null;
    }
}
  private @Valid StoreTypeEnum storeType = null;

  private @Valid String repoName = null;

  /**
   * Name of the branch.
   **/
  public GitCreateDetails branchName(String branchName) {
    this.branchName = branchName;
    return this;
  }

  
  @Schema(description = "Name of the branch.")
  @JsonProperty("branch_name")

  public String getBranchName() {
    return branchName;
  }
  public void setBranchName(String branchName) {
    this.branchName = branchName;
  }

  /**
   * File path of the Entity in the repository.
   **/
  public GitCreateDetails filePath(String filePath) {
    this.filePath = filePath;
    return this;
  }

  
  @Schema(description = "File path of the Entity in the repository.")
  @JsonProperty("file_path")

  public String getFilePath() {
    return filePath;
  }
  public void setFilePath(String filePath) {
    this.filePath = filePath;
  }

  /**
   * Commit message used for the merge commit.
   **/
  public GitCreateDetails commitMessage(String commitMessage) {
    this.commitMessage = commitMessage;
    return this;
  }

  
  @Schema(description = "Commit message used for the merge commit.")
  @JsonProperty("commit_message")

  public String getCommitMessage() {
    return commitMessage;
  }
  public void setCommitMessage(String commitMessage) {
    this.commitMessage = commitMessage;
  }

  /**
   * Name of the default branch (this checks out a new branch titled by branch_name).
   **/
  public GitCreateDetails baseBranch(String baseBranch) {
    this.baseBranch = baseBranch;
    return this;
  }

  
  @Schema(description = "Name of the default branch (this checks out a new branch titled by branch_name).")
  @JsonProperty("base_branch")

  public String getBaseBranch() {
    return baseBranch;
  }
  public void setBaseBranch(String baseBranch) {
    this.baseBranch = baseBranch;
  }

  /**
   * Identifier of the Harness Connector used for CRUD operations on the Entity.
   **/
  public GitCreateDetails connectorRef(String connectorRef) {
    this.connectorRef = connectorRef;
    return this;
  }

  
  @Schema(description = "Identifier of the Harness Connector used for CRUD operations on the Entity.")
  @JsonProperty("connector_ref")

  public String getConnectorRef() {
    return connectorRef;
  }
  public void setConnectorRef(String connectorRef) {
    this.connectorRef = connectorRef;
  }

  /**
   * Specifies whether the Entity is to be stored in Git or not.
   **/
  public GitCreateDetails storeType(StoreTypeEnum storeType) {
    this.storeType = storeType;
    return this;
  }

  
  @Schema(description = "Specifies whether the Entity is to be stored in Git or not.")
  @JsonProperty("store_type")

  public StoreTypeEnum getStoreType() {
    return storeType;
  }
  public void setStoreType(StoreTypeEnum storeType) {
    this.storeType = storeType;
  }

  /**
   * Name of the repository.
   **/
  public GitCreateDetails repoName(String repoName) {
    this.repoName = repoName;
    return this;
  }

  
  @Schema(description = "Name of the repository.")
  @JsonProperty("repo_name")

  public String getRepoName() {
    return repoName;
  }
  public void setRepoName(String repoName) {
    this.repoName = repoName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GitCreateDetails gitCreateDetails = (GitCreateDetails) o;
    return Objects.equals(branchName, gitCreateDetails.branchName) &&
        Objects.equals(filePath, gitCreateDetails.filePath) &&
        Objects.equals(commitMessage, gitCreateDetails.commitMessage) &&
        Objects.equals(baseBranch, gitCreateDetails.baseBranch) &&
        Objects.equals(connectorRef, gitCreateDetails.connectorRef) &&
        Objects.equals(storeType, gitCreateDetails.storeType) &&
        Objects.equals(repoName, gitCreateDetails.repoName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(branchName, filePath, commitMessage, baseBranch, connectorRef, storeType, repoName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GitCreateDetails {\n");
    
    sb.append("    branchName: ").append(toIndentedString(branchName)).append("\n");
    sb.append("    filePath: ").append(toIndentedString(filePath)).append("\n");
    sb.append("    commitMessage: ").append(toIndentedString(commitMessage)).append("\n");
    sb.append("    baseBranch: ").append(toIndentedString(baseBranch)).append("\n");
    sb.append("    connectorRef: ").append(toIndentedString(connectorRef)).append("\n");
    sb.append("    storeType: ").append(toIndentedString(storeType)).append("\n");
    sb.append("    repoName: ").append(toIndentedString(repoName)).append("\n");
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
