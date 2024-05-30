package org.choongang.global.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Objects;
import java.util.function.Consumer;

public class Client {
    private Socket socket;
    private String name; // name 으로 등록
    private ObjectMapper om;

    public Client(String name, Consumer<SocketData> handler) {
        this.name = name;
        om = new ObjectMapper();
        om.registerModule(new JavaTimeModule());

        String serverAddress = Objects.requireNonNullElse(System.getenv("server"), "127.0.0.1");
        /* String serverAddress = System.getenv("server"); 위의 것이 여기 두 줄 간략화한 것
        serverAddress = Objects.requireNonNullElse(serverAddress, "127.0.0.1"); */
        String _port = System.getenv("port");
        int port = _port == null || _port.isBlank() ? 9999 : Integer.parseInt(_port);

        try {
            socket = new Socket(serverAddress, port); // 바뀔 수 있으므로 환경변수 형태로 저장
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 수신 데이터 처리 S
        Thread inputTh = new Thread(() -> {
            try (DataInputStream dis = new DataInputStream(socket.getInputStream())) {

                while (true) {
                    if (socket == null || socket.isClosed() || handler == null) {
                        Thread.currentThread().yield();
                        break;
                    }

                    String json = dis.readUTF();
                    SocketData data = om.readValue(json, SocketData.class);
                    handler.accept(data);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        inputTh.start();
        // 수신 데이터 처리 E
    }

    public void send(SocketData data) {
        try {
            String json = om.writeValueAsString(data);

            Thread th = new Thread(() -> {
                try{
                    DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                    dos.writeUTF(json);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            th.start();
        } catch (JsonException) {
            e.printStackTrace();
        }
    }
}