package org.choongang.global;

import org.choongang.global.constants.Menu;

/**
 * 사용자가 입력한 메뉴 번호, 문구 -> 해당하는 컨트롤러로 이동 (메뉴 -> 상수 형태로 관리)
 */
public interface Router {
    void change(Menu menu);
    void start(); // 메뉴 변경 -> 컨트롤러 실행
}
