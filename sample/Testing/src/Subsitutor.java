import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.MessageFormat;

import org.apache.commons.lang3.text.StrSubstitutor;
import org.apache.commons.text.StringSubstitutor;



@SuppressWarnings("deprecation")
public class Subsitutor extends Properties{
	
	private static Properties properties = new Properties();
	private static Pattern pattern = Pattern.compile("\\{.*?\\}"); // in short: {, followed by any character, followed by the first }
	 

	public static void main(String[] args) {
		String name = "Welcome Mr. ${firstName} ${lastName} !!!";
		String user = "Hello ${userName} loading you console...";
		subsitute(user);
		
		 Map<String, String> valueMap = new HashMap<String, String>();
		 
		 valueMap.put("firstName", "Santy");
		 //{
	       /* {
	            put("firstName", "Santosh");
	            put("bar", "bar1");
	            put("car", "BMW");
	            put("truck", "MAN");
	        }
	    };*/
	    
	    String message ="Hello ${firstName} loading your console...}";
	    String res = replaceParams(valueMap, message);
	    System.out.println(res);

	}

	public static void subsitute(String name){
		
		Map<String, String> valuesMap = new HashMap<String, String>();
		valuesMap.put("firstName", "ram");
		valuesMap.put("lastName", "Kumar");
		valuesMap.put("userName", "Santosh");
	//	@SuppressWarnings("deprecation")
		//StringSubstitutor sub = new StringSubstitutor(valuesMap);
		//String message = sub.replace(name);
		
		//System.out.println(message);
		
		
	}
	
	public static String replaceParams(Map<String, String> valueMap, String message) {
	    return valueMap.entrySet().stream().reduce(message, (s, e) -> s.replace("${" + e.getKey() + "}", e.getValue()),
	            (s, s2) -> s);
	}
	
	
	/*public String getProperty(String key)
	{
	    return getProperty(key, new HashMap<String,String>());
	}*/
	 
	/*private String getProperty(String key, Map<String,String> templates)
	{
	    if (templates.containsKey(key))
	    {
	        // already tried to replace it before, so there either is a circular
	        // reference or the value has already been resolved
	        return templates.get(key);
	    }
	    String raw = super.getProperty(key);
	    if (raw == null)
	    {
	        return raw;
	    }
	    // put with null first, later replace
	    templates.put(key, null);
	    Pattern pattern = getPattern();
	    int startLen = templateStart.length();
	    int endLen = templateEnd.length();
	    Matcher matcher = pattern.matcher(raw);
	    StringBuilder value = new StringBuilder(raw.length());
	    int index = 0;
	    while (matcher.find())
	    {
	        int start = matcher.start();
	        int end = matcher.end();
	        String template = raw.substring(start + startLen, end - endLen);
	        String templateVal = getProperty(template, templates);
	        if (templateVal == null)
	        {
	            // don't replace
	            value.append(raw.substring(index, end));
	        }
	        else
	        {
	            value.append(raw.substring(index, start));
	            value.append(templateVal);
	        }
	        index = end;
	    }
	    value.append(raw.substring(index));
	    String result = value.toString();
	    templates.put(key, result);
	    return result;
	}*/
}
