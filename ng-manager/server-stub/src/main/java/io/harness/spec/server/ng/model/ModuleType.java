package io.harness.spec.server.ng.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Type of Modules
 */
public enum ModuleType {
  CD("CD"),
    CI("CI"),
    CV("CV"),
    CF("CF"),
    CE("CE"),
    STO("STO"),
    CORE("CORE"),
    PMS("PMS"),
    TEMPLATESERVICE("TEMPLATESERVICE"),
    GOVERNANCE("GOVERNANCE");

  private String value;

  ModuleType(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static ModuleType fromValue(String text) {
    for (ModuleType b : ModuleType.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
