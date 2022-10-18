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

public class SecretFileSpec extends SecretSpec  {

  private @Valid String secretManagerSlug = null;

  /**
   * Slug of the secret manager used to manage the secret
   **/
  public SecretFileSpec secretManagerSlug(String secretManagerSlug) {
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


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SecretFileSpec secretFileSpec = (SecretFileSpec) o;
    return Objects.equals(secretManagerSlug, secretFileSpec.secretManagerSlug);
  }

  @Override
  public int hashCode() {
    return Objects.hash(secretManagerSlug);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SecretFileSpec {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    secretManagerSlug: ").append(toIndentedString(secretManagerSlug)).append("\n");
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
