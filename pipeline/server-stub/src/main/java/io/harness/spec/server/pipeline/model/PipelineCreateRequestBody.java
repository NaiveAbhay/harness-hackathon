package io.harness.spec.server.pipeline.model;

import io.harness.spec.server.pipeline.model.GitCreateDetails;
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

public class PipelineCreateRequestBody   {

  private @Valid String pipelineYaml = null;

  private @Valid GitCreateDetails gitDetails = null;

  /**
   * Pipeline YAML (to be passed as a String).
   **/
  public PipelineCreateRequestBody pipelineYaml(String pipelineYaml) {
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
  public PipelineCreateRequestBody gitDetails(GitCreateDetails gitDetails) {
    this.gitDetails = gitDetails;
    return this;
  }

  
  @Schema(description = "")
  @JsonProperty("git_details")

  public GitCreateDetails getGitDetails() {
    return gitDetails;
  }
  public void setGitDetails(GitCreateDetails gitDetails) {
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
    PipelineCreateRequestBody pipelineCreateRequestBody = (PipelineCreateRequestBody) o;
    return Objects.equals(pipelineYaml, pipelineCreateRequestBody.pipelineYaml) &&
        Objects.equals(gitDetails, pipelineCreateRequestBody.gitDetails);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pipelineYaml, gitDetails);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PipelineCreateRequestBody {\n");
    
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
