package ladder.user;

import spark.utils.StringUtils;

public class User {
    private static final int LIMIT_OF_NAME = 5;
    private final String name;
    private final int order;

    public User(final String name, final int order) {
        validate(name);

        this.name = name;
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return order;
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
