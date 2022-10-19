package io.harness.spec.server.template.model;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * Contains details of the Template Filter
 **/
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.v3.oas.annotations.media.Schema;



@Schema(description = "Contains details of the Template Filter")

public class TemplateFilterProperties   {

  private @Valid List<String> names = new ArrayList<>();

  private @Valid List<String> identifiers = new ArrayList<>();

  private @Valid String description = null;

public enum EntityTypesEnum {

    STEP(String.valueOf("Step")), STAGE(String.valueOf("Stage")), PIPELINE(String.valueOf("Pipeline")), CUSTOMDEPLOYMENT(String.valueOf("CustomDeployment")), MONITOREDSERVICE(String.valueOf("MonitoredService")), SECRETMANAGER(String.valueOf("SecretManager"));


    private String value;

    EntityTypesEnum (String v) {
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
    public static EntityTypesEnum fromValue(String v) {
        for (EntityTypesEnum b : EntityTypesEnum.values()) {
            if (String.valueOf(b.value).equals(v)) {
                return b;
            }
        }
        return null;
    }
}
  private @Valid List<EntityTypesEnum> entityTypes = new ArrayList<>();

  private @Valid List<String> childTypes = new ArrayList<>();

  /**
   * Template names for filtering
   **/
  public TemplateFilterProperties names(List<String> names) {
    this.names = names;
    return this;
  }

  
  @Schema(description = "Template names for filtering")
  @JsonProperty("names")

  public List<String> getNames() {
    return names;
  }
  public void setNames(List<String> names) {
    this.names = names;
  }

  /**
   * Template Ids for Filtering
   **/
  public TemplateFilterProperties identifiers(List<String> identifiers) {
    this.identifiers = identifiers;
    return this;
  }

  
  @Schema(description = "Template Ids for Filtering")
  @JsonProperty("identifiers")

  public List<String> getIdentifiers() {
    return identifiers;
  }
  public void setIdentifiers(List<String> identifiers) {
    this.identifiers = identifiers;
  }

  /**
   * Filter properties description
   **/
  public TemplateFilterProperties description(String description) {
    this.description = description;
    return this;
  }

  
  @Schema(description = "Filter properties description")
  @JsonProperty("description")

  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * Type of Template 
   **/
  public TemplateFilterProperties entityTypes(List<EntityTypesEnum> entityTypes) {
    this.entityTypes = entityTypes;
    return this;
  }

  
  @Schema(description = "Type of Template ")
  @JsonProperty("entity_types")

  public List<EntityTypesEnum> getEntityTypes() {
    return entityTypes;
  }
  public void setEntityTypes(List<EntityTypesEnum> entityTypes) {
    this.entityTypes = entityTypes;
  }

  /**
   **/
  public TemplateFilterProperties childTypes(List<String> childTypes) {
    this.childTypes = childTypes;
    return this;
  }

  
  @Schema(description = "")
  @JsonProperty("child_types")

  public List<String> getChildTypes() {
    return childTypes;
  }
  public void setChildTypes(List<String> childTypes) {
    this.childTypes = childTypes;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TemplateFilterProperties templateFilterProperties = (TemplateFilterProperties) o;
    return Objects.equals(names, templateFilterProperties.names) &&
        Objects.equals(identifiers, templateFilterProperties.identifiers) &&
        Objects.equals(description, templateFilterProperties.description) &&
        Objects.equals(entityTypes, templateFilterProperties.entityTypes) &&
        Objects.equals(childTypes, templateFilterProperties.childTypes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(names, identifiers, description, entityTypes, childTypes);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TemplateFilterProperties {\n");
    
    sb.append("    names: ").append(toIndentedString(names)).append("\n");
    sb.append("    identifiers: ").append(toIndentedString(identifiers)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    entityTypes: ").append(toIndentedString(entityTypes)).append("\n");
    sb.append("    childTypes: ").append(toIndentedString(childTypes)).append("\n");
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
