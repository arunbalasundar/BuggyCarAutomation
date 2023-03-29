import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class API_TC1_2Test {
	public static void main(String[] args) {
		verifyGetRequest("https://jsonplaceholder.typicode.com/users", 8, "Nicholas Runolfsdottir V");
	}
	private static void verifyGetRequest(String urlString, int id, String name) {
	    try {
	        URL url = new URL(urlString);
	        HttpURLConnection con = (HttpURLConnection) url.openConnection();
	        con.setRequestMethod("GET");
	        int status = con.getResponseCode();
	        if (status == 200) {
	            BufferedReader in = new BufferedReader(
	                    new InputStreamReader(con.getInputStream()));
	            String inputLine;
	            StringBuilder content = new StringBuilder();
	            while ((inputLine = in.readLine()) != null) {
	                content.append(inputLine);
	            }
	            in.close();
	            String json = content.toString();
	            boolean userFound = verifyUser(json, id, name);
	            if (userFound) {
	                System.out.println("User with id " + id + " is named '" + name + "'");
	            } else {
	                System.out.println("User with id " + id + " is not named '" + name + "'");
	            }
	            int numUsers = countUsers(json);                
	            if (numUsers == 10) {
	                System.out.println("There are 10 users in the response.");
	            } else {
	                System.out.println("Expected 10 users in the response, but got " + numUsers + " instead.");
	            }
	        } else {
	            System.out.println("Request failed with status code: " + status);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	private static int countUsers(String json) {
        int count = 0;
        boolean inObject = false;
        for (int i = 0; i < json.length(); i++) {
            char c = json.charAt(i);
            if (c == '{') {
                inObject = true;
                count++;
            } else if (c == '}') {
                inObject = false;
            } else if (c == ',' && !inObject) {
                count++;
            }
        }
        return count;
    }
	private static boolean verifyUser(String json, int id, String name) {
	    int count = 0;
	    boolean inObject = false;
	    for (int i = 0; i < json.length(); i++) {
	        char c = json.charAt(i);
	        if (c == '{') {
	            inObject = true;
	            count++;
	            if (count == id) {
	                String sub = json.substring(i, json.indexOf('}', i) + 1);
	                return sub.contains("\"id\":" + id) && sub.contains("\"name\":\"" + name + "\"");
	            }
	        } else if (c == '}') {
	            inObject = false;
	        }
	    }
	    return false;
	}
}
	
