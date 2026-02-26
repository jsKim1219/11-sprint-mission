package com.sprint.mission.discodeit;

import com.sprint.mission.discodeit.entity.Channel;
import com.sprint.mission.discodeit.entity.Message;
import com.sprint.mission.discodeit.entity.User;
import com.sprint.mission.discodeit.repository.ChannelRepository;
import com.sprint.mission.discodeit.repository.MessageRepository;
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
import com.sprint.mission.discodeit.service.file.FileChannelService;
import com.sprint.mission.discodeit.service.file.FileMessageService;
import com.sprint.mission.discodeit.service.file.FileUserService;
import com.sprint.mission.discodeit.service.jcf.JCFUserService;
import com.sprint.mission.discodeit.service.jcf.JCFChannelService;
import com.sprint.mission.discodeit.service.jcf.JCFMessageService;

public class JavaApplication {
    public static void main(String[] args) {
        //UserService userService = new JCFUserService();
        UserService fileUserService = new FileUserService();
        UserRepository userRepository = new JCFUserRepository();
        UserService userService = new BasicUserService(userRepository);

        //ChannelService channelService = new JCFChannelService();
        ChannelService fileChannelService = new FileChannelService();
        ChannelRepository channelRepository = new JCFChannelRepository();
        ChannelService channelService = new BasicChannelService(channelRepository);

        //MessageService messageService = new JCFMessageService(userService, channelService);
        MessageService fileMessageService = new FileMessageService();
        MessageRepository messageRepository = new JCFMessageRepository();
        MessageService messageService = new BasicMessageService(messageRepository, userRepository, channelRepository);

        System.out.println("등록");
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
        System.out.println(userService.findAll());
    }
}
