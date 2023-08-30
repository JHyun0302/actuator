package hello.order.v2;

import hello.order.OrderService;
import io.micrometer.core.annotation.Counted;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Counted(name) : 반복되는 코드 AOP 적용 - `name` : 메트릭 이름
 */
@Slf4j
public class OrderServiceV2 implements OrderService {
    private AtomicInteger stock = new AtomicInteger(100);

    @Counted("my.order")
    @Override
    public void order() {
        log.info("주문");
        stock.decrementAndGet(); //감소

    }

    @Counted("my.order")
    @Override
    public void cancel() {
        log.info("취소");
        stock.incrementAndGet(); //증가

    }

    @Override
    public AtomicInteger getStock() {
        return stock;
    }
}
