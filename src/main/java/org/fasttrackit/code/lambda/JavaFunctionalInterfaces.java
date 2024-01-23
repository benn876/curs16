package org.fasttrackit.code.lambda;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class JavaFunctionalInterfaces {
    public static void main(String[] args) {
        tryFunction(6,a -> a +1);
        tryFunction(6,a -> a +10);


        trySupplier(()-> "ceva");
        trySupplier(()-> "altceva");

        tryConsumer("ceva", System.out::println);

        System.out.println(tryPredicate("something", i -> i.length() > 10));
        System.out.println(tryPredicate("something", i -> i.length() > 2));

        tryMultiple(
                ()->"FastTrack",
                String::length,
                number -> number > 5,
                number-> System.out.println("Greater than 5")
        );
    }

    private static void tryMultiple(
            Supplier<String> supplier,
            Function<String, Integer> function,
            Predicate<Integer> predicate,
            Consumer<Integer> consumer
            ) {
        String s = supplier.get();
        Integer integer = function.apply(s);
        if(predicate.test(integer)){
            consumer.accept(integer);
        } else {
            System.out.println("Not bigger than 5");
        }
    }

    private static boolean tryPredicate(String something, Predicate<String> predicate) {
        return predicate.test(something);
    }

    private static void tryConsumer(String input, Consumer<String> consumer) {
        consumer.accept(input);
    }

    private static String trySupplier(Supplier<String> supplier) {
        String s = supplier.get();
        if(s.startsWith("c")){
            System.out.println("Starts with c");
        } else {
            System.out.println("Doesn't starts with c");
        }
        return s;
    }

    private static Integer tryFunction(Integer input, Function<Integer,Integer> function) {
        Integer result = function.apply(input);
        System.out.println(result);
        return result;
    }
}
