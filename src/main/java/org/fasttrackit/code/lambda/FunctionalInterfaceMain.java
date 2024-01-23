package org.fasttrackit.code.lambda;

import java.util.function.Function;

public class FunctionalInterfaceMain {
    public static void main(String[] args) {

        trySomething("test", new Function<String, String>() {
            @Override
            public String apply(String s) {
                return null;
            }
        });

        System.out.println(trySomething("Test", s -> {
            System.out.println("This function is ran");
            return s.toUpperCase();
        }));
        System.out.println(trySomething("Test", s -> s.toLowerCase()));

        System.out.println(doMathStuff(5, a -> a * 2));
        System.out.println(doMathStuff(5, a -> a - 2));

        System.out.println(doMathStuffAdvanced(4, 5, (a, b) -> a * b));
    }

    private static Integer doMathStuffAdvanced(int input1, int input2, MyFunctionalInterface myFunction) {
        return myFunction.applyThis(input1,input2);
    }

    private static String trySomething(String request, Function<String, String> function) {
        System.out.println(request);
        return function.apply(request);
    }

    public static Integer doMathStuff(Integer request, Function<Integer,Integer> function){
        return function.apply(request);
    }

    public int method(int a){ return a-2;} // echivalent cu a->a+1
}