package is.toxic.model;

import lombok.Builder;
import lombok.Data;

import java.util.Map;
import java.util.Objects;

@Data
@Builder
public class DealInfo {
    private String country;
    private String currency;
    private String paymentSystem;
    private String profit;
    private String profitAvg;
    private String timeOfPayment;
    private String minTransactionLimit;
    private String maxTransactionLimit;
    private String dealInfo;
    private String dealHead;
    private String monStart;
    private String monEnd;
    private String thuStart;
    private String thuEnd;
    private String wenStart;
    private String wenEnd;
    private String tueStart;
    private String tueEnd;
    private String friStart;
    private String friEnd;
    private String satStart;
    private String satEnd;
    private String sunStart;
    private String sunEnd;
    private Boolean buy;
    private Boolean seeLiq;
    private Boolean notForAnon;
    private Boolean forVerifiedNum;
    private Boolean onlyTrust;
    private Boolean autoPrice;

    public static DealInfo getDealFromMap(Map<String, String> entry){
        return DealInfo.builder()
                .dealInfo(entry.get("условия сделки"))
                .timeOfPayment(entry.getOrDefault("окно оплаты", null))
                .profitAvg(entry.getOrDefault("уравнение цены", null))
                .profit(entry.getOrDefault("прибыль", null))
                .minTransactionLimit(entry.getOrDefault("минимальный лимит транзакции", null))
                .maxTransactionLimit(entry.get("максимальный лимит транзакции"))
                .paymentSystem(entry.get("способ оплаты"))
                .dealHead(entry.get("заголовок"))
                .currency(entry.get("валюта"))
                .country(entry.get("местоположение"))
                .autoPrice(entry.get("авто цена").equals("да"))
                .buy(entry.get("покупка").equals("да"))
                .forVerifiedNum(entry.get("номер телефона подтвержден").equals("да"))
                .notForAnon(entry.get("не показывать объявление анонимным пользователям").equals("да"))
                .onlyTrust(entry.get("только доверенные пользователи").equals("да"))
                .seeLiq(entry.get("следить за ликвидностью").equals("да"))
                .monStart(entry.getOrDefault("пнд начало", "----"))
                .tueStart(entry.getOrDefault("втр начало", "----"))
                .wenStart(entry.getOrDefault("срд начало", "----"))
                .thuStart(entry.getOrDefault("чтв начало", "----"))
                .friStart(entry.getOrDefault("птн начало", "----"))
                .satStart(entry.getOrDefault("сбт начало", "----"))
                .sunStart(entry.getOrDefault("вск начало", "----"))
                .monEnd(entry.getOrDefault("пнд конец", "----"))
                .tueEnd(entry.getOrDefault("втр конец", "----"))
                .wenEnd(entry.getOrDefault("срд конец", "----"))
                .thuEnd(entry.getOrDefault("чтв конец", "----"))
                .friEnd(entry.getOrDefault("птн конец", "----"))
                .satEnd(entry.getOrDefault("сбт конец", "----"))
                .sunEnd(entry.getOrDefault("вск конец", "----"))
                .build();
    }
}
