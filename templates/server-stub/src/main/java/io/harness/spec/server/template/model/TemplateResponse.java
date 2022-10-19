package io.harness.spec.server.template.model;

import io.harness.spec.server.template.model.EntityGitDetails;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * Default response when a template is returned
 **/
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.v3.oas.annotations.media.Schema;



@Schema(description = "Default response when a template is returned")

public class TemplateResponse   {

  private @Valid String account = null;

  private @Valid String org = null;

  private @Valid String project = null;

  private @Valid String slug = null;

  private @Valid String name = null;

  private @Valid String description = null;

  private @Valid Map<String, String> tags = new HashMap<>();

  private @Valid String yaml = null;

  private @Valid String versionLabel = null;

public enum EntityTypeEnum {

    STEP(String.valueOf("Step")), STAGE(String.valueOf("Stage")), PIPELINE(String.valueOf("Pipeline")), CUSTOMDEPLOYMENT(String.valueOf("CustomDeployment")), MONITOREDSERVICE(String.valueOf("MonitoredService")), SECRETMANAGER(String.valueOf("SecretManager"));


    private String value;

    EntityTypeEnum (String v) {
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
    public static EntityTypeEnum fromValue(String v) {
        for (EntityTypeEnum b : EntityTypeEnum.values()) {
            if (String.valueOf(b.value).equals(v)) {
                return b;
            }
        }
        return null;
    }
}
  private @Valid EntityTypeEnum entityType = null;

  private @Valid String childType = null;

public enum ScopeEnum {

    ORG(String.valueOf("org")), PROJECT(String.valueOf("project")), ACCOUNT(String.valueOf("account")), UNKNOWN(String.valueOf("unknown"));


    private String value;

    ScopeEnum (String v) {
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
    public static ScopeEnum fromValue(String v) {
        for (ScopeEnum b : ScopeEnum.values()) {
            if (String.valueOf(b.value).equals(v)) {
                return b;
            }
        }
        return null;
    }
}
  private @Valid ScopeEnum scope = null;

  private @Valid Long version = null;

  private @Valid EntityGitDetails gitDetails = null;

  private @Valid Long updated = null;

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

  private @Valid Boolean stableTemplate = null;

  /**
   * Account identifier
   **/
  public TemplateResponse account(String account) {
    this.account = account;
    return this;
  }

  
  @Schema(required = true, description = "Account identifier")
  @JsonProperty("account")
  @NotNull
 @Pattern(regexp="^[a-zA-Z_][0-9a-zA-Z_$]{0,63}$") @Size(min=1,max=64)
  public String getAccount() {
    return account;
  }
  public void setAccount(String account) {
    this.account = account;
  }

  /**
   * Organization identifier
   **/
  public TemplateResponse org(String org) {
    this.org = org;
    return this;
  }

  
  @Schema(description = "Organization identifier")
  @JsonProperty("org")
 @Pattern(regexp="^[a-zA-Z_][0-9a-zA-Z_$]{0,63}$") @Size(min=1,max=64)
  public String getOrg() {
    return org;
  }
  public void setOrg(String org) {
    this.org = org;
  }

  /**
   * Project identifier
   **/
  public TemplateResponse project(String project) {
    this.project = project;
    return this;
  }

  
  @Schema(description = "Project identifier")
  @JsonProperty("project")
 @Pattern(regexp="^[a-zA-Z_][0-9a-zA-Z_$]{0,63}$") @Size(min=1,max=64)
  public String getProject() {
    return project;
  }
  public void setProject(String project) {
    this.project = project;
  }

  /**
   * Template identifier
   **/
  public TemplateResponse slug(String slug) {
    this.slug = slug;
    return this;
  }

  
  @Schema(required = true, description = "Template identifier")
  @JsonProperty("slug")
  @NotNull
 @Pattern(regexp="^[a-zA-Z_][0-9a-zA-Z_$]{0,63}$") @Size(min=1,max=64)
  public String getSlug() {
    return slug;
  }
  public void setSlug(String slug) {
    this.slug = slug;
  }

  /**
   * Template Name
   **/
  public TemplateResponse name(String name) {
    this.name = name;
    return this;
  }

  
  @Schema(required = true, description = "Template Name")
  @JsonProperty("name")
  @NotNull
 @Pattern(regexp="^[a-zA-Z_][0-9a-zA-Z_$]{0,63}$") @Size(min=1,max=64)
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Template description
   **/
  public TemplateResponse description(String description) {
    this.description = description;
    return this;
  }

  
  @Schema(description = "Template description")
  @JsonProperty("description")
 @Size(max=1024)
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * Template tags
   **/
  public TemplateResponse tags(Map<String, String> tags) {
    this.tags = tags;
    return this;
  }

  
  @Schema(description = "Template tags")
  @JsonProperty("tags")
 @Size(max=128)
  public Map<String, String> getTags() {
    return tags;
  }
  public void setTags(Map<String, String> tags) {
    this.tags = tags;
  }

  /**
   * Yaml related to template
   **/
  public TemplateResponse yaml(String yaml) {
    this.yaml = yaml;
    return this;
  }

  
  @Schema(required = true, description = "Yaml related to template")
  @JsonProperty("yaml")
  @NotNull

  public String getYaml() {
    return yaml;
  }
  public void setYaml(String yaml) {
    this.yaml = yaml;
  }

  /**
   * Version label of template
   **/
  public TemplateResponse versionLabel(String versionLabel) {
    this.versionLabel = versionLabel;
    return this;
  }

  
  @Schema(description = "Version label of template")
  @JsonProperty("version_label")

