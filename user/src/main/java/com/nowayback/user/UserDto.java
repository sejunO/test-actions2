package com.nowayback.user;

public record UserDto(Long id, String name) {
    public static UserDto from(User user) {
        return new UserDto(user.getId(), user.getName());
    }
}
