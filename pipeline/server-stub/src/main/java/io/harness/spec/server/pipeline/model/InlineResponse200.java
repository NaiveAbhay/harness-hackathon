package io.harness.spec.server.pipeline.model;

import io.harness.spec.server.pipeline.model.PipelineListSummary;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * Response body for List Pipelines.
 **/
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

@Schema(description = "Response body for List Pipelines.")

public class InlineResponse200   {

  private @Valid List<PipelineListSummary> pipelines = new ArrayList<>();

  /**
   * Pipelines
   **/
  public InlineResponse200 pipelines(List<PipelineListSummary> pipelines) {
    this.pipelines = pipelines;
    return this;
  }

  
  @Schema(description = "Pipelines")
  @JsonProperty("pipelines")

  public List<PipelineListSummary> getPipelines() {
    return pipelines;
  }
  public void setPipelines(List<PipelineListSummary> pipelines) {
    this.pipelines = pipelines;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InlineResponse200 inlineResponse200 = (InlineResponse200) o;
    return Objects.equals(pipelines, inlineResponse200.pipelines);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pipelines);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse200 {\n");
    
    sb.append("    pipelines: ").append(toIndentedString(pipelines)).append("\n");
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
