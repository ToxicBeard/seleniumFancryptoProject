package is.toxic.db.common.repository;

import is.toxic.db.common.dto.Invoice;
import is.toxic.db.data.tables.Invoices;
import is.toxic.repository.CrudRepository;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InvoiceRepository implements CrudRepository<Long, Invoice> {

    private final DSLContext dsl;

    @Autowired
    public InvoiceRepository(@Qualifier("dslData") DSLContext dsl) {
        this.dsl = dsl;
    }

    @Override
    public Invoice insert(Invoice invoice) {
        return dsl.insertInto(Invoices.INVOICES)
                .set(dsl.newRecord(Invoices.INVOICES, invoice))
                .returning()
                .fetchOne()
                .into(Invoice.class);
    }

    @Override
    public Invoice update(Invoice invoice) {
        return dsl.update(Invoices.INVOICES)
                .set(dsl.newRecord(Invoices.INVOICES, invoice))
                .where(Invoices.INVOICES.ID.eq(invoice.getId()))
                .returning()
                .fetchOne()
                .into(Invoice.class);
    }

    @Override
    public Invoice find(Long id) {
        return dsl.selectFrom(Invoices.INVOICES)
                .where(Invoices.INVOICES.ID.eq(id))
                .fetchAny()
                .into(Invoice.class);
    }

    @Override
    public Invoice find(Condition condition) {
        return dsl.selectFrom(Invoices.INVOICES)
                .where(condition)
                .fetchAny()
                .into(Invoice.class);
    }

    @Override
    public List<Invoice> findAll(Condition condition) {
        return dsl.selectFrom(Invoices.INVOICES)
                .where(condition)
                .fetch()
                .into(Invoice.class);
    }

    @Override
    public Boolean delete(Long id) {
        return dsl.deleteFrom(Invoices.INVOICES)
                .where(Invoices.INVOICES.ID.eq(id))
                .execute() == SUCCESS_CODE;
    }
}
