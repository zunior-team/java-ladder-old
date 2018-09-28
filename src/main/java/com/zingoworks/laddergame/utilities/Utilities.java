package com.zingoworks.laddergame.utilities;

import com.zingoworks.laddergame.view.InputView;

import java.util.ArrayList;

public class Utilities {
    static final int LENGTH_LIMIT = 5;
    static final String BLANK = " ";
    static final int ZERO = 0;
    static final int ONE = 1;

    public static ArrayList<StringBuilder> convertToMutable(String[] str, ArrayList<StringBuilder> object) {
        for (int i = 0; i < str.length; i++) {
            object.add(new StringBuilder(str[i]));
        }
        return object;
    }

    public static ArrayList<StringBuilder> checkLengthLimit (ArrayList<StringBuilder> user) {
        for (int i = 0; i < user.size(); i++) {
            user = alertLengthLimit(user, user.get(i));
        }
        return user;
    }

    public static ArrayList<StringBuilder> alertLengthLimit(ArrayList<StringBuilder> user, StringBuilder userName) {
        if (userName.length() > LENGTH_LIMIT) {
            System.out.println("<경고> 이름의 최대길이는 5자 입니다.");
            user = InputView.inputUser();
        }
        return user;
    }

    public static ArrayList<StringBuilder> convertLengthToLimit (ArrayList<StringBuilder> object) {
        for (int i = 0; i < object.size(); i++) {
            insertBlankInValue(object, i);
        }
        return object;
    }

    public static ArrayList<StringBuilder> convertLengthToDefault (ArrayList<StringBuilder> object) {
        for (int i = 0; i < object.size(); i++) {
            removeBlankInValue(object, i);
        }
        return object;
    }

    private static ArrayList<StringBuilder> insertBlankInValue(ArrayList<StringBuilder> object, int i) {
        while (object.get(i).length() <= LENGTH_LIMIT) {
            object.get(i).insert(ZERO, BLANK);
        }
        return object;
    }

    private static ArrayList<StringBuilder> removeBlankInValue(ArrayList<StringBuilder> object, int i) {
        while (object.get(i).indexOf(BLANK) > -1) {
            object.get(i).delete(ZERO, ONE);
        }
        return object;
    }
}
