package NLP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CallPython {
	
	private static String OS = System.getProperty("os.name").toLowerCase();
	
	public static boolean isWindows() {

		return (OS.indexOf("win") >= 0);

	}

	public static boolean isMac() {

		return (OS.indexOf("mac") >= 0);

	}

	public static boolean isUnix() {

		return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0 );
		
	}

	public static boolean isSolaris() {

		return (OS.indexOf("sunos") >= 0);
	}
		
	public static String Annotate(int id) {
		
		String currentDir = System.getProperty("user.dir");
        String annotation = "";
        
    	System.out.println(System.getProperty("user.dir"));	

        
        String command = "";

        if (isWindows()) {
        	command = "py "+ "C:\\DevelopmentEclipseEE\\annotationTool\\src\\main\\java\\NLP\\Python\\Database.py "  + id;
        } else if (isMac()) {
        	command = "python "+ currentDir + "/src/main/java/NLP/Python/Database.py "  + id;
        } else if (isUnix()) {
        	command = "python " + currentDir + "/src/main/java/NLP/Python/Database.py "  + id;

        }
		
		try {
			Process p = Runtime.getRuntime().exec(command);

			BufferedReader stdInput = new BufferedReader(new 
                 InputStreamReader(p.getInputStream()));
			
			BufferedReader stdErr = new BufferedReader(new 
	                 InputStreamReader(p.getErrorStream()));
			
			String st = null;
			while ((st = stdErr.readLine()) != null) {
				System.out.println(st);

			}

            // read the output from the command
            String s = null;
           
            while ((s = stdInput.readLine()) != null) {
            	annotation += s;
            }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return annotation;
	}
	
	
	public static void main(String[] args) {

	System.out.println(System.getProperty("user.dir"));	
	}

}
