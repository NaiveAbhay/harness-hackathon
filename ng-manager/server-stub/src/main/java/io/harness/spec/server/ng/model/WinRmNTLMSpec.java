package io.harness.spec.server.ng.model;

import io.harness.spec.server.ng.model.SecretSpec;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * This is the SSH key authentication details defined in Harness.
 **/
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.v3.oas.annotations.media.Schema;



@Schema(description = "This is the SSH key authentication details defined in Harness.")

public class WinRmNTLMSpec extends SecretSpec implements OneOfSecretSpec  {

  private @Valid Integer port = 5986;

  private @Valid String domain = null;

  private @Valid String username = null;

  private @Valid String password = null;

  private @Valid Boolean useSsl = true;

  private @Valid Boolean skipCertChecks = true;

  private @Valid Boolean useNoProfile = null;

  /**
   * WinRm port
   **/
  public WinRmNTLMSpec port(Integer port) {
    this.port = port;
    return this;
  }

  
  @Schema(description = "WinRm port")
  @JsonProperty("port")

  public Integer getPort() {
    return port;
  }
  public void setPort(Integer port) {
    this.port = port;
  }

  /**
   * This is the NTLM domain name
   **/
  public WinRmNTLMSpec domain(String domain) {
    this.domain = domain;
    return this;
  }

  
  @Schema(required = true, description = "This is the NTLM domain name")
  @JsonProperty("domain")
  @NotNull

  public String getDomain() {
    return domain;
  }
  public void setDomain(String domain) {
    this.domain = domain;
  }

  /**
   * This is the NTLM user name
   **/
  public WinRmNTLMSpec username(String username) {
    this.username = username;
    return this;
  }

  
  @Schema(required = true, description = "This is the NTLM user name")
  @JsonProperty("username")
  @NotNull

  public String getUsername() {
    return username;
  }
  public void setUsername(String username) {
    this.username = username;
  }

  /**
   * This is the NTLM password
   **/
  public WinRmNTLMSpec password(String password) {
    this.password = password;
    return this;
  }

  
  @Schema(required = true, description = "This is the NTLM password")
  @JsonProperty("password")
  @NotNull

  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * This is the NTLM either to use SSL/https
   **/
  public WinRmNTLMSpec useSsl(Boolean useSsl) {
    this.useSsl = useSsl;
    return this;
  }

  
  @Schema(description = "This is the NTLM either to use SSL/https")
  @JsonProperty("use_ssl")

  public Boolean isUseSsl() {
    return useSsl;
  }
  public void setUseSsl(Boolean useSsl) {
    this.useSsl = useSsl;
  }

  /**
   * This is the Kerberos either to skip certificate checks
   **/
  public WinRmNTLMSpec skipCertChecks(Boolean skipCertChecks) {
    this.skipCertChecks = skipCertChecks;
    return this;
  }

  
  @Schema(description = "This is the Kerberos either to skip certificate checks")
  @JsonProperty("skip_cert_checks")

  public Boolean isSkipCertChecks() {
    return skipCertChecks;
  }
  public void setSkipCertChecks(Boolean skipCertChecks) {
    this.skipCertChecks = skipCertChecks;
  }

  /**
   * This is the Kerberos powershell runs without loading profile
   **/
  public WinRmNTLMSpec useNoProfile(Boolean useNoProfile) {
    this.useNoProfile = useNoProfile;
    return this;
  }

  
  @Schema(description = "This is the Kerberos powershell runs without loading profile")
  @JsonProperty("use_no_profile")

  public Boolean isUseNoProfile() {
    return useNoProfile;
  }
  public void setUseNoProfile(Boolean useNoProfile) {
    this.useNoProfile = useNoProfile;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WinRmNTLMSpec winRmNTLMSpec = (WinRmNTLMSpec) o;
    return Objects.equals(port, winRmNTLMSpec.port) &&
        Objects.equals(domain, winRmNTLMSpec.domain) &&
        Objects.equals(username, winRmNTLMSpec.username) &&
        Objects.equals(password, winRmNTLMSpec.password) &&
        Objects.equals(useSsl, winRmNTLMSpec.useSsl) &&
        Objects.equals(skipCertChecks, winRmNTLMSpec.skipCertChecks) &&
        Objects.equals(useNoProfile, winRmNTLMSpec.useNoProfile);
  }

  @Override
  public int hashCode() {
    return Objects.hash(port, domain, username, password, useSsl, skipCertChecks, useNoProfile);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WinRmNTLMSpec {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    port: ").append(toIndentedString(port)).append("\n");
    sb.append("    domain: ").append(toIndentedString(domain)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    useSsl: ").append(toIndentedString(useSsl)).append("\n");
    sb.append("    skipCertChecks: ").append(toIndentedString(skipCertChecks)).append("\n");
    sb.append("    useNoProfile: ").append(toIndentedString(useNoProfile)).append("\n");
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
