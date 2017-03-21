package app.parseclient;

public interface QueryResults<T> extends Iterable<T> {

	Integer count();

	T first();

}
