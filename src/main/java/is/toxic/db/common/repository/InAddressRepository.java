package is.toxic.db.common.repository;

import is.toxic.db.common.dto.InAddress;
import is.toxic.db.data.tables.InAddresses;
import is.toxic.repository.CrudRepository;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InAddressRepository implements CrudRepository<Long, InAddress> {

    private final DSLContext dsl;

    @Autowired
    public InAddressRepository(@Qualifier("dslData") DSLContext dsl) {
        this.dsl = dsl;
    }

    @Override
    public InAddress insert(InAddress inAddress) {
        return dsl.insertInto(InAddresses.IN_ADDRESSES)
                .set(dsl.newRecord(InAddresses.IN_ADDRESSES, inAddress))
                .returning()
                .fetchOne()
                .into(InAddress.class);
    }

    @Override
    public InAddress update(InAddress inAddress) {
        return dsl.update(InAddresses.IN_ADDRESSES)
                .set(dsl.newRecord(InAddresses.IN_ADDRESSES, inAddress))
                .where(InAddresses.IN_ADDRESSES.ID.eq(inAddress.getId()))
                .returning()
                .fetchOne()
                .into(InAddress.class);
    }

    @Override
    public InAddress find(Long id) {
        return dsl.selectFrom(InAddresses.IN_ADDRESSES)
                .where(InAddresses.IN_ADDRESSES.ID.eq(id))
                .fetchAny()
                .into(InAddress.class);
    }

    @Override
    public InAddress find(Condition condition) {
        return dsl.selectFrom(InAddresses.IN_ADDRESSES)
                .where(condition)
                .fetchAny()
                .into(InAddress.class);
    }

    @Override
    public List<InAddress> findAll(Condition condition) {
        return dsl.selectFrom(InAddresses.IN_ADDRESSES)
                .where(condition)
                .fetch()
                .into(InAddress.class);
    }

    @Override
    public Boolean delete(Long id) {
        return dsl.deleteFrom(InAddresses.IN_ADDRESSES)
                .where(InAddresses.IN_ADDRESSES.ID.eq(id))
                .execute() == SUCCESS_CODE;
    }
}
