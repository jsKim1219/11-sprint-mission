package com.sprint.mission.discodeit.controller;

import com.sprint.mission.discodeit.dto.UserCreateRequest;
import com.sprint.mission.discodeit.dto.UserDto;
import com.sprint.mission.discodeit.dto.UserStatusUpdateRequest;
import com.sprint.mission.discodeit.dto.UserUpdateRequest;
import com.sprint.mission.discodeit.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public UserDto registerUser(@RequestBody UserCreateRequest request) {
        return userService.create(request);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.PUT)
    public void updateUser(
            @PathVariable UUID userId, @RequestBody UserUpdateRequest requst) {
        userService.update(userId, requst);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
    public void  deleteUser(@PathVariable UUID userId) {
        userService.delete(userId);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<UserDto> getAllUsers() {
        return userService.findAll();
    }

    @RequestMapping(value = "/{userId}/online-status", method = RequestMethod.PUT)
    public void updateOnlineStatus(
            @PathVariable UUID userId, @RequestBody UserStatusUpdateRequest request) {
        //
    }
}
