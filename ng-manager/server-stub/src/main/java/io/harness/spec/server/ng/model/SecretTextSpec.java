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

public class SecretTextSpec extends SecretSpec implements OneOfSecretSpec  {

  private @Valid String secretManagerSlug = null;

public enum ValueTypeEnum {

    INLINE(String.valueOf("Inline")), REFERENCE(String.valueOf("Reference"));


    private String value;

    ValueTypeEnum (String v) {
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
    public static ValueTypeEnum fromValue(String v) {
        for (ValueTypeEnum b : ValueTypeEnum.values()) {
            if (String.valueOf(b.value).equals(v)) {
                return b;
            }
        }
        return null;
    }
}
  private @Valid ValueTypeEnum valueType = null;

  private @Valid String value = null;

  /**
   * Slug of the secret manager used to manage the secret
   **/
  public SecretTextSpec secretManagerSlug(String secretManagerSlug) {
    this.secretManagerSlug = secretManagerSlug;
    return this;
  }

  
  @Schema(required = true, description = "Slug of the secret manager used to manage the secret")
  @JsonProperty("secret_manager_slug")
  @NotNull

  public String getSecretManagerSlug() {
    return secretManagerSlug;
  }
  public void setSecretManagerSlug(String secretManagerSlug) {
    this.secretManagerSlug = secretManagerSlug;
  }

  /**
   * This has details to specify if the secret value is inline or referenced
   **/
  public SecretTextSpec valueType(ValueTypeEnum valueType) {
    this.valueType = valueType;
    return this;
  }

  
  @Schema(required = true, description = "This has details to specify if the secret value is inline or referenced")
  @JsonProperty("value_type")
  @NotNull

  public ValueTypeEnum getValueType() {
    return valueType;
  }
  public void setValueType(ValueTypeEnum valueType) {
    this.valueType = valueType;
  }

  /**
   * Value of the Secret
   **/
  public SecretTextSpec value(String value) {
    this.value = value;
    return this;
  }

  
  @Schema(description = "Value of the Secret")
  @JsonProperty("value")

  public String getValue() {
    return value;
  }
  public void setValue(String value) {
    this.value = value;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SecretTextSpec secretTextSpec = (SecretTextSpec) o;
    return Objects.equals(secretManagerSlug, secretTextSpec.secretManagerSlug) &&
        Objects.equals(valueType, secretTextSpec.valueType) &&
        Objects.equals(value, secretTextSpec.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(secretManagerSlug, valueType, value);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SecretTextSpec {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    secretManagerSlug: ").append(toIndentedString(secretManagerSlug)).append("\n");
    sb.append("    valueType: ").append(toIndentedString(valueType)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
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
