package io.harness.spec.server.pipeline.model;

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

public class YAML extends PipelineViewResponseOption implements OneOfPipelineViewResponseOption  {

  private @Valid String pipelineYaml = null;

  private @Valid String pipelineYamlWithTemplates = null;

  /**
   * Pipeline YAML (returned as a String).
   **/
  public YAML pipelineYaml(String pipelineYaml) {
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
  public YAML pipelineYamlWithTemplates(String pipelineYamlWithTemplates) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    YAML YAML = (YAML) o;
    return Objects.equals(pipelineYaml, YAML.pipelineYaml) &&
        Objects.equals(pipelineYamlWithTemplates, YAML.pipelineYamlWithTemplates);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pipelineYaml, pipelineYamlWithTemplates);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class YAML {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    pipelineYaml: ").append(toIndentedString(pipelineYaml)).append("\n");
    sb.append("    pipelineYamlWithTemplates: ").append(toIndentedString(pipelineYamlWithTemplates)).append("\n");
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
