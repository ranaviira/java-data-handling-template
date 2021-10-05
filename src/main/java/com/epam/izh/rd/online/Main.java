package com.epam.izh.rd.online;

import java.math.BigInteger;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<BigInteger> list = new ArrayList<>();


        int i = 2;
        while (list.size() <= 100){
            if(new BigInteger(String.valueOf(i)).isProbablePrime(i)){
                list.add(BigInteger.valueOf(i));
            }
            i++;
        }
        System.out.println(list);
    }
}


