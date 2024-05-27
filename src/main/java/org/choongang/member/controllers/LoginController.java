package org.choongang.member.controllers;

import org.choongang.global.AbstractController;
import org.choongang.global.Router;
import org.choongang.global.Service;
import org.choongang.global.constants.Menu;
import org.choongang.main.MainRouter;
import org.choongang.member.services.MemberServiceLocator;
import org.choongang.template.Templates;

/**
 * 로그인 컨트롤러
 */
public class LoginController extends AbstractController {

    @Override
    public void show() {

        Templates.getInstance().render(Menu.LOGIN);
    }

    @Override
    public void prompt() {
        String userId = promptWithValidation("아이디 : ", s -> !s.isBlank()); // id가 있을 때만 값을 입력할 수 있도록
        String userPW = promptWithValidation("비밀번호 : ", s -> !s.isBlank());

        RequestLogin form = RequestLogin.builder()
                .userId(userId)
                .userPw(userPW)
                .build();

        // 로그인 처리 기능 ...
        Router router = MainRouter.getInstance();
        try {

            Service service = MemberServiceLocator.getInstance().find(Menu.LOGIN);
            service.process(form);

            router.change(Menu.MAIN); // 로그인 성공 시 -> 메인 화면으로 이동
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
            router.change(Menu.LOGIN); // 로그인 실패 시 -> 로그인 페이지로 이동
        }
    }
}
