package ru.geekbrains.marketautumn.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.geekbrains.marketautumn.mapper.UserMapper;
import ru.geekbrains.marketautumn.model.dto.UserDto;
import ru.geekbrains.marketautumn.model.entity.Role;
import ru.geekbrains.marketautumn.model.entity.User;
import ru.geekbrains.marketautumn.model.repositpry.UserRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService implements UserDetailsService {

  private final UserRepository userRepository;

  public Optional<User> findByUsername(String username) {
    return userRepository.findByUsername(username);
  }

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = findByUsername(username).orElseThrow(
        () -> new UsernameNotFoundException(String.format("User '%s' not found", username)));
    return new org.springframework.security.core.userdetails.User(user.getUsername(),
        user.getPassword(), mapRolesToAuthorities(user.getRoles()));
  }

  public Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
    return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName()))
        .collect(Collectors.toList());
  }

  public List<UserDto> getAllUsers() {
    return userRepository.findAll().stream().map(UserMapper.MAPPER::fromUser)
        .collect(Collectors.toList());
  }

}
