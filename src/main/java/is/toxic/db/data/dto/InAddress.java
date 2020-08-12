package is.toxic.db.data.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InAddress {
    private Long id;
    private String address;
    private String btc_core_wallet_private_key;
    private Long owner_id;
    private Boolean is_bech32;
}
