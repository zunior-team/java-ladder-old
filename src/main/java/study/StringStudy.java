package study;

public class StringStudy {
    public static String createMessage(int numberofClass) {
        StringBuilder sb = new StringBuilder();
        sb.append("코드스쿼드 백엔드 수강생은? ");
        sb.append(numberofClass);
        sb.append(" 명이다.");
        return sb.toString();
    }
}
