package ladder.user;

import spark.utils.StringUtils;

public class User {
    private static final int LIMIT_OF_NAME = 5;
    private String name;

    public User(final String name) {
        validate(name);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    private void validate(String name) {
        if(StringUtils.isEmpty(name)) {
            throw new IllegalArgumentException("User name is null or empty");
        }

        if(name.length() > LIMIT_OF_NAME) {
            throw new IllegalArgumentException("User name should be equal or short than : " + LIMIT_OF_NAME);
        }
    }
}
