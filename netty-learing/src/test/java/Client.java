import io.netty.buffer.ByteBuf;

import java.io.IOException;
import java.net.Socket;
import java.nio.ByteBuffer;

/**
 * @Author: Jokeer
 * @Description: TODO
 * @Date: 2024/4/28 15:18
 * @Version: 1.0
 */

public class Client {


    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("localhost", 9000);


        String msg = "6hello!";

        byte[] bytes1 = msg.getBytes();

        byte[] bytes = ByteBuffer.allocate(4).putInt(msg.length()).array();

        socket.getOutputStream().write(bytes);
        socket.getOutputStream().write(bytes1);

    }

}
