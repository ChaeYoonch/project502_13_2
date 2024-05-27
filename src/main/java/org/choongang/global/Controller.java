package org.choongang.global;

public interface Controller {
    void show(); // 서비스(Model) 와 뷰를 연결하고 해당 뷰를 보여줌 | common(공통) - show(메뉴 항목) - prompt(입력) 순서대로
    void run();
}
