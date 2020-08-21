/*
 * This file is generated by jOOQ.
 */
package is.toxic.db.data.tables.records;


import is.toxic.db.data.tables.TimeTables;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.Row5;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TimeTablesRecord extends UpdatableRecordImpl<TimeTablesRecord> implements Record5<Long, Integer, Short, Short, Long> {

    private static final long serialVersionUID = 1890861883;

    /**
     * Setter for <code>public.time_tables.id</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.time_tables.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.time_tables.day</code>.
     */
    public void setDay(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.time_tables.day</code>.
     */
    public Integer getDay() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>public.time_tables.start</code>.
     */
    public void setStart(Short value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.time_tables.start</code>.
     */
    public Short getStart() {
        return (Short) get(2);
    }

    /**
     * Setter for <code>public.time_tables.end</code>.
     */
    public void setEnd(Short value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.time_tables.end</code>.
     */
    public Short getEnd() {
        return (Short) get(3);
    }

    /**
     * Setter for <code>public.time_tables.advertisement_id</code>.
     */
    public void setAdvertisementId(Long value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.time_tables.advertisement_id</code>.
     */
    public Long getAdvertisementId() {
        return (Long) get(4);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record5 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row5<Long, Integer, Short, Short, Long> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    @Override
    public Row5<Long, Integer, Short, Short, Long> valuesRow() {
        return (Row5) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return TimeTables.TIME_TABLES.ID;
    }

    @Override
    public Field<Integer> field2() {
        return TimeTables.TIME_TABLES.DAY;
    }

    @Override
    public Field<Short> field3() {
        return TimeTables.TIME_TABLES.START;
    }

    @Override
    public Field<Short> field4() {
        return TimeTables.TIME_TABLES.END;
    }

    @Override
    public Field<Long> field5() {
        return TimeTables.TIME_TABLES.ADVERTISEMENT_ID;
    }

    @Override
    public Long component1() {
        return getId();
    }

    @Override
    public Integer component2() {
        return getDay();
    }

    @Override
    public Short component3() {
        return getStart();
    }

    @Override
    public Short component4() {
        return getEnd();
    }

    @Override
    public Long component5() {
        return getAdvertisementId();
    }

    @Override
    public Long value1() {
        return getId();
    }

    @Override
    public Integer value2() {
        return getDay();
    }

    @Override
    public Short value3() {
        return getStart();
    }

    @Override
    public Short value4() {
        return getEnd();
    }

    @Override
    public Long value5() {
        return getAdvertisementId();
    }

    @Override
    public TimeTablesRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public TimeTablesRecord value2(Integer value) {
        setDay(value);
        return this;
    }

    @Override
    public TimeTablesRecord value3(Short value) {
        setStart(value);
        return this;
    }

    @Override
    public TimeTablesRecord value4(Short value) {
        setEnd(value);
        return this;
    }

    @Override
    public TimeTablesRecord value5(Long value) {
        setAdvertisementId(value);
        return this;
    }

    @Override
    public TimeTablesRecord values(Long value1, Integer value2, Short value3, Short value4, Long value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TimeTablesRecord
     */
    public TimeTablesRecord() {
        super(TimeTables.TIME_TABLES);
    }

    /**
     * Create a detached, initialised TimeTablesRecord
     */
    public TimeTablesRecord(Long id, Integer day, Short start, Short end, Long advertisementId) {
        super(TimeTables.TIME_TABLES);

        set(0, id);
        set(1, day);
        set(2, start);
        set(3, end);
        set(4, advertisementId);
    }
}
