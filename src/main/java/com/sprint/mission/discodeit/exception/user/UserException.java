package com.sprint.mission.discodeit.exception.user;

import com.sprint.mission.discodeit.exception.DiscodeitException;
import com.sprint.mission.discodeit.exception.Errorcode;
import java.util.Map;

public class UserException extends DiscodeitException {

  public UserException(Errorcode errorCode,
      Map<String, Object> details) {
    super(errorCode, details);
  }
}
