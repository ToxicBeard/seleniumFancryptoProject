package is.toxic.db.data.repository;

import is.toxic.db.data.dto.Invoice;
import is.toxic.db.data.tables.Invoices;
import is.toxic.repository.CrudRepository;
import lombok.RequiredArgsConstructor;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class InvoiceRepository implements CrudRepository<Long, Invoice> {

    private final DSLContext dsl;

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
