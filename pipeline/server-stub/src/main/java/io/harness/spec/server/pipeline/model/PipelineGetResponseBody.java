package io.harness.spec.server.pipeline.model;

import io.harness.spec.server.pipeline.model.GitDetails;
import io.harness.spec.server.pipeline.model.YAMLSchemaErrorWrapper;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * Pipeline response body.
 **/
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

@Schema(description = "Pipeline response body.")

public class PipelineGetResponseBody   {

  private @Valid String pipelineYaml = null;

  private @Valid String pipelineYamlWithTemplates = null;

  private @Valid List<String> modules = new ArrayList<>();

  private @Valid GitDetails gitDetails = null;

  private @Valid List<YAMLSchemaErrorWrapper> yamlErrorWrapper = new ArrayList<>();

  private @Valid Long created = null;

  private @Valid Long updated = null;

  /**
   * Pipeline YAML (returned as a String).
   **/
  public PipelineGetResponseBody pipelineYaml(String pipelineYaml) {
    this.pipelineYaml = pipelineYaml;
    return this;
  }

  
  @Schema(description = "Pipeline YAML (returned as a String).")
  @JsonProperty("pipeline_yaml")

  public String getPipelineYaml() {
    return pipelineYaml;
  }
  public void setPipelineYaml(String pipelineYaml) {
    this.pipelineYaml = pipelineYaml;
  }

  /**
   * Pipeline YAML after resolving Templates (returned as a String).
   **/
  public PipelineGetResponseBody pipelineYamlWithTemplates(String pipelineYamlWithTemplates) {
    this.pipelineYamlWithTemplates = pipelineYamlWithTemplates;
    return this;
  }

  
  @Schema(description = "Pipeline YAML after resolving Templates (returned as a String).")
  @JsonProperty("pipeline_yaml_with_templates")

  public String getPipelineYamlWithTemplates() {
    return pipelineYamlWithTemplates;
  }
  public void setPipelineYamlWithTemplates(String pipelineYamlWithTemplates) {
    this.pipelineYamlWithTemplates = pipelineYamlWithTemplates;
  }

  /**
   * Modules utilised in the Pipeline.
   **/
  public PipelineGetResponseBody modules(List<String> modules) {
    this.modules = modules;
    return this;
  }

  
  @Schema(description = "Modules utilised in the Pipeline.")
  @JsonProperty("modules")

  public List<String> getModules() {
    return modules;
  }
  public void setModules(List<String> modules) {
    this.modules = modules;
  }

  /**
   **/
  public PipelineGetResponseBody gitDetails(GitDetails gitDetails) {
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

  /**
   * YAML schema errors.
   **/
  public PipelineGetResponseBody yamlErrorWrapper(List<YAMLSchemaErrorWrapper> yamlErrorWrapper) {
    this.yamlErrorWrapper = yamlErrorWrapper;
    return this;
  }

  
  @Schema(description = "YAML schema errors.")
  @JsonProperty("yaml_error_wrapper")

  public List<YAMLSchemaErrorWrapper> getYamlErrorWrapper() {
    return yamlErrorWrapper;
  }
  public void setYamlErrorWrapper(List<YAMLSchemaErrorWrapper> yamlErrorWrapper) {
    this.yamlErrorWrapper = yamlErrorWrapper;
  }

  /**
   * Creation timestamp for Pipeline.
   **/
  public PipelineGetResponseBody created(Long created) {
    this.created = created;
    return this;
  }

  
  @Schema(description = "Creation timestamp for Pipeline.")
  @JsonProperty("created")

  public Long getCreated() {
    return created;
  }
  public void setCreated(Long created) {
    this.created = created;
  }

  /**
   * Last modification timestamp for Pipeline.
   **/
  public PipelineGetResponseBody updated(Long updated) {
    this.updated = updated;
    return this;
  }

  
  @Schema(description = "Last modification timestamp for Pipeline.")
  @JsonProperty("updated")

  public Long getUpdated() {
    return updated;
  }
  public void setUpdated(Long updated) {
    this.updated = updated;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PipelineGetResponseBody pipelineGetResponseBody = (PipelineGetResponseBody) o;
    return Objects.equals(pipelineYaml, pipelineGetResponseBody.pipelineYaml) &&
        Objects.equals(pipelineYamlWithTemplates, pipelineGetResponseBody.pipelineYamlWithTemplates) &&
        Objects.equals(modules, pipelineGetResponseBody.modules) &&
        Objects.equals(gitDetails, pipelineGetResponseBody.gitDetails) &&
        Objects.equals(yamlErrorWrapper, pipelineGetResponseBody.yamlErrorWrapper) &&
        Objects.equals(created, pipelineGetResponseBody.created) &&
        Objects.equals(updated, pipelineGetResponseBody.updated);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pipelineYaml, pipelineYamlWithTemplates, modules, gitDetails, yamlErrorWrapper, created, updated);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PipelineGetResponseBody {\n");
    
    sb.append("    pipelineYaml: ").append(toIndentedString(pipelineYaml)).append("\n");
    sb.append("    pipelineYamlWithTemplates: ").append(toIndentedString(pipelineYamlWithTemplates)).append("\n");
    sb.append("    modules: ").append(toIndentedString(modules)).append("\n");
    sb.append("    gitDetails: ").append(toIndentedString(gitDetails)).append("\n");
    sb.append("    yamlErrorWrapper: ").append(toIndentedString(yamlErrorWrapper)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    updated: ").append(toIndentedString(updated)).append("\n");
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
