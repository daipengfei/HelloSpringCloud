package com.hello.spring.reactive;

import io.reactivex.Flowable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import org.springframework.test.context.TestExecutionListeners;


public class RxJava {

    public static void main(String[] args) throws InterruptedException {
        Flowable.just("hello world!","Hi RxJava")
//                .observeOn(Schedulers.newThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(@NonNull String s) throws Exception {
                        System.out.println(Thread.currentThread().hashCode());
                        System.out.println(s);
                        Thread.sleep(1000);
                    }
                });
        Thread.sleep(Integer.MAX_VALUE);
    }

}
