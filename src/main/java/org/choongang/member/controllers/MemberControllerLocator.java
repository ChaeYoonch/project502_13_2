package org.choongang.member.controllers;

import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
import org.choongang.global.constants.Menu;

import java.util.HashMap;
import java.util.Map;

public class MemberControllerLocator implements ControllerLocator {

    private static ControllerLocator instance;

    private Map<Menu, Controller> controllers;

    private MemberControllerLocator() { // 기본 생성자 : private 로 한정
        controllers = new HashMap<>(); // 초기화 작업
    }

    public static ControllerLocator getInstance() { // 싱글톤 패턴
        if (instance == null) { // instance 가 null 인 경우
            instance = new MemberControllerLocator();
        }

        return instance;
    }

    @Override
    public Controller find(Menu menu) { // ControllerLocator 의 find()
        Controller controller = controllers.get(menu);
        if (controller != null) { // menu 가 null 이 아니면
            return controller;
        }

        switch (menu) {
            case JOIN: controller = new JoinController(); break;
            default: controller = new LoginController();
        }

        controllers.put(menu, controller); // 있으면 기본 것 사용 없으면 생성

        return controller;
    }
}
