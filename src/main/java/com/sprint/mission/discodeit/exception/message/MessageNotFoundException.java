package com.sprint.mission.discodeit.exception.message;

import com.sprint.mission.discodeit.exception.Errorcode;
import java.util.Map;
import java.util.UUID;

public class MessageNotFoundException extends MessageException {

  public MessageNotFoundException(UUID messageId) {
    super(Errorcode.MESSAGE_NOT_FOUND, Map.of("messageId", messageId));
  }
}
