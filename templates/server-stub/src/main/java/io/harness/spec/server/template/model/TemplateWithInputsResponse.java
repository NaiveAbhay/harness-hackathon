package io.harness.spec.server.template.model;

import io.harness.spec.server.template.model.TemplateResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * Returns Template input YAML with template response
 **/
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.v3.oas.annotations.media.Schema;



@Schema(description = "Returns Template input YAML with template response")

public class TemplateWithInputsResponse   {

  private @Valid TemplateResponse templateResponse = null;

  private @Valid String inputYaml = null;

  /**
   **/
  public TemplateWithInputsResponse templateResponse(TemplateResponse templateResponse) {
    this.templateResponse = templateResponse;
    return this;
  }

  
  @Schema(description = "")
  @JsonProperty("template_response")

  public TemplateResponse getTemplateResponse() {
    return templateResponse;
  }
  public void setTemplateResponse(TemplateResponse templateResponse) {
    this.templateResponse = templateResponse;
  }

  /**
   * Input Yaml for the Template
   **/
  public TemplateWithInputsResponse inputYaml(String inputYaml) {
    this.inputYaml = inputYaml;
    return this;
  }

  
  @Schema(description = "Input Yaml for the Template")
  @JsonProperty("input_yaml")

  public String getInputYaml() {
    return inputYaml;
  }
  public void setInputYaml(String inputYaml) {
    this.inputYaml = inputYaml;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TemplateWithInputsResponse templateWithInputsResponse = (TemplateWithInputsResponse) o;
    return Objects.equals(templateResponse, templateWithInputsResponse.templateResponse) &&
        Objects.equals(inputYaml, templateWithInputsResponse.inputYaml);
  }

  @Override
  public int hashCode() {
    return Objects.hash(templateResponse, inputYaml);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TemplateWithInputsResponse {\n");
    
    sb.append("    templateResponse: ").append(toIndentedString(templateResponse)).append("\n");
    sb.append("    inputYaml: ").append(toIndentedString(inputYaml)).append("\n");
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
