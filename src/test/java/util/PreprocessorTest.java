package util;

import exception.PreprocessorException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("전처리기는")
class PreprocessorTest {

    @DisplayName("구분자에 의해서 스트링을 자른다.")
    @CsvSource({
        "'1,2,3,4,5', ',', 5",
        "'1^2^3^4^5', '\\^', 5",
        "'1|2|3|4|5', '\\|', 5",
        "'1$2$3$4$5', '\\$', 5",
        "'1, 2 , 3 , 4 , 5', ',', 5",
    })
    @ParameterizedTest
    void splitLineBySeparatorTest(String line, String separator, int expectedLength) {

        // when
        List<String> list = Preprocessor.splitLineBySeparator(line, separator);

        // then
        assertThat(list.size()).isEqualTo(expectedLength);
    }

    @DisplayName("구분자에 들어오는 라인이 널 또는 비어있을시 에러가 발생한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void splitLineBySeparatorExceptionTest1(String line){
        // when & then
        assertThatThrownBy(() -> Preprocessor.splitLineBySeparator(line, Preprocessor.COMMA))
                .isInstanceOf(PreprocessorException.class);
    }

    @DisplayName("구분자가 널 또는 비어있을시 에러가 발생한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void splitLineBySeparatorExceptionTest2(String separator){
        // when & then
        assertThatThrownBy(() -> Preprocessor.splitLineBySeparator("PARK, KIM, YUN, JEON", separator))
                .isInstanceOf(PreprocessorException.class);
    }
}
