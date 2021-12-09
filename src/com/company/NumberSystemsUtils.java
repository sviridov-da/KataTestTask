package com.company;

public class NumberSystemsUtils {
    /**
     *
     * @param romeDigit - char from lots of Roman digit
     * @return - decimal value of romeDigit
     * @throws Exception - romeDigit is not from a set of Roman numerals
     */
    static int RomeDigitToIntDigit(char romeDigit) throws Exception {
        switch (romeDigit){
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            case '0':
                return 0;
            default:
                throw new Exception("Invalid input");
        }
    }

    /**
     *
     * @param source - string contains only symbols from set of Rome digit
     * @return - decimal value of source
     * @throws Exception - source contain invalid symbols
     */
    public static int RomeToInt(String source) throws Exception {
        int result = 0;
        if(source.length()==1) {
            return NumberSystemsUtils.RomeDigitToIntDigit(source.charAt(0));
        }
        char currentDigit, predDigit;
        int currentValue, predValue;

        for(int currentIndex = source.length(); currentIndex>0; currentIndex--){
            if(currentIndex==source.length())
                currentDigit = '0';
            else
                currentDigit = source.charAt(currentIndex);
            predDigit = source.charAt(currentIndex-1);
            currentValue = NumberSystemsUtils.RomeDigitToIntDigit(currentDigit);
            predValue = NumberSystemsUtils.RomeDigitToIntDigit(predDigit);
            if(predValue<currentValue){
                result-=predValue;
            } else {
                result+=predValue;
            }
        }
        return result;
    }

    /**
     *
     * @param value - positive decimal which should be transformed to Rome Numeric System
     * @return - string contains value in Rome Numeric System
     * @throws Exception - value is zero or less
     */
    public static String IntToRome(int value) throws Exception {
        if(value<=0)
            throw new Exception("zero or negative number in Roman System");
        int countOfThousands = value / 1000;
        value = value % 1000;
        int countOfHundreds = value / 100;
        value = value % 100;
        int countOfTens = value / 10;
        value = value % 10;
        String result = "";
        for(int i = 0; i<countOfThousands; i++)
            result+="M";
        if(countOfHundreds==9)
            result += "CM";
        else{
            if(countOfHundreds>=5){
                result+="D";
                countOfHundreds-=5;
            }
            if(countOfHundreds==4)
                result+="CD";
            else for(int i = 0; i<countOfHundreds; i++)
                result+="C";
        }
        if(countOfTens==9)
            result+="XC";
        else{
            if(countOfTens>=5){
                result+="L";
                countOfTens-=5;
            }if(countOfTens==4)
                result+="XL";
            else for(int i = 0; i<countOfTens; i++)
                result+="X";
        }
        if(value==9)
            result+="IX";
        else{
            if(value>=5){
                result+="V";
                value-=5;
            }
            if(value==4)
                result+="IV";
            else for(int i = 0; i<value; i++)
                result+="I";
        }
    return result;
    }
}
