package io.harness.spec.server.template.model;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * Template stable version update Response
 **/
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.v3.oas.annotations.media.Schema;



@Schema(description = "Template stable version update Response")

public class TemplateUpdateStableResponse   {

  private @Valid String stableVersion = null;

  /**
   * Version which is set as stable for the given Template 
   **/
  public TemplateUpdateStableResponse stableVersion(String stableVersion) {
    this.stableVersion = stableVersion;
    return this;
  }

  
  @Schema(description = "Version which is set as stable for the given Template ")
  @JsonProperty("stable_version")

  public String getStableVersion() {
    return stableVersion;
  }
  public void setStableVersion(String stableVersion) {
    this.stableVersion = stableVersion;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TemplateUpdateStableResponse templateUpdateStableResponse = (TemplateUpdateStableResponse) o;
    return Objects.equals(stableVersion, templateUpdateStableResponse.stableVersion);
  }

  @Override
  public int hashCode() {
    return Objects.hash(stableVersion);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TemplateUpdateStableResponse {\n");
    
    sb.append("    stableVersion: ").append(toIndentedString(stableVersion)).append("\n");
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
