package util;

import exception.PreprocessorException;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

public class Preprocessor {

    public static final String COMMA = ",";

    public static List<String> splitLineBySeparator(final String line, final String separator){
        validate(line, separator);
        return Arrays.asList(
                line.split(separator));
    }

    private static void validate(String line, String separator){
        if(StringUtils.isEmpty(line) || StringUtils.isEmpty(separator)){
            throw new PreprocessorException("잘못된 인자로 인해서 구분자로 자르지 못합니다.");
        }
    }
}
