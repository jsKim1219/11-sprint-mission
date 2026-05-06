package com.sprint.mission.discodeit.exception.user;

import com.sprint.mission.discodeit.exception.Errorcode;
import java.util.Map;
import java.util.UUID;

public class UserNotFoundException extends UserException {

  public UserNotFoundException(UUID userId) {
    super(Errorcode.USER_NOT_FOUND, Map.of("userId", userId));
  }

}
