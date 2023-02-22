package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class UsersTest {

    @Test
    @DisplayName("같은 이름을 가진 User가 존재하면 예외를 던진다.")
    void should_throwException_when_duplicatedNameExist() {
        User kodak = new User("kodak");
        User duplicatedKodak = new User("kodak");
        User polo = new User("polo");
        User poz = new User("poz");

        List<User> users = List.of(kodak, duplicatedKodak, polo, poz);

        assertThatThrownBy(() -> new Users(users))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("같은 이름을 가진 User가 존재하지 않는다면 예외를 던지지 않는다.")
    void should_notThrowException_when_duplicatedNameNotExist() {
        User kodak = new User("kodak");
        User polo = new User("polo");
        User poz = new User("poz");

        List<User> users = List.of(kodak, polo, poz);

        assertThatCode(() -> new Users(users))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("이름으로 User를 찾을 수 있다.")
    void findByNameTest1() {
        User kodak = new User("kodak");
        User polo = new User("polo");
        User poz = new User("poz");

        Users users = new Users(List.of(kodak, polo, poz));
        User findedUser = users.findByName("kodak");

        assertThat(findedUser).isEqualTo(kodak);
    }

    @Test
    @DisplayName("User를 찾을 수 없다면 예외를 던진다.")
    void findByNameTest2() {
        User kodak = new User("kodak");
        User polo = new User("polo");
        User poz = new User("poz");

        Users users = new Users(List.of(kodak, polo, poz));

        assertThatThrownBy(() -> users.findByName("kadak"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