  public String getVersionLabel() {
    return versionLabel;
  }
  public void setVersionLabel(String versionLabel) {
    this.versionLabel = versionLabel;
  }

  /**
   * Type of Template 
   **/
  public TemplateResponse entityType(EntityTypeEnum entityType) {
    this.entityType = entityType;
    return this;
  }

  
  @Schema(description = "Type of Template ")
  @JsonProperty("entity_type")

  public EntityTypeEnum getEntityType() {
    return entityType;
  }
  public void setEntityType(EntityTypeEnum entityType) {
    this.entityType = entityType;
  }

  /**
   * Defines child template type
   **/
  public TemplateResponse childType(String childType) {
    this.childType = childType;
    return this;
  }

  
  @Schema(description = "Defines child template type")
  @JsonProperty("child_type")

  public String getChildType() {
    return childType;
  }
  public void setChildType(String childType) {
    this.childType = childType;
  }

  /**
   * Scope of template
   **/
  public TemplateResponse scope(ScopeEnum scope) {
    this.scope = scope;
    return this;
  }

  
  @Schema(description = "Scope of template")
  @JsonProperty("scope")

  public ScopeEnum getScope() {
    return scope;
  }
  public void setScope(ScopeEnum scope) {
    this.scope = scope;
  }

  /**
   * Version of template
   **/
  public TemplateResponse version(Long version) {
    this.version = version;
    return this;
  }

  
  @Schema(description = "Version of template")
  @JsonProperty("version")

  public Long getVersion() {
    return version;
  }
  public void setVersion(Long version) {
    this.version = version;
  }

  /**
   **/
  public TemplateResponse gitDetails(EntityGitDetails gitDetails) {
    this.gitDetails = gitDetails;
    return this;
  }

  
  @Schema(description = "")
  @JsonProperty("git_details")

  public EntityGitDetails getGitDetails() {
    return gitDetails;
  }
  public void setGitDetails(EntityGitDetails gitDetails) {
    this.gitDetails = gitDetails;
  }

  /**
   * Last modification timestamp for Service. 
   **/
  public TemplateResponse updated(Long updated) {
    this.updated = updated;
    return this;
  }

  
  @Schema(description = "Last modification timestamp for Service. ")
  @JsonProperty("updated")

  public Long getUpdated() {
    return updated;
  }
  public void setUpdated(Long updated) {
    this.updated = updated;
  }

  /**
   * Specifies whether the Entity is to be stored in Git or not (for Git Experience).
   **/
  public TemplateResponse storeType(StoreTypeEnum storeType) {
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
  public TemplateResponse connectorRef(String connectorRef) {
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
   * True if this version is stable version of Template
   **/
  public TemplateResponse stableTemplate(Boolean stableTemplate) {
    this.stableTemplate = stableTemplate;
    return this;
  }

  
  @Schema(description = "True if this version is stable version of Template")
  @JsonProperty("stable_template")

  public Boolean isStableTemplate() {
    return stableTemplate;
  }
  public void setStableTemplate(Boolean stableTemplate) {
    this.stableTemplate = stableTemplate;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TemplateResponse templateResponse = (TemplateResponse) o;
    return Objects.equals(account, templateResponse.account) &&
        Objects.equals(org, templateResponse.org) &&
        Objects.equals(project, templateResponse.project) &&
        Objects.equals(slug, templateResponse.slug) &&
        Objects.equals(name, templateResponse.name) &&
        Objects.equals(description, templateResponse.description) &&
        Objects.equals(tags, templateResponse.tags) &&
        Objects.equals(yaml, templateResponse.yaml) &&
        Objects.equals(versionLabel, templateResponse.versionLabel) &&
        Objects.equals(entityType, templateResponse.entityType) &&
        Objects.equals(childType, templateResponse.childType) &&
        Objects.equals(scope, templateResponse.scope) &&
        Objects.equals(version, templateResponse.version) &&
        Objects.equals(gitDetails, templateResponse.gitDetails) &&
        Objects.equals(updated, templateResponse.updated) &&
        Objects.equals(storeType, templateResponse.storeType) &&
        Objects.equals(connectorRef, templateResponse.connectorRef) &&
        Objects.equals(stableTemplate, templateResponse.stableTemplate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(account, org, project, slug, name, description, tags, yaml, versionLabel, entityType, childType, scope, version, gitDetails, updated, storeType, connectorRef, stableTemplate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TemplateResponse {\n");
    
    sb.append("    account: ").append(toIndentedString(account)).append("\n");
    sb.append("    org: ").append(toIndentedString(org)).append("\n");
    sb.append("    project: ").append(toIndentedString(project)).append("\n");
    sb.append("    slug: ").append(toIndentedString(slug)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
    sb.append("    yaml: ").append(toIndentedString(yaml)).append("\n");
    sb.append("    versionLabel: ").append(toIndentedString(versionLabel)).append("\n");
    sb.append("    entityType: ").append(toIndentedString(entityType)).append("\n");
    sb.append("    childType: ").append(toIndentedString(childType)).append("\n");
    sb.append("    scope: ").append(toIndentedString(scope)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    gitDetails: ").append(toIndentedString(gitDetails)).append("\n");
    sb.append("    updated: ").append(toIndentedString(updated)).append("\n");
    sb.append("    storeType: ").append(toIndentedString(storeType)).append("\n");
    sb.append("    connectorRef: ").append(toIndentedString(connectorRef)).append("\n");
    sb.append("    stableTemplate: ").append(toIndentedString(stableTemplate)).append("\n");
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
