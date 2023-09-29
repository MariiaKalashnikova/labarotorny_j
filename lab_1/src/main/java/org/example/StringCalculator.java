package org.example;

public class StringCalculator {
    public int add(String number) {
        int coma_2 = 0;
        for(int i=0; i < number.length(); i++) {
            if(number.charAt(i) ==',') {
                coma_2 += 1;
            }
        }
        //підрахунок кількості ком
        String number_1 = "";
        int result = 0, j = 0;
        coma_2 += 1;
        int[] arr = new int[coma_2];
        try {
            for (int i=0; i<number.length(); i++) {
                if(number.charAt(i) == ',') {
                    //якщо розділовий знак кома в масив додається число до коми, перехід на наступний елемент масиву
                    arr[j] = Integer.parseInt(number_1);
                    j+=1;
                    number_1 = "";
                    continue;
                }
                else {
                    //якщо наступний елемент цифра, записання її в рядок
                    number_1 += number.charAt(i);
                }

            }

            for(int i = 0; i<arr.length; i++) {
                //підрахунок елементів масиву
                result = result+arr[i];
            }
            //додавання останньої цифри з рядка
            result = result+Integer.parseInt(number_1);}
        catch(NumberFormatException e) {
            result = 0;
        }
        return result;


    }
}
