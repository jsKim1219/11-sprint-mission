package com.sprint.mission.discodeit;

import com.sprint.mission.discodeit.entity.Channel;
import com.sprint.mission.discodeit.entity.ChannelType;
import com.sprint.mission.discodeit.entity.Message;
import com.sprint.mission.discodeit.entity.User;
import com.sprint.mission.discodeit.repository.UserRepository;
import com.sprint.mission.discodeit.repository.jcf.JCFChannelRepository;
import com.sprint.mission.discodeit.repository.jcf.JCFMessageRepository;
import com.sprint.mission.discodeit.repository.jcf.JCFUserRepository;
import com.sprint.mission.discodeit.service.ChannelService;
import com.sprint.mission.discodeit.service.MessageService;
import com.sprint.mission.discodeit.service.UserService;
import com.sprint.mission.discodeit.service.basic.BasicChannelService;
import com.sprint.mission.discodeit.service.basic.BasicMessageService;
import com.sprint.mission.discodeit.service.basic.BasicUserService;

public class JavaApplication {
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
        /*UserService userService = new JCFUserService();
        UserService fileUserService = new FileUserService();*/
        UserRepository userRepository = new JCFUserRepository();
        UserService userService = new BasicUserService(userRepository);

        /*ChannelService channelService = new JCFChannelService();
        ChannelService fileChannelService = new FileChannelService();
        ChannelRepository channelRepository = new JCFChannelRepository();*/
        JCFChannelRepository channelRepository = new JCFChannelRepository();
        ChannelService channelService = new BasicChannelService(channelRepository);

        /*MessageService messageService = new JCFMessageService(userService, channelService);
        MessageService fileMessageService = new FileMessageService();
        MessageRepository messageRepository = new JCFMessageRepository();*/
        JCFMessageRepository messageRepository = new JCFMessageRepository();
        MessageService messageService = new BasicMessageService(messageRepository, userRepository, channelRepository);

        User user = setupUser(userService);
        Channel channel = setupChannel(channelService);
        messageCreateTest(messageService, channel, user);

        /*System.out.println("등록");
        User user = userService.create("kim");
        Channel channel = channelService.create("General");
        System.out.println("생성된 유저 : " + user.getId());
        Message message = messageService.create("Hello", user.getId(), channel.getId());
        System.out.println("생성된 메시지: " + message);

        System.out.println("조회(단건)");
        User foundUser = userService.findById(user.getId());
        System.out.println("조회 유저 : " + foundUser.getName());

        System.out.println("조회(다건)");
        System.out.println(userService.findAll());

        System.out.println("수정");
        userService.update(user.getId(), "kim2");

        System.out.println("수정된 데이터 조회");
        System.out.println(userService.findById(user.getId()));

        System.out.println("삭제");
        userService.delete(user.getId());

        System.out.println("조회를 통해 삭제되었는지 확인");
        System.out.println(userService.findAll());*/
    }
}
