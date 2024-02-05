package ru.yandex.practicum.filmorate.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.Builder;
import lombok.Data;
import ru.yandex.practicum.filmorate.model.validator.MinReleaseData;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDate;

/**
 * Film.
 *
 * @author Nikolay Radzivon
 */
@Data
@Builder(toBuilder = true)
public class Film {
    /**
     * Индификатор фильма
     */
    @Builder.Default
    private int id = 0;

    /**
     * Имя фильма
     */
    @NotBlank(message = "Название фильма не должно быть пустым")
    @NotNull
    private String name;

    /**
     * Описание фильма
     */
    @Size(max = 200, message = "Описание фильма не должно быть больше {max}")
    private String description;

    /**
     * Дата релиза фильма
     */
    @NotNull
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @MinReleaseData("1895-12-28")
    private LocalDate releaseDate;

    /**
     * Продолжительнность фильма
     */
    @Positive(message = "Продолжительность фильма должна быть положительной")
    private int duration;
}
