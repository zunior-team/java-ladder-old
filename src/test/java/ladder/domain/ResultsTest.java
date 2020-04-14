package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Results test")
class ResultsTest {

    @DisplayName("생성")
    @ParameterizedTest
    @ValueSource(strings = {"wonoh","asd","test"})
    void 생성(String name){
        Result result = new Result(name);
        assertThat(result).isNotNull();
    }
    @DisplayName("빈값이면 익셉션")
    @ParameterizedTest
    @EmptySource
    void 빈값_익셉션(String name){
        assertThatThrownBy(() -> new Result(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

}