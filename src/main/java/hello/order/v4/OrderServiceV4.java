package hello.order.v4;

import hello.order.OrderService;
import io.micrometer.core.annotation.Timed;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @timed(name) 메트릭 적용
 */
@Timed("my.order")
@Slf4j
public class OrderServiceV4 implements OrderService {
    private AtomicInteger stock = new AtomicInteger(100);


    @Override
    public void order() {
        log.info("주문");
        stock.decrementAndGet(); //감소
        sleep(500);
    }

    @Override
    public void cancel() {
        log.info("취소");
        stock.incrementAndGet(); //증가
        sleep(200);
    }

    private static void sleep(int millis) {
        try {
            Thread.sleep(millis + new Random().nextInt(200));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public AtomicInteger getStock() {
        return stock;
    }
}
