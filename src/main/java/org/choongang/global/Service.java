package org.choongang.global;

public interface Service<T> { // 입력받는 자료형 = 다양한 형태 가능 <- <T> 지네릭 으로 가능
    void process(T form);
}
