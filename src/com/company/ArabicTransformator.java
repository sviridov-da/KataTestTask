package com.company;

public class ArabicTransformator extends Transformator {

    public ArabicTransformator(String str) throws Exception {
        super(str);
        type = Types.ARABIC;
    }

    @Override
    boolean canTransform() throws Exception {
        try {
            result = Integer.parseInt(source);
        } catch (Exception e){
            throw new Exception("Invalid string");
        }
        return true;
    }



}
