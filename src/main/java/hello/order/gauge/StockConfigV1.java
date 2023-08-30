package hello.order.gauge;

import hello.order.OrderService;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 사용자 정의 메트릭 : 게이지 등록
 * `counter` : 요청이 올 때마다 값을 저장
 * `gauge` : 현재 상태 값을 봐야해서 metric에서 넘어온 정보를 읽음
 */
@Configuration
public class StockConfigV1 {

    @Slf4j
    static class MyStockMetric {

        @Bean
        public MyStockMetric myStockMetric(OrderService orderService, MeterRegistry registry) {
            return new MyStockMetric(orderService, registry);
        }

        private OrderService orderService;

        private MeterRegistry registry;

        public MyStockMetric(OrderService orderService, MeterRegistry registry) {
            this.orderService = orderService;
            this.registry = registry;
        }

        @PostConstruct
        public void init() {
            Gauge.builder("my.stock", orderService, service -> {
                log.info("stock gauge call");
                return service.getStock().get();
            }).register(registry);
        }
    }
}
