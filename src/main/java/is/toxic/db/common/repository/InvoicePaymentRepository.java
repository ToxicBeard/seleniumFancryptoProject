package is.toxic.db.common.repository;

import is.toxic.db.common.dto.InvoicePayment;
import is.toxic.db.data.tables.InvoicePayments;
import is.toxic.repository.CrudRepository;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InvoicePaymentRepository implements CrudRepository<Long, InvoicePayment> {

    private final DSLContext dsl;

    @Autowired
    public InvoicePaymentRepository(@Qualifier("dslData") DSLContext dsl) {
        this.dsl = dsl;
    }

    @Override
    public InvoicePayment insert(InvoicePayment invoicePayment) {
        return dsl.insertInto(InvoicePayments.INVOICE_PAYMENTS)
                .set(dsl.newRecord(InvoicePayments.INVOICE_PAYMENTS, invoicePayment))
                .returning()
                .fetchOne()
                .into(InvoicePayment.class);
    }

    @Override
    public InvoicePayment update(InvoicePayment invoicePayment) {
        return dsl.update(InvoicePayments.INVOICE_PAYMENTS)
                .set(dsl.newRecord(InvoicePayments.INVOICE_PAYMENTS, invoicePayment))
                .where(InvoicePayments.INVOICE_PAYMENTS.ID.eq(invoicePayment.getId()))
                .returning()
                .fetchOne()
                .into(InvoicePayment.class);
    }

    @Override
    public InvoicePayment find(Long id) {
        return dsl.selectFrom(InvoicePayments.INVOICE_PAYMENTS)
                .where(InvoicePayments.INVOICE_PAYMENTS.ID.eq(id))
                .fetchAny()
                .into(InvoicePayment.class);
    }

    @Override
    public InvoicePayment find(Condition condition) {
        return dsl.selectFrom(InvoicePayments.INVOICE_PAYMENTS)
                .where(condition)
                .fetchAny()
                .into(InvoicePayment.class);
    }

    @Override
    public List<InvoicePayment> findAll(Condition condition) {
        return dsl.selectFrom(InvoicePayments.INVOICE_PAYMENTS)
                .where(condition)
                .fetch()
                .into(InvoicePayment.class);
    }

    @Override
    public Boolean delete(Long id) {
        return dsl.deleteFrom(InvoicePayments.INVOICE_PAYMENTS)
                .where(InvoicePayments.INVOICE_PAYMENTS.ID.eq(id))
                .execute() == SUCCESS_CODE;
    }
}
