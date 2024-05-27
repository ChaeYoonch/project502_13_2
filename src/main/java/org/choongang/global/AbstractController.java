package org.choongang.global;

import org.choongang.global.constants.Menu;
import org.choongang.main.MainRouter;

import java.util.Scanner;

public abstract class AbstractController implements Controller { // 템플릿 메서드 패턴

    protected Scanner sc; // 프롬프트 재정의 -> protected 사용

    public AbstractController() {
        sc = new Scanner(System.in); // 프롬프트가 입력받음 -> sc 로 인해 이동 가능?
    }

    /**
     * 상단 공통 출력 부분
     */
    public void common() {
        System.out.println("학생 관리 프로그램 Ver1.0");
        System.out.println("----------------------");
    }

    /**
     * 입력 항목 : 기본 설정 = 메뉴 입력 , 필요시 컨트롤러마다 다르게 입력
     * - 문자 : q, exit, quit -> 종료
     * - 숫자 : 메뉴 항목
     */
    public void prompt() {
        System.out.print("메뉴 선택 : ");
        String menu = sc.nextLine();
        if (menu.equals("q") || menu.equals("quit") || menu.equals("exit")) {
            System.exit(0); // 0 - 정상 종료 | 1 - 비정상 종료
        }

        try {
            int m = Integer.parseInt(menu);
            change(m); // 메뉴 변경
        } catch (Exception e) { // 숫자만 들어감
            e.printStackTrace();
            System.out.println("메뉴는 숫자로 입력하세요.");
        }
    }

    /**
     * 템플릿 메서드 패턴 구현 : 특정 절차가 구현되어 있는 경우에 사용
     * 추상 클래스와 final 이용
     */
    @Override
    public final void run() { // final -> 변경 X | 순서대로
        common();
        show(); // 각 메뉴마다 다르게 보임 (로그인, 회원가입 등)
        prompt();
    }

    private void change(int menuNo) {
        Menu menu = null;
        switch (menuNo) {
            case 1: menu = Menu.JOIN; break; // 회원가입 (줄 개행 X 괜찮음)
            case 2: menu = Menu.LOGIN; break; // 로그인
            default: menu = Menu.MAIN; // 메인 메뉴
        }

        // 메뉴 컨트롤러 변경 처리 - Router 구현체에 넣어줌!
        // new MainRouter().change(menu); 매번 new 생성하면 메모리 소비 多 -> 1개만 만들어 공유 (싱글톤 패턴 이용)
        MainRouter.getInstance().change(menu); // run() 으로 실행
    }
}