package io.harness.spec.server.commons.model;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * Test Error Metadata
 **/
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.v3.oas.annotations.media.Schema;



@Schema(description = "Test Error Metadata")

public class TestErrorMetadata   {

  private @Valid Object type = null;

  private @Valid Object test = null;

  /**
   **/
  public TestErrorMetadata type(Object type) {
    this.type = type;
    return this;
  }

  
  @Schema(required = true, description = "")
  @JsonProperty("type")
  @NotNull

  public Object getType() {
    return type;
  }
  public void setType(Object type) {
    this.type = type;
  }

  /**
   **/
  public TestErrorMetadata test(Object test) {
    this.test = test;
    return this;
  }

  
  @Schema(description = "")
  @JsonProperty("test")

  public Object getTest() {
    return test;
  }
  public void setTest(Object test) {
    this.test = test;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TestErrorMetadata testErrorMetadata = (TestErrorMetadata) o;
    return Objects.equals(type, testErrorMetadata.type) &&
        Objects.equals(test, testErrorMetadata.test);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, test);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TestErrorMetadata {\n");
    
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    test: ").append(toIndentedString(test)).append("\n");
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
