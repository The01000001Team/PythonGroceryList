package main.python;

import org.python.core.PyInstance;
import org.python.core.PyString;
import org.python.core.PySystemState;
import org.python.util.PythonInterpreter;



public class PyInterpreter
{
 
   PythonInterpreter interpreter = null;
 
 
   public PyInterpreter(PySystemState state)
   {
     // PythonInterpreter.initialize(System.getProperties(), System.getProperties(), new String[0]);
      this.interpreter = new PythonInterpreter(null, state);
   }
 
   /** Executes the .py file. Do not call this, only call execPyFile()
    * 
    * @param fileName
    */
   void execfile( final String fileName )
   {
      this.interpreter.execfile(fileName);
   }
 
   /** Creates a class for the python file. Do not call this, only call the execPyFile()
    * 
    * @param className 
    * @param opts
    * @return
    */
   private PyInstance createClass( final String className, final String opts )
   {
      return (PyInstance) this.interpreter.eval(className + "(" + opts + ")");
   }
 
   /** Launches the given Python file. When calling the method, pass in the name of the .py file without the file extension.
    * 
    * @param fileName A String for the file name. Omit the ".py" extension
    */
   public static String[] execPyFile(String fileName, String url)
   {
	  PySystemState state = new PySystemState();
	  state.argv.clear();
	  state.argv.append (new PyString (fileName));      
	  state.argv.append (new PyString (url));

      PyInterpreter ie = new PyInterpreter(state);
      ie.execfile("Python/" + fileName + ".py");
      

      String[] array = ie.interpreter.get("jythonArray", String[].class);
      return array;    
   }
   
}