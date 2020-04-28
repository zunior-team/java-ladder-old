package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Result test")
class ResultTest {

    @DisplayName("생성")
    @ParameterizedTest
    @ValueSource(strings = "wonoh,asdsa,asdqwedas")
    void 생성(String name){
        Results results = new Results(name);
        assertThat(results).isNotNull();
        assertThat(results.getResults().size()).isEqualTo(3);
    }
    @DisplayName("빈값이면 익셉션")
    @ParameterizedTest
    @EmptySource
    void 빈값_익셉션(String name){
        assertThatThrownBy(() -> new Results(name))
                .isInstanceOf(IllegalArgumentException.class);
    }
}