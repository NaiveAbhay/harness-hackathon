package io.harness.spec.server.accesscontrol.model;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * Role assignment principal
 **/
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.v3.oas.annotations.media.Schema;



@Schema(description = "Role assignment principal")

public class Principal   {

  private @Valid String scopeLevel = null;

  private @Valid String slug = null;

public enum TypeEnum {

    USER(String.valueOf("USER")), USER_GROUP(String.valueOf("USER_GROUP")), SERVICE(String.valueOf("SERVICE")), API_KEY(String.valueOf("API_KEY")), SERVICE_ACCOUNT(String.valueOf("SERVICE_ACCOUNT"));


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
   * Role assignment principal scope level
   **/
  public Principal scopeLevel(String scopeLevel) {
    this.scopeLevel = scopeLevel;
    return this;
  }

  
  @Schema(description = "Role assignment principal scope level")
  @JsonProperty("scope_level")

  public String getScopeLevel() {
    return scopeLevel;
  }
  public void setScopeLevel(String scopeLevel) {
    this.scopeLevel = scopeLevel;
  }

  /**
   * Role assignment principal slug
   **/
  public Principal slug(String slug) {
    this.slug = slug;
    return this;
  }

  
  @Schema(required = true, description = "Role assignment principal slug")
  @JsonProperty("slug")
  @NotNull

  public String getSlug() {
    return slug;
  }
  public void setSlug(String slug) {
    this.slug = slug;
  }

  /**
   * Role assignment principal type
   **/
  public Principal type(TypeEnum type) {
    this.type = type;
    return this;
  }

  
  @Schema(required = true, description = "Role assignment principal type")
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
    Principal principal = (Principal) o;
    return Objects.equals(scopeLevel, principal.scopeLevel) &&
        Objects.equals(slug, principal.slug) &&
        Objects.equals(type, principal.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(scopeLevel, slug, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Principal {\n");
    
    sb.append("    scopeLevel: ").append(toIndentedString(scopeLevel)).append("\n");
    sb.append("    slug: ").append(toIndentedString(slug)).append("\n");
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
