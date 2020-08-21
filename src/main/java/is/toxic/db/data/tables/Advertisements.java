/*
 * This file is generated by jOOQ.
 */
package is.toxic.db.data.tables;


import is.toxic.db.data.Indexes;
import is.toxic.db.data.Keys;
import is.toxic.db.data.Public;
import is.toxic.db.data.tables.records.AdvertisementsRecord;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row19;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Advertisements extends TableImpl<AdvertisementsRecord> {

    private static final long serialVersionUID = -1952289512;

    /**
     * The reference instance of <code>public.advertisements</code>
     */
    public static final Advertisements ADVERTISEMENTS = new Advertisements();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<AdvertisementsRecord> getRecordType() {
        return AdvertisementsRecord.class;
    }

    /**
     * The column <code>public.advertisements.id</code>.
     */
    public final TableField<AdvertisementsRecord, Long> ID = createField(DSL.name("id"), org.jooq.impl.SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>public.advertisements.equation</code>.
     */
    public final TableField<AdvertisementsRecord, String> EQUATION = createField(DSL.name("equation"), org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.advertisements.min_amount</code>.
     */
    public final TableField<AdvertisementsRecord, BigDecimal> MIN_AMOUNT = createField(DSL.name("min_amount"), org.jooq.impl.SQLDataType.NUMERIC.nullable(false), this, "");

    /**
     * The column <code>public.advertisements.max_amount</code>.
     */
    public final TableField<AdvertisementsRecord, BigDecimal> MAX_AMOUNT = createField(DSL.name("max_amount"), org.jooq.impl.SQLDataType.NUMERIC.nullable(false), this, "");

    /**
     * The column <code>public.advertisements.message</code>.
     */
    public final TableField<AdvertisementsRecord, String> MESSAGE = createField(DSL.name("message"), org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.advertisements.created_at</code>.
     */
    public final TableField<AdvertisementsRecord, LocalDateTime> CREATED_AT = createField(DSL.name("created_at"), org.jooq.impl.SQLDataType.LOCALDATETIME.nullable(false), this, "");

    /**
     * The column <code>public.advertisements.country</code>.
     */
    public final TableField<AdvertisementsRecord, Integer> COUNTRY = createField(DSL.name("country"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.advertisements.payment_type</code>.
     */
    public final TableField<AdvertisementsRecord, Integer> PAYMENT_TYPE = createField(DSL.name("payment_type"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.advertisements.fiat_currency</code>.
     */
    public final TableField<AdvertisementsRecord, Integer> FIAT_CURRENCY = createField(DSL.name("fiat_currency"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.advertisements.crypto_currency</code>.
     */
    public final TableField<AdvertisementsRecord, Integer> CRYPTO_CURRENCY = createField(DSL.name("crypto_currency"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.advertisements.is_buy</code>.
     */
    public final TableField<AdvertisementsRecord, Boolean> IS_BUY = createField(DSL.name("is_buy"), org.jooq.impl.SQLDataType.BOOLEAN.nullable(false), this, "");

    /**
     * The column <code>public.advertisements.owner_id</code>.
     */
    public final TableField<AdvertisementsRecord, Long> OWNER_ID = createField(DSL.name("owner_id"), org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.advertisements.monitor_liquidity</code>.
     */
    public final TableField<AdvertisementsRecord, Boolean> MONITOR_LIQUIDITY = createField(DSL.name("monitor_liquidity"), org.jooq.impl.SQLDataType.BOOLEAN.nullable(false), this, "");

    /**
     * The column <code>public.advertisements.not_anonymous</code>.
     */
    public final TableField<AdvertisementsRecord, Boolean> NOT_ANONYMOUS = createField(DSL.name("not_anonymous"), org.jooq.impl.SQLDataType.BOOLEAN.nullable(false), this, "");

    /**
     * The column <code>public.advertisements.phone_confirmed</code>.
     */
    public final TableField<AdvertisementsRecord, Boolean> PHONE_CONFIRMED = createField(DSL.name("phone_confirmed"), org.jooq.impl.SQLDataType.BOOLEAN.nullable(false), this, "");

    /**
     * The column <code>public.advertisements.trusted</code>.
     */
    public final TableField<AdvertisementsRecord, Boolean> TRUSTED = createField(DSL.name("trusted"), org.jooq.impl.SQLDataType.BOOLEAN.nullable(false), this, "");

    /**
     * The column <code>public.advertisements.title</code>.
     */
    public final TableField<AdvertisementsRecord, String> TITLE = createField(DSL.name("title"), org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.advertisements.window</code>.
     */
    public final TableField<AdvertisementsRecord, Long> WINDOW = createField(DSL.name("window"), org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.advertisements.is_enabled</code>.
     */
    public final TableField<AdvertisementsRecord, Boolean> IS_ENABLED = createField(DSL.name("is_enabled"), org.jooq.impl.SQLDataType.BOOLEAN.nullable(false), this, "");

    /**
     * Create a <code>public.advertisements</code> table reference
     */
    public Advertisements() {
        this(DSL.name("advertisements"), null);
    }

    /**
     * Create an aliased <code>public.advertisements</code> table reference
     */
    public Advertisements(String alias) {
        this(DSL.name(alias), ADVERTISEMENTS);
    }

    /**
     * Create an aliased <code>public.advertisements</code> table reference
     */
    public Advertisements(Name alias) {
        this(alias, ADVERTISEMENTS);
    }

    private Advertisements(Name alias, Table<AdvertisementsRecord> aliased) {
        this(alias, aliased, null);
    }

    private Advertisements(Name alias, Table<AdvertisementsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> Advertisements(Table<O> child, ForeignKey<O, AdvertisementsRecord> key) {
        super(child, key, ADVERTISEMENTS);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.IX_ADVERTISEMENTS_COUNTRY, Indexes.IX_ADVERTISEMENTS_CRYPTO_CURRENCY, Indexes.IX_ADVERTISEMENTS_FIAT_CURRENCY, Indexes.IX_ADVERTISEMENTS_IS_BUY, Indexes.IX_ADVERTISEMENTS_IS_ENABLED, Indexes.IX_ADVERTISEMENTS_MAX_AMOUNT, Indexes.IX_ADVERTISEMENTS_MIN_AMOUNT, Indexes.IX_ADVERTISEMENTS_MONITOR_LIQUIDITY, Indexes.IX_ADVERTISEMENTS_NOT_ANONYMOUS, Indexes.IX_ADVERTISEMENTS_OWNER_ID, Indexes.IX_ADVERTISEMENTS_PAYMENT_TYPE, Indexes.IX_ADVERTISEMENTS_PHONE_CONFIRMED, Indexes.IX_ADVERTISEMENTS_TRUSTED);
    }

    @Override
    public Identity<AdvertisementsRecord, Long> getIdentity() {
        return Keys.IDENTITY_ADVERTISEMENTS;
    }

    @Override
    public UniqueKey<AdvertisementsRecord> getPrimaryKey() {
        return Keys.PK_ADVERTISEMENTS;
    }

    @Override
    public List<UniqueKey<AdvertisementsRecord>> getKeys() {
        return Arrays.<UniqueKey<AdvertisementsRecord>>asList(Keys.PK_ADVERTISEMENTS);
    }

    @Override
    public List<ForeignKey<AdvertisementsRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<AdvertisementsRecord, ?>>asList(Keys.ADVERTISEMENTS__FK_ADVERTISEMENTS_USER_DATAS_OWNER_ID);
    }

    public UserDatas userDatas() {
        return new UserDatas(this, Keys.ADVERTISEMENTS__FK_ADVERTISEMENTS_USER_DATAS_OWNER_ID);
    }

    @Override
    public Advertisements as(String alias) {
        return new Advertisements(DSL.name(alias), this);
    }

    @Override
    public Advertisements as(Name alias) {
        return new Advertisements(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Advertisements rename(String name) {
        return new Advertisements(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Advertisements rename(Name name) {
        return new Advertisements(name, null);
    }

    // -------------------------------------------------------------------------
    // Row19 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row19<Long, String, BigDecimal, BigDecimal, String, LocalDateTime, Integer, Integer, Integer, Integer, Boolean, Long, Boolean, Boolean, Boolean, Boolean, String, Long, Boolean> fieldsRow() {
        return (Row19) super.fieldsRow();
    }
}
