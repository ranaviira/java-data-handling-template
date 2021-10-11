package com.epam.izh.rd.online.service;

import com.epam.izh.rd.online.repository.SimpleFileRepository;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleRegExpService implements RegExpService {

    SimpleFileRepository repository = new SimpleFileRepository();

    /**
     * Метод должен читать файл sensitive_data.txt (из директории resources) и маскировать в нем конфиденциальную информацию.
     * Номер счета должен содержать только первые 4 и последние 4 цифры (1234 **** **** 5678). Метод должен содержать регулярное
     * выражение для поиска счета.
     *
     * @return обработанный текст
     */
    @Override
    public String maskSensitiveData() {
        String s1 = repository.readFileFromResources("sensitive_data.txt");
        String s;
        Pattern pattern = Pattern.compile("(\\d{4}).(\\d{4}).(\\d{4}).(\\d{4})");
        Matcher matcher = pattern.matcher(s1);
        s = matcher.replaceAll("$1 **** **** $4");
        return s;
    }

    /**
     * Метод должен считыввать файл sensitive_data.txt (из директории resources) и заменять плейсхолдер ${payment_amount} и ${balance} на заданные числа. Метод должен
     * содержать регулярное выражение для поиска плейсхолдеров
     *
     * @return обработанный текст
     */
    @Override
    public String replacePlaceholders(double paymentAmount, double balance) {

        String s1 = repository.readFileFromResources("sensitive_data.txt");
        String s;

        Pattern pattern = Pattern.compile("\\$\\{payment_amount}");
        Matcher matcher = pattern.matcher(s1);

        s = matcher.replaceAll(Integer.toString((int) paymentAmount));

        Pattern pattern1 = Pattern.compile("\\$\\{balance}");
        Matcher matcher1 = pattern1.matcher(s);

        String s2 = matcher1.replaceAll(Integer.toString((int) balance));
        return s2;
    }
}
