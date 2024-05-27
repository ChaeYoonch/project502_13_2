package org.choongang.global;

import org.choongang.global.constants.Menu;

public interface ControllerLocator { // 컨트롤러가 무엇이 올 지 모름 -> 다형성 이용
    Controller find(Menu menu);
}
