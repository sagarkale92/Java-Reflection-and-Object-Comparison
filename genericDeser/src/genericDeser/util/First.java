package genericDeser.util;

public class First {
	/**
	 * First class.
	 */
	private int IntValue;
	private float FloatValue;
	private short ShortValue;
	private String StringValue;
	
	/**
	 * Empty constructor
	 */
	public First(){
		Logger.writeOutput("Constructor of First class is called.", 2);
	}
	
	/* 
	 * Displays object parameters and data.
	 */
	@Override
	public String toString() {
		return "First [IntValue=" + IntValue + ", FloatValue=" + FloatValue + ", ShortValue=" + ShortValue
				+ ", StringValue=" + StringValue + "]";
	}

	/* 
	 * Returns result by adding int values of parameters to prime number. 
	 */
	@Override
	public int hashCode() {
		final int prime = 19;
		int res = 1;
		res = prime * res + Float.floatToIntBits(FloatValue);
		res = prime * res + ShortValue;
		res = prime * res + IntValue;
		res = prime * res + ((StringValue == null) ? 0 : StringValue.hashCode());
		return res;
	}

	/* 
	 * Matches parameters of both objects and return true(if matches) or false(if not matches).
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		First other = (First) obj;
		if (Float.floatToIntBits(FloatValue) != Float.floatToIntBits(other.FloatValue))
			return false;
		if (IntValue != other.IntValue)
			return false;
		if (ShortValue != other.ShortValue)
			return false;
		if (StringValue == null) {
			if (other.StringValue != null)
				return false;
		} else if (!StringValue.equals(other.StringValue))
			return false;
		return true;
	}

	public int getIntValue() {
		return IntValue;
	}
	public void setIntValue(int intValue) {
		IntValue = intValue;
	}
	public short getShortValue() {
		return ShortValue;
	}
	public void setShortValue(short shortValue) {
		ShortValue = shortValue;
	}
	public float getFloatValue() {
		return FloatValue;
	}
	public void setFloatValue(float floatValue) {
		FloatValue = floatValue;
	}
	public String getStringValue() {
		return StringValue;
	}
	public void setStringValue(String stringValue) {
		StringValue = stringValue;
	}
}
