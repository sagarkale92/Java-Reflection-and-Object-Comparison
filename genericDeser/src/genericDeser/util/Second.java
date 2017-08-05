package genericDeser.util;

public class Second {
	/**
	 * Second class.
	 */
	private int IntValue;
	private double DoubleValue;
	private boolean BooleanValue;

	/**
	 * Empty constructor
	 */
	public Second(){
		Logger.writeOutput("Constructor of Second class is called.", 2);
	}
	
	/* 
	 * Displays object parameters and data.
	 */
	@Override
	public String toString() {
		return "Second [IntValue=" + IntValue + ", DoubleValue=" + DoubleValue + ", BooleanValue=" + BooleanValue + "]";
	}
	
	/* 
	 * Returns result by adding int values of parameters to prime number. 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (BooleanValue ? 1231 : 1237);
		long temp;
		temp = Double.doubleToLongBits(DoubleValue);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + IntValue;
		return result;
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
		Second other = (Second) obj;
		if (BooleanValue != other.BooleanValue)
			return false;
		if (Double.doubleToLongBits(DoubleValue) != Double.doubleToLongBits(other.DoubleValue))
			return false;
		if (IntValue != other.IntValue)
			return false;
		return true;
	}

	public int getIntValue() {
		return IntValue;
	}
	public void setIntValue(int intValue) {
		IntValue = intValue;
	}
	public double getDoubleValue() {
		return DoubleValue;
	}
	public void setDoubleValue(double doubleValue) {
		DoubleValue = doubleValue;
	}
	public boolean isBooleanValue() {
		return BooleanValue;
	}
	public void setBooleanValue(boolean booleanValue) {
		BooleanValue = booleanValue;
	}
	
}
