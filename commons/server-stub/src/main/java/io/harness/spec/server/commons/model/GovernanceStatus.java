package io.harness.spec.server.commons.model;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * Governance Status
 **/
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Governance Status
 */
public enum GovernanceStatus {
  WARNING("WARNING"),
    ERROR("ERROR"),
    PASS("PASS");

  private Object value;

  GovernanceStatus(Object value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static GovernanceStatus fromValue(String text) {
    for (GovernanceStatus b : GovernanceStatus.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
