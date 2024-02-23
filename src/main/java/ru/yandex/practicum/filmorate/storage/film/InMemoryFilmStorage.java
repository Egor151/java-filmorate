package ru.yandex.practicum.filmorate.storage.film;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.yandex.practicum.filmorate.model.Film;

import java.util.*;
import java.util.stream.Collectors;

@Getter
@Component
@Slf4j
public class InMemoryFilmStorage implements FilmStorage {
    private final Map<Integer, Film> filmMap = new HashMap<>();

    @Override
    public Collection<Film> getAllFilms() {
        log.info("Запрошен список всех фильмов");
        return Collections.unmodifiableCollection(filmMap.values());
    }

    @Override
    public void addFilm(Film film) {
        log.info("Добавлен фильм {}", film);
        filmMap.put(film.getId(), film);
    }

    @Override
    public void updateFilm(Film film) {
        log.info("Обновлён фильм с id: {}", film.getId());
        filmMap.put(film.getId(), film);
    }

    @Override
    public Optional<Film> getFilmById(int id) {
        log.info("Запрошен фильм с id: {}", id);
        return Optional.ofNullable(filmMap.get(id));
    }

    @Override
    public void deleteFilm(int id) {
        log.info("Удалён фильм с id: {}", id);
        filmMap.remove(id);
    }

    /**
     * @param comparator
     * @param count
     * @return
     */
    @Override
    public Collection<Film> getSortedFilms(Comparator<Film> comparator, Integer count) {
        log.info("Запрошен сортированный список с {} элементами", count);
        return filmMap.values().stream().sorted(comparator).limit(count).collect(Collectors.toList());
    }
}
