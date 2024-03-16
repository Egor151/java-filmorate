package ru.yandex.practicum.filmorate.service.user;

import ru.yandex.practicum.filmorate.model.User;

import java.util.Collection;

public interface UserFriendService {
    String addingUserAsFriend(Integer userId, Integer friendId);

    String deletingFromUserFriends(Integer userId, Integer deletingFriendId);

    Collection<?> getUserFriends(Integer userId);

    Collection<User> getListOfCommonFriends(Integer userId, Integer otherUserId);
}
