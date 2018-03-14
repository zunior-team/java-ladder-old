public class InputViewUtils {
    static String[] checkNames(String[] namesOfPersons) {
        for (int i = 0; i < namesOfPersons.length; i++) {
            String name = namesOfPersons[i];
            name = checkValidation(name);  // isValid()로 구분하려면 if()가 필요한데 depth 늘어남.
            namesOfPersons[i] = name;
        }
        return namesOfPersons;
    }

    static String checkValidation(String name) {
        if(isValid(name)) {
            return name;
        }
        return convert(name);
    }

    static String convert(String name) {
        return name.substring(0, 5);  // endIndex번째는 포함되지 않는다.
    }

    static Boolean isValid(String name) {
        if(name.length()<=5) {
            return true;
        }
        return false;
    }
}
