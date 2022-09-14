package io.harness.spec.server.pipeline.model;

import io.harness.spec.server.pipeline.model.ModuleProperties;
import io.harness.spec.server.pipeline.model.PipelineTags;
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

  private @Valid List<PipelineTags> pipelineTags = new ArrayList<>();

  private @Valid List<String> pipelines = new ArrayList<>();

  private @Valid String name = null;

  private @Valid String description = null;

  private @Valid ModuleProperties moduleProperties = null;

  private @Valid Map<String, String> tags = new HashMap<>();

public enum FilterTypeEnum {

    CONNECTOR(String.valueOf("Connector")), DELEGATEPROFILE(String.valueOf("DelegateProfile")), DELEGATE(String.valueOf("Delegate")), PIPELINESETUP(String.valueOf("PipelineSetup")), PIPELINEEXECUTION(String.valueOf("PipelineExecution")), DEPLOYMENT(String.valueOf("Deployment")), AUDIT(String.valueOf("Audit")), TEMPLATE(String.valueOf("Template")), ENVIRONMENTGROUP(String.valueOf("EnvironmentGroup")), FILESTORE(String.valueOf("FileStore")), CCMRECOMMENDATION(String.valueOf("CCMRecommendation")), ANOMALY(String.valueOf("Anomaly")), ENVIRONMENT(String.valueOf("Environment"));


    private String value;

    FilterTypeEnum (String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    @Override
    @JsonValue
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static FilterTypeEnum fromValue(String v) {
        for (FilterTypeEnum b : FilterTypeEnum.values()) {
            if (String.valueOf(b.value).equals(v)) {
                return b;
            }
        }
        return null;
    }
}
  private @Valid FilterTypeEnum filterType = null;

  /**
   * Pipeline Tags on which filter will be applied.
   **/
  public PipelineListRequestBody pipelineTags(List<PipelineTags> pipelineTags) {
    this.pipelineTags = pipelineTags;
    return this;
  }

  
  @Schema(description = "Pipeline Tags on which filter will be applied.")
  @JsonProperty("pipeline_tags")

  public List<PipelineTags> getPipelineTags() {
    return pipelineTags;
  }
  public void setPipelineTags(List<PipelineTags> pipelineTags) {
    this.pipelineTags = pipelineTags;
  }

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
   **/
  public PipelineListRequestBody moduleProperties(ModuleProperties moduleProperties) {
    this.moduleProperties = moduleProperties;
    return this;
  }

  
  @Schema(description = "")
  @JsonProperty("module_properties")

  public ModuleProperties getModuleProperties() {
    return moduleProperties;
  }
  public void setModuleProperties(ModuleProperties moduleProperties) {
    this.moduleProperties = moduleProperties;
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

  /**
   * Corresponding Entity of the filter.
   **/
  public PipelineListRequestBody filterType(FilterTypeEnum filterType) {
    this.filterType = filterType;
    return this;
  }

  
  @Schema(required = true, description = "Corresponding Entity of the filter.")
  @JsonProperty("filter_type")
  @NotNull

  public FilterTypeEnum getFilterType() {
    return filterType;
  }
  public void setFilterType(FilterTypeEnum filterType) {
    this.filterType = filterType;
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
    return Objects.equals(pipelineTags, pipelineListRequestBody.pipelineTags) &&
        Objects.equals(pipelines, pipelineListRequestBody.pipelines) &&
        Objects.equals(name, pipelineListRequestBody.name) &&
        Objects.equals(description, pipelineListRequestBody.description) &&
        Objects.equals(moduleProperties, pipelineListRequestBody.moduleProperties) &&
        Objects.equals(tags, pipelineListRequestBody.tags) &&
        Objects.equals(filterType, pipelineListRequestBody.filterType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pipelineTags, pipelines, name, description, moduleProperties, tags, filterType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PipelineListRequestBody {\n");
    
    sb.append("    pipelineTags: ").append(toIndentedString(pipelineTags)).append("\n");
    sb.append("    pipelines: ").append(toIndentedString(pipelines)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    moduleProperties: ").append(toIndentedString(moduleProperties)).append("\n");
    sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
    sb.append("    filterType: ").append(toIndentedString(filterType)).append("\n");
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
