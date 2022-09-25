package io.harness.spec.server.ng.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeId;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * Details of the connector defined in Harness
 **/
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.v3.oas.annotations.media.Schema;


@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "type", visible = true )
@JsonSubTypes({
    @JsonSubTypes.Type(value = AzureInheritFromDelegateSystemAssignedManagedIdentityConnectorSpec.class, name = "AzureInheritFromDelegateSystemAssignedManagedIdentity" ),
    @JsonSubTypes.Type(value = ArtifactoryEncryptedConnectorSpec.class, name = "ArtifactoryEncrypted" ),
    @JsonSubTypes.Type(value = GitHttpEncryptedConnectorSpec.class, name = "GitHttpEncrypted" ),
    @JsonSubTypes.Type(value = AzureClientSecretKeyConnectorSpec.class, name = "AzureClientSecretKey" ),
    @JsonSubTypes.Type(value = AwsIRSAConnectorSpec.class, name = "AwsIRSA" ),
    @JsonSubTypes.Type(value = AwsKmsAccessKeyConnectorSpec.class, name = "AwsKmsAccessKey" ),
    @JsonSubTypes.Type(value = AwsIAMRoleConnectorSpec.class, name = "AwsIAMRole" ),
    @JsonSubTypes.Type(value = ArtifactoryConnectorSpec.class, name = "Artifactory" ),
    @JsonSubTypes.Type(value = AwsEncryptedAccessKeyConnectorSpec.class, name = "AwsEncryptedAccessKey" ),
    @JsonSubTypes.Type(value = AwsSecretManagerAccessKeyConnectorSpec.class, name = "AwsSecretManagerAccessKey" ),
    @JsonSubTypes.Type(value = AwsSecretManagerAssumeSTSConnectorSpec.class, name = "AwsSecretManagerAssumeSTS" ),
    @JsonSubTypes.Type(value = AwsKmsAssumeIAMConnectorSpec.class, name = "AwsKmsAssumeIAM" ),
    @JsonSubTypes.Type(value = GitSshConnectorSpec.class, name = "GitSsh" ),
    @JsonSubTypes.Type(value = AzureClientCertificateConnectorSpec.class, name = "AzureClientCertificate" ),
    @JsonSubTypes.Type(value = AwsSecretManagerAssumeIAMConnectorSpec.class, name = "AwsSecretManagerAssumeIAM" ),
    @JsonSubTypes.Type(value = AwsAccessKeyConnectorSpec.class, name = "AwsAccessKey" ),
    @JsonSubTypes.Type(value = AzureInheritFromDelegateUserAssignedManagedIdentityConnectorSpec.class, name = "AzureInheritFromDelegateUserAssignedManagedIdentity" ),
    @JsonSubTypes.Type(value = AppdynamicsConnectorSpec.class, name = "Appdynamics" ),
    @JsonSubTypes.Type(value = AwsKmsAssumeSTSConnectorSpec.class, name = "AwsKmsAssumeSTS" ),
    @JsonSubTypes.Type(value = AppdynamicsClientIdConnectorSpec.class, name = "AppdynamicsClientId" ),
    @JsonSubTypes.Type(value = AwsCodeCommitConnectorSpec.class, name = "AwsCodeCommit" ),
    @JsonSubTypes.Type(value = GitHttpConnectorSpec.class, name = "GitHttp" ),
    @JsonSubTypes.Type(value = ArtifactoryAnonymousConnectorSpec.class, name = "ArtifactoryAnonymous" ),
})
@Schema(description = "Details of the connector defined in Harness")

public class ConnectorSpec  implements OneOfConnectorSpec  {

public enum TypeEnum {

    GITHTTP(String.valueOf("GitHttp")), GITHTTPENCRYPTED(String.valueOf("GitHttpEncrypted")), GITSSH(String.valueOf("GitSsh")), APPDYNAMICS(String.valueOf("Appdynamics")), APPDYNAMICSCLIENTID(String.valueOf("AppdynamicsClientId")), ARTIFACTORY(String.valueOf("Artifactory")), ARTIFACTORYENCRYPTED(String.valueOf("ArtifactoryEncrypted")), ARTIFACTORYANONYMOUS(String.valueOf("ArtifactoryAnonymous")), AWSCODECOMMIT(String.valueOf("AwsCodeCommit")), AWSACCESSKEY(String.valueOf("AwsAccessKey")), AWSENCRYPTEDACCESSKEY(String.valueOf("AwsEncryptedAccessKey")), AWSIAMROLE(String.valueOf("AwsIAMRole")), AWSIRSA(String.valueOf("AwsIRSA")), AWSKMSACCESSKEY(String.valueOf("AwsKmsAccessKey")), AWSKMSASSUMEIAM(String.valueOf("AwsKmsAssumeIAM")), AWSKMSASSUMESTS(String.valueOf("AwsKmsAssumeSTS")), AWSSECRETMANAGERACCESSKEY(String.valueOf("AwsSecretManagerAccessKey")), AWSSECRETMANAGERASSUMEIAM(String.valueOf("AwsSecretManagerAssumeIAM")), AWSSECRETMANAGERASSUMESTS(String.valueOf("AwsSecretManagerAssumeSTS")), AZURECLIENTSECRETKEY(String.valueOf("AzureClientSecretKey")), AZURECLIENTCERTIFICATE(String.valueOf("AzureClientCertificate")), AZUREINHERITFROMDELEGATEUSERASSIGNEDMANAGEDIDENTITY(String.valueOf("AzureInheritFromDelegateUserAssignedManagedIdentity")), AZUREINHERITFROMDELEGATESYSTEMASSIGNEDMANAGEDIDENTITY(String.valueOf("AzureInheritFromDelegateSystemAssignedManagedIdentity"));


    private String value;

    TypeEnum (String v) {
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

  /**
   * This specifies the type of connector
   **/
  public ConnectorSpec type(TypeEnum type) {
    this.type = type;
    return this;
  }

  
  @Schema(required = true, description = "This specifies the type of connector")
  @JsonProperty("type")
  @NotNull

  public TypeEnum getType() {
    return type;
  }
  public void setType(TypeEnum type) {
    this.type = type;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConnectorSpec connectorSpec = (ConnectorSpec) o;
    return Objects.equals(type, connectorSpec.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConnectorSpec {\n");
    
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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
