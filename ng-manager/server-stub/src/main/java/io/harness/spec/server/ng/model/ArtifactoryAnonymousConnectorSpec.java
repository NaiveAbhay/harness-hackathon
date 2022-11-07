/*
* Copyright 2022 Harness Inc. All rights reserved.
* Use of this source code is governed by the PolyForm Free Trial 1.0.0 license
* that can be found in the licenses directory at the root of this repository, also available at
* https://polyformproject.org/wp-content/uploads/2020/05/PolyForm-Free-Trial-1.0.0.txt.
*/

package io.harness.spec.server.ng.model;

import io.harness.spec.server.ng.model.ConnectorSpec;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
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
* This contains details of the artifactory connector with anonymous user
**/


@Schema(description = "This contains details of the artifactory connector with anonymous user")

public class ArtifactoryAnonymousConnectorSpec extends ConnectorSpec  {

  private @Valid String url = null;

  private @Valid List<String> delegateSelectors = new ArrayList<>();

  private @Valid Boolean executeOnDelegate = null;

  /**
   * artifactory repo url
   **/
  public ArtifactoryAnonymousConnectorSpec url(String url) {
    this.url = url;
    return this;
  }

  
  @Schema(required = true, description = "artifactory repo url")
  @JsonProperty("url")
  @NotNull

  public String getUrl() {
    return url;
  }
  public void setUrl(String url) {
    this.url = url;
  }

  /**
   * List of unique delegate selectors
   **/
  public ArtifactoryAnonymousConnectorSpec delegateSelectors(List<String> delegateSelectors) {
    this.delegateSelectors = delegateSelectors;
    return this;
  }

  
  @Schema(description = "List of unique delegate selectors")
  @JsonProperty("delegate_selectors")

  public List<String> getDelegateSelectors() {
    return delegateSelectors;
  }
  public void setDelegateSelectors(List<String> delegateSelectors) {
    this.delegateSelectors = delegateSelectors;
  }

  /**
   * execute on delegate
   **/
  public ArtifactoryAnonymousConnectorSpec executeOnDelegate(Boolean executeOnDelegate) {
    this.executeOnDelegate = executeOnDelegate;
    return this;
  }

  
  @Schema(description = "execute on delegate")
  @JsonProperty("execute_on_delegate")

  public Boolean isExecuteOnDelegate() {
    return executeOnDelegate;
  }
  public void setExecuteOnDelegate(Boolean executeOnDelegate) {
    this.executeOnDelegate = executeOnDelegate;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ArtifactoryAnonymousConnectorSpec artifactoryAnonymousConnectorSpec = (ArtifactoryAnonymousConnectorSpec) o;
    return Objects.equals(url, artifactoryAnonymousConnectorSpec.url) &&
        Objects.equals(delegateSelectors, artifactoryAnonymousConnectorSpec.delegateSelectors) &&
        Objects.equals(executeOnDelegate, artifactoryAnonymousConnectorSpec.executeOnDelegate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(url, delegateSelectors, executeOnDelegate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ArtifactoryAnonymousConnectorSpec {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    delegateSelectors: ").append(toIndentedString(delegateSelectors)).append("\n");
    sb.append("    executeOnDelegate: ").append(toIndentedString(executeOnDelegate)).append("\n");
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
