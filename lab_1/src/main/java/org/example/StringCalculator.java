package org.example;

public class StringCalculator {
    public int add(String number) {
        int coma = number.indexOf(',');
        int result = 0;
        String number_1 = "", number_2 = "";

        if(coma == -1) {
            try {
                result = Integer.parseInt(number);}
            catch(NumberFormatException e)
            {
                result = 0;
            }
        }
        else{
            try {

                for(int i=0; i < coma; i++) {
                    number_1 = number_1+number.charAt(i);
                }
                for(int i=coma+1; i < number.length(); i++) {
                    number_2 = number_2+number.charAt(i);
                }
                result = Integer.parseInt(number_1)+Integer.parseInt(number_2);
            }
            catch(NumberFormatException e) {
                result = 0;
            }
        }
        return result;


    }
}
