package org.example;

import java.util.concurrent.*;

public class FutureAndCompleteableFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future = executorService.submit(
                ()->{
                    try {
                        Thread.sleep(1000);
                        return "hello";
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
        );
        String result = future.get();
        System.out.println(result);

        //Completeable future

        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Fetching data...");
            return 50;
        }).thenApply(data -> data * 2);

        System.out.println("Result: " + future1.join());
    }
}
