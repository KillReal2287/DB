package Homework8;

import java.util.concurrent.Callable;

import static java.lang.Math.pow;

public class Counter implements Callable<Double> {
    double result;

    Counter(Integer start, Integer end){
        for (int i = start; i < end; i++) {
            double sign = pow(-1,i+1);
            double number = 1.0/(2*i-1);
            result += sign*number;
        }
    }

    @Override
    public Double call(){
        return result;
    }
}
