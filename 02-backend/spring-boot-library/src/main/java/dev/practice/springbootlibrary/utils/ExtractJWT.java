package dev.practice.springbootlibrary.utils;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class ExtractJWT {

    public static String payloadJWTExtraction(String token, String claim) {
        token = token.replace("Bearer ", "");
        String[] chunks = token.split("\\.");
        Base64.Decoder decoder = Base64.getUrlDecoder();
        String payload = new String(decoder.decode(chunks[1]));
        String[] entries = payload.split(",");

        for (String entry : entries) {
            String[] keyValue = entry.split(":");
            if (keyValue[0].equals("\"" + claim + "\"")) {
                int remove = 1;
                if (keyValue[1].endsWith("}")) {
                    remove = 2;
                }
                keyValue[1] = keyValue[1].substring(1, keyValue[1].length() - remove);
                return keyValue[1];
            }
        }
        return null;
    }
}
