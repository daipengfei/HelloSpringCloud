import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import org.junit.Test;

public class RxJavaTest {

    @Test
    public void basicObserve() {
        Flowable.just("Hello world")
                .zipWith(Flowable.just("1"), (s, u) -> s + " " + u)
                .subscribe(s -> {
                    System.out.println(Thread.currentThread());
                    System.out.println(s);
                });
    }

    @Test
    public void testFlowable() {
    }

    @Test
    public void testMaybe() {
        Maybe.just("hello").observeOn(Schedulers.io()).subscribe(
                message -> {
                    System.out.println(Thread.currentThread());
                    System.out.println(message);
                });
    }

    @Test
    public void testScheduled() throws InterruptedException {
        Observable
                .<Integer>create(e ->
                {
                    for (int i = 0; i < 20; i++) {
                        System.out.println("发射线程:" + Thread.currentThread().getName() + "---->" + "发射:" + i);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e1) {
                            Thread.currentThread().interrupt();
                        }
                        e.onNext(i);
                    }
                    e.onComplete();
                })
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.newThread())
                .map(count ->
                {
                    System.out.println("处理线程:" + Thread.currentThread().getName() + "---->" + "处理:" + count);
                    return count;
                })
                .observeOn(Schedulers.computation())
                .subscribe(count ->
                {
                    System.out.println(Thread.currentThread().getName());
                    System.out.println(count);
                });

        Thread.sleep(Integer.MAX_VALUE);
    }
}
