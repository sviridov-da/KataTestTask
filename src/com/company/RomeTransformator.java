package com.company;

import java.util.Locale;

public class RomeTransformator extends Transformator{
    public RomeTransformator(String str) throws Exception {
        super(str);
        type = Types.ROME;
    }

    @Override
    boolean canTransform() throws Exception {
        char currentDigit;
        char predDigit;
        int currentValue;
        int predValue;
        source=source.toUpperCase(Locale.ROOT);
        result= NumberSystemsUtils.RomeToInt(source);
        return true;
    }



}
