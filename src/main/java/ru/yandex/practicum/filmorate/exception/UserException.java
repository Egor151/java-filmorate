package ru.yandex.practicum.filmorate.exception;


public class UserException extends RuntimeException {
    public UserException(String massage) {
        super(massage);
    }
}
