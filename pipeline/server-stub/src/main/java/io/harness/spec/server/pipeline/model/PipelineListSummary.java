package io.harness.spec.server.pipeline.model;

import io.harness.spec.server.pipeline.model.GitDetails;
import io.harness.spec.server.pipeline.model.PipelineViewResponseOption;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * Pipeline when called in List API
 **/
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

@Schema(description = "Pipeline when called in List API")

public class PipelineListSummary   {

  private @Valid PipelineViewResponseOption pipeline = null;

  private @Valid GitDetails gitDetails = null;

  /**
   **/
  public PipelineListSummary pipeline(PipelineViewResponseOption pipeline) {
    this.pipeline = pipeline;
    return this;
  }

  
  @Schema(description = "")
  @JsonProperty("pipeline")

  public PipelineViewResponseOption getPipeline() {
    return pipeline;
  }
  public void setPipeline(PipelineViewResponseOption pipeline) {
    this.pipeline = pipeline;
  }

  /**
   **/
  public PipelineListSummary gitDetails(GitDetails gitDetails) {
    this.gitDetails = gitDetails;
    return this;
  }

  
  @Schema(description = "")
  @JsonProperty("git_details")

  public GitDetails getGitDetails() {
    return gitDetails;
  }
  public void setGitDetails(GitDetails gitDetails) {
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
    PipelineListSummary pipelineListSummary = (PipelineListSummary) o;
    return Objects.equals(pipeline, pipelineListSummary.pipeline) &&
        Objects.equals(gitDetails, pipelineListSummary.gitDetails);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pipeline, gitDetails);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PipelineListSummary {\n");
    
    sb.append("    pipeline: ").append(toIndentedString(pipeline)).append("\n");
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
