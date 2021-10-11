package com.epam.izh.rd.online.service;

public class SimpleTextService implements TextService {

    @Override
    public String removeString(String base, String remove) {
        return base.replaceAll(remove, "");
    }

    @Override
    public boolean isQuestionString(String text) {
        return text.endsWith("?");
    }

    @Override
    public String concatenate(String... elements) {
        StringBuilder concat = new StringBuilder();
        for (String s : elements) {
            concat.append(s);
        }
        return concat.toString();
    }

    @Override
    public String toJumpCase(String text) {
        String textLowerCase = text.toLowerCase();
        StringBuilder jumpCase = new StringBuilder();
        for (int i = 0; i < textLowerCase.length(); i++) {
            if (i % 2 != 0) {
                jumpCase.append(textLowerCase.toUpperCase().charAt(i));
            } else {
                jumpCase.append(textLowerCase.charAt(i));
            }
        }
        return jumpCase.toString();
    }

    @Override
    public boolean isPalindrome(String string) {
        String lowerCase = string.toLowerCase();
        lowerCase = lowerCase.replaceAll(" ", "");
        StringBuilder reverseString = new StringBuilder(lowerCase);
        String inverted = String.valueOf(reverseString.reverse());
        return lowerCase.equals(inverted) && lowerCase.length() > 1;
    }
}
