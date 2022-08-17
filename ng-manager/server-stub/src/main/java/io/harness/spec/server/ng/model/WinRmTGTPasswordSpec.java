package io.harness.spec.server.ng.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.Valid;
import java.util.Objects;



@Schema(description = "This is the SSH key authentication details defined in Harness.")

public class WinRmTGTPasswordSpec extends SecretSpec implements OneOfSecretSpec  {

  private @Valid Integer port = 5986;

  private @Valid String principal = null;

  private @Valid String realm = null;

  private @Valid String password = null;

  private @Valid Boolean useSsl = true;

  private @Valid Boolean skipCertChecks = true;

  private @Valid Boolean useNoProfile = null;

  /**
   * WinRm port
   **/
  public WinRmTGTPasswordSpec port(Integer port) {
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
   * Kerberos principal
   **/
  public WinRmTGTPasswordSpec principal(String principal) {
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
  public WinRmTGTPasswordSpec realm(String realm) {
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
  public WinRmTGTPasswordSpec password(String password) {
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

  /**
   * This is the Kerberos either to use SSL/https
   **/
  public WinRmTGTPasswordSpec useSsl(Boolean useSsl) {
    this.useSsl = useSsl;
    return this;
  }

  
  @Schema(description = "This is the Kerberos either to use SSL/https")
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
  public WinRmTGTPasswordSpec skipCertChecks(Boolean skipCertChecks) {
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
  public WinRmTGTPasswordSpec useNoProfile(Boolean useNoProfile) {
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
    WinRmTGTPasswordSpec winRmTGTPasswordSpec = (WinRmTGTPasswordSpec) o;
    return Objects.equals(port, winRmTGTPasswordSpec.port) &&
        Objects.equals(principal, winRmTGTPasswordSpec.principal) &&
        Objects.equals(realm, winRmTGTPasswordSpec.realm) &&
        Objects.equals(password, winRmTGTPasswordSpec.password) &&
        Objects.equals(useSsl, winRmTGTPasswordSpec.useSsl) &&
        Objects.equals(skipCertChecks, winRmTGTPasswordSpec.skipCertChecks) &&
        Objects.equals(useNoProfile, winRmTGTPasswordSpec.useNoProfile);
  }

  @Override
  public int hashCode() {
    return Objects.hash(port, principal, realm, password, useSsl, skipCertChecks, useNoProfile);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WinRmTGTPasswordSpec {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    port: ").append(toIndentedString(port)).append("\n");
    sb.append("    principal: ").append(toIndentedString(principal)).append("\n");
    sb.append("    realm: ").append(toIndentedString(realm)).append("\n");
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
