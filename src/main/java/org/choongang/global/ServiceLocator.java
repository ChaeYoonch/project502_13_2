package org.choongang.global;

import org.choongang.global.constants.Menu;

public interface ServiceLocator { // 서비스 찾는 역할
    Service find(Menu menu);
}
