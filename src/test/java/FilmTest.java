import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.manager.PosterManager;
import ru.netology.domain.Film;

public class FilmTest {
    PosterManager manager = new PosterManager();
    Film first = new Film( "Бладшот");
    Film second = new Film( "Вперёд");
    Film third = new Film( "Отель Белград");
    Film fourth = new Film( "Джентельмены");
    Film fifth = new Film( "Человек-неведимка");
    Film sixth = new Film( "Тролли. Мировой тур");
    Film seventh = new Film( "Номер один");

    @BeforeEach

    public void setUp() {
        manager.addFilm(first);
        manager.addFilm(second);
    }

    @Test
    public void filmTest() {

        manager.addFilm(third);
        Film[] actual = manager.findAll();
        Film[] expected = {first, second, third};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastFilm() {

        manager.addFilm(third);
        manager.addFilm(fourth);
        manager.addFilm(fifth);
        manager.addFilm(sixth);
        Film[] actual = manager.findLast();
        Film[] expected = {sixth, fifth, fourth, third, second, first};
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void fiveLastFilms() {
        PosterManager manager = new PosterManager(5);
        manager.addFilm(first);
        manager.addFilm(second);
        manager.addFilm(third);
        manager.addFilm(fourth);
        manager.addFilm(fifth);
        manager.addFilm(sixth);
        Film[] actual = manager.findLast();
        Film[] expected = {sixth, fifth, fourth, third, second};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void OnlyOne() {
        PosterManager manager = new PosterManager(1);
        manager.addFilm(first);
        manager.addFilm(second);
        Film[] actual = manager.findLast();
        Film[] expected = {second};
        Assertions.assertArrayEquals(expected, actual);
    }
}


