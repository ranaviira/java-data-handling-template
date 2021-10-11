package com.epam.izh.rd.online.service;

import com.epam.izh.rd.online.repository.SimpleFileRepository;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleRegExpService implements RegExpService {

    SimpleFileRepository repository = new SimpleFileRepository();

    @Override
    public String maskSensitiveData() {
        String readFile = repository.readFileFromResources("sensitive_data.txt");
        String resultMask;
        Pattern pattern = Pattern.compile("(\\d{4}).(\\d{4}).(\\d{4}).(\\d{4})");
        Matcher matcher = pattern.matcher(readFile);
        resultMask = matcher.replaceAll("$1 **** **** $4");
        return resultMask;
    }

    /**
     * Метод должен считыввать файл sensitive_data.txt (из директории resources) и заменять плейсхолдер ${payment_amount} и ${balance} на заданные числа. Метод должен
     * содержать регулярное выражение для поиска плейсхолдеров
     *
     * @return обработанный текст
     */
    @Override
    public String replacePlaceholders(double paymentAmount, double balance) {

        String readFile = repository.readFileFromResources("sensitive_data.txt");

        Pattern patternPaymentAmount = Pattern.compile("\\$\\{payment_amount}");
        Matcher matcherPaymentAmount = patternPaymentAmount.matcher(readFile);

        String replacePaymentAmount = matcherPaymentAmount.replaceAll(Integer.toString((int) paymentAmount));

        Pattern patternBalance = Pattern.compile("\\$\\{balance}");
        Matcher matcherBalance = patternBalance.matcher(replacePaymentAmount);

        return matcherBalance.replaceAll(Integer.toString((int) balance));
    }
}
