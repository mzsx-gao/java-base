package gao.netty.adv;

import gao.netty.adv.busivo.User;
import gao.netty.adv.busivo.UserContact;

import java.util.Scanner;

/**
 * 业务方如何调用Netty客户端演示
 * 测试:
 * 1、 正常情况
 * 2、 客户端宕机，服务器应能清除客户端的缓存信息，允许客户端重新登录
 * 3、 服务器宕机，客户端应能发起重连
 * 4、在 LoginAuthRespHandler 中进行注释，可以模拟当服务器不处理客户端的请求时，客户端在超时后重新进行登录
 */
public class BusiClient {

    public static void main(String[] args) throws Exception {
        NettyClient nettyClient = new NettyClient();
        new Thread(nettyClient).start();
        while (!nettyClient.isConnected()) {
            synchronized (nettyClient) {
                nettyClient.wait();
            }
        }
        System.out.println("网络通信已准备好，可以进行业务操作了........");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String msg = scanner.next();
            if (msg == null) {
                break;
            } else if ("q".equals(msg.toLowerCase())) {
                nettyClient.close();//主动关闭
                while (nettyClient.isConnected()) {
                    synchronized (nettyClient) {
                        nettyClient.wait();
                    }
                }
                scanner.close();
                System.exit(1);
            } else if ("v".equals(msg.toLowerCase())) {
                User user = new User();
                user.setAge(19);
                String userName = "ABCDEFG --->1";
                user.setUserName(userName);
                user.setId("No:1");
                user.setUserContact(new UserContact(userName + "@xiangxue.com", "133"));
                nettyClient.send(user);
            } else {
                nettyClient.send(msg);
            }
        }
    }
}
