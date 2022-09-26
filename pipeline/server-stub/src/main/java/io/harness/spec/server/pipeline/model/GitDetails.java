package io.harness.spec.server.pipeline.model;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * Git details of the Entity.
 **/
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

@Schema(description = "Git details of the Entity.")

public class GitDetails   {

  private @Valid String entityIdentifier = null;

  private @Valid String branchName = null;

  private @Valid String filePath = null;

  private @Valid String repoName = null;

  private @Valid String commitId = null;

  private @Valid String fileUrl = null;

  private @Valid String repoUrl = null;

  /**
   * Entity identifier
   **/
  public GitDetails entityIdentifier(String entityIdentifier) {
    this.entityIdentifier = entityIdentifier;
    return this;
  }

  
  @Schema(description = "Entity identifier")
  @JsonProperty("entity_identifier")
 @Pattern(regexp="^[a-zA-Z_][0-9a-zA-Z_$]{0,63}$") @Size(min=1,max=64)
  public String getEntityIdentifier() {
    return entityIdentifier;
  }
  public void setEntityIdentifier(String entityIdentifier) {
    this.entityIdentifier = entityIdentifier;
  }

  /**
   * Name of the branch (for Git Experience).
   **/
  public GitDetails branchName(String branchName) {
    this.branchName = branchName;
    return this;
  }

  
  @Schema(description = "Name of the branch (for Git Experience).")
  @JsonProperty("branch_name")

  public String getBranchName() {
    return branchName;
  }
  public void setBranchName(String branchName) {
    this.branchName = branchName;
  }

  /**
   * File path of the Entity in the repository (for Git Experience).
   **/
  public GitDetails filePath(String filePath) {
    this.filePath = filePath;
    return this;
  }

  
  @Schema(description = "File path of the Entity in the repository (for Git Experience).")
  @JsonProperty("file_path")

  public String getFilePath() {
    return filePath;
  }
  public void setFilePath(String filePath) {
    this.filePath = filePath;
  }

  /**
   * Name of the repository (for Git Experience).
   **/
  public GitDetails repoName(String repoName) {
    this.repoName = repoName;
    return this;
  }

  
  @Schema(description = "Name of the repository (for Git Experience).")
  @JsonProperty("repo_name")

  public String getRepoName() {
    return repoName;
  }
  public void setRepoName(String repoName) {
    this.repoName = repoName;
  }

  /**
   * Latest commit identifier (for Git Experience).
   **/
  public GitDetails commitId(String commitId) {
    this.commitId = commitId;
    return this;
  }

  
  @Schema(description = "Latest commit identifier (for Git Experience).")
  @JsonProperty("commit_id")

  public String getCommitId() {
    return commitId;
  }
  public void setCommitId(String commitId) {
    this.commitId = commitId;
  }

  /**
   * File URL of the Entity (for Git Experience).
   **/
  public GitDetails fileUrl(String fileUrl) {
    this.fileUrl = fileUrl;
    return this;
  }

  
  @Schema(description = "File URL of the Entity (for Git Experience).")
  @JsonProperty("file_url")

  public String getFileUrl() {
    return fileUrl;
  }
  public void setFileUrl(String fileUrl) {
    this.fileUrl = fileUrl;
  }

  /**
   * Repository URL of the Entity (for Git Experience).
   **/
  public GitDetails repoUrl(String repoUrl) {
    this.repoUrl = repoUrl;
    return this;
  }

  
  @Schema(description = "Repository URL of the Entity (for Git Experience).")
  @JsonProperty("repo_url")

  public String getRepoUrl() {
    return repoUrl;
  }
  public void setRepoUrl(String repoUrl) {
    this.repoUrl = repoUrl;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GitDetails gitDetails = (GitDetails) o;
    return Objects.equals(entityIdentifier, gitDetails.entityIdentifier) &&
        Objects.equals(branchName, gitDetails.branchName) &&
        Objects.equals(filePath, gitDetails.filePath) &&
        Objects.equals(repoName, gitDetails.repoName) &&
        Objects.equals(commitId, gitDetails.commitId) &&
        Objects.equals(fileUrl, gitDetails.fileUrl) &&
        Objects.equals(repoUrl, gitDetails.repoUrl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(entityIdentifier, branchName, filePath, repoName, commitId, fileUrl, repoUrl);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GitDetails {\n");
    
    sb.append("    entityIdentifier: ").append(toIndentedString(entityIdentifier)).append("\n");
    sb.append("    branchName: ").append(toIndentedString(branchName)).append("\n");
    sb.append("    filePath: ").append(toIndentedString(filePath)).append("\n");
    sb.append("    repoName: ").append(toIndentedString(repoName)).append("\n");
    sb.append("    commitId: ").append(toIndentedString(commitId)).append("\n");
    sb.append("    fileUrl: ").append(toIndentedString(fileUrl)).append("\n");
    sb.append("    repoUrl: ").append(toIndentedString(repoUrl)).append("\n");
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
