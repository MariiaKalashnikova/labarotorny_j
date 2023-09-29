package org.example;

public class StringCalculator {
    public int add(String number) {
            int coma_2 = 0, er = 0, del = 0,  neg_count = 0, index=number.indexOf('n'), count_br = 0;
            String number_1 = "", negative = "",  delimeter = "";;
            if (number.length()>0 && index!=-1 && number.charAt(index-2)==']' && number.charAt(index-1)=='\\' && number.charAt(index)=='n'&& number.charAt(0)=='/'&& number.charAt(1)=='/' && number.charAt(2)=='[') {
                for (int t = 0; t<index; t++ ) {
                    if(number.charAt(t) == ']' && number.charAt(t+1) == '[') {
                        count_br+=1;
                        t+=1;
                    }
                }
                count_br+=1;
            }
            String[] arr_br= new String[count_br];
            if(count_br>0) {
                for(int count_del = 3; number.charAt(count_del)!=']'; count_del++) {
                    delimeter+= number.charAt(count_del);
                    del = 1;}
                arr_br[0] = delimeter;
                int count_del_1 = 0;
                int d = 1;

                while (count_del_1 < index) {
                    delimeter = "";
                    if (number.charAt(count_del_1) == ']' && number.charAt(count_del_1+1) == '[') {
                        count_del_1+=2;
                        while (count_del_1 < index && number.charAt(count_del_1) != ']') {
                            delimeter += number.charAt(count_del_1);
                            count_del_1++;
                        }
                        arr_br[d] = delimeter;
                        d++;
                    } else {
                        count_del_1++;
                    }
                }
            }

            int count_0 = 0;
            if(del > 0) {
                count_0 = index+1;
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
                if(del > 0) {
                    for(int count_delimeter = 0; count_delimeter < count_br; count_delimeter++) {
                        for(int j = 0; j<arr_br[count_delimeter].length(); j++) {
                            if(number.charAt(i) == arr_br[count_delimeter].charAt(j)) {
                                while(j<arr_br[count_delimeter].length()-1) {
                                    if(arr_br[count_delimeter].charAt(j) == number.charAt(i) ) {
                                        i++;
                                        j++;
                                    }
                                    else {
                                        break;
                                    }
                                }

                                if(j == (arr_br[count_delimeter].length()-1)) {
                                    if(arr_br[count_delimeter].charAt(j) == number.charAt(i)) {
                                        coma_2+=1;
                                    }
                                }
                            }
                        }
                    }

                }

            }

            //підрахунок кількості ком або роздільників

            int result = 0, j = 0, er_1 = 0;
            int open = 0, close =0;
            for(int iopen = 0; iopen < number.length(); iopen++) {
                if(number.charAt(iopen) == '[') {
                    open++;
                }
                if(number.charAt(iopen) == ']') {
                    close++;
                }
            }
            if(open!=close){
                er_1+=1;
            }
            coma_2 += 1;
            int[] arr = new int[coma_2];

            int count = 0;
            if(del > 0) {
                count = index+1;;
            }

            try {
                for (int i = count; i<number.length(); i++) {

                    if(number.charAt(i) == ',') {
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

                    else if(del>0 && String.join(" ", arr_br).contains(String.valueOf(number.charAt(i)))) {
                        er_1+=1;
                        for(int count_delimeter = 0; count_delimeter < count_br; count_delimeter++) {
                            for(int count_p = 0; count_p<arr_br[count_delimeter].length(); count_p++) {
                                if(number.charAt(i) == arr_br[count_delimeter].charAt(count_p)) {
                                    er_1-=1;
                                    while(count_p<arr_br[count_delimeter].length()-1) {
                                        if(arr_br[count_delimeter].charAt(count_p) == number.charAt(i)) {
                                            i++;
                                            count_p++;
                                        }
                                        else {
                                            er+=1;
                                            break;}}

                                    if(count_p == (arr_br[count_delimeter].length()-1)) {
                                        if(arr_br[count_delimeter].charAt(count_p) == number.charAt(i)) {
                                            arr[j] = Integer.parseInt(number_1);
                                            if(arr[j]<0) {
                                                neg_count+=1;
                                            }
                                            j+=1;
                                            number_1 = "";}
                                        else {
                                            er+=1;
                                            break;
                                        }}}
                                else {
                                    break;}

                            }}}
                    else {
                        //якщо наступний елемент цифра, записання її в рядок
                        number_1 += number.charAt(i);

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

                if(neg_count > 0 && er==0 && er_1 ==0) {
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
                else if(er==0 && er_1 ==0) {
                    for(int y = 0; y<arr.length; y++) {
                        //підрахунок cуми елементів масиву
                        if(arr[y] <= 1000) {
                            result+=arr[y];}
                    }
                    //додавання останньої цифри з рядка

                    if(number_arr < 1001) {
                        result+=number_arr;}


                }
                else {
                    result=0;
                }}
            catch(NumberFormatException e) {
                result = 0;
            }
            return result;
    }
}
