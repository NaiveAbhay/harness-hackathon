package io.harness.spec.server.ng.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Schema(description = "Organization model")

public class Organization {

  private @Valid String slug = null;

  private @Valid String name = null;

  private @Valid String description = null;

  private @Valid Map<String, String> tags = new HashMap<>();

  /**
   * Organization slug
   **/
  public Organization slug(String slug) {
    this.slug = slug;
    return this;
  }

  @Schema(required = true, description = "Organization slug")
  @JsonProperty("slug")
  @NotNull
  @Pattern(regexp = "^[a-zA-Z_][0-9a-zA-Z_$]{0,63}$")
  @Size(min = 1, max = 64)
  public String getSlug() {
    return slug;
  }
  public void setSlug(String slug) { this.slug = slug; }

  /**
   * Organization name
   **/
  public Organization name(String name) {
    this.name = name;
    return this;
  }

  @Schema(required = true, description = "Organization name")
  @JsonProperty("name")
  @NotNull
  @Pattern(regexp = "^[a-zA-Z_][0-9a-zA-Z-_ ]{0,63}$")
  @Size(min = 1, max = 64)
  public String getName() {
    return name;
  }
  public void setName(String name) { this.name = name; }

  /**
   * Organization description
   **/
  public Organization description(String description) {
    this.description = description;
    return this;
  }

  @Schema(description = "Organization description")
  @JsonProperty("description")
  @Size(max = 1024)
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * Organization tags
   **/
  public Organization tags(Map<String, String> tags) {
    this.tags = tags;
    return this;
  }

  @Schema(description = "Organization tags")
  @JsonProperty("tags")
  @Size(max = 128)
  public Map<String, String> getTags() {
    return tags;
  }
  public void setTags(Map<String, String> tags) { this.tags = tags; }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Organization organization = (Organization)o;
    return Objects.equals(slug, organization.slug) &&
        Objects.equals(name, organization.name) &&
        Objects.equals(description, organization.description) &&
        Objects.equals(tags, organization.tags);
  }

  @Override
  public int hashCode() {
    return Objects.hash(slug, name, description, tags);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Organization {\n");

    sb.append("    slug: ").append(toIndentedString(slug)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ")
        .append(toIndentedString(description))
        .append("\n");
    sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
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
