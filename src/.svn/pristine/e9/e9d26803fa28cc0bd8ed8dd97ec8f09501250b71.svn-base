package framework.features;

import com.aventstack.extentreports.ExtentTest;
import framework.util.common.JsonPathOperation;

import static framework.util.common.JsonPathOperation.set;

import static framework.util.common.MultiLineString.multiLineString;
import static framework.util.common.Utils.json;

/**
 * Created by karthik.m on 6/14/2018.
 */
public class ApiManagement {
    private static ExtentTest pNode;

    public static ApiManagement init(ExtentTest t1) {
        pNode = t1;
        return new ApiManagement();
    }

    public String verifyWalletPayment(String action,String msisdn, String rrn) {
        String jsonLoad = serviceRequestWalletTransaction(
                set("actionType",action),
                set("customerId",msisdn),
                set("rrn",rrn)
        );
        pNode.info("json: "+ jsonLoad);
//        RestAssured.given().request().body(jsonLoad).response().statusCode(200).log().all();
        String responseCode = ApiMethods.init(pNode).post(jsonLoad);
        return responseCode;
    }


    public static String serviceRequestWalletTransaction(JsonPathOperation... operations) {
        final String json = json(multiLineString(/*
                {
                    "actionType":"ACCEPT",
	                 "imei":"1234567890",
	                 "customerId":"transactor",
	                 "rrn":"101"
                   }
            */), operations);
        return json;
    }



    public String currencyCode(String payload) throws Exception {
        String responseCode = ApiMethods.init(pNode).post1(payload);
        return responseCode;
    }


}
