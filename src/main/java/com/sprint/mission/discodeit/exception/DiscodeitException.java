package com.sprint.mission.discodeit.exception;

import java.util.Map;

public class DiscodeitException extends RuntimeException {

  private final Errorcode errorCode;
  private final Map<String, Object> details;

  public DiscodeitException(Errorcode errorCode, Map<String, Object> details) {
    super(errorCode.getMessage());
    this.errorCode = errorCode;
    this.details = details != null ? details : Map.of();
  }

  public Errorcode getErrorCode() {
    return errorCode;
  }

  public Map<String, Object> getDetails() {
    return details;
  }
}
