package io.harness.spec.server.pipeline.model;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * Request body for the filter properties for listing Pipelines.
 **/
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

@Schema(description = "Request body for the filter properties for listing Pipelines.")

public class PipelineListRequestBody   {

  private @Valid List<String> pipelines = new ArrayList<>();

  private @Valid String name = null;

  private @Valid String description = null;

  private @Valid Map<String, String> tags = new HashMap<>();

  /**
   * List of Pipeline Identifiers on which the filter will be applied.
   **/
  public PipelineListRequestBody pipelines(List<String> pipelines) {
    this.pipelines = pipelines;
    return this;
  }

  
  @Schema(description = "List of Pipeline Identifiers on which the filter will be applied.")
  @JsonProperty("pipelines")

  public List<String> getPipelines() {
    return pipelines;
  }
  public void setPipelines(List<String> pipelines) {
    this.pipelines = pipelines;
  }

  /**
   * Pipeline Name on which the filter will be applied.
   **/
  public PipelineListRequestBody name(String name) {
    this.name = name;
    return this;
  }

  
  @Schema(description = "Pipeline Name on which the filter will be applied.")
  @JsonProperty("name")
 @Pattern(regexp="^[a-zA-Z_][0-9a-zA-Z_$]{0,63}$") @Size(min=1,max=64)
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Pipeline Description on which the filter will be applied.
   **/
  public PipelineListRequestBody description(String description) {
    this.description = description;
    return this;
  }

  
  @Schema(description = "Pipeline Description on which the filter will be applied.")
  @JsonProperty("description")
 @Size(max=1024)
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * Filter tags as a key-value pair.
   **/
  public PipelineListRequestBody tags(Map<String, String> tags) {
    this.tags = tags;
    return this;
  }

  
  @Schema(description = "Filter tags as a key-value pair.")
  @JsonProperty("tags")
 @Size(max=128)
  public Map<String, String> getTags() {
    return tags;
  }
  public void setTags(Map<String, String> tags) {
    this.tags = tags;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PipelineListRequestBody pipelineListRequestBody = (PipelineListRequestBody) o;
    return Objects.equals(pipelines, pipelineListRequestBody.pipelines) &&
        Objects.equals(name, pipelineListRequestBody.name) &&
        Objects.equals(description, pipelineListRequestBody.description) &&
        Objects.equals(tags, pipelineListRequestBody.tags);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pipelines, name, description, tags);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PipelineListRequestBody {\n");
    
    sb.append("    pipelines: ").append(toIndentedString(pipelines)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
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
