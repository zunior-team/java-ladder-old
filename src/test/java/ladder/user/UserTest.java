package ladder.user;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserTest {

    @Test
    void constructorTest() {
        User user = new User("name");

        assertThat(user).isNotNull();
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"123456"})
    void constructorExceptionTest(String name) {
        assertThatThrownBy(() -> new User(name)).isInstanceOf(IllegalArgumentException.class);
    }

}