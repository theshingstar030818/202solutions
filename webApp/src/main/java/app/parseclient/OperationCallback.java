package app.parseclient;

public interface OperationCallback<R> {

	void future(R response, Throwable throwable);

}
