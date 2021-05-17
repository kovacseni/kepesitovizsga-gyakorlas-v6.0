package hu.nive.ujratervezes.kepesitovizsga.digits;

import java.util.ArrayList;
import java.util.List;

public class Digits {

    public int getNumbers() {
        int sum = 0;
        for (int i = 10; i <= 99; i++) {
            String numberString = Integer.toString(i);
            int firstDigit = Integer.parseInt(numberString.substring(0, 1));
            int secondDigit = Integer.parseInt(numberString.substring(1));

            if (firstDigit + 5 == secondDigit || firstDigit - 5 == secondDigit) {
                sum++;
            }
        }
        return sum;
    }

    public int getNumbers2(){
        List<Integer> numbers = new ArrayList<>();
        for(int i = 10; i<100; i++){
            if(Math.abs(i % 10  - i/10) == 5){
                numbers.add(i);
            }
        }
        return numbers.size();
    }
}
