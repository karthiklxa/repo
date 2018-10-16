package framework.util.common;

import java.io.*;

/**
 * Created by karthik.m on 6/14/2018.
 */
public class MultiLineString {
    public static void main(String[] args) throws Exception {
        System.out.println(multiLineString(/*
            <?xml version="1.0"?>
			<root>
				<something/>
			</root>
        */));
    }

    public static String multiLineString() {
        try {
            StackTraceElement element = new RuntimeException().getStackTrace()[1];
            String name = "src/test/java/" + element.getClassName().replace('.', '/') + ".java";
            String s = convertStreamToString(new FileInputStream(name), element.getLineNumber());
            return s.substring(s.indexOf("/*")+2, s.indexOf("*/"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static String replaceServiceCode(String serviceName, String serviceFlowIdAndNameToReplace, String serviceFlow) {
        return serviceFlow.replace("serviceCodeToReplace",serviceName).replace("serviceFlowIdAndNameToReplace",serviceFlowIdAndNameToReplace);
    }

    public static String replaceCriteria(String roleCode, String hierarchyRoleCode, String gradeCode,
                                         String productId, String providerId, String cron, String criteria) {
        return criteria.replace("roleCodeToReplace", roleCode)
                .replace("hierarchyRoleCodeToReplace", hierarchyRoleCode)
                .replace("productIdToReplace", productId)
                .replace("providerIdToReplace", providerId)
                .replace("cronToReplace", cron)
                .replace("gradeToReplace", gradeCode);
    }

    private static String convertStreamToString(InputStream is, int lineNum) {
        /*
        * To convert the InputStream to String we use the
        * BufferedReader.readLine() method. We iterate until the BufferedReader
        * return null which means there's no more data to read. Each line will
        * appended to a StringBuilder and returned as String.
        */
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line;
        int i = 1;
        try {
            while ((line = reader.readLine()) != null) {
                if (i++ >= lineNum) {
                    sb.append(line + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return sb.toString();
    }
}
