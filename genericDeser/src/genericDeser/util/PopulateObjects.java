package genericDeser.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import genericDeser.fileOperations.FileProcessor;

/**
 * @author Sagar
 * Class reads file, create objects, saves to data structure and display results.
 */
public class PopulateObjects {
	
	private FileProcessor fp;
	private Set<First> firstObjs;
	private Set<Second> secondObjs;
	private Map<String,Class<?>> sign;
	private int firstObjsCount;
	private int secondObjsCount;
	
	/**
	 * @param fpIn
	 * Constructor to update parameters and initialize Map.
	 */
	public PopulateObjects(FileProcessor fpIn){
		Logger.writeOutput("Constructor of PopulateObjects class is called.", 2);
		firstObjs = new HashSet<First>();
		secondObjs = new HashSet<Second>();
		firstObjsCount=0;
		secondObjsCount=0;
		sign = new HashMap<String, Class<?>>();
		sign.put("int", Integer.TYPE);
		sign.put("double", Double.TYPE);
		sign.put("boolean",Boolean.TYPE);
		sign.put("float", Float.TYPE);
		sign.put("short", Short.TYPE);
		sign.put("String",String.class);
		fp = fpIn;
	}
	
	/**
	 * Reads line from file, generates object and saves to data structure.
	 */
	public void deserObjects(){
		String line = "";
		String clsName="";
		String fqn = "fqn:";
		Class<?> cls = null;
		Object obj = null;
		while((line = getFp().readLine()) != null){
			if(line.substring(0, 4).hashCode() == fqn.hashCode()){
				if(null != obj){
					addObjects(obj);
				}
				clsName = line.substring(4,line.length());
				try{
					cls = Class.forName(clsName);
					obj = cls.newInstance();
				}
				catch(ClassNotFoundException e){
					e.printStackTrace();
					System.exit(-1);
				}
				catch(InstantiationException | IllegalAccessException e){
					e.printStackTrace();
					System.exit(-1);
				}
			}
			else{
				Class<?>[] signature = new Class[1];
				String type = line.substring(line.indexOf("type=")+5,line.indexOf("var=")-2);
				String var = line.substring(line.indexOf("var=")+4,line.indexOf("value=")-2);
				String value = line.substring(line.indexOf("value=")+6,line.length());
				signature[0] = sign.get(type);
				String methodName = "set"+var;
				Method meth = null;
				try{
					meth = cls.getMethod(methodName, signature);
				}
				catch(NoSuchMethodException e){
					e.printStackTrace();
					System.exit(-1);
				}
				catch(SecurityException e){
					e.printStackTrace();
					System.exit(-1);
				}
				Object[] params = new Object[1];
				params[0] = getTypeObject(type, value);
				try{
					meth.invoke(obj, params);
				}
				catch(IllegalAccessException e){
					e.printStackTrace();
					System.exit(-1);
				}
				catch(IllegalArgumentException e){
					e.printStackTrace();
					System.exit(-1);
				}
				catch(InvocationTargetException e){
					e.printStackTrace();
					System.exit(-1);
				}
			}
		}
		if(null != obj)
			addObjects(obj);
	}
	
	/**
	 * @param type
	 * @param value
	 * @return Object
	 * Creates and returns new object from type of parameter.
	 */
	public Object getTypeObject(String type, String value){
		Object param=null;
		switch(type){
		case "double":	param = new Double(Double.parseDouble(value));
						break;
		case "int":		param = new Integer(Integer.parseInt(value));
						break;
		case "boolean":	param = new Boolean(value);
						break;
		case "String":	param = new String(value);
						break;
		case "short":	param = new Short(Short.parseShort(value));
						break;
		case "float":	param = new Float(Float.parseFloat(value));
						break;
		default:
		}
		return param;
	}
	
	/**
	 * @param ob
	 * Adds object to data structure.
	 */
	public void addObjects(Object ob){
		String className = ob.getClass().getName();
		if(className.equals("genericDeser.util.First")){
			First fobj = (First)ob;
			firstObjs.add(fobj);
			firstObjsCount++;
		}
		else{
			Second sobj = (Second)ob;
			secondObjs.add(sobj);
			secondObjsCount++;
		}
	}
	
	/**
	 * Display results.
	 */
	public void display(){
		Logger.writeOutput("Number of unique First objects: "+firstObjs.size(),0);
		Logger.writeOutput("Total Number of First objects: "+getFirstObjsCount(),0);
		Logger.writeOutput("Number of unique Second objects: "+secondObjs.size(),0);
		Logger.writeOutput("Total Number of Second objects: "+getSecondObjsCount(),0);
	}
	
	public FileProcessor getFp() {
		return fp;
	}

	public void setFp(FileProcessor fp) {
		this.fp = fp;
	}

	public Set<First> getFirstObjs() {
		return firstObjs;
	}

	public void setFirstObjs(Set<First> firstObjs) {
		this.firstObjs = firstObjs;
	}

	public Set<Second> getSecondObjs() {
		return secondObjs;
	}

	public void setSecondObjs(Set<Second> secondObjs) {
		this.secondObjs = secondObjs;
	}

	public int getFirstObjsCount() {
		return firstObjsCount;
	}

	public void setFirstObjsCount(int firstObjsCount) {
		this.firstObjsCount = firstObjsCount;
	}

	public int getSecondObjsCount() {
		return secondObjsCount;
	}

	public void setSecondObjsCount(int secondObjsCount) {
		this.secondObjsCount = secondObjsCount;
	}
}
