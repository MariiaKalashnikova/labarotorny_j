package org.example;

public class StringCalculator {
    public int add(String number) {
        int coma_2 = 0, er = 0;
        for(int i=0; i < number.length(); i++) {
            if(number.charAt(i)==',') {
                coma_2+=1;
            }
            if (number.charAt(i)=='\\') {
                i++;
                if (number.charAt(i)=='n') {
                    coma_2 += 1;
                }
            }
        }
        //підрахунок кількості ком або знаків \n
        String number_1 = "";
        int result = 0, j = 0;
        coma_2 += 1;
        int[] arr = new int[coma_2];
        try {
            for (int i=0; i<number.length(); i++) {
                if(number.charAt(i) == ',') {
                    //якщо розділовий знак кома або \n в масив додається число до коми(\n), перехід на наступний елемент масиву
                    arr[j] = Integer.parseInt(number_1);
                    j+=1;
                    number_1 = "";
                }
                else if(number.charAt(i) =='\\') {
                    i++;
                    if(number.charAt(i) =='n') {
                        arr[j] = Integer.parseInt(number_1);
                        j += 1;
                        number_1 = "";
                    }
                    else {
                        er += 1;
                        break;
                    }
                }
                else {
                    //якщо наступний елемент цифра, записання її в рядок
                    number_1 += number.charAt(i);
                }

            }

            for(int i = 0; i<arr.length; i++) {
                //сума елементів масиву
                result = result+arr[i];
            }
            //додавання останньої цифри з рядка
            if(er == 0) {
                result = result+Integer.parseInt(number_1);}
            else {
                result = 0;
            }}
        catch(NumberFormatException e) {
            result = 0;
        }
        return result;


    }
}
