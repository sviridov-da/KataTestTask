package com.company;



public class TransformatorFactory {
    static String arabicValidSymbols = "1234567890";
    static String romeValidSymbols = "IVXLCDM";
    /**
    @param source - string, which should be transformed to number
     */
    public static Transformator getTransformator(String source) throws Exception {
        Transformator result = null;
        if(arabicValidSymbols.contains(Character.toString(source.charAt(0))))
            result = new ArabicTransformator(source);
        else if(romeValidSymbols.contains(Character.toString(source.toUpperCase().charAt(0))))
            result = new RomeTransformator((source));
        if(result==null)
            throw new Exception("Invalid input");
        return result;
    }
}
