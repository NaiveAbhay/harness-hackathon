package io.harness.spec.server.ng.model;

import io.harness.spec.server.ng.model.SecretSpec;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * This is the SSH key authentication details defined in Harness.
 **/
import io.swagger.annotations.*;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.v3.oas.annotations.media.Schema;



@Schema(description = "This is the SSH key authentication details defined in Harness.")

public class SSHKeyReferenceSpec extends SecretSpec implements OneOfSecretSpec  {

  private @Valid Integer port = null;

  private @Valid String username = null;

  private @Valid String key = null;

  private @Valid String encryptedPassphrase = null;

  /**
   * SSH port
   **/
  public SSHKeyReferenceSpec port(Integer port) {
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
   * SSH username
   **/
  public SSHKeyReferenceSpec username(String username) {
    this.username = username;
    return this;
  }

  
  @Schema(required = true, description = "SSH username")
  @JsonProperty("username")
  @NotNull

  public String getUsername() {
    return username;
  }
  public void setUsername(String username) {
    this.username = username;
  }

  /**
   * SSH key
   **/
  public SSHKeyReferenceSpec key(String key) {
    this.key = key;
    return this;
  }

  
  @Schema(description = "SSH key")
  @JsonProperty("key")

  public String getKey() {
    return key;
  }
  public void setKey(String key) {
    this.key = key;
  }

  /**
   * This is the passphrase provided while creating the SSH key for local encryption
   **/
  public SSHKeyReferenceSpec encryptedPassphrase(String encryptedPassphrase) {
    this.encryptedPassphrase = encryptedPassphrase;
    return this;
  }

  
  @Schema(description = "This is the passphrase provided while creating the SSH key for local encryption")
  @JsonProperty("encrypted_passphrase")

  public String getEncryptedPassphrase() {
    return encryptedPassphrase;
  }
  public void setEncryptedPassphrase(String encryptedPassphrase) {
    this.encryptedPassphrase = encryptedPassphrase;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SSHKeyReferenceSpec ssHKeyReferenceSpec = (SSHKeyReferenceSpec) o;
    return Objects.equals(port, ssHKeyReferenceSpec.port) &&
        Objects.equals(username, ssHKeyReferenceSpec.username) &&
        Objects.equals(key, ssHKeyReferenceSpec.key) &&
        Objects.equals(encryptedPassphrase, ssHKeyReferenceSpec.encryptedPassphrase);
  }

  @Override
  public int hashCode() {
    return Objects.hash(port, username, key, encryptedPassphrase);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SSHKeyReferenceSpec {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    port: ").append(toIndentedString(port)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    key: ").append(toIndentedString(key)).append("\n");
    sb.append("    encryptedPassphrase: ").append(toIndentedString(encryptedPassphrase)).append("\n");
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
