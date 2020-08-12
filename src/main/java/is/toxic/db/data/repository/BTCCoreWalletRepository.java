package is.toxic.db.data.repository;

import lombok.RequiredArgsConstructor;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import is.toxic.db.data.tables.BtcCoreWallets;
import is.toxic.db.data.dto.BTCCoreWallet;
import is.toxic.repository.CrudRepository;

import java.util.List;

@Repository
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class BTCCoreWalletRepository implements CrudRepository<String, BTCCoreWallet> {

    private final DSLContext dsl;

    @Override
    public BTCCoreWallet insert(BTCCoreWallet btcCoreWallet) {
        return dsl.insertInto(BtcCoreWallets.BTC_CORE_WALLETS)
                .set(dsl.newRecord(BtcCoreWallets.BTC_CORE_WALLETS, btcCoreWallet))
                .returning()
                .fetchOne()
                .into(BTCCoreWallet.class);
    }

    @Override
    public BTCCoreWallet update(BTCCoreWallet btcCoreWallet) {
        return dsl.update(BtcCoreWallets.BTC_CORE_WALLETS)
                .set(dsl.newRecord(BtcCoreWallets.BTC_CORE_WALLETS, btcCoreWallet))
                .where(BtcCoreWallets.BTC_CORE_WALLETS.PRIVATE_KEY.eq(btcCoreWallet.getPrivate_key()))
                .returning()
                .fetchOne()
                .into(BTCCoreWallet.class);
    }

    @Override
    public BTCCoreWallet find(String privateKey) {
        return dsl.selectFrom(BtcCoreWallets.BTC_CORE_WALLETS)
                .where(BtcCoreWallets.BTC_CORE_WALLETS.PRIVATE_KEY.eq(privateKey))
                .fetchAny()
                .into(BTCCoreWallet.class);
    }

    @Override
    public List<BTCCoreWallet> findAll(Condition condition) {
        return dsl.selectFrom(BtcCoreWallets.BTC_CORE_WALLETS)
                .where(condition)
                .fetch()
                .into(BTCCoreWallet.class);
    }

    @Override
    public Boolean delete(String privateKey) {
        return dsl.deleteFrom(BtcCoreWallets.BTC_CORE_WALLETS)
                .where(BtcCoreWallets.BTC_CORE_WALLETS.PRIVATE_KEY.eq(privateKey))
                .execute() == SUCCESS_CODE;
    }
}
