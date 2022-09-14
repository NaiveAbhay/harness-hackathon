package io.harness.spec.server.pipeline.model;

import io.harness.spec.server.pipeline.model.GitDetails;
import io.harness.spec.server.pipeline.model.PipelineViewResponseOption;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * Pipeline response body (YAML view).
 **/
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

@Schema(description = "Pipeline response body (YAML view).")

public class InlineResponse2001   {

  private @Valid PipelineViewResponseOption pipelineResponse = null;

  private @Valid GitDetails gitDetails = null;

  /**
   **/
  public InlineResponse2001 pipelineResponse(PipelineViewResponseOption pipelineResponse) {
    this.pipelineResponse = pipelineResponse;
    return this;
  }

  
  @Schema(description = "")
  @JsonProperty("pipeline_response")

  public PipelineViewResponseOption getPipelineResponse() {
    return pipelineResponse;
  }
  public void setPipelineResponse(PipelineViewResponseOption pipelineResponse) {
    this.pipelineResponse = pipelineResponse;
  }

  /**
   **/
  public InlineResponse2001 gitDetails(GitDetails gitDetails) {
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
    InlineResponse2001 inlineResponse2001 = (InlineResponse2001) o;
    return Objects.equals(pipelineResponse, inlineResponse2001.pipelineResponse) &&
        Objects.equals(gitDetails, inlineResponse2001.gitDetails);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pipelineResponse, gitDetails);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse2001 {\n");
    
    sb.append("    pipelineResponse: ").append(toIndentedString(pipelineResponse)).append("\n");
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
