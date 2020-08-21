/*
 * This file is generated by jOOQ.
 */
package is.toxic.db.data.tables.records;


import is.toxic.db.data.tables.CryptoExchangeVariables;

import java.math.BigDecimal;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CryptoExchangeVariablesRecord extends UpdatableRecordImpl<CryptoExchangeVariablesRecord> implements Record2<Integer, BigDecimal> {

    private static final long serialVersionUID = -1627391835;

    /**
     * Setter for <code>public.crypto_exchange_variables.key</code>.
     */
    public void setKey(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.crypto_exchange_variables.key</code>.
     */
    public Integer getKey() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.crypto_exchange_variables.value</code>.
     */
    public void setValue(BigDecimal value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.crypto_exchange_variables.value</code>.
     */
    public BigDecimal getValue() {
        return (BigDecimal) get(1);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row2<Integer, BigDecimal> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    @Override
    public Row2<Integer, BigDecimal> valuesRow() {
        return (Row2) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return CryptoExchangeVariables.CRYPTO_EXCHANGE_VARIABLES.KEY;
    }

    @Override
    public Field<BigDecimal> field2() {
        return CryptoExchangeVariables.CRYPTO_EXCHANGE_VARIABLES.VALUE;
    }

    @Override
    public Integer component1() {
        return getKey();
    }

    @Override
    public BigDecimal component2() {
        return getValue();
    }

    @Override
    public Integer value1() {
        return getKey();
    }

    @Override
    public BigDecimal value2() {
        return getValue();
    }

    @Override
    public CryptoExchangeVariablesRecord value1(Integer value) {
        setKey(value);
        return this;
    }

    @Override
    public CryptoExchangeVariablesRecord value2(BigDecimal value) {
        setValue(value);
        return this;
    }

    @Override
    public CryptoExchangeVariablesRecord values(Integer value1, BigDecimal value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached CryptoExchangeVariablesRecord
     */
    public CryptoExchangeVariablesRecord() {
        super(CryptoExchangeVariables.CRYPTO_EXCHANGE_VARIABLES);
    }

    /**
     * Create a detached, initialised CryptoExchangeVariablesRecord
     */
    public CryptoExchangeVariablesRecord(Integer key, BigDecimal value) {
        super(CryptoExchangeVariables.CRYPTO_EXCHANGE_VARIABLES);

        set(0, key);
        set(1, value);
    }
}
