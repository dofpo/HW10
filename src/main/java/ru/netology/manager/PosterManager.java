package ru.netology.manager;

import ru.netology.domain.Film;

public class PosterManager {
    int filmQuantity = 10;
    //private static class FilmRepository {
    private Film[] films = new Film[0];

    public PosterManager() {
    }

    public PosterManager(int filmQuantity) {
        this.filmQuantity = filmQuantity;
    }

    public void addFilm(Film film) {
        int length = films.length + 1;
        Film[] tmp = new Film[length];
        System.arraycopy(films, 0, tmp, 0, films.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = film;
        films = tmp;
    }

    public Film[] findAll() {
        return films;
    }

    public Film[] findLast() {
        int resultLength;
        if (filmQuantity > films.length) {
            resultLength = films.length;
        } else {
            resultLength = filmQuantity;
        }
        Film[] result = new Film[resultLength];
        for (int i = 0; i < resultLength; i++) {
            int index = films.length - i - 1;
            result[i] = films[index];
        }
        return result;
    }
}
