package com.sprint.mission.discodeit.exception.channel;

import com.sprint.mission.discodeit.exception.Errorcode;
import java.util.Map;
import java.util.UUID;

public class PrivateChannelUpdateDeniedException extends ChannelException {

  public PrivateChannelUpdateDeniedException(UUID channelId) {
    super(Errorcode.PRIVATE_CHANNEL_UPDATE_DENIED, Map.of("channelId", channelId));
  }
}
