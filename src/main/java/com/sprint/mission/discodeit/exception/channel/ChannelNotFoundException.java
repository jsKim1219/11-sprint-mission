package com.sprint.mission.discodeit.exception.channel;

import com.sprint.mission.discodeit.exception.Errorcode;
import java.util.Map;
import java.util.UUID;

public class ChannelNotFoundException extends ChannelException {

  public ChannelNotFoundException(UUID channelId) {
    super(Errorcode.CHANNEL_NOT_FOUND, Map.of("channelId", channelId));
  }
}
