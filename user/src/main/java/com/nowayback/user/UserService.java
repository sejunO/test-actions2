package com.nowayback.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final EventPublisher eventPublisher;

    public User create(String name) {
        User user = userRepository.save(User.create(name));
        eventPublisher.publish(UserDto.from(user));
        return user;
    }
}
