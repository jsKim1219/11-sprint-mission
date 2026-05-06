package com.sprint.mission.discodeit.exception.user;

import com.sprint.mission.discodeit.exception.Errorcode;
import java.util.Map;

public class UserAlreadyExistsException extends UserException {

  public UserAlreadyExistsException(String duplicateInfo) {
    super(Errorcode.USER_ALREADY_EXISTS, Map.of("duplicateInfo", duplicateInfo));
  }
}
