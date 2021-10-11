package com.epam.izh.rd.online.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;

public class SimpleBigNumbersService implements BigNumbersService {

    @Override
    public BigDecimal getPrecisionNumber(int a, int b, int range) {
        if (b != 0) {
            return new BigDecimal(a).divide(new BigDecimal(b), range, RoundingMode.DOWN);
        }
        return null;
    }

    @Override
    public BigInteger getPrimaryNumber(int range) {
        ArrayList<BigInteger> primaryNumber = new ArrayList<>();
        if (range >= 2) {
            int i = 2;
            while (primaryNumber.size() <= range) {
                if (new BigInteger(String.valueOf(i)).isProbablePrime(100)) {
                    primaryNumber.add(BigInteger.valueOf(i));
                }
                i++;
            }
            return primaryNumber.get(range);
        }
        return null;
    }
}
