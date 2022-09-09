package io.harness.spec.server.platform.model;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * Specifies resources in Resource Group.
 **/
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

@Schema(description = "Specifies resources in Resource Group.")

public class ResourceFilter   {

  private @Valid String resourceType = null;

  private @Valid List<String> identifiers = new ArrayList<>();

  private @Valid String attributeName = null;

  private @Valid List<String> attributeValues = new ArrayList<>();

  /**
   * Specifies the type of Resource.
   **/
  public ResourceFilter resourceType(String resourceType) {
    this.resourceType = resourceType;
    return this;
  }

  
  @Schema(required = true, description = "Specifies the type of Resource.")
  @JsonProperty("resource_type")
  @NotNull

  public String getResourceType() {
    return resourceType;
  }
  public void setResourceType(String resourceType) {
    this.resourceType = resourceType;
  }

  /**
   * Identifiers for the Resource Type.
   **/
  public ResourceFilter identifiers(List<String> identifiers) {
    this.identifiers = identifiers;
    return this;
  }

  
  @Schema(description = "Identifiers for the Resource Type.")
  @JsonProperty("identifiers")

  public List<String> getIdentifiers() {
    return identifiers;
  }
  public void setIdentifiers(List<String> identifiers) {
    this.identifiers = identifiers;
  }

  /**
   * Attribute name on the basis of which filtering will be done.
   **/
  public ResourceFilter attributeName(String attributeName) {
    this.attributeName = attributeName;
    return this;
  }

  
  @Schema(description = "Attribute name on the basis of which filtering will be done.")
  @JsonProperty("attribute_name")

  public String getAttributeName() {
    return attributeName;
  }
  public void setAttributeName(String attributeName) {
    this.attributeName = attributeName;
  }

  /**
   * Attribute values selected
   **/
  public ResourceFilter attributeValues(List<String> attributeValues) {
    this.attributeValues = attributeValues;
    return this;
  }

  
  @Schema(description = "Attribute values selected")
  @JsonProperty("attribute_values")

  public List<String> getAttributeValues() {
    return attributeValues;
  }
  public void setAttributeValues(List<String> attributeValues) {
    this.attributeValues = attributeValues;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResourceFilter resourceFilter = (ResourceFilter) o;
    return Objects.equals(resourceType, resourceFilter.resourceType) &&
        Objects.equals(identifiers, resourceFilter.identifiers) &&
        Objects.equals(attributeName, resourceFilter.attributeName) &&
        Objects.equals(attributeValues, resourceFilter.attributeValues);
  }

  @Override
  public int hashCode() {
    return Objects.hash(resourceType, identifiers, attributeName, attributeValues);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResourceFilter {\n");
    
    sb.append("    resourceType: ").append(toIndentedString(resourceType)).append("\n");
    sb.append("    identifiers: ").append(toIndentedString(identifiers)).append("\n");
    sb.append("    attributeName: ").append(toIndentedString(attributeName)).append("\n");
    sb.append("    attributeValues: ").append(toIndentedString(attributeValues)).append("\n");
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
