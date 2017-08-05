package genericDeser.driver;

import genericDeser.fileOperations.FileProcessor;
import genericDeser.util.Logger;
import genericDeser.util.PopulateObjects;

/**
 * @author Sagar
 * Program gives total number of First and Second Unique and total objects.
 */
public class Driver {
	private String inputFileName;
	private int debugValue;
	private FileProcessor fp;
	
	/**
	 * @param args
	 * Main function to validate input arguments and call process method.
	 */
	public static void main(String[] args){
		if(args.length != 2){
			System.out.println("Invalid Arguments supplied");
			System.exit(0);
		}
		
		Driver dr = new Driver();
		dr.initialize(args);
		dr.process();
	}
	
	/**
	 * @param args
	 * Sets parameters and initiates logger class.
	 */
	public void initialize(String[] args){
		setInputFileName(args[0]);
		setDebugValue(Integer.parseInt(args[1]));
		setFp(new FileProcessor(getInputFileName(), ""));
		new Logger(getDebugValue());
	}
	
	/**
	 * Creates PopulateObjects object and call deserObject, display methods.
	 */
	public void process(){
		PopulateObjects po = new PopulateObjects(fp);
		po.deserObjects();
		getFp().terminateInputFile();
		po.display();
	}

	public String getInputFileName() {
		return inputFileName;
	}

	public void setInputFileName(String inputFileName) {
		this.inputFileName = inputFileName;
	}

	public FileProcessor getFp() {
		return fp;
	}

	public void setFp(FileProcessor fp) {
		this.fp = fp;
	}

	public int getDebugValue() {
		return debugValue;
	}

	public void setDebugValue(int debugValue) {
		this.debugValue = debugValue;
	}
}
