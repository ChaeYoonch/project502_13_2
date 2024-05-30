package exam03;

public class ComputerAssembler { // 별도의 클래스를 만들어 함수로 정의해 객체로 가져오면 편함!
    public Monitor monitor() {
        return new UpgradedMonitor(); // 상위 쪽 자료형으로 참조하는게 유리 -> 공통된 틀만 알면 되므로 -> 다형성 이용
    }

    public Body body() {
        return new Body();
    }

    public Keyboard keyboard() {
        return new Keyboard();
    }

    public Mouse mouse() {
        return new Mouse();
    }

    public GraphicCard Card() {
        return new GraphicCard();
    }

    public Desktop desktop() {
        return new Desktop(monitor(), body(), keyboard(), mouse(), Card()); // (안에 객체가 들어갈 것임) <- 이거로 완성된 객체 가져옴
    }

} // 내부에서 열어 놨기에 외부에서 가져다 쓸 수 있음 -> 통제하기 위해
