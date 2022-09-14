package io.harness.spec.server.pipeline.model;

import io.harness.spec.server.pipeline.model.ExecutionSummary;
import io.harness.spec.server.pipeline.model.PipelineViewResponseOption;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * Pipeline response body (Summary view).
**/
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

@Schema(description = "Pipeline response body (Summary view).")

public class Summary extends PipelineViewResponseOption implements OneOfPipelineViewResponseOption  {

  private @Valid String slug = null;

  private @Valid String name = null;

  private @Valid String description = null;

  private @Valid Map<String, String> tags = new HashMap<>();

  private @Valid String version = null;

  private @Valid Long created = null;

  private @Valid Long updated = null;

  private @Valid ExecutionSummary executionSummary = null;

  private @Valid Object filter = null;

public enum StoreTypeEnum {

    INLINE(String.valueOf("INLINE")), REMOTE(String.valueOf("REMOTE"));


    private String value;

    StoreTypeEnum (String v) {
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
    public static StoreTypeEnum fromValue(String v) {
        for (StoreTypeEnum b : StoreTypeEnum.values()) {
            if (String.valueOf(b.value).equals(v)) {
                return b;
            }
        }
        return null;
    }
}
  private @Valid StoreTypeEnum storeType = null;

  private @Valid String connectorRef = null;

  private @Valid Boolean draft = null;

  /**
   * Pipeline identifier
   **/
  public Summary slug(String slug) {
    this.slug = slug;
    return this;
  }

  
  @Schema(description = "Pipeline identifier")
  @JsonProperty("slug")
 @Pattern(regexp="^[a-zA-Z_][0-9a-zA-Z_$]{0,63}$") @Size(min=1,max=64)
  public String getSlug() {
    return slug;
  }
  public void setSlug(String slug) {
    this.slug = slug;
  }

  /**
   * Pipeline name
   **/
  public Summary name(String name) {
    this.name = name;
    return this;
  }

  
  @Schema(description = "Pipeline name")
  @JsonProperty("name")
 @Pattern(regexp="^[a-zA-Z_][0-9a-zA-Z_$]{0,63}$") @Size(min=1,max=64)
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Pipeline description
   **/
  public Summary description(String description) {
    this.description = description;
    return this;
  }

  
  @Schema(description = "Pipeline description")
  @JsonProperty("description")
 @Size(max=1024)
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * Pipeline tags
   **/
  public Summary tags(Map<String, String> tags) {
    this.tags = tags;
    return this;
  }

  
  @Schema(description = "Pipeline tags")
  @JsonProperty("tags")
 @Size(max=128)
  public Map<String, String> getTags() {
    return tags;
  }
  public void setTags(Map<String, String> tags) {
    this.tags = tags;
  }

  /**
   * Pipeline version
   **/
  public Summary version(String version) {
    this.version = version;
    return this;
  }

  
  @Schema(description = "Pipeline version")
  @JsonProperty("version")

  public String getVersion() {
    return version;
  }
  public void setVersion(String version) {
    this.version = version;
  }

  /**
   * Creation timestamp for Pipeline.
   **/
  public Summary created(Long created) {
    this.created = created;
    return this;
  }

  
  @Schema(description = "Creation timestamp for Pipeline.")
  @JsonProperty("created")

  public Long getCreated() {
    return created;
  }
  public void setCreated(Long created) {
    this.created = created;
  }

  /**
   * Last modification timestamp for Pipeline.
   **/
  public Summary updated(Long updated) {
    this.updated = updated;
    return this;
  }

  
  @Schema(description = "Last modification timestamp for Pipeline.")
  @JsonProperty("updated")

  public Long getUpdated() {
    return updated;
  }
  public void setUpdated(Long updated) {
    this.updated = updated;
  }

  /**
   **/
  public Summary executionSummary(ExecutionSummary executionSummary) {
    this.executionSummary = executionSummary;
    return this;
  }

  
  @Schema(description = "")
  @JsonProperty("execution_summary")

  public ExecutionSummary getExecutionSummary() {
    return executionSummary;
  }
  public void setExecutionSummary(ExecutionSummary executionSummary) {
    this.executionSummary = executionSummary;
  }

  /**
   * Additional properties
   **/
  public Summary filter(Object filter) {
    this.filter = filter;
    return this;
  }

  
  @Schema(description = "Additional properties")
  @JsonProperty("filter")

  public Object getFilter() {
    return filter;
  }
  public void setFilter(Object filter) {
    this.filter = filter;
  }

  /**
   * Specifies whether the Entity is to be stored in Git or not (for Git Experience).
   **/
  public Summary storeType(StoreTypeEnum storeType) {
    this.storeType = storeType;
    return this;
  }

  
  @Schema(description = "Specifies whether the Entity is to be stored in Git or not (for Git Experience).")
  @JsonProperty("store_type")

  public StoreTypeEnum getStoreType() {
    return storeType;
  }
  public void setStoreType(StoreTypeEnum storeType) {
    this.storeType = storeType;
  }

  /**
   * Identifier of the Harness Connector used for CRUD operations on the Entity (for Git Experience).
   **/
  public Summary connectorRef(String connectorRef) {
    this.connectorRef = connectorRef;
    return this;
  }

  
  @Schema(description = "Identifier of the Harness Connector used for CRUD operations on the Entity (for Git Experience).")
  @JsonProperty("connector_ref")

  public String getConnectorRef() {
    return connectorRef;
  }
  public void setConnectorRef(String connectorRef) {
    this.connectorRef = connectorRef;
  }

  /**
   * Specifies whether Pipeline is a draft or not.
   **/
  public Summary draft(Boolean draft) {
    this.draft = draft;
    return this;
  }

  
  @Schema(description = "Specifies whether Pipeline is a draft or not.")
  @JsonProperty("draft")

  public Boolean isDraft() {
    return draft;
  }
  public void setDraft(Boolean draft) {
    this.draft = draft;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Summary summary = (Summary) o;
    return Objects.equals(slug, summary.slug) &&
        Objects.equals(name, summary.name) &&
        Objects.equals(description, summary.description) &&
        Objects.equals(tags, summary.tags) &&
        Objects.equals(version, summary.version) &&
        Objects.equals(created, summary.created) &&
        Objects.equals(updated, summary.updated) &&
        Objects.equals(executionSummary, summary.executionSummary) &&
        Objects.equals(filter, summary.filter) &&
        Objects.equals(storeType, summary.storeType) &&
        Objects.equals(connectorRef, summary.connectorRef) &&
        Objects.equals(draft, summary.draft);
  }

  @Override
  public int hashCode() {
    return Objects.hash(slug, name, description, tags, version, created, updated, executionSummary, filter, storeType, connectorRef, draft);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Summary {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    slug: ").append(toIndentedString(slug)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    updated: ").append(toIndentedString(updated)).append("\n");
    sb.append("    executionSummary: ").append(toIndentedString(executionSummary)).append("\n");
    sb.append("    filter: ").append(toIndentedString(filter)).append("\n");
    sb.append("    storeType: ").append(toIndentedString(storeType)).append("\n");
    sb.append("    connectorRef: ").append(toIndentedString(connectorRef)).append("\n");
    sb.append("    draft: ").append(toIndentedString(draft)).append("\n");
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
