package wmsdk;

import wmsdk.model.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Example {
    private final WmWallet wm;

    public Example(String caPath, String cliCertPath, String clientKey, String publicKeyPath, String url, String broker) throws Exception {
        Client cli = new Client(cliCertPath, "", clientKey, "", caPath, publicKeyPath);
        // todo
        wm = new WmWallet(url, broker, cli);
    }

    public static String generateUUID() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String timePart = now.format(formatter);
        Random random = new Random();
        String randomPart = String.format("%06d", random.nextInt(1000000));
        return timePart + randomPart;
    }

    public void deposit() throws Exception {
        Deposit deposit = new Deposit(wm);
        String sourceId = generateUUID();

        //1、test create order
        int chainId = 1;
        int coinId = 1;
        BigDecimal flatAmount = new BigDecimal("4");
        String symbol = "USDT/CNY";
        DepositCreateOrderReq depositCreateOrderReq = new DepositCreateOrderReq(sourceId, chainId, coinId, flatAmount, symbol);
        Resp<DepositCreateOrderResp> createResp = deposit.Create(depositCreateOrderReq);
        System.out.println(createResp.getCode());
        System.out.println(createResp.getMsg());
        System.out.println(createResp.getData());

        // sleep 5 second
        Thread.sleep(5000); // 参数单位为毫秒

        // 2、test get detail
        DepositGetDetailReq depositGetDetailReq = new DepositGetDetailReq(sourceId);
        Resp<DepositGetDetailResp> detailResp = deposit.Detail(depositGetDetailReq);
        System.out.println(detailResp.getCode());
        System.out.println(detailResp.getMsg());
        System.out.println(detailResp.getData());

        // sleep 5 second
        Thread.sleep(5000); // 参数单位为毫秒

        // 3、test cancel order
//        DepositCancelOrderReq depositCancelOrderReq = new DepositCancelOrderReq(sourceId);
//        Resp<DepositCancelOrderResp> cancelResp = deposit.Cancel(depositCancelOrderReq);
//        System.out.println(cancelResp.getCode());
//        System.out.println(cancelResp.getMsg());
//        System.out.println(cancelResp.getData());
    }

    public void withdraw() throws Exception {
        Withdraw withdraw = new Withdraw(wm);
        //1、test create order
        String sourceId = generateUUID();
        String withdrawAddress = "";
        String withdrawTag = "";
        WithdrawCreateOrderReq withdrawCreateOrderReq = new WithdrawCreateOrderReq(sourceId, 1, 1, withdrawAddress, withdrawTag, new BigDecimal("2"));
        Resp<WithdrawCreateOrderResp> createResp = withdraw.Create(withdrawCreateOrderReq);
        System.out.println(createResp.getCode());
        System.out.println(createResp.getMsg());
        System.out.println(createResp.getData());

        // sleep 5 second
        Thread.sleep(5000); // 参数单位为毫秒

        //2、test get detail
        WithdrawGetDetailReq withdrawGetDetailReq = new WithdrawGetDetailReq(sourceId);
        Resp<WithdrawGetDetailResp> detailResp = withdraw.Detail(withdrawGetDetailReq);
        System.out.println(detailResp.getCode());
        System.out.println(detailResp.getMsg());
        System.out.println(detailResp.getData());
    }
}

