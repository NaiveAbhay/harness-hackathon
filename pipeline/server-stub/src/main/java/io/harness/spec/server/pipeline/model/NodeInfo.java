package io.harness.spec.server.pipeline.model;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * Entity details
 **/
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

@Schema(description = "Entity details")

public class NodeInfo   {

  private @Valid String slug = null;

  private @Valid String type = null;

  private @Valid String name = null;

  private @Valid String fqn = null;

  /**
   * Entity identifier
   **/
  public NodeInfo slug(String slug) {
    this.slug = slug;
    return this;
  }

  
  @Schema(description = "Entity identifier")
  @JsonProperty("slug")
 @Pattern(regexp="^[a-zA-Z_][0-9a-zA-Z_$]{0,63}$") @Size(min=1,max=64)
  public String getSlug() {
    return slug;
  }
  public void setSlug(String slug) {
    this.slug = slug;
  }

  /**
   * Type of Entity
   **/
  public NodeInfo type(String type) {
    this.type = type;
    return this;
  }

  
  @Schema(description = "Type of Entity")
  @JsonProperty("type")

  public String getType() {
    return type;
  }
  public void setType(String type) {
    this.type = type;
  }

  /**
   * Name of Entity
   **/
  public NodeInfo name(String name) {
    this.name = name;
    return this;
  }

  
  @Schema(description = "Name of Entity")
  @JsonProperty("name")
 @Pattern(regexp="^[a-zA-Z_][0-9a-zA-Z_$]{0,63}$") @Size(min=1,max=64)
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Fully Qualified Name
   **/
  public NodeInfo fqn(String fqn) {
    this.fqn = fqn;
    return this;
  }

  
  @Schema(description = "Fully Qualified Name")
  @JsonProperty("fqn")

  public String getFqn() {
    return fqn;
  }
  public void setFqn(String fqn) {
    this.fqn = fqn;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NodeInfo nodeInfo = (NodeInfo) o;
    return Objects.equals(slug, nodeInfo.slug) &&
        Objects.equals(type, nodeInfo.type) &&
        Objects.equals(name, nodeInfo.name) &&
        Objects.equals(fqn, nodeInfo.fqn);
  }

  @Override
  public int hashCode() {
    return Objects.hash(slug, type, name, fqn);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NodeInfo {\n");
    
    sb.append("    slug: ").append(toIndentedString(slug)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    fqn: ").append(toIndentedString(fqn)).append("\n");
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
