/*
 * This file is generated by jOOQ.
 */
package is.toxic.db.data.tables;


import is.toxic.db.data.Indexes;
import is.toxic.db.data.Keys;
import is.toxic.db.data.Public;
import is.toxic.db.data.tables.records.AdMetadataRecord;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row5;
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
public class AdMetadata extends TableImpl<AdMetadataRecord> {

    private static final long serialVersionUID = -1715667612;

    /**
     * The reference instance of <code>public.ad_metadata</code>
     */
    public static final AdMetadata AD_METADATA = new AdMetadata();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<AdMetadataRecord> getRecordType() {
        return AdMetadataRecord.class;
    }

    /**
     * The column <code>public.ad_metadata.id</code>.
     */
    public final TableField<AdMetadataRecord, Long> ID = createField(DSL.name("id"), org.jooq.impl.SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>public.ad_metadata.status</code>.
     */
    public final TableField<AdMetadataRecord, Integer> STATUS = createField(DSL.name("status"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.ad_metadata.max_amount</code>.
     */
    public final TableField<AdMetadataRecord, BigDecimal> MAX_AMOUNT = createField(DSL.name("max_amount"), org.jooq.impl.SQLDataType.NUMERIC.nullable(false), this, "");

    /**
     * The column <code>public.ad_metadata.price</code>.
     */
    public final TableField<AdMetadataRecord, BigDecimal> PRICE = createField(DSL.name("price"), org.jooq.impl.SQLDataType.NUMERIC.nullable(false), this, "");

    /**
     * The column <code>public.ad_metadata.advertisement_id</code>.
     */
    public final TableField<AdMetadataRecord, Long> ADVERTISEMENT_ID = createField(DSL.name("advertisement_id"), org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * Create a <code>public.ad_metadata</code> table reference
     */
    public AdMetadata() {
        this(DSL.name("ad_metadata"), null);
    }

    /**
     * Create an aliased <code>public.ad_metadata</code> table reference
     */
    public AdMetadata(String alias) {
        this(DSL.name(alias), AD_METADATA);
    }

    /**
     * Create an aliased <code>public.ad_metadata</code> table reference
     */
    public AdMetadata(Name alias) {
        this(alias, AD_METADATA);
    }

    private AdMetadata(Name alias, Table<AdMetadataRecord> aliased) {
        this(alias, aliased, null);
    }

    private AdMetadata(Name alias, Table<AdMetadataRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> AdMetadata(Table<O> child, ForeignKey<O, AdMetadataRecord> key) {
        super(child, key, AD_METADATA);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.IX_AD_METADATA_ADVERTISEMENT_ID, Indexes.IX_AD_METADATA_MAX_AMOUNT, Indexes.IX_AD_METADATA_PRICE, Indexes.IX_AD_METADATA_STATUS);
    }

    @Override
    public Identity<AdMetadataRecord, Long> getIdentity() {
        return Keys.IDENTITY_AD_METADATA;
    }

    @Override
    public UniqueKey<AdMetadataRecord> getPrimaryKey() {
        return Keys.PK_AD_METADATA;
    }

    @Override
    public List<UniqueKey<AdMetadataRecord>> getKeys() {
        return Arrays.<UniqueKey<AdMetadataRecord>>asList(Keys.PK_AD_METADATA);
    }

    @Override
    public List<ForeignKey<AdMetadataRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<AdMetadataRecord, ?>>asList(Keys.AD_METADATA__FK_AD_METADATA_ADVERTISEMENTS_ADVERTISEMENT_ID);
    }

    public Advertisements advertisements() {
        return new Advertisements(this, Keys.AD_METADATA__FK_AD_METADATA_ADVERTISEMENTS_ADVERTISEMENT_ID);
    }

    @Override
    public AdMetadata as(String alias) {
        return new AdMetadata(DSL.name(alias), this);
    }

    @Override
    public AdMetadata as(Name alias) {
        return new AdMetadata(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public AdMetadata rename(String name) {
        return new AdMetadata(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public AdMetadata rename(Name name) {
        return new AdMetadata(name, null);
    }

    // -------------------------------------------------------------------------
    // Row5 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row5<Long, Integer, BigDecimal, BigDecimal, Long> fieldsRow() {
        return (Row5) super.fieldsRow();
    }
}
