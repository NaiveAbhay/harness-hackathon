package io.harness.spec.server.pipeline.model;

import io.harness.spec.server.pipeline.model.GitUpdateDetails;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * Pipeline request body object 
 **/
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

@Schema(description = "Pipeline request body object ")

public class PipelineUpdateRequestBody   {

  private @Valid String pipelineYaml = null;

  private @Valid GitUpdateDetails gitDetails = null;

  /**
   * Pipeline YAML (to be passed as a String).
   **/
  public PipelineUpdateRequestBody pipelineYaml(String pipelineYaml) {
    this.pipelineYaml = pipelineYaml;
    return this;
  }

  
  @Schema(required = true, description = "Pipeline YAML (to be passed as a String).")
  @JsonProperty("pipeline_yaml")
  @NotNull

  public String getPipelineYaml() {
    return pipelineYaml;
  }
  public void setPipelineYaml(String pipelineYaml) {
    this.pipelineYaml = pipelineYaml;
  }

  /**
   **/
  public PipelineUpdateRequestBody gitDetails(GitUpdateDetails gitDetails) {
    this.gitDetails = gitDetails;
    return this;
  }

  
  @Schema(description = "")
  @JsonProperty("git_details")

  public GitUpdateDetails getGitDetails() {
    return gitDetails;
  }
  public void setGitDetails(GitUpdateDetails gitDetails) {
    this.gitDetails = gitDetails;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PipelineUpdateRequestBody pipelineUpdateRequestBody = (PipelineUpdateRequestBody) o;
    return Objects.equals(pipelineYaml, pipelineUpdateRequestBody.pipelineYaml) &&
        Objects.equals(gitDetails, pipelineUpdateRequestBody.gitDetails);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pipelineYaml, gitDetails);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PipelineUpdateRequestBody {\n");
    
    sb.append("    pipelineYaml: ").append(toIndentedString(pipelineYaml)).append("\n");
    sb.append("    gitDetails: ").append(toIndentedString(gitDetails)).append("\n");
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
