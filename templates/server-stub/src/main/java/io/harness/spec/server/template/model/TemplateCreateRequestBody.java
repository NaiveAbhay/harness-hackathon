package io.harness.spec.server.template.model;

import io.harness.spec.server.template.model.GitCreateDetails;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * Templates Create Request Body
 **/
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.v3.oas.annotations.media.Schema;



@Schema(description = "Templates Create Request Body")

public class TemplateCreateRequestBody   {

  private @Valid String templateYaml = null;

  private @Valid GitCreateDetails gitDetails = null;

  /**
   * Yaml for creating new Template
   **/
  public TemplateCreateRequestBody templateYaml(String templateYaml) {
    this.templateYaml = templateYaml;
    return this;
  }

  
  @Schema(description = "Yaml for creating new Template")
  @JsonProperty("template_yaml")

  public String getTemplateYaml() {
    return templateYaml;
  }
  public void setTemplateYaml(String templateYaml) {
    this.templateYaml = templateYaml;
  }

  /**
   **/
  public TemplateCreateRequestBody gitDetails(GitCreateDetails gitDetails) {
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
    TemplateCreateRequestBody templateCreateRequestBody = (TemplateCreateRequestBody) o;
    return Objects.equals(templateYaml, templateCreateRequestBody.templateYaml) &&
        Objects.equals(gitDetails, templateCreateRequestBody.gitDetails);
  }

  @Override
  public int hashCode() {
    return Objects.hash(templateYaml, gitDetails);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TemplateCreateRequestBody {\n");
    
    sb.append("    templateYaml: ").append(toIndentedString(templateYaml)).append("\n");
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
