package hello.order.v1;

import hello.order.OrderService;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * MeterRegistry : 마이크로미터 기능을 제공하는 핵심 컴포넌트
 * <p>
 * Counter.builder("name")  //메트릭 이름
 * .tag("class", this.getClass().getName()) //.tag() : 프로메테우스의 레이블
 * .tag("me블thod", "order")
 * .description("order")
 * .register(registry).increment();     //.register() : 만든 카운터를 `meterRegistry`에 등록    //.increment() : 카운터 값 증가
 */
@Slf4j
public class OrderServiceV1 implements OrderService {
    private final MeterRegistry registry;
    private AtomicInteger stock = new AtomicInteger(100);

    public OrderServiceV1(MeterRegistry meterRegistry) {
        this.registry = meterRegistry;
    }

    @Override
    public void order() {
        log.info("주문");
        stock.decrementAndGet(); //감소

        Counter.builder("my.order")
                .tag("class", this.getClass().getName())
                .tag("method", "order")
                .description("order")
                .register(registry).increment();
    }

    @Override
    public void cancel() {
        log.info("취소");
        stock.incrementAndGet(); //증가

        Counter.builder("my.order")
                .tag("class", this.getClass().getName())
                .tag("method", "cancel")
                .description("cancel")
                .register(registry).increment();
    }

    @Override
    public AtomicInteger getStock() {
        return stock;
    }
}
