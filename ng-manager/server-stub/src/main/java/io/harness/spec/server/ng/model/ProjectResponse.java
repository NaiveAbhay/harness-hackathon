package io.harness.spec.server.ng.model;

import io.harness.spec.server.ng.model.Project;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * Project response model
 **/
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.v3.oas.annotations.media.Schema;



@Schema(description = "Project response model")

public class ProjectResponse   {

  private @Valid Project project = null;

  private @Valid Long created = null;

  private @Valid Long updated = null;

  /**
   **/
  public ProjectResponse project(Project project) {
    this.project = project;
    return this;
  }

  
  @Schema(description = "")
  @JsonProperty("project")

  public Project getProject() {
    return project;
  }
  public void setProject(Project project) {
    this.project = project;
  }

  /**
   * Creation timestamp for the project
   **/
  public ProjectResponse created(Long created) {
    this.created = created;
    return this;
  }

  
  @Schema(description = "Creation timestamp for the project")
  @JsonProperty("created")

  public Long getCreated() {
    return created;
  }
  public void setCreated(Long created) {
    this.created = created;
  }

  /**
   * Updated timestamp for the project
   **/
  public ProjectResponse updated(Long updated) {
    this.updated = updated;
    return this;
  }

  
  @Schema(description = "Updated timestamp for the project")
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
    ProjectResponse projectResponse = (ProjectResponse) o;
    return Objects.equals(project, projectResponse.project) &&
        Objects.equals(created, projectResponse.created) &&
        Objects.equals(updated, projectResponse.updated);
  }

  @Override
  public int hashCode() {
    return Objects.hash(project, created, updated);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProjectResponse {\n");
    
    sb.append("    project: ").append(toIndentedString(project)).append("\n");
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
