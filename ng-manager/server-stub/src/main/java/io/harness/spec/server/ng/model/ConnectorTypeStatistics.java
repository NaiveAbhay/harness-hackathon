package io.harness.spec.server.ng.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Objects;
import javax.validation.Valid;

@Schema(description = "Count of Connectors grouped by type.")

public class ConnectorTypeStatistics {

  public enum TypeEnum {

    K8SCLUSTER(String.valueOf("K8sCluster")),
    GIT(String.valueOf("Git")),
    SPLUNK(String.valueOf("Splunk")),
    APPDYNAMICS(String.valueOf("AppDynamics")),
    PROMETHEUS(String.valueOf("Prometheus")),
    DYNATRACE(String.valueOf("Dynatrace")),
    VAULT(String.valueOf("Vault")),
    AZUREKEYVAULT(String.valueOf("AzureKeyVault")),
    DOCKERREGISTRY(String.valueOf("DockerRegistry")),
    LOCAL(String.valueOf("Local")),
    AWSKMS(String.valueOf("AwsKms")),
    GCPKMS(String.valueOf("GcpKms")),
    AWSSECRETMANAGER(String.valueOf("AwsSecretManager")),
    GCP(String.valueOf("Gcp")),
    AWS(String.valueOf("Aws")),
    AZURE(String.valueOf("Azure")),
    ARTIFACTORY(String.valueOf("Artifactory")),
    JIRA(String.valueOf("Jira")),
    NEXUS(String.valueOf("Nexus")),
    GITHUB(String.valueOf("Github")),
    GITLAB(String.valueOf("Gitlab")),
    BITBUCKET(String.valueOf("Bitbucket")),
    CODECOMMIT(String.valueOf("Codecommit")),
    CEAWS(String.valueOf("CEAws")),
    CEAZURE(String.valueOf("CEAzure")),
    GCPCLOUDCOST(String.valueOf("GcpCloudCost")),
    CEK8SCLUSTER(String.valueOf("CEK8sCluster")),
    HTTPHELMREPO(String.valueOf("HttpHelmRepo")),
    NEWRELIC(String.valueOf("NewRelic")),
    DATADOG(String.valueOf("Datadog")),
    SUMOLOGIC(String.valueOf("SumoLogic")),
    PAGERDUTY(String.valueOf("PagerDuty")),
    CUSTOMHEALTH(String.valueOf("CustomHealth")),
    SERVICENOW(String.valueOf("ServiceNow")),
    ERRORTRACKING(String.valueOf("ErrorTracking")),
    PDC(String.valueOf("Pdc")),
    AZUREREPO(String.valueOf("AzureRepo")),
    JENKINS(String.valueOf("Jenkins")),
    OCIHELMREPO(String.valueOf("OciHelmRepo"));

    private String value;

    TypeEnum(String v) { value = v; }

    public String value() { return value; }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TypeEnum fromValue(String v) {
      for (TypeEnum b : TypeEnum.values()) {
        if (String.valueOf(b.value).equals(v)) {
          return b;
        }
      }
      return null;
    }
  }
  private @Valid TypeEnum type = null;

  private @Valid Integer count = null;

  /**
   **/
  public ConnectorTypeStatistics type(TypeEnum type) {
    this.type = type;
    return this;
  }

  @Schema(description = "")
  @JsonProperty("type")

  public TypeEnum getType() {
    return type;
  }
  public void setType(TypeEnum type) { this.type = type; }

  /**
   **/
  public ConnectorTypeStatistics count(Integer count) {
    this.count = count;
    return this;
  }

  @Schema(description = "")
  @JsonProperty("count")

  public Integer getCount() {
    return count;
  }
  public void setCount(Integer count) { this.count = count; }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConnectorTypeStatistics connectorTypeStatistics =
        (ConnectorTypeStatistics)o;
    return Objects.equals(type, connectorTypeStatistics.type) &&
        Objects.equals(count, connectorTypeStatistics.count);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, count);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConnectorTypeStatistics {\n");

    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    count: ").append(toIndentedString(count)).append("\n");
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
