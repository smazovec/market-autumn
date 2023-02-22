package ru.geekbrains.marketautumn.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.marketautumn.model.dto.UserDto;
import ru.geekbrains.marketautumn.service.UserService;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @GetMapping("/all")
  public List<UserDto> getAllUsers() {
    return userService.getAllUsers();
  }

}
