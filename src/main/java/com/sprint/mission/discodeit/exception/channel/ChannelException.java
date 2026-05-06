package com.sprint.mission.discodeit.exception.channel;

import com.sprint.mission.discodeit.exception.DiscodeitException;
import com.sprint.mission.discodeit.exception.Errorcode;
import java.util.Map;

public class ChannelException extends DiscodeitException {

  public ChannelException(Errorcode errorCode,
      Map<String, Object> details) {
    super(errorCode, details);
  }
}
