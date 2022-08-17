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

public class SSHPasswordSpec extends SecretSpec implements OneOfSecretSpec  {

  private @Valid Integer port = null;

  private @Valid String username = null;

  private @Valid String password = null;

  /**
   * SSH port
   **/
  public SSHPasswordSpec port(Integer port) {
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
  public SSHPasswordSpec username(String username) {
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
   * SSH password
   **/
  public SSHPasswordSpec password(String password) {
    this.password = password;
    return this;
  }

  
  @Schema(required = true, description = "SSH password")
  @JsonProperty("password")
  @NotNull

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
    SSHPasswordSpec ssHPasswordSpec = (SSHPasswordSpec) o;
    return Objects.equals(port, ssHPasswordSpec.port) &&
        Objects.equals(username, ssHPasswordSpec.username) &&
        Objects.equals(password, ssHPasswordSpec.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(port, username, password);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SSHPasswordSpec {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    port: ").append(toIndentedString(port)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
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
