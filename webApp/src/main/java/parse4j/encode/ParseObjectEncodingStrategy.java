package parse4j.encode;

import org.json.JSONObject;
import parse4j.ParseObject;

public interface ParseObjectEncodingStrategy {
	
	public abstract JSONObject encodeRelatedObject(ParseObject parseObject);

}
