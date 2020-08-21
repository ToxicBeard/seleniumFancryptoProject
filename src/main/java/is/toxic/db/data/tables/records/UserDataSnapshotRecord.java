/*
 * This file is generated by jOOQ.
 */
package is.toxic.db.data.tables.records;


import is.toxic.db.data.tables.UserDataSnapshot;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.jooq.Record1;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UserDataSnapshotRecord extends UpdatableRecordImpl<UserDataSnapshotRecord> {

    private static final long serialVersionUID = 1666495207;

    /**
     * Setter for <code>public.user_data_snapshot.key</code>.
     */
    public void setKey(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.user_data_snapshot.key</code>.
     */
    public Long getKey() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.user_data_snapshot.id</code>.
     */
    public void setId(Long value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.user_data_snapshot.id</code>.
     */
    public Long getId() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>public.user_data_snapshot.user_id</code>.
     */
    public void setUserId(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.user_data_snapshot.user_id</code>.
     */
    public String getUserId() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.user_data_snapshot.user_name</code>.
     */
    public void setUserName(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.user_data_snapshot.user_name</code>.
     */
    public String getUserName() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.user_data_snapshot.trades_avg_amount</code>.
     */
    public void setTradesAvgAmount(BigDecimal value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.user_data_snapshot.trades_avg_amount</code>.
     */
    public BigDecimal getTradesAvgAmount() {
        return (BigDecimal) get(4);
    }

    /**
     * Setter for <code>public.user_data_snapshot.trades_count</code>.
     */
    public void setTradesCount(Long value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.user_data_snapshot.trades_count</code>.
     */
    public Long getTradesCount() {
        return (Long) get(5);
    }

    /**
     * Setter for <code>public.user_data_snapshot.counterpartys_count</code>.
     */
    public void setCounterpartysCount(Long value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.user_data_snapshot.counterpartys_count</code>.
     */
    public Long getCounterpartysCount() {
        return (Long) get(6);
    }

    /**
     * Setter for <code>public.user_data_snapshot.response_rate</code>.
     */
    public void setResponseRate(BigDecimal value) {
        set(7, value);
    }

    /**
     * Getter for <code>public.user_data_snapshot.response_rate</code>.
     */
    public BigDecimal getResponseRate() {
        return (BigDecimal) get(7);
    }

    /**
     * Setter for <code>public.user_data_snapshot.first_trade_date</code>.
     */
    public void setFirstTradeDate(LocalDateTime value) {
        set(8, value);
    }

    /**
     * Getter for <code>public.user_data_snapshot.first_trade_date</code>.
     */
    public LocalDateTime getFirstTradeDate() {
        return (LocalDateTime) get(8);
    }

    /**
     * Setter for <code>public.user_data_snapshot.is_identity_verifed</code>.
     */
    public void setIsIdentityVerifed(Boolean value) {
        set(9, value);
    }

    /**
     * Getter for <code>public.user_data_snapshot.is_identity_verifed</code>.
     */
    public Boolean getIsIdentityVerifed() {
        return (Boolean) get(9);
    }

    /**
     * Setter for <code>public.user_data_snapshot.trusted_count</code>.
     */
    public void setTrustedCount(Long value) {
        set(10, value);
    }

    /**
     * Getter for <code>public.user_data_snapshot.trusted_count</code>.
     */
    public Long getTrustedCount() {
        return (Long) get(10);
    }

    /**
     * Setter for <code>public.user_data_snapshot.blocked_count</code>.
     */
    public void setBlockedCount(Long value) {
        set(11, value);
    }

    /**
     * Getter for <code>public.user_data_snapshot.blocked_count</code>.
     */
    public Long getBlockedCount() {
        return (Long) get(11);
    }

    /**
     * Setter for <code>public.user_data_snapshot.avg_delay_seconds</code>.
     */
    public void setAvgDelaySeconds(Long value) {
        set(12, value);
    }

    /**
     * Getter for <code>public.user_data_snapshot.avg_delay_seconds</code>.
     */
    public Long getAvgDelaySeconds() {
        return (Long) get(12);
    }

    /**
     * Setter for <code>public.user_data_snapshot.median_delay_seconds</code>.
     */
    public void setMedianDelaySeconds(Long value) {
        set(13, value);
    }

    /**
     * Getter for <code>public.user_data_snapshot.median_delay_seconds</code>.
     */
    public Long getMedianDelaySeconds() {
        return (Long) get(13);
    }

    /**
     * Setter for <code>public.user_data_snapshot.time_zone</code>.
     */
    public void setTimeZone(String value) {
        set(14, value);
    }

    /**
     * Getter for <code>public.user_data_snapshot.time_zone</code>.
     */
    public String getTimeZone() {
        return (String) get(14);
    }

    /**
     * Setter for <code>public.user_data_snapshot.introduction</code>.
     */
    public void setIntroduction(String value) {
        set(15, value);
    }

    /**
     * Getter for <code>public.user_data_snapshot.introduction</code>.
     */
    public String getIntroduction() {
        return (String) get(15);
    }

    /**
     * Setter for <code>public.user_data_snapshot.site</code>.
     */
    public void setSite(String value) {
        set(16, value);
    }

    /**
     * Getter for <code>public.user_data_snapshot.site</code>.
     */
    public String getSite() {
        return (String) get(16);
    }

    /**
     * Setter for <code>public.user_data_snapshot.sales_disabled</code>.
     */
    public void setSalesDisabled(Boolean value) {
        set(17, value);
    }

    /**
     * Getter for <code>public.user_data_snapshot.sales_disabled</code>.
     */
    public Boolean getSalesDisabled() {
        return (Boolean) get(17);
    }

    /**
     * Setter for <code>public.user_data_snapshot.buys_disabled</code>.
     */
    public void setBuysDisabled(Boolean value) {
        set(18, value);
    }

    /**
     * Getter for <code>public.user_data_snapshot.buys_disabled</code>.
     */
    public Boolean getBuysDisabled() {
        return (Boolean) get(18);
    }

    /**
     * Setter for <code>public.user_data_snapshot.send_sms_contacts_notification</code>.
     */
    public void setSendSmsContactsNotification(Boolean value) {
        set(19, value);
    }

    /**
     * Getter for <code>public.user_data_snapshot.send_sms_contacts_notification</code>.
     */
    public Boolean getSendSmsContactsNotification() {
        return (Boolean) get(19);
    }

    /**
     * Setter for <code>public.user_data_snapshot.send_sms_payments_notifications</code>.
     */
    public void setSendSmsPaymentsNotifications(Boolean value) {
        set(20, value);
    }

    /**
     * Getter for <code>public.user_data_snapshot.send_sms_payments_notifications</code>.
     */
    public Boolean getSendSmsPaymentsNotifications() {
        return (Boolean) get(20);
    }

    /**
     * Setter for <code>public.user_data_snapshot.send_crypto_deposit_notifications</code>.
     */
    public void setSendCryptoDepositNotifications(Boolean value) {
        set(21, value);
    }

    /**
     * Getter for <code>public.user_data_snapshot.send_crypto_deposit_notifications</code>.
     */
    public Boolean getSendCryptoDepositNotifications() {
        return (Boolean) get(21);
    }

    /**
     * Setter for <code>public.user_data_snapshot.show_me_as_having_verified_real_name</code>.
     */
    public void setShowMeAsHavingVerifiedRealName(Boolean value) {
        set(22, value);
    }

    /**
     * Getter for <code>public.user_data_snapshot.show_me_as_having_verified_real_name</code>.
     */
    public Boolean getShowMeAsHavingVerifiedRealName() {
        return (Boolean) get(22);
    }

    /**
     * Setter for <code>public.user_data_snapshot.disable_confidential_information_from_email</code>.
     */
    public void setDisableConfidentialInformationFromEmail(Boolean value) {
        set(23, value);
    }

    /**
     * Getter for <code>public.user_data_snapshot.disable_confidential_information_from_email</code>.
     */
    public Boolean getDisableConfidentialInformationFromEmail() {
        return (Boolean) get(23);
    }

    /**
     * Setter for <code>public.user_data_snapshot.enable_web_notifications</code>.
     */
    public void setEnableWebNotifications(Boolean value) {
        set(24, value);
    }

    /**
     * Getter for <code>public.user_data_snapshot.enable_web_notifications</code>.
     */
    public Boolean getEnableWebNotifications() {
        return (Boolean) get(24);
    }

    /**
     * Setter for <code>public.user_data_snapshot.created_at</code>.
     */
    public void setCreatedAt(LocalDateTime value) {
        set(25, value);
    }

    /**
     * Getter for <code>public.user_data_snapshot.created_at</code>.
     */
    public LocalDateTime getCreatedAt() {
        return (LocalDateTime) get(25);
    }

    /**
     * Setter for <code>public.user_data_snapshot.is_anonymous</code>.
     */
    public void setIsAnonymous(Boolean value) {
        set(26, value);
    }

    /**
     * Getter for <code>public.user_data_snapshot.is_anonymous</code>.
     */
    public Boolean getIsAnonymous() {
        return (Boolean) get(26);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached UserDataSnapshotRecord
     */
    public UserDataSnapshotRecord() {
        super(UserDataSnapshot.USER_DATA_SNAPSHOT);
    }

    /**
     * Create a detached, initialised UserDataSnapshotRecord
     */
    public UserDataSnapshotRecord(Long key, Long id, String userId, String userName, BigDecimal tradesAvgAmount, Long tradesCount, Long counterpartysCount, BigDecimal responseRate, LocalDateTime firstTradeDate, Boolean isIdentityVerifed, Long trustedCount, Long blockedCount, Long avgDelaySeconds, Long medianDelaySeconds, String timeZone, String introduction, String site, Boolean salesDisabled, Boolean buysDisabled, Boolean sendSmsContactsNotification, Boolean sendSmsPaymentsNotifications, Boolean sendCryptoDepositNotifications, Boolean showMeAsHavingVerifiedRealName, Boolean disableConfidentialInformationFromEmail, Boolean enableWebNotifications, LocalDateTime createdAt, Boolean isAnonymous) {
        super(UserDataSnapshot.USER_DATA_SNAPSHOT);

        set(0, key);
        set(1, id);
        set(2, userId);
        set(3, userName);
        set(4, tradesAvgAmount);
        set(5, tradesCount);
        set(6, counterpartysCount);
        set(7, responseRate);
        set(8, firstTradeDate);
        set(9, isIdentityVerifed);
        set(10, trustedCount);
        set(11, blockedCount);
        set(12, avgDelaySeconds);
        set(13, medianDelaySeconds);
        set(14, timeZone);
        set(15, introduction);
        set(16, site);
        set(17, salesDisabled);
        set(18, buysDisabled);
        set(19, sendSmsContactsNotification);
        set(20, sendSmsPaymentsNotifications);
        set(21, sendCryptoDepositNotifications);
        set(22, showMeAsHavingVerifiedRealName);
        set(23, disableConfidentialInformationFromEmail);
        set(24, enableWebNotifications);
        set(25, createdAt);
        set(26, isAnonymous);
    }
}
