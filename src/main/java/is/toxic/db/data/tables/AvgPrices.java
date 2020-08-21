/*
 * This file is generated by jOOQ.
 */
package is.toxic.db.data.tables;


import is.toxic.db.data.Indexes;
import is.toxic.db.data.Keys;
import is.toxic.db.data.Public;
import is.toxic.db.data.tables.records.AvgPricesRecord;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row4;
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
public class AvgPrices extends TableImpl<AvgPricesRecord> {

    private static final long serialVersionUID = 1242813972;

    /**
     * The reference instance of <code>public.avg_prices</code>
     */
    public static final AvgPrices AVG_PRICES = new AvgPrices();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<AvgPricesRecord> getRecordType() {
        return AvgPricesRecord.class;
    }

    /**
     * The column <code>public.avg_prices.id</code>.
     */
    public final TableField<AvgPricesRecord, Integer> ID = createField(DSL.name("id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>public.avg_prices.fiat_currency</code>.
     */
    public final TableField<AvgPricesRecord, Integer> FIAT_CURRENCY = createField(DSL.name("fiat_currency"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.avg_prices.crypto_currency</code>.
     */
    public final TableField<AvgPricesRecord, Integer> CRYPTO_CURRENCY = createField(DSL.name("crypto_currency"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.avg_prices.value</code>.
     */
    public final TableField<AvgPricesRecord, BigDecimal> VALUE = createField(DSL.name("value"), org.jooq.impl.SQLDataType.NUMERIC.nullable(false), this, "");

    /**
     * Create a <code>public.avg_prices</code> table reference
     */
    public AvgPrices() {
        this(DSL.name("avg_prices"), null);
    }

    /**
     * Create an aliased <code>public.avg_prices</code> table reference
     */
    public AvgPrices(String alias) {
        this(DSL.name(alias), AVG_PRICES);
    }

    /**
     * Create an aliased <code>public.avg_prices</code> table reference
     */
    public AvgPrices(Name alias) {
        this(alias, AVG_PRICES);
    }

    private AvgPrices(Name alias, Table<AvgPricesRecord> aliased) {
        this(alias, aliased, null);
    }

    private AvgPrices(Name alias, Table<AvgPricesRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> AvgPrices(Table<O> child, ForeignKey<O, AvgPricesRecord> key) {
        super(child, key, AVG_PRICES);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.IX_AVG_PRICES_CRYPTO_CURRENCY, Indexes.IX_AVG_PRICES_FIAT_CURRENCY);
    }

    @Override
    public Identity<AvgPricesRecord, Integer> getIdentity() {
        return Keys.IDENTITY_AVG_PRICES;
    }

    @Override
    public UniqueKey<AvgPricesRecord> getPrimaryKey() {
        return Keys.PK_AVG_PRICES;
    }

    @Override
    public List<UniqueKey<AvgPricesRecord>> getKeys() {
        return Arrays.<UniqueKey<AvgPricesRecord>>asList(Keys.PK_AVG_PRICES);
    }

    @Override
    public AvgPrices as(String alias) {
        return new AvgPrices(DSL.name(alias), this);
    }

    @Override
    public AvgPrices as(Name alias) {
        return new AvgPrices(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public AvgPrices rename(String name) {
        return new AvgPrices(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public AvgPrices rename(Name name) {
        return new AvgPrices(name, null);
    }

    // -------------------------------------------------------------------------
    // Row4 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row4<Integer, Integer, Integer, BigDecimal> fieldsRow() {
        return (Row4) super.fieldsRow();
    }
}
