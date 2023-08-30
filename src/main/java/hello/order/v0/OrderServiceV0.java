package hello.order.v0;

import hello.order.OrderService;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 사용자 정의 메트릭 : 기본 예제 만들기
 */
@Slf4j
public class OrderServiceV0 implements OrderService {
    private AtomicInteger stock = new AtomicInteger(100);

    @Override
    public void order() {
        log.info("주문");
        stock.decrementAndGet(); //감소
    }

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
