import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class API_TC3 {
    public static void main(String[] args) {
        String urlString = "https://jsonplaceholder.typicode.com/posts";
        String requestMethod = "POST";
        String contentType = "application/json; utf-8";
        String requestBody = "{\"title\":\"foo\",\"body\":\"bar\",\"userId\":1}";
        int expectedResponseCode = 201;
        String expectedResponse = "";
        sendRequestAndVerifyResponse(urlString, requestMethod, contentType, requestBody, expectedResponseCode, expectedResponse);
    }

    private static void sendRequestAndVerifyResponse(String urlString, String requestMethod, String contentType,
                                                      String requestBody, int expectedResponseCode, String expectedResponse) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod(requestMethod);
            con.setRequestProperty("Content-Type", contentType);
            con.setDoOutput(true);
            try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
                wr.writeBytes(requestBody);
                wr.flush();
            }
            int status = con.getResponseCode();
            if (status == expectedResponseCode) {
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                if (response.toString().equals(expectedResponse)) {
                    System.out.println("Test passed");
                } else {
                    System.out.println("Test failed. Expected response: " + expectedResponse + " but got: " + response.toString());
                }
            } else {
                System.out.println("Test failed. Expected response code: " + expectedResponseCode + " but got: " + status);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
