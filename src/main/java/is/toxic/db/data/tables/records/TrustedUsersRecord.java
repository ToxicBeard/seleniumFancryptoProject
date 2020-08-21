/*
 * This file is generated by jOOQ.
 */
package is.toxic.db.data.tables.records;


import is.toxic.db.data.tables.TrustedUsers;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TrustedUsersRecord extends UpdatableRecordImpl<TrustedUsersRecord> implements Record3<Long, Long, Long> {

    private static final long serialVersionUID = -890633919;

    /**
     * Setter for <code>public.trusted_users.id</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.trusted_users.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.trusted_users.owner_id</code>.
     */
    public void setOwnerId(Long value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.trusted_users.owner_id</code>.
     */
    public Long getOwnerId() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>public.trusted_users.user_id</code>.
     */
    public void setUserId(Long value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.trusted_users.user_id</code>.
     */
    public Long getUserId() {
        return (Long) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row3<Long, Long, Long> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    @Override
    public Row3<Long, Long, Long> valuesRow() {
        return (Row3) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return TrustedUsers.TRUSTED_USERS.ID;
    }

    @Override
    public Field<Long> field2() {
        return TrustedUsers.TRUSTED_USERS.OWNER_ID;
    }

    @Override
    public Field<Long> field3() {
        return TrustedUsers.TRUSTED_USERS.USER_ID;
    }

    @Override
    public Long component1() {
        return getId();
    }

    @Override
    public Long component2() {
        return getOwnerId();
    }

    @Override
    public Long component3() {
        return getUserId();
    }

    @Override
    public Long value1() {
        return getId();
    }

    @Override
    public Long value2() {
        return getOwnerId();
    }

    @Override
    public Long value3() {
        return getUserId();
    }

    @Override
    public TrustedUsersRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public TrustedUsersRecord value2(Long value) {
        setOwnerId(value);
        return this;
    }

    @Override
    public TrustedUsersRecord value3(Long value) {
        setUserId(value);
        return this;
    }

    @Override
    public TrustedUsersRecord values(Long value1, Long value2, Long value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TrustedUsersRecord
     */
    public TrustedUsersRecord() {
        super(TrustedUsers.TRUSTED_USERS);
    }

    /**
     * Create a detached, initialised TrustedUsersRecord
     */
    public TrustedUsersRecord(Long id, Long ownerId, Long userId) {
        super(TrustedUsers.TRUSTED_USERS);

        set(0, id);
        set(1, ownerId);
        set(2, userId);
    }
}
