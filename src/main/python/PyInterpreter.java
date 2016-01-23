package main.python;

import org.python.core.PyInstance;
import org.python.util.PythonInterpreter;


public class PyInterpreter
{
 
   PythonInterpreter interpreter = null;
 
 
   public PyInterpreter()
   {
      PythonInterpreter.initialize(System.getProperties(), System.getProperties(), new String[0]);
 
      this.interpreter = new PythonInterpreter();
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
   PyInstance createClass( final String className, final String opts )
   {
      return (PyInstance) this.interpreter.eval(className + "(" + opts + ")");
   }
 
   /** Launches the given Python file. When calling the method, pass in the name of the .py file without the file extension.
    * 
    * @param fileName A String for the file name. Omit the ".py" extension
    */
   public static void execPyFile(String fileName)
   {
      PyInterpreter ie = new PyInterpreter();
 
      ie.execfile("Python/" + fileName + ".py");
 
      PyInstance hello = ie.createClass("Hello", "None");
 
      hello.invoke("run");
   }
}