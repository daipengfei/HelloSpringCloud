package com.hello.spring.guava.future;

import com.google.common.util.concurrent.*;

import javax.annotation.Nullable;
import java.util.concurrent.*;

/****************************************
 *
 * Created by daipengfei on 2017/6/23.****
 *
 ***************************************/
public class CallBackExecutor {
    public static void main(String[] args) {
//        guava();
        java();
    }

    private static void guava() {
        ListeningExecutorService executorService =
                MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(5));
        final ListenableFuture<String> future = executorService.submit(() -> {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(3000);
            return "hi";
        });

        future.addListener(() -> {
            try {
                System.out.println(Thread.currentThread().getName());
                System.out.println(future.get());
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }, executorService);

        Futures.addCallback(future, new FutureCallback<String>() {
            @Override
            public void onSuccess(@Nullable String result) {
                System.out.println(Thread.currentThread().getName());
                System.out.println(result);
            }

            @Override
            public void onFailure(Throwable t) {

            }

        }, executorService);
        System.out.println("hi guava");
    }

    public void testCompleteService() {
        java();
    }

    private static void java() {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(
                () -> {
                    System.out.println(Thread.currentThread());
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        //ignore
                    }
                    return "hello world!";
                }, executorService);
        completableFuture.thenAccept(s -> System.out.println(s + " : " + Thread.currentThread()));
        System.out.println("hi");
    }

}
