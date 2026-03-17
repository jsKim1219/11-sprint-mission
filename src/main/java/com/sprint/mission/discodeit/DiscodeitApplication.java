package com.sprint.mission.discodeit;

import com.sprint.mission.discodeit.dto.ChannelDto;
import com.sprint.mission.discodeit.dto.PublicChannelCreateRequest;
import com.sprint.mission.discodeit.dto.UserCreateRequest;
import com.sprint.mission.discodeit.dto.UserDto;
import com.sprint.mission.discodeit.entity.Message;
import com.sprint.mission.discodeit.service.ChannelService;
import com.sprint.mission.discodeit.service.MessageService;
import com.sprint.mission.discodeit.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DiscodeitApplication {

	static UserDto setupUser(UserService userService) {
		UserCreateRequest request = new UserCreateRequest("woody", "woody@codeit.com", "woody1234", null);
		return userService.create(request);
	}

	static ChannelDto setupChannel(ChannelService channelService) {
		PublicChannelCreateRequest request = new PublicChannelCreateRequest("공지", "공지 채널입니다.");
		return channelService.createPublic(request);
	}

	static void messageCreateTest(MessageService messageService, ChannelDto channel, UserDto user) {
		Message message = messageService.create("안녕하세요.", user.id(), channel.id());
		System.out.println("메시지 생성 완료: " + message.getId());
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext context =
				SpringApplication.run(DiscodeitApplication.class, args);

		UserService userService = context.getBean(UserService.class);
		ChannelService channelService = context.getBean(ChannelService.class);
		MessageService messageService = context.getBean(MessageService.class);

		UserDto user = setupUser(userService);
		ChannelDto channel = setupChannel(channelService);
		messageCreateTest(messageService, channel, user);
	}
}