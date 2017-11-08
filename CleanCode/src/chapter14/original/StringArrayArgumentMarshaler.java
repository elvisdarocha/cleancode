package chapter14.original;

import java.util.Iterator;
import java.util.NoSuchElementException;

import chapter14.original.ArgsException.ErrorCode;

public class StringArrayArgumentMarshaler implements ArgumentMarshaler {

	private String[] stringValue;

	public void set(Iterator<String> currentArgument) throws ArgsException {
		try {
			stringValue = currentArgument.next().split(",");
		} catch (NoSuchElementException e) {
			throw new ArgsException(ErrorCode.MISSING_STRING);
		}
	}

	public static String[] getValue(ArgumentMarshaler am) {
		if (am != null && am instanceof StringArgumentMarshaler)
			return ((StringArrayArgumentMarshaler) am).stringValue;
		else
			return new String[0];
	}
	
}
