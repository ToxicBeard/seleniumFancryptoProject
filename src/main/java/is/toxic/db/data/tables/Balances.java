/*
 * This file is generated by jOOQ.
 */
package is.toxic.db.data.tables;


import is.toxic.db.data.Indexes;
import is.toxic.db.data.Keys;
import is.toxic.db.data.Public;
import is.toxic.db.data.tables.records.BalancesRecord;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row6;
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
public class Balances extends TableImpl<BalancesRecord> {

    private static final long serialVersionUID = 1610984427;

    /**
     * The reference instance of <code>public.balances</code>
     */
    public static final Balances BALANCES = new Balances();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<BalancesRecord> getRecordType() {
        return BalancesRecord.class;
    }

    /**
     * The column <code>public.balances.id</code>.
     */
    public final TableField<BalancesRecord, Long> ID = createField(DSL.name("id"), org.jooq.impl.SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>public.balances.owner_id</code>.
     */
    public final TableField<BalancesRecord, Long> OWNER_ID = createField(DSL.name("owner_id"), org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.balances.currency</code>.
     */
    public final TableField<BalancesRecord, Integer> CURRENCY = createField(DSL.name("currency"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.balances.balance</code>.
     */
    public final TableField<BalancesRecord, BigDecimal> BALANCE = createField(DSL.name("balance"), org.jooq.impl.SQLDataType.NUMERIC.nullable(false), this, "");

    /**
     * The column <code>public.balances.unconfirmed_balance</code>.
     */
    public final TableField<BalancesRecord, BigDecimal> UNCONFIRMED_BALANCE = createField(DSL.name("unconfirmed_balance"), org.jooq.impl.SQLDataType.NUMERIC.nullable(false), this, "");

    /**
     * The column <code>public.balances.deposited</code>.
     */
    public final TableField<BalancesRecord, BigDecimal> DEPOSITED = createField(DSL.name("deposited"), org.jooq.impl.SQLDataType.NUMERIC.nullable(false), this, "");

    /**
     * Create a <code>public.balances</code> table reference
     */
    public Balances() {
        this(DSL.name("balances"), null);
    }

    /**
     * Create an aliased <code>public.balances</code> table reference
     */
    public Balances(String alias) {
        this(DSL.name(alias), BALANCES);
    }

    /**
     * Create an aliased <code>public.balances</code> table reference
     */
    public Balances(Name alias) {
        this(alias, BALANCES);
    }

    private Balances(Name alias, Table<BalancesRecord> aliased) {
        this(alias, aliased, null);
    }

    private Balances(Name alias, Table<BalancesRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> Balances(Table<O> child, ForeignKey<O, BalancesRecord> key) {
        super(child, key, BALANCES);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.IX_BALANCES_CURRENCY, Indexes.IX_BALANCES_OWNER_ID);
    }

    @Override
    public Identity<BalancesRecord, Long> getIdentity() {
        return Keys.IDENTITY_BALANCES;
    }

    @Override
    public UniqueKey<BalancesRecord> getPrimaryKey() {
        return Keys.PK_BALANCES;
    }

    @Override
    public List<UniqueKey<BalancesRecord>> getKeys() {
        return Arrays.<UniqueKey<BalancesRecord>>asList(Keys.PK_BALANCES);
    }

    @Override
    public List<ForeignKey<BalancesRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<BalancesRecord, ?>>asList(Keys.BALANCES__FK_BALANCES_USER_DATAS_OWNER_ID);
    }

    public UserDatas userDatas() {
        return new UserDatas(this, Keys.BALANCES__FK_BALANCES_USER_DATAS_OWNER_ID);
    }

    @Override
    public Balances as(String alias) {
        return new Balances(DSL.name(alias), this);
    }

    @Override
    public Balances as(Name alias) {
        return new Balances(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Balances rename(String name) {
        return new Balances(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Balances rename(Name name) {
        return new Balances(name, null);
    }

    // -------------------------------------------------------------------------
    // Row6 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row6<Long, Long, Integer, BigDecimal, BigDecimal, BigDecimal> fieldsRow() {
        return (Row6) super.fieldsRow();
    }
}
