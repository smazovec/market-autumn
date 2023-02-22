package ru.geekbrains.marketautumn.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.geekbrains.marketautumn.model.dto.UserDto;
import ru.geekbrains.marketautumn.model.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

  UserMapper MAPPER = Mappers.getMapper(UserMapper.class);

  User toUser(UserDto userDto);

  @InheritInverseConfiguration
  UserDto fromUser(User user);

}
