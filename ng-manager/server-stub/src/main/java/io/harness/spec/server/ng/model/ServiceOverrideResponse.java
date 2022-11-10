package io.harness.spec.server.ng.model;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * Default Service Override response 
 **/
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.v3.oas.annotations.media.Schema;



@Schema(description = "Default Service Override response ")

public class ServiceOverrideResponse   {

  private @Valid String account = null;

  private @Valid String org = null;

  private @Valid String project = null;

  private @Valid String environemnt = null;

  private @Valid String service = null;

  private @Valid String yaml = null;

  /**
   * Account Identifier
   **/
  public ServiceOverrideResponse account(String account) {
    this.account = account;
    return this;
  }

  
  @Schema(description = "Account Identifier")
  @JsonProperty("account")
 @Pattern(regexp="^[a-zA-Z_][0-9a-zA-Z_$]{0,63}$") @Size(min=1,max=64)
  public String getAccount() {
    return account;
  }
  public void setAccount(String account) {
    this.account = account;
  }

  /**
   * Organization Identifier for the Entity.
   **/
  public ServiceOverrideResponse org(String org) {
    this.org = org;
    return this;
  }

  
  @Schema(description = "Organization Identifier for the Entity.")
  @JsonProperty("org")
 @Pattern(regexp="^[a-zA-Z_][0-9a-zA-Z_$]{0,63}$") @Size(min=1,max=64)
  public String getOrg() {
    return org;
  }
  public void setOrg(String org) {
    this.org = org;
  }

  /**
   * Project Identifier for the Entity.
   **/
  public ServiceOverrideResponse project(String project) {
    this.project = project;
    return this;
  }

  
  @Schema(description = "Project Identifier for the Entity.")
  @JsonProperty("project")
 @Pattern(regexp="^[a-zA-Z_][0-9a-zA-Z_$]{0,63}$") @Size(min=1,max=64)
  public String getProject() {
    return project;
  }
  public void setProject(String project) {
    this.project = project;
  }

  /**
   * Environemnt Identifier for the Entity.
   **/
  public ServiceOverrideResponse environemnt(String environemnt) {
    this.environemnt = environemnt;
    return this;
  }

  
  @Schema(description = "Environemnt Identifier for the Entity.")
  @JsonProperty("environemnt")
 @Pattern(regexp="^[a-zA-Z_][0-9a-zA-Z_$]{0,63}$") @Size(min=1,max=64)
  public String getEnvironemnt() {
    return environemnt;
  }
  public void setEnvironemnt(String environemnt) {
    this.environemnt = environemnt;
  }

  /**
   * Service Identifier for the Entity.
   **/
  public ServiceOverrideResponse service(String service) {
    this.service = service;
    return this;
  }

  
  @Schema(description = "Service Identifier for the Entity.")
  @JsonProperty("service")
 @Pattern(regexp="^[a-zA-Z_][0-9a-zA-Z_$]{0,63}$") @Size(min=1,max=64)
  public String getService() {
    return service;
  }
  public void setService(String service) {
    this.service = service;
  }

  /**
   * Yaml related to service override 
   **/
  public ServiceOverrideResponse yaml(String yaml) {
    this.yaml = yaml;
    return this;
  }

  
  @Schema(required = true, description = "Yaml related to service override ")
  @JsonProperty("yaml")
  @NotNull

  public String getYaml() {
    return yaml;
  }
  public void setYaml(String yaml) {
    this.yaml = yaml;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServiceOverrideResponse serviceOverrideResponse = (ServiceOverrideResponse) o;
    return Objects.equals(account, serviceOverrideResponse.account) &&
        Objects.equals(org, serviceOverrideResponse.org) &&
        Objects.equals(project, serviceOverrideResponse.project) &&
        Objects.equals(environemnt, serviceOverrideResponse.environemnt) &&
        Objects.equals(service, serviceOverrideResponse.service) &&
        Objects.equals(yaml, serviceOverrideResponse.yaml);
  }

  @Override
  public int hashCode() {
    return Objects.hash(account, org, project, environemnt, service, yaml);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceOverrideResponse {\n");
    
    sb.append("    account: ").append(toIndentedString(account)).append("\n");
    sb.append("    org: ").append(toIndentedString(org)).append("\n");
    sb.append("    project: ").append(toIndentedString(project)).append("\n");
    sb.append("    environemnt: ").append(toIndentedString(environemnt)).append("\n");
    sb.append("    service: ").append(toIndentedString(service)).append("\n");
    sb.append("    yaml: ").append(toIndentedString(yaml)).append("\n");
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
