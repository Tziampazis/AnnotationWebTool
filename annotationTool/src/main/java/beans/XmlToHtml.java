package beans;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XmlToHtml {

	
	public static void main(String[] args){
		String test1 = "<report><O>kkskdfksd</O><positive>bla<mass>ten</mass></positive><O>fuck</O></report>";
		String test2 = "<report><O>plain</O><standard1>te<standard1>x</standard1>t</standard1><O>- both</O><standard1>se<standard1>lect</standard1>and</standard1></report>";
		String test3 = "<report><O>kkskdfksd</O><positive>bla<mass>ten<las>ksksk<klass>okokok<vilos>vivivi</></klass></las></mass></positive><O>THkiaole</O><put>lklklk</put><O>fuck</O></report>";
		
		
		insideR(test3);
	}
	
	public static void insideR(String str){
		String pattern = "(<report>.*</report>)";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str);
        String a = "";
        while(m.find()){
        	a = m.group(0);
        	//System.out.println(m.group(0));
        	
        }
        
        a = a.replace("<report>","");
        a = a.replace("</report>","");

        System.out.println(a);
        takeRest(a);       
	}
	
	public static void takeRest(String str){
		String sent = "";
		String pattern = "(<.*?>.*?)";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str);
        ArrayList<String> kk = new ArrayList<>();
        String a = str;
        while(m.find()){
        	kk.add(m.group(0));
        	
        	//System.out.println("== " +m.group(0));
        }
        
        for(String i : kk){
        	a = a.replaceFirst(i, "");
        	String st = i;
        	st = st.replace("<", "");
        	st = st.replace(">", "");        	
        	
        	if(!st.equals("O") && !st.equals("/O")){
	        	if(!i.contains("/")){
	        		sent = sent + "<span class=\""+st+"\">";
	        	}else{
	        		sent = sent + "</span>";
	        	}
        	}
        	
        	String[] word = a.split("<");
        	//System.out.println("_+_+ " + word[0]);
        	if(!word[0].isEmpty()){
        		a = a.replaceFirst(word[0], "");
        		sent = sent + word[0];
        	}
        	
        	//System.out.println("Se " + a);

        }
        
        System.out.println("SE " + sent);
	}
	
	
	
}
