package mate.academy;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class FindFirstTest {

    // Stream API: find first
    List<String> cities = List.of("Kyiv", "Kyoto", "Oslo", "Antananarivo", "Vinnitsa");

    /**
     * потрібно пробігтись по певному списку міст в нашому List
     *
     * @param letter
     * @return
     */
    private String getFirst(char letter, List<String> cities) {
        // отримаєю Stream<String>
        Optional<String> first = cities.stream()
                // потрібно відфільтрувати і знайти перше слово, яке починається на задану літеру
                .filter(s -> s.charAt(0) == letter)
                // Повертаємо будь яке перше слово яке починається на задану літеру
                // термінальний метод findFirst() повертає Optional<String>
                .findFirst();

        // викликати метод get без перевірни чи існує значення в Optional може викинутись NoSuchElementException
        // викликаємо свою кастомну помилку
        return first.orElseThrow(() -> new RuntimeException("Can't find the city!"));
    }

    private String getAny(char letter, List<String> cities) {
        Optional<String> first = cities.stream()
                .filter(s -> s.charAt(0) == letter)
                // можемо отримати будь який елемент нашого Steam
                .findAny();
        return first.orElseThrow(() -> new RuntimeException("Can't find the city!"));
    }

    private boolean getAnyMatch(char letter, List<String> cities) {
        boolean exist = cities.stream()
                // повертає нам в результаті true of false
                .anyMatch(s -> s.charAt(0) == letter);
        return exist;
    }

    @Test
    public void test1() {
        System.out.println(getFirst('K', cities));
    }

    @Test
    public void test2() {
        System.out.println(getFirst('O', cities));
    }

    @Test
    public void test3() {
        System.out.println(getFirst('F', cities));
    }

    @Test
    public void test4() {
        System.out.println(getAnyMatch('O', cities));
    }
}
