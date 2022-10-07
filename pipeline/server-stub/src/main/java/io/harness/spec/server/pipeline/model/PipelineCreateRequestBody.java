package io.harness.spec.server.pipeline.model;

import io.harness.spec.server.pipeline.model.GitCreateDetails;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

  private @Valid String slug = null;

  private @Valid String name = null;

  private @Valid String description = null;

  private @Valid Map<String, String> tags = new HashMap<>();

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
   * Pipeline identifier
   **/
  public PipelineCreateRequestBody slug(String slug) {
    this.slug = slug;
    return this;
  }

  
  @Schema(required = true, description = "Pipeline identifier")
  @JsonProperty("slug")
  @NotNull
 @Pattern(regexp="^[a-zA-Z_][0-9a-zA-Z_$]{0,63}$") @Size(min=1,max=64)
  public String getSlug() {
    return slug;
  }
  public void setSlug(String slug) {
    this.slug = slug;
  }

  /**
   * Pipeline name
   **/
  public PipelineCreateRequestBody name(String name) {
    this.name = name;
    return this;
  }

  
  @Schema(required = true, description = "Pipeline name")
  @JsonProperty("name")
  @NotNull
 @Pattern(regexp="^[a-zA-Z_][0-9a-zA-Z_$]{0,63}$") @Size(min=1,max=64)
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Pipeline description
   **/
  public PipelineCreateRequestBody description(String description) {
    this.description = description;
    return this;
  }

  
  @Schema(description = "Pipeline description")
  @JsonProperty("description")
 @Size(max=1024)
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * Pipeline tags
   **/
  public PipelineCreateRequestBody tags(Map<String, String> tags) {
    this.tags = tags;
    return this;
  }

  
  @Schema(description = "Pipeline tags")
  @JsonProperty("tags")
 @Size(max=128)
  public Map<String, String> getTags() {
    return tags;
  }
  public void setTags(Map<String, String> tags) {
    this.tags = tags;
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
        Objects.equals(slug, pipelineCreateRequestBody.slug) &&
        Objects.equals(name, pipelineCreateRequestBody.name) &&
        Objects.equals(description, pipelineCreateRequestBody.description) &&
        Objects.equals(tags, pipelineCreateRequestBody.tags) &&
        Objects.equals(gitDetails, pipelineCreateRequestBody.gitDetails);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pipelineYaml, slug, name, description, tags, gitDetails);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PipelineCreateRequestBody {\n");
    
    sb.append("    pipelineYaml: ").append(toIndentedString(pipelineYaml)).append("\n");
    sb.append("    slug: ").append(toIndentedString(slug)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
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
