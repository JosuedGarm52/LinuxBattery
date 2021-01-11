package source;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Bateria 
{
	public Bateria()
	{
		leerArchivo();
	}
	private int nivel=0;
	private String Status="";
	public int getNivel()
	{
		return nivel;
	}
	public String getStatus()
	{
		return Status;
	}
	public String getComando="";
	private void leerArchivo()
	{
		try
		{
			//String[] args = new String[] {"/bin/bash", "-c", "acpi"};
			//Process process = new ProcessBuilder(args).start();

	           String command = "acpi";

	           Process proc = Runtime.getRuntime().exec(command);

	           // Read the output

	           BufferedReader reader =  
	                 new BufferedReader(new InputStreamReader(proc.getInputStream()));
	           String line = "";
	           line = reader.readLine();
	           getComando=line;
	           char[] c_arr = line.toCharArray(); 
	           int vuelta=10;
	           String Numero= "";
	           while(vuelta<c_arr.length) 
	           {
	        	   
	        	   if(c_arr[vuelta]=='0'||c_arr[vuelta]=='1'||c_arr[vuelta]=='2'||c_arr[vuelta]=='3'||c_arr[vuelta]=='4'||c_arr[vuelta]=='5'||c_arr[vuelta]=='6'||c_arr[vuelta]=='7'||c_arr[vuelta]=='8'||c_arr[vuelta]=='9')
	        	   {
	        		   Numero+=c_arr[vuelta];
	        	   }
	        	   vuelta++;
	           }
	           vuelta=10;
	           String status="";
	           while(c_arr[vuelta]!=',')
	           {
	        	   if(c_arr[vuelta]!=' ')
	        	   {
	        		   status+=c_arr[vuelta];
	        	   }
	        	   vuelta++;
	           }
	           proc.waitFor();
	           int numero = Integer.parseInt(Numero);
	           nivel = numero;
	           Status=status;
		}catch(Exception excepcion)
        {
	         excepcion.printStackTrace();
        }
		
	}
	
	
}
