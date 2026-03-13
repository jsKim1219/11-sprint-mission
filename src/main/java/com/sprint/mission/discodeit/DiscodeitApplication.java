package com.sprint.mission.discodeit;

import com.sprint.mission.discodeit.entity.Channel;
import com.sprint.mission.discodeit.entity.ChannelType;
import com.sprint.mission.discodeit.entity.Message;
import com.sprint.mission.discodeit.entity.User;
import com.sprint.mission.discodeit.service.ChannelService;
import com.sprint.mission.discodeit.service.MessageService;
import com.sprint.mission.discodeit.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DiscodeitApplication {

	static User setupUser(UserService userService) {
		User user = userService.create("woody", "woody@codeit.com", "woody1234");
		return user;
	}

	static Channel setupChannel(ChannelService channelService) {
		Channel channel = channelService.create(ChannelType.PUBLIC, "공지", "공지 채널입니다.");
		return channel;
	}

	static void messageCreateTest(MessageService messageService, Channel channel, User user) {
		Message message = messageService.create("안녕하세요.", user.getId(), channel.getId());
		System.out.println("메시지 생성 완료: " + message.getId());
	}

	public static void main(String[] args) {
		SpringApplication.run(DiscodeitApplication.class, args);
	}
}
