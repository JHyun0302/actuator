package hello.order;

import java.util.concurrent.atomic.AtomicInteger;

public interface OrderService {
    void order();

    void cancel();

    AtomicInteger getStock(); //멀티 스레드 상황에서 안전하게 값 더하기/빼기 가능
}
