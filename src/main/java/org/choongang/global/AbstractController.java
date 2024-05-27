package org.choongang.global;

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

    }

    /**
     * 입력 항목 : 기본 설정 = 메뉴 입력 , 필요시 컨트롤러마다 다르게 입력
     */
    public void prompt() {
        System.out.print("메뉴 선택 : ");
        String menu = sc.nextLine();
    }

    @Override
    public final void run() { // final -> 변경 X | 순서대로
        common();
        show();
        prompt();
    }
}
