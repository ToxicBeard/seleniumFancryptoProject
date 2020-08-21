/*
 * This file is generated by jOOQ.
 */
package is.toxic.db.data.tables;


import is.toxic.db.data.Indexes;
import is.toxic.db.data.Keys;
import is.toxic.db.data.Public;
import is.toxic.db.data.tables.records.LastAdSearchParamsRecord;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row7;
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
public class LastAdSearchParams extends TableImpl<LastAdSearchParamsRecord> {

    private static final long serialVersionUID = -156801258;

    /**
     * The reference instance of <code>public.last_ad_search_params</code>
     */
    public static final LastAdSearchParams LAST_AD_SEARCH_PARAMS = new LastAdSearchParams();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<LastAdSearchParamsRecord> getRecordType() {
        return LastAdSearchParamsRecord.class;
    }

    /**
     * The column <code>public.last_ad_search_params.id</code>.
     */
    public final TableField<LastAdSearchParamsRecord, Long> ID = createField(DSL.name("id"), org.jooq.impl.SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>public.last_ad_search_params.owner_fk</code>.
     */
    public final TableField<LastAdSearchParamsRecord, Long> OWNER_FK = createField(DSL.name("owner_fk"), org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * The column <code>public.last_ad_search_params.country</code>.
     */
    public final TableField<LastAdSearchParamsRecord, Integer> COUNTRY = createField(DSL.name("country"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.last_ad_search_params.currency</code>.
     */
    public final TableField<LastAdSearchParamsRecord, Integer> CURRENCY = createField(DSL.name("currency"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.last_ad_search_params.payment_type</code>.
     */
    public final TableField<LastAdSearchParamsRecord, Integer> PAYMENT_TYPE = createField(DSL.name("payment_type"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.last_ad_search_params.amount</code>.
     */
    public final TableField<LastAdSearchParamsRecord, BigDecimal> AMOUNT = createField(DSL.name("amount"), org.jooq.impl.SQLDataType.NUMERIC.nullable(false), this, "");

    /**
     * The column <code>public.last_ad_search_params.is_buy</code>.
     */
    public final TableField<LastAdSearchParamsRecord, Boolean> IS_BUY = createField(DSL.name("is_buy"), org.jooq.impl.SQLDataType.BOOLEAN.nullable(false), this, "");

    /**
     * Create a <code>public.last_ad_search_params</code> table reference
     */
    public LastAdSearchParams() {
        this(DSL.name("last_ad_search_params"), null);
    }

    /**
     * Create an aliased <code>public.last_ad_search_params</code> table reference
     */
    public LastAdSearchParams(String alias) {
        this(DSL.name(alias), LAST_AD_SEARCH_PARAMS);
    }

    /**
     * Create an aliased <code>public.last_ad_search_params</code> table reference
     */
    public LastAdSearchParams(Name alias) {
        this(alias, LAST_AD_SEARCH_PARAMS);
    }

    private LastAdSearchParams(Name alias, Table<LastAdSearchParamsRecord> aliased) {
        this(alias, aliased, null);
    }

    private LastAdSearchParams(Name alias, Table<LastAdSearchParamsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> LastAdSearchParams(Table<O> child, ForeignKey<O, LastAdSearchParamsRecord> key) {
        super(child, key, LAST_AD_SEARCH_PARAMS);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.IX_LAST_AD_SEARCH_PARAMS_IS_BUY, Indexes.IX_LAST_AD_SEARCH_PARAMS_OWNER_FK);
    }

    @Override
    public Identity<LastAdSearchParamsRecord, Long> getIdentity() {
        return Keys.IDENTITY_LAST_AD_SEARCH_PARAMS;
    }

    @Override
    public UniqueKey<LastAdSearchParamsRecord> getPrimaryKey() {
        return Keys.PK_LAST_AD_SEARCH_PARAMS;
    }

    @Override
    public List<UniqueKey<LastAdSearchParamsRecord>> getKeys() {
        return Arrays.<UniqueKey<LastAdSearchParamsRecord>>asList(Keys.PK_LAST_AD_SEARCH_PARAMS);
    }

    @Override
    public List<ForeignKey<LastAdSearchParamsRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<LastAdSearchParamsRecord, ?>>asList(Keys.LAST_AD_SEARCH_PARAMS__FK_LAST_AD_SEARCH_PARAMS_USER_DATAS_OWNER_FK);
    }

    public UserDatas userDatas() {
        return new UserDatas(this, Keys.LAST_AD_SEARCH_PARAMS__FK_LAST_AD_SEARCH_PARAMS_USER_DATAS_OWNER_FK);
    }

    @Override
    public LastAdSearchParams as(String alias) {
        return new LastAdSearchParams(DSL.name(alias), this);
    }

    @Override
    public LastAdSearchParams as(Name alias) {
        return new LastAdSearchParams(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public LastAdSearchParams rename(String name) {
        return new LastAdSearchParams(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public LastAdSearchParams rename(Name name) {
        return new LastAdSearchParams(name, null);
    }

    // -------------------------------------------------------------------------
    // Row7 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row7<Long, Long, Integer, Integer, Integer, BigDecimal, Boolean> fieldsRow() {
        return (Row7) super.fieldsRow();
    }
}
