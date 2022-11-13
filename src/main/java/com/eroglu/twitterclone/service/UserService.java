package com.eroglu.twitterclone.service;

import com.eroglu.twitterclone.dto.UserResponse;
import com.eroglu.twitterclone.exceptions.TwitterException;
import com.eroglu.twitterclone.mapper.UserMapper;
import com.eroglu.twitterclone.model.User;
import com.eroglu.twitterclone.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
@Transactional
public class UserService {

    private final AuthService authService;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Transactional(readOnly = true)
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public UserResponse getCurrentUser() {
        return userMapper.mapToDto(authService.getCurrentUser());
    }

    @Transactional(readOnly = true)
    public UserResponse getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow();
        return userMapper.mapToDto(user);
    }

    @Transactional(readOnly = true)
    public UserResponse getUserByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow();
        return userMapper.mapToDto(user);
    }
}
