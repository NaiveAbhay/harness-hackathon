package io.harness.spec.server.ng.model;

import io.harness.spec.server.ng.model.Project;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * Update project request
 **/
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.v3.oas.annotations.media.Schema;



@Schema(description = "Update project request")

public class UpdateProjectRequest   {

  private @Valid Project project = null;

  /**
   **/
  public UpdateProjectRequest project(Project project) {
    this.project = project;
    return this;
  }

  
  @Schema(required = true, description = "")
  @JsonProperty("project")
  @NotNull

  public Project getProject() {
    return project;
  }
  public void setProject(Project project) {
    this.project = project;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateProjectRequest updateProjectRequest = (UpdateProjectRequest) o;
    return Objects.equals(project, updateProjectRequest.project);
  }

  @Override
  public int hashCode() {
    return Objects.hash(project);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateProjectRequest {\n");
    
    sb.append("    project: ").append(toIndentedString(project)).append("\n");
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
