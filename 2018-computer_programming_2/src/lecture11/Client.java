package lecture11;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

  private Socket clientSocket;
  private DataInputStream dataInputStream;
  private DataOutputStream dataOutputStream;

  public Client() {
    connect();
    streamSetting();
    dataSend();
    dataRecv();
  }

  public static void main(String[] args) {
    new Client();
  }

  public void connect() {
    try {
      System.out.println("접속 시도");
      clientSocket = new Socket("127.0.0.1", 8080);
      System.out.println("접속 완료");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // 데이터를 계속 수신 쓰레드
  public void dataRecv() {
    new Thread(new Runnable() {
      boolean isThread = true;

      @Override
      public void run() {
        while (isThread) {
          try {
            String recvData = dataInputStream.readUTF();
            if (recvData.equals("/quit")) {
              isThread = false;
            } else {
              System.out.println("상대방 : " + recvData);
            }
          } catch (Exception e) {
          }
        }
      }
    }).start();
  }

  // 데이터를 계속 전송 쓰레드
  public void dataSend() {
    new Thread(new Runnable() {
      final Scanner in = new Scanner(System.in);
      boolean isThread = true;

      @Override
      public void run() {
        while (isThread) {
          try {
            String sendData = in.nextLine();
            if (sendData.equals("/quit")) {
              isThread = false;
            } else {
              dataOutputStream.writeUTF(sendData);
            }
          } catch (Exception e) {
          }
        }
      }
    }).start();
  }

  public void streamSetting() {
    try {
      dataInputStream = new DataInputStream(clientSocket.getInputStream());
      dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());
    } catch (Exception e) {
    }
  }
}