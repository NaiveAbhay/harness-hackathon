package io.harness.spec.server.ng.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.Valid;
import java.util.Objects;



@Schema(description = "This is the SSH key authentication details defined in Harness.")

public class SSHKerberosTGTPasswordSpec extends SecretSpec implements OneOfSecretSpec  {

  private @Valid Integer port = null;

  private @Valid String principal = null;

  private @Valid String realm = null;

  private @Valid String password = null;

  /**
   * SSH port
   **/
  public SSHKerberosTGTPasswordSpec port(Integer port) {
    this.port = port;
    return this;
  }

  
  @Schema(description = "SSH port")
  @JsonProperty("port")

  public Integer getPort() {
    return port;
  }
  public void setPort(Integer port) {
    this.port = port;
  }

  /**
   * Kerberos principal
   **/
  public SSHKerberosTGTPasswordSpec principal(String principal) {
    this.principal = principal;
    return this;
  }

  
  @Schema(description = "Kerberos principal")
  @JsonProperty("principal")

  public String getPrincipal() {
    return principal;
  }
  public void setPrincipal(String principal) {
    this.principal = principal;
  }

  /**
   * Kerberos realm
   **/
  public SSHKerberosTGTPasswordSpec realm(String realm) {
    this.realm = realm;
    return this;
  }

  
  @Schema(description = "Kerberos realm")
  @JsonProperty("realm")

  public String getRealm() {
    return realm;
  }
  public void setRealm(String realm) {
    this.realm = realm;
  }

  /**
   * Kerberos password
   **/
  public SSHKerberosTGTPasswordSpec password(String password) {
    this.password = password;
    return this;
  }

  
  @Schema(description = "Kerberos password")
  @JsonProperty("password")

  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SSHKerberosTGTPasswordSpec ssHKerberosTGTPasswordSpec = (SSHKerberosTGTPasswordSpec) o;
    return Objects.equals(port, ssHKerberosTGTPasswordSpec.port) &&
        Objects.equals(principal, ssHKerberosTGTPasswordSpec.principal) &&
        Objects.equals(realm, ssHKerberosTGTPasswordSpec.realm) &&
        Objects.equals(password, ssHKerberosTGTPasswordSpec.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(port, principal, realm, password);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SSHKerberosTGTPasswordSpec {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    port: ").append(toIndentedString(port)).append("\n");
    sb.append("    principal: ").append(toIndentedString(principal)).append("\n");
    sb.append("    realm: ").append(toIndentedString(realm)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
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
