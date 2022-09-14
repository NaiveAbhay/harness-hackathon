package io.harness.spec.server.pipeline.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * Pipeline Resource response body
 **/
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

@Schema(description = "Pipeline Resource response body")

public class PipelineViewResponseOption  implements OneOfPipelineViewResponseOption  {

public enum ViewOptionEnum {

    YAML(String.valueOf("YAML")), SUMMARY(String.valueOf("Summary"));


    private String value;

    ViewOptionEnum (String v) {
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
    public static ViewOptionEnum fromValue(String v) {
        for (ViewOptionEnum b : ViewOptionEnum.values()) {
            if (String.valueOf(b.value).equals(v)) {
                return b;
            }
        }
        return null;
    }
}
  private @Valid ViewOptionEnum viewOption = null;

  /**
   * This specifies the view option for Pipeline Resource.
   **/
  public PipelineViewResponseOption viewOption(ViewOptionEnum viewOption) {
    this.viewOption = viewOption;
    return this;
  }

  
  @Schema(description = "This specifies the view option for Pipeline Resource.")
  @JsonProperty("view_option")

  public ViewOptionEnum getViewOption() {
    return viewOption;
  }
  public void setViewOption(ViewOptionEnum viewOption) {
    this.viewOption = viewOption;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PipelineViewResponseOption pipelineViewResponseOption = (PipelineViewResponseOption) o;
    return Objects.equals(viewOption, pipelineViewResponseOption.viewOption);
  }

  @Override
  public int hashCode() {
    return Objects.hash(viewOption);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PipelineViewResponseOption {\n");
    
    sb.append("    viewOption: ").append(toIndentedString(viewOption)).append("\n");
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
