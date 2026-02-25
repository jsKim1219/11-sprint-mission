package com.sprint.mission.discodeit;

import com.sprint.mission.discodeit.entity.User;
import com.sprint.mission.discodeit.service.ChannelService;
import com.sprint.mission.discodeit.service.MessageService;
import com.sprint.mission.discodeit.service.UserService;
import com.sprint.mission.discodeit.service.file.FileChannelService;
import com.sprint.mission.discodeit.service.file.FileMessageService;
import com.sprint.mission.discodeit.service.file.FileUserService;
import com.sprint.mission.discodeit.service.jcf.JCFUserService;
import com.sprint.mission.discodeit.service.jcf.JCFChannelService;
import com.sprint.mission.discodeit.service.jcf.JCFMessageService;

public class JavaApplication {
    public static void main(String[] args) {
        UserService userService = new FileUserService();
        ChannelService channelService = new FileChannelService();
        MessageService messageService = new FileMessageService();

        System.out.println("등록");
        User user = userService.create("kim");
        System.out.println("생성된 유저 : " + user.getId());

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
