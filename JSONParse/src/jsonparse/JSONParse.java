/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsonparse;
import org.json.simple.JSONObject;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;
//JSON SIMPLE LINK https://code.google.com/archive/p/json-simple/downloads
    
/**
 *
 * @author Ethan
 */
public class JSONParse {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JSONObject obj = new JSONObject();

      obj.put("name", "foo");
      obj.put("num", new Integer(100));
      obj.put("balance", new Double(1000.21));
      obj.put("is_vip", new Boolean(true));

      System.out.print(obj);
      
      JSONParser parser = new JSONParser();
      String s = "[0,{\"1\":{\"2\":{\"3\":{\"4\":[5,{\"6\":7}]}}}}]";
      
      //Here's a breakdown of the JSON array and its contents:
/*The array begins with the opening square bracket [.
The first element of the array is the number 0.
The second element of the array is a nested JSON object, which is enclosed in curly braces {}.
The nested JSON object contains a key-value pair, where the key is a string "1" enclosed in double quotes "" and the value is another nested JSON object.
The second nested JSON object contains a key-value pair, where the key is a string "2" and the value is another nested JSON object.
The third nested JSON object contains a key-value pair, where the key is a string "3" and the value is another nested JSON object.
The fourth nested JSON object contains a key-value pair, where the key is a string "4" and the value is a JSON array that contains two elements: the number 5 and another nested JSON object.
The second element of the nested JSON array contains a key-value pair, where the key is a string "6" and the value is the number 7.
The entire JSON array is enclosed in a closing square bracket ].
Overall, the JSON array represents a complex data structure with multiple levels of nesting. It's worth noting that the backslashes (\) are used to escape the double quotes (") within the string in order to indicate that they are part of the string rather than delimiters for the JSON structure.*/
		
      try{
         Object obj2 = parser.parse(s);
         JSONArray array = (JSONArray)obj2;
			
         System.out.println("\n \n The 2nd element of array");
         System.out.println(array.get(1));
         System.out.println();

         JSONObject obj3 = (JSONObject)array.get(1);
         System.out.println("Field \"1\"");
         System.out.println(obj3.get("1"));    

         s = "{}";
         obj2 = parser.parse(s);
         System.out.println(obj2);

         s = "[5,]";
         obj2 = parser.parse(s);
         System.out.println(obj2);

         s = "[5,,2]";
         obj2 = parser.parse(s);
         System.out.println(obj2);
         
         /* These lines of code extract a value from the JSON array and print it to the console.

First, the line JSONObject obj3 = (JSONObject)array.get(1); retrieves the second element of the JSON array (index 1) and casts it to a JSONObject type. This element is the nested JSON object that contains multiple levels of nested key-value pairs.

Next, the line System.out.println("Field \"1\""); prints the string "Field \"1\"" to the console. This is just a header to indicate which value is being printed next.

Finally, the line System.out.println(obj3.get("1")); retrieves the value associated with the key "1" from the JSONObject obj3 and prints it to the console. In this case, the value associated with "1" is another nested JSONObject, so the output will be a string representation of that object.

Overall, these lines of code demonstrate how to extract and access nested data structures within a JSON array using the get() method and casting to the appropriate data types. */
         
      }catch(ParseException pe) {
		
         System.out.println("position: " + pe.getPosition());
         System.out.println(pe);
      }
    }
    
}
