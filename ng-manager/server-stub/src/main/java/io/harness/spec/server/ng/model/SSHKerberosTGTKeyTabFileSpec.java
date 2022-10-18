/*
* Copyright 2022 Harness Inc. All rights reserved.
* Use of this source code is governed by the PolyForm Free Trial 1.0.0 license
* that can be found in the licenses directory at the root of this repository, also available at
* https://polyformproject.org/wp-content/uploads/2020/05/PolyForm-Free-Trial-1.0.0.txt.
*/

package io.harness.spec.server.ng.model;

import io.harness.spec.server.ng.model.SecretSpec;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.Valid;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.v3.oas.annotations.media.Schema;
/**
* This is the SSH key authentication details defined in Harness.
**/


@Schema(description = "This is the SSH key authentication details defined in Harness.")

public class SSHKerberosTGTKeyTabFileSpec extends SecretSpec implements OneOfSecretSpec  {

  private @Valid Integer port = null;

  private @Valid String principal = null;

  private @Valid String realm = null;

  private @Valid String keyPath = null;

  /**
   * SSH port
   **/
  public SSHKerberosTGTKeyTabFileSpec port(Integer port) {
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
  public SSHKerberosTGTKeyTabFileSpec principal(String principal) {
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
  public SSHKerberosTGTKeyTabFileSpec realm(String realm) {
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
   * Kerberos keytab file path
   **/
  public SSHKerberosTGTKeyTabFileSpec keyPath(String keyPath) {
    this.keyPath = keyPath;
    return this;
  }

  
  @Schema(description = "Kerberos keytab file path")
  @JsonProperty("key_path")

  public String getKeyPath() {
    return keyPath;
  }
  public void setKeyPath(String keyPath) {
    this.keyPath = keyPath;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SSHKerberosTGTKeyTabFileSpec ssHKerberosTGTKeyTabFileSpec = (SSHKerberosTGTKeyTabFileSpec) o;
    return Objects.equals(port, ssHKerberosTGTKeyTabFileSpec.port) &&
        Objects.equals(principal, ssHKerberosTGTKeyTabFileSpec.principal) &&
        Objects.equals(realm, ssHKerberosTGTKeyTabFileSpec.realm) &&
        Objects.equals(keyPath, ssHKerberosTGTKeyTabFileSpec.keyPath);
  }

  @Override
  public int hashCode() {
    return Objects.hash(port, principal, realm, keyPath);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SSHKerberosTGTKeyTabFileSpec {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    port: ").append(toIndentedString(port)).append("\n");
    sb.append("    principal: ").append(toIndentedString(principal)).append("\n");
    sb.append("    realm: ").append(toIndentedString(realm)).append("\n");
    sb.append("    keyPath: ").append(toIndentedString(keyPath)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
