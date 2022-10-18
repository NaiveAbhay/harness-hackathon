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
* This contains details of the AWS code commit connector
**/


@Schema(description = "This contains details of the AWS code commit connector")

public class AwsCodeCommitConnectorSpec extends ConnectorSpec  {

  private @Valid String url = null;

public enum UrlTypeEnum {

    REPO(String.valueOf("Repo")), REGION(String.valueOf("Region"));


    private String value;

    UrlTypeEnum (String v) {
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
    public static UrlTypeEnum fromValue(String v) {
        for (UrlTypeEnum b : UrlTypeEnum.values()) {
            if (String.valueOf(b.value).equals(v)) {
                return b;
            }
        }
        return null;
    }
}
  private @Valid UrlTypeEnum urlType = null;

  private @Valid String accessKey = null;

  private @Valid String accessKeyRef = null;

  private @Valid String secretKeyRef = null;

  private @Valid List<String> delegateSelectors = new ArrayList<>();

  /**
   * AWS codecommit repository url
   **/
  public AwsCodeCommitConnectorSpec url(String url) {
    this.url = url;
    return this;
  }

  
  @Schema(required = true, description = "AWS codecommit repository url")
  @JsonProperty("url")
  @NotNull

  public String getUrl() {
    return url;
  }
  public void setUrl(String url) {
    this.url = url;
  }

  /**
   * AWS codecommit repository url type
   **/
  public AwsCodeCommitConnectorSpec urlType(UrlTypeEnum urlType) {
    this.urlType = urlType;
    return this;
  }

  
  @Schema(required = true, description = "AWS codecommit repository url type")
  @JsonProperty("url_type")
  @NotNull

  public UrlTypeEnum getUrlType() {
    return urlType;
  }
  public void setUrlType(UrlTypeEnum urlType) {
    this.urlType = urlType;
  }

  /**
   * AWS access key
   **/
  public AwsCodeCommitConnectorSpec accessKey(String accessKey) {
    this.accessKey = accessKey;
    return this;
  }

  
  @Schema(description = "AWS access key")
  @JsonProperty("access_key")

  public String getAccessKey() {
    return accessKey;
  }
  public void setAccessKey(String accessKey) {
    this.accessKey = accessKey;
  }

  /**
   * Reference to encrypted Harness secret for AWS access key
   **/
  public AwsCodeCommitConnectorSpec accessKeyRef(String accessKeyRef) {
    this.accessKeyRef = accessKeyRef;
    return this;
  }

  
  @Schema(description = "Reference to encrypted Harness secret for AWS access key")
  @JsonProperty("access_key_ref")

  public String getAccessKeyRef() {
    return accessKeyRef;
  }
  public void setAccessKeyRef(String accessKeyRef) {
    this.accessKeyRef = accessKeyRef;
  }

  /**
   * Reference to encrypted Harness secret for AWS secret key
   **/
  public AwsCodeCommitConnectorSpec secretKeyRef(String secretKeyRef) {
    this.secretKeyRef = secretKeyRef;
    return this;
  }

  
  @Schema(required = true, description = "Reference to encrypted Harness secret for AWS secret key")
  @JsonProperty("secret_key_ref")
  @NotNull

  public String getSecretKeyRef() {
    return secretKeyRef;
  }
  public void setSecretKeyRef(String secretKeyRef) {
    this.secretKeyRef = secretKeyRef;
  }

  /**
   * List of unique delegate selectors
   **/
  public AwsCodeCommitConnectorSpec delegateSelectors(List<String> delegateSelectors) {
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


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AwsCodeCommitConnectorSpec awsCodeCommitConnectorSpec = (AwsCodeCommitConnectorSpec) o;
    return Objects.equals(url, awsCodeCommitConnectorSpec.url) &&
        Objects.equals(urlType, awsCodeCommitConnectorSpec.urlType) &&
        Objects.equals(accessKey, awsCodeCommitConnectorSpec.accessKey) &&
        Objects.equals(accessKeyRef, awsCodeCommitConnectorSpec.accessKeyRef) &&
        Objects.equals(secretKeyRef, awsCodeCommitConnectorSpec.secretKeyRef) &&
        Objects.equals(delegateSelectors, awsCodeCommitConnectorSpec.delegateSelectors);
  }

  @Override
  public int hashCode() {
    return Objects.hash(url, urlType, accessKey, accessKeyRef, secretKeyRef, delegateSelectors);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AwsCodeCommitConnectorSpec {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    urlType: ").append(toIndentedString(urlType)).append("\n");
    sb.append("    accessKey: ").append(toIndentedString(accessKey)).append("\n");
    sb.append("    accessKeyRef: ").append(toIndentedString(accessKeyRef)).append("\n");
    sb.append("    secretKeyRef: ").append(toIndentedString(secretKeyRef)).append("\n");
    sb.append("    delegateSelectors: ").append(toIndentedString(delegateSelectors)).append("\n");
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
