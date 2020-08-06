package ru.toxic.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

    private String login;
    private String password;
    private Double balance;
    private String timezone;
    private String site;
    private String introduction;
    private Boolean salesDisabled;
    private Boolean buysDisabled;
    private Boolean sendSmsContactNotification;
    private Boolean sendSmsPaymentsNotification;
    private Boolean sendCryptoDepositNotification;
    private Boolean showMeAsVerified;
    private Boolean disableConfInfoInEmail;
    private Boolean enableWebNotifications;
}
