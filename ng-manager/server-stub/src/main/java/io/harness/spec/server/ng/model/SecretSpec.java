package io.harness.spec.server.ng.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;


@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type", visible = true )
@JsonSubTypes({
    @JsonSubTypes.Type(value = SSHPasswordSpec.class, name = "SSHPassword" ),
    @JsonSubTypes.Type(value = SecretFileSpec.class, name = "SecretFile" ),
    @JsonSubTypes.Type(value = WinRmTGTKeyTabFileSpec.class, name = "WinRmTGTKeyTabFile" ),
    @JsonSubTypes.Type(value = SSHKerberosTGTPasswordSpec.class, name = "SSHKerberosTGTPassword" ),
    @JsonSubTypes.Type(value = SSHKeyPathSpec.class, name = "SSHKeyPath" ),
    @JsonSubTypes.Type(value = WinRmTGTPasswordSpec.class, name = "WinRmTGTPassword" ),
    @JsonSubTypes.Type(value = SecretTextSpec.class, name = "SecretText" ),
    @JsonSubTypes.Type(value = SSHKeyReferenceSpec.class, name = "SSHKeyReference" ),
    @JsonSubTypes.Type(value = WinRmNTLMSpec.class, name = "WinRmNTLM" ),
    @JsonSubTypes.Type(value = SSHKerberosTGTKeyTabFileSpec.class, name = "SSHKerberosTGTKeyTabFile" ),
})
@Schema(description = "Details of the secret defined in Harness")

public class SecretSpec  implements OneOfSecretSpec  {

public enum TypeEnum {

    SSHKEYPATH(String.valueOf("SSHKeyPath")), SSHKEYREFERENCE(String.valueOf("SSHKeyReference")), SSHPASSWORD(String.valueOf("SSHPassword")), SSHKERBEROSTGTKEYTABFILE(String.valueOf("SSHKerberosTGTKeyTabFile")), SSHKERBEROSTGTPASSWORD(String.valueOf("SSHKerberosTGTPassword")), SECRETFILE(String.valueOf("SecretFile")), SECRETTEXT(String.valueOf("SecretText")), WINRMTGTKEYTABFILE(String.valueOf("WinRmTGTKeyTabFile")), WINRMTGTPASSWORD(String.valueOf("WinRmTGTPassword")), WINRMNTLM(String.valueOf("WinRmNTLM"));


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
   * This specifies the type of secret
   **/
  public SecretSpec type(TypeEnum type) {
    this.type = type;
    return this;
  }

  
  @Schema(required = true, description = "This specifies the type of secret")
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
    SecretSpec secretSpec = (SecretSpec) o;
    return Objects.equals(type, secretSpec.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SecretSpec {\n");
    
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
