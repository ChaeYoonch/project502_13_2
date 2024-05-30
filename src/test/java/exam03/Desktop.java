package exam03;

public class Desktop {
    private Monitor monitor = new UpgradedMonitor(); // 멤버 변수로 정의
    private Body body = new Body();
    private Keyboard keyboard = new Keyboard();
    private Mouse mouse = new Mouse();
    private GraphicCard card = new GraphicCard();

    public Desktop(Monitor monitor, Body body, Keyboard keyboard, Mouse mouse, GraphicCard card) {
        // 외부에서 주입받아 해결 | 의존성 사용
        this.monitor = monitor;
        this.body = body;
        this.keyboard = keyboard;
        this.mouse = mouse;
        this.card = card;
    }

    public void run() { // 내부에서 작동
        // monitor, body, keyboard, mouse 객체를 활용
        // Desktop 객체는 구성 객체 (monitor, body, keyboard, mouse) 의 변화에 영향을 받는 관계 -> 통제가 필요 (메서드 내에서 통제)
        // -> 캡슐화 : 폐쇄 (메서드 안에 있어야만 가능 = 코드가 안에 있기 때문에)
        // 개방 폐쇄 : 확장에는 열려있고, 변화에는 닫혀있음 => 전략 패턴
        body.run();
    }
}
