package com.epam.izh.rd.online.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;

public class SimpleBigNumbersService implements BigNumbersService {

    /**
     * Метод делит первое число на второе с заданной точностью
     * Например 1/3 с точностью 2 = 0.33
     *
     * @param range точность
     * @return результат
     */
    @Override
    public BigDecimal getPrecisionNumber(int a, int b, int range) {
        if (b != 0) {
            BigDecimal bigDecimal = new BigDecimal(a).divide(new BigDecimal(b), range, RoundingMode.DOWN);
            return bigDecimal;
        }
        return null;
    }


    /**
     * Метод находит простое число по номеру
     *
     * @param range номер числа, считая с числа 2
     * @return простое число
     */
    @Override
    public BigInteger getPrimaryNumber(int range) {
        ArrayList<BigInteger> PrimaryNumber = new ArrayList<>();
        if (range >= 2) {
            int i = 2;
            while (PrimaryNumber.size() <= range) {
                if (new BigInteger(String.valueOf(i)).isProbablePrime(i)) {
                    PrimaryNumber.add(BigInteger.valueOf(i));
                }
                i++;
            }
            return PrimaryNumber.get(range);
        }
        return null;
    }
}
