/*
 * This file is generated by jOOQ.
 */
package is.toxic.db.data.tables;


import is.toxic.db.data.Keys;
import is.toxic.db.data.Public;
import is.toxic.db.data.tables.records.FiatExchangeVariablesRecord;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row2;
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
public class FiatExchangeVariables extends TableImpl<FiatExchangeVariablesRecord> {

    private static final long serialVersionUID = -1257539595;

    /**
     * The reference instance of <code>public.fiat_exchange_variables</code>
     */
    public static final FiatExchangeVariables FIAT_EXCHANGE_VARIABLES = new FiatExchangeVariables();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<FiatExchangeVariablesRecord> getRecordType() {
        return FiatExchangeVariablesRecord.class;
    }

    /**
     * The column <code>public.fiat_exchange_variables.key</code>.
     */
    public final TableField<FiatExchangeVariablesRecord, Integer> KEY = createField(DSL.name("key"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.fiat_exchange_variables.value</code>.
     */
    public final TableField<FiatExchangeVariablesRecord, BigDecimal> VALUE = createField(DSL.name("value"), org.jooq.impl.SQLDataType.NUMERIC.nullable(false), this, "");

    /**
     * Create a <code>public.fiat_exchange_variables</code> table reference
     */
    public FiatExchangeVariables() {
        this(DSL.name("fiat_exchange_variables"), null);
    }

    /**
     * Create an aliased <code>public.fiat_exchange_variables</code> table reference
     */
    public FiatExchangeVariables(String alias) {
        this(DSL.name(alias), FIAT_EXCHANGE_VARIABLES);
    }

    /**
     * Create an aliased <code>public.fiat_exchange_variables</code> table reference
     */
    public FiatExchangeVariables(Name alias) {
        this(alias, FIAT_EXCHANGE_VARIABLES);
    }

    private FiatExchangeVariables(Name alias, Table<FiatExchangeVariablesRecord> aliased) {
        this(alias, aliased, null);
    }

    private FiatExchangeVariables(Name alias, Table<FiatExchangeVariablesRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> FiatExchangeVariables(Table<O> child, ForeignKey<O, FiatExchangeVariablesRecord> key) {
        super(child, key, FIAT_EXCHANGE_VARIABLES);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public UniqueKey<FiatExchangeVariablesRecord> getPrimaryKey() {
        return Keys.PK_FIAT_EXCHANGE_VARIABLES;
    }

    @Override
    public List<UniqueKey<FiatExchangeVariablesRecord>> getKeys() {
        return Arrays.<UniqueKey<FiatExchangeVariablesRecord>>asList(Keys.PK_FIAT_EXCHANGE_VARIABLES);
    }

    @Override
    public FiatExchangeVariables as(String alias) {
        return new FiatExchangeVariables(DSL.name(alias), this);
    }

    @Override
    public FiatExchangeVariables as(Name alias) {
        return new FiatExchangeVariables(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public FiatExchangeVariables rename(String name) {
        return new FiatExchangeVariables(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public FiatExchangeVariables rename(Name name) {
        return new FiatExchangeVariables(name, null);
    }

    // -------------------------------------------------------------------------
    // Row2 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row2<Integer, BigDecimal> fieldsRow() {
        return (Row2) super.fieldsRow();
    }
}
