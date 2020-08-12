package is.toxic.db.data.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class UserSnapshot {
    private Long key;
    private Long id;
    private String user_id;
    private String user_name;
    private BigDecimal trades_avg_amount;
    private Long trades_count;
    private Long counterpartys_count;
    private BigDecimal response_rate;
    private LocalDateTime first_trade_date;
    private Boolean is_identity_verifed;
    private Long trusted_count;
    private Long blocked_count;
    private Long avg_delay_seconds;
    private Long median_delay_seconds;
    private String time_zone;
    private String introduction;
    private String site;
    private Boolean sales_disabled;
    private Boolean buys_disabled;
    private Boolean send_sms_contacts_notification;
    private Boolean send_sms_payments_notifications;
    private Boolean send_crypto_deposit_notifications;
    private Boolean show_me_as_having_verified_real_name;
    private Boolean disable_confidential_information_from_email;
    private Boolean enable_web_notifications;
    private LocalDateTime created_at;
    private Boolean is_anonymous;
}
