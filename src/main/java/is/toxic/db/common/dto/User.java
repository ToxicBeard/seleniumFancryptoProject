package is.toxic.db.common.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class User {
    private Long id;
    private Integer invoices_data_created_count;
    private BigDecimal invoices_data_payments_sum_amount;
    private Integer invoices_data_payments_count;
    private Integer invoices_data_positive_feedbacks;
    private Integer invoices_data_negative_feedbacks;
    private BigDecimal deals_data_avg_amount;
    private Long deals_data_count;
    private Long deals_data_partners_count;
    private BigDecimal deals_data_response_rate;
    private LocalDateTime deals_data_deal_date;
    private Long deals_data_avg_delay_seconds;
    private Long deals_data_median_delay_seconds;
    private String user_id;
    private String user_name;
    private Long trusted_count;
    private Long blocked_count;
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
    private String jira_creds_username;
    private String jira_creds_key;
    private String jira_creds_password;
    private Boolean is_deleted;
    private Integer default_currency;
    private Integer options_auto_price;
    private Boolean is_anonymous;
    private Long last_ad_search_sell_owner_id;
    private Integer last_ad_search_sell_country;
    private Integer last_ad_search_sell_currency;
    private Integer last_ad_search_sell_payment_type;
    private BigDecimal last_ad_search_sell_amount;
    private Long last_ad_search_buy_owner_id;
    private Integer last_ad_search_buy_country;
    private Integer last_ad_search_buy_currency;
    private Integer last_ad_search_buy_payment_type;
    private BigDecimal last_ad_search_buy_amount;

}
