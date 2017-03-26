package parse4j.callback;

import parse4j.ParseException;

public abstract class GetDataCallback extends ParseCallback<byte[]> {

	public abstract void done(byte[] data, ParseException e);

	final void internalDone(byte[] returnValue, ParseException e) {
		done(returnValue, e);
	}

}
