package io.harness.spec.server.pipeline.model;

import io.harness.spec.server.pipeline.model.GitDetails;
import io.harness.spec.server.pipeline.model.YAMLSchemaErrorWrapper;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

  private @Valid String templateAppliedPipelineYaml = null;

  private @Valid String slug = null;

  private @Valid String name = null;

  private @Valid String org = null;

  private @Valid String project = null;

  private @Valid String description = null;

  private @Valid Map<String, String> tags = new HashMap<>();

  private @Valid List<String> modules = new ArrayList<>();

  private @Valid GitDetails gitDetails = null;

  private @Valid Boolean valid = null;

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
  public PipelineGetResponseBody templateAppliedPipelineYaml(String templateAppliedPipelineYaml) {
    this.templateAppliedPipelineYaml = templateAppliedPipelineYaml;
    return this;
  }

  
  @Schema(description = "Pipeline YAML after resolving Templates (returned as a String).")
  @JsonProperty("template_applied_pipeline_yaml")

  public String getTemplateAppliedPipelineYaml() {
    return templateAppliedPipelineYaml;
  }
  public void setTemplateAppliedPipelineYaml(String templateAppliedPipelineYaml) {
    this.templateAppliedPipelineYaml = templateAppliedPipelineYaml;
  }

  /**
   * Pipeline identifier
   **/
  public PipelineGetResponseBody slug(String slug) {
    this.slug = slug;
    return this;
  }

  
  @Schema(description = "Pipeline identifier")
  @JsonProperty("slug")
 @Pattern(regexp="^[a-zA-Z_][0-9a-zA-Z-_$]{0,63}$") @Size(min=1,max=64)
  public String getSlug() {
    return slug;
  }
  public void setSlug(String slug) {
    this.slug = slug;
  }

  /**
   * Pipeline name
   **/
  public PipelineGetResponseBody name(String name) {
    this.name = name;
    return this;
  }

  
  @Schema(description = "Pipeline name")
  @JsonProperty("name")
 @Pattern(regexp="^[a-zA-Z_][0-9a-zA-Z-_$]{0,63}$") @Size(min=1,max=64)
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Organization identifier
   **/
  public PipelineGetResponseBody org(String org) {
    this.org = org;
    return this;
  }

  
  @Schema(description = "Organization identifier")
  @JsonProperty("org")
 @Pattern(regexp="^[a-zA-Z_][0-9a-zA-Z-_$]{0,63}$") @Size(min=1,max=64)
  public String getOrg() {
    return org;
  }
  public void setOrg(String org) {
    this.org = org;
  }

  /**
   * Project identifier
   **/
  public PipelineGetResponseBody project(String project) {
    this.project = project;
    return this;
  }

  
  @Schema(description = "Project identifier")
  @JsonProperty("project")
 @Pattern(regexp="^[a-zA-Z_][0-9a-zA-Z-_$]{0,63}$") @Size(min=1,max=64)
  public String getProject() {
    return project;
  }
  public void setProject(String project) {
    this.project = project;
  }

  /**
   * Pipeline description
   **/
  public PipelineGetResponseBody description(String description) {
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
  public PipelineGetResponseBody tags(Map<String, String> tags) {
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
   * Specifies whether Pipeline is a valid or not.
   **/
  public PipelineGetResponseBody valid(Boolean valid) {
    this.valid = valid;
    return this;
  }

  
  @Schema(description = "Specifies whether Pipeline is a valid or not.")
  @JsonProperty("valid")

  public Boolean isValid() {
    return valid;
  }
  public void setValid(Boolean valid) {
    this.valid = valid;
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
        Objects.equals(templateAppliedPipelineYaml, pipelineGetResponseBody.templateAppliedPipelineYaml) &&
        Objects.equals(slug, pipelineGetResponseBody.slug) &&
        Objects.equals(name, pipelineGetResponseBody.name) &&
        Objects.equals(org, pipelineGetResponseBody.org) &&
        Objects.equals(project, pipelineGetResponseBody.project) &&
        Objects.equals(description, pipelineGetResponseBody.description) &&
        Objects.equals(tags, pipelineGetResponseBody.tags) &&
        Objects.equals(modules, pipelineGetResponseBody.modules) &&
        Objects.equals(gitDetails, pipelineGetResponseBody.gitDetails) &&
        Objects.equals(valid, pipelineGetResponseBody.valid) &&
        Objects.equals(yamlErrorWrapper, pipelineGetResponseBody.yamlErrorWrapper) &&
        Objects.equals(created, pipelineGetResponseBody.created) &&
        Objects.equals(updated, pipelineGetResponseBody.updated);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pipelineYaml, templateAppliedPipelineYaml, slug, name, org, project, description, tags, modules, gitDetails, valid, yamlErrorWrapper, created, updated);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PipelineGetResponseBody {\n");
    
    sb.append("    pipelineYaml: ").append(toIndentedString(pipelineYaml)).append("\n");
    sb.append("    templateAppliedPipelineYaml: ").append(toIndentedString(templateAppliedPipelineYaml)).append("\n");
    sb.append("    slug: ").append(toIndentedString(slug)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    org: ").append(toIndentedString(org)).append("\n");
    sb.append("    project: ").append(toIndentedString(project)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
    sb.append("    modules: ").append(toIndentedString(modules)).append("\n");
    sb.append("    gitDetails: ").append(toIndentedString(gitDetails)).append("\n");
    sb.append("    valid: ").append(toIndentedString(valid)).append("\n");
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
