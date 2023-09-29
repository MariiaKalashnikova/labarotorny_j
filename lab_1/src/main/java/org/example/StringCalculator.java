package org.example;

public class StringCalculator {
    public int add(String number) {
        int coma_2 = 0, er = 0, del = 0,  neg_count = 0;
        String number_1 = "", negative = "";
        char delimeter = ' ';
        if (number.length()>0) {
            if(number.charAt(0)=='\\' && number.charAt(1)=='\\' && number.charAt(3)=='\\' && number.charAt(4)=='n') {
                delimeter = number.charAt(2);
                del++;
            }}

        int count_0 = 0;
        if(del == 1) {
            count_0 = 5;
        }
        for(int i=count_0; i < number.length(); i++) {
            if(number.charAt(i)==',') {
                coma_2+=1;
            }
            if (number.charAt(i)=='\\') {
                i++;
                if (number.charAt(i)=='n') {
                    coma_2+=1;
                }
            }
            if(del == 1) {
                if(number.charAt(i)==delimeter)
                    coma_2+=1;
            }
        }
        //підрахунок кількості ком або знаків \n

        int result = 0, j = 0;
        coma_2 += 1;
        int[] arr = new int[coma_2];
        int count = 0;
        if(del == 1) {
            count = 5;
        }

        try {
            for (int i = count; i<number.length(); i++) {
                if(number.charAt(i) == ',' || number.charAt(i) == delimeter) {
                    //якщо розділовий знак кома або \n в масив додається число до коми(\n), перехід на наступний елемент масиву
                    arr[j] = Integer.parseInt(number_1);
                    if(arr[j]<0) {
                        neg_count+=1;
                    }
                    j+=1;
                    number_1 = "";
                }
                else if(number.charAt(i)=='\\') {
                    i++;
                    if(number.charAt(i)=='n') {
                        arr[j] = Integer.parseInt(number_1);
                        if(arr[j]<0) {
                            neg_count+=1;
                        }
                        j+=1;
                        number_1 = "";
                    }
                    else {
                        er+=1;
                        break;
                    }
                }
                else {
                    //якщо наступний елемент цифра, записання її в рядок
                    number_1 = number_1+number.charAt(i);
                }

            }
            int number_arr = Integer.parseInt(number_1);
            if(number_arr<0) {
                neg_count++;
            }

            int[] arr_negative = new int[neg_count];
            int q = 0;
            if (neg_count > 0) {
                while(q < arr_negative.length) {
                    for(int p = 0; p<arr.length; p++) {
                        if(arr[p]<0) {
                            arr_negative[q] = arr[p];
                            q++;
                        }
                    }
                    if(number_arr<0) {
                        arr_negative[neg_count-1] = number_arr;
                        q++;
                    }

                }}

            if(neg_count > 0) {
                try {
                    throw new NegativeException("Від'ємне число: ", arr_negative);
                }
                catch (NegativeException e) {
                    System.out.print(e.getMessage());
                    int[] neg = e.negativearr();
                    for (int count_1=0; count_1<neg.length; count_1++) {
                        System.out.print(neg[count_1]+" ");
                    }
                    result = 0;
                }}
            else {
                for(int y = 0; y<arr.length; y++) {
                    //підрахунок cуми елементів масиву
                    result = result+arr[y];
                }
                //додавання останньої цифри з рядка
                if(er==0) {
                    result = result+number_arr;}
                else {
                    result=0;
                }
            }}
        catch(NumberFormatException e) {
            result = 0;
        }
        return result;

    }
}
