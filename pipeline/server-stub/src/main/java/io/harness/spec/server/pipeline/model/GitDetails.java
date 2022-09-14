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

  private @Valid String object = null;

  private @Valid String branch = null;

  private @Valid String filePath = null;

  private @Valid String repoName = null;

  private @Valid String commitId = null;

  private @Valid String fileUrl = null;

  private @Valid String repoUrl = null;

  /**
   * Object identifier of the Entity.
   **/
  public GitDetails object(String object) {
    this.object = object;
    return this;
  }

  
  @Schema(description = "Object identifier of the Entity.")
  @JsonProperty("object")
 @Pattern(regexp="^[a-zA-Z_][0-9a-zA-Z_$]{0,63}$") @Size(min=1,max=64)
  public String getObject() {
    return object;
  }
  public void setObject(String object) {
    this.object = object;
  }

  /**
   * Name of the branch (for Git Experience).
   **/
  public GitDetails branch(String branch) {
    this.branch = branch;
    return this;
  }

  
  @Schema(description = "Name of the branch (for Git Experience).")
  @JsonProperty("branch")

  public String getBranch() {
    return branch;
  }
  public void setBranch(String branch) {
    this.branch = branch;
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
   * File URL of the Entity.
   **/
  public GitDetails fileUrl(String fileUrl) {
    this.fileUrl = fileUrl;
    return this;
  }

  
  @Schema(description = "File URL of the Entity.")
  @JsonProperty("file_url")

  public String getFileUrl() {
    return fileUrl;
  }
  public void setFileUrl(String fileUrl) {
    this.fileUrl = fileUrl;
  }

  /**
   * Repository URL of the Entity.
   **/
  public GitDetails repoUrl(String repoUrl) {
    this.repoUrl = repoUrl;
    return this;
  }

  
  @Schema(description = "Repository URL of the Entity.")
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
    return Objects.equals(object, gitDetails.object) &&
        Objects.equals(branch, gitDetails.branch) &&
        Objects.equals(filePath, gitDetails.filePath) &&
        Objects.equals(repoName, gitDetails.repoName) &&
        Objects.equals(commitId, gitDetails.commitId) &&
        Objects.equals(fileUrl, gitDetails.fileUrl) &&
        Objects.equals(repoUrl, gitDetails.repoUrl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(object, branch, filePath, repoName, commitId, fileUrl, repoUrl);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GitDetails {\n");
    
    sb.append("    object: ").append(toIndentedString(object)).append("\n");
    sb.append("    branch: ").append(toIndentedString(branch)).append("\n");
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
