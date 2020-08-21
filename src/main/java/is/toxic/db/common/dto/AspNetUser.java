package is.toxic.db.common.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Data
@Builder
public class AspNetUser {

    private String id;
    private String user_name;
    private String normalized_user_name;
    private String email;
    private String normalized_email;
    private Boolean email_confirmed;
    private String password_hash;
    private String security_stamp;
    private String concurrency_stamp;
    private String phone_number;
    private Boolean phone_number_confirmed;
    private Boolean two_factor_enabled;
    private OffsetDateTime lockout_end;
    private Boolean ockout_enabled;
    private Integer access_failed_count;
    private String two_fa_secret;
    private LocalDateTime last_sms_sent;
    private LocalDateTime last_online;
    private String reference_token;
    private LocalDateTime reference_token_created_at;
    private LocalDateTime created_at;
    private Boolean is_anonymous;
    private Integer telegram_id;
}
