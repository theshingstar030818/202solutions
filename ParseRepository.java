package app.parse;

/**
 * Created by tanzeelrana on 27/03/17.
 */
public interface ParseRepository <T, ID extends java.io.Serializable> extends org.springframework.data.repository.PagingAndSortingRepository<T,ID>, org.springframework.data.repository.query.QueryByExampleExecutor<T> {

    java.util.List<T> findAll();

    java.util.List<T> findAll(org.springframework.data.domain.Sort sort);

    java.util.List<T> findAll(java.lang.Iterable<ID> iterable);

    <S extends T> java.util.List<S> save(java.lang.Iterable<S> iterable);

    void flush();

    <S extends T> S saveAndFlush(S s);

    void deleteInBatch(java.lang.Iterable<T> iterable);

    void deleteAllInBatch();

    T getOne(ID id);

    <S extends T> java.util.List<S> findAll(org.springframework.data.domain.Example<S> example);

    <S extends T> java.util.List<S> findAll(org.springframework.data.domain.Example<S> example, org.springframework.data.domain.Sort sort);

}
