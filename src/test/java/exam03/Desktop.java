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
    }
}
