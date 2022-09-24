package io.harness.spec.server.ng.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Objects;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Schema(description =
            "This is the SSH key authentication details defined in Harness.")

public class SSHKeyPathSpec extends SecretSpec implements OneOfSecretSpec {

  private @Valid Integer port = null;

  private @Valid String username = null;

  private @Valid String keyPath = null;

  private @Valid String encryptedPassphrase = null;

  /**
   * SSH port
   **/
  public SSHKeyPathSpec port(Integer port) {
    this.port = port;
    return this;
  }

  @Schema(description = "SSH port")
  @JsonProperty("port")

  public Integer getPort() {
    return port;
  }
  public void setPort(Integer port) { this.port = port; }

  /**
   * SSH username
   **/
  public SSHKeyPathSpec username(String username) {
    this.username = username;
    return this;
  }

  @Schema(required = true, description = "SSH username")
  @JsonProperty("username")
  @NotNull

  public String getUsername() {
    return username;
  }
  public void setUsername(String username) { this.username = username; }

  /**
   * Path of the key file
   **/
  public SSHKeyPathSpec keyPath(String keyPath) {
    this.keyPath = keyPath;
    return this;
  }

  @Schema(required = true, description = "Path of the key file")
  @JsonProperty("key_path")
  @NotNull

  public String getKeyPath() {
    return keyPath;
  }
  public void setKeyPath(String keyPath) { this.keyPath = keyPath; }

  /**
   * This is the passphrase provided while creating the SSH key for local
   *encryption
   **/
  public SSHKeyPathSpec encryptedPassphrase(String encryptedPassphrase) {
    this.encryptedPassphrase = encryptedPassphrase;
    return this;
  }

  @Schema(
      description =
          "This is the passphrase provided while creating the SSH key for local encryption")
  @JsonProperty("encrypted_passphrase")

  public String
  getEncryptedPassphrase() {
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
    SSHKeyPathSpec ssHKeyPathSpec = (SSHKeyPathSpec)o;
    return Objects.equals(port, ssHKeyPathSpec.port) &&
        Objects.equals(username, ssHKeyPathSpec.username) &&
        Objects.equals(keyPath, ssHKeyPathSpec.keyPath) &&
        Objects.equals(encryptedPassphrase, ssHKeyPathSpec.encryptedPassphrase);
  }

  @Override
  public int hashCode() {
    return Objects.hash(port, username, keyPath, encryptedPassphrase);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SSHKeyPathSpec {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    port: ").append(toIndentedString(port)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    keyPath: ").append(toIndentedString(keyPath)).append("\n");
    sb.append("    encryptedPassphrase: ")
        .append(toIndentedString(encryptedPassphrase))
        .append("\n");
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
