package exam03;

public class Ex02 {
    public static void main(String[] args) {
        ComputerAssembler assembler = new ComputerAssembler();

        Desktop d1 = assembler.desktop();
        Desktop d2 = assembler.desktop(); // 완성된 객체를 가져올 수 있음
    }
}
