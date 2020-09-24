//package is.toxic.db.common.repository;
//
//import is.toxic.db.common.dto.Disput;
//import is.toxic.db.data.tables.Disputes;
//import is.toxic.repository.CrudRepository;
//import org.jooq.Condition;
//import org.jooq.DSLContext;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public class DisputesRepository implements CrudRepository<Long, Disput> {
//
//    private final DSLContext dsl;
//
//    @Autowired
//    public DisputesRepository(@Qualifier("dslData") DSLContext dsl) {
//        this.dsl = dsl;
//    }
//
//    @Override
//    public Disput insert(Disput disput) {
//        return dsl.insertInto(Disputes.DISPUTES)
//                .set(dsl.newRecord(Disputes.DISPUTES, disput))
//                .returning()
//                .fetchOne()
//                .into(Disput.class);
//    }
//
//    @Override
//    public Disput update(Disput disput) {
//        return dsl.update(Disputes.DISPUTES)
//                .set(dsl.newRecord(Disputes.DISPUTES, disput))
//                .where(Disputes.DISPUTES.ID.eq(disput.getId()))
//                .returning()
//                .fetchOne()
//                .into(Disput.class);
//    }
//
//    @Override
//    public Disput find(Long id) {
//        return dsl.selectFrom(Disputes.DISPUTES)
//                .where(Disputes.DISPUTES.ID.eq(id))
//                .fetchAny()
//                .into(Disput.class);
//    }
//
//    @Override
//    public Disput find(Condition condition) {
//        return dsl.selectFrom(Disputes.DISPUTES)
//                .where(condition)
//                .fetchAny()
//                .into(Disput.class);
//    }
//
//    @Override
//    public List<Disput> findAll(Condition condition) {
//        return dsl.selectFrom(Disputes.DISPUTES)
//                .where(condition)
//                .fetch()
//                .into(Disput.class);
//    }
//
//    @Override
//    public Boolean delete(Long id) {
//        return dsl.deleteFrom(Disputes.DISPUTES)
//                .where(Disputes.DISPUTES.ID.eq(id))
//                .execute() == SUCCESS_CODE;
//    }
//}
