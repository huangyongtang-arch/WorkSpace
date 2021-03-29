package com.json;
import cn.hutool.json.JSONUtil;
import cn.hutool.json.JSONObject;
/**
 * @author: tommy wing
 * @description
 */

public class jacksonTest {
  public static void main(String[] args) {
    //
    //    String json =
    // "{\"vin\":\"LFWSRXSJ0K1F33855\",\"vehicleModel\":\"通用\",\"mileage\":null,\"registrationNo\":\"粤A88888\",\"ein\":\"ein33855\",\"productionTime\":null,\"saleTime\":\"2020-09-15\"}";
    //    String json =
    //
    // "{\"vin\":\"LFWSRXSJXJAD33855\",\"vehicleModel\":\"通用\",\"mileage\":null,\"registrationNo\":\"沪AAAAAA\",\"ein\":\"3118H028624\",\"productionTime\":\"2020-09-09 11:26:30\",\"saleTime\":\"2018-08-30\"}";
    String json =
        "{\"woCode\":\"13202103121745120003\",\"stationCode\":\"A0747\",\"stationName\":\"沈阳名流汽车销售服务有限公司\",\"technicianAccount\":\"A0747002\",\"technicianName\":\"\",\"technicianPhone\":\"13522222222\"}";
    JSONObject jsonObject = new JSONObject(json);
    String technicianName = (String) jsonObject.get("technicianName");

    Test test = new Test();
    test.setTests(technicianName);
    System.out.println(test.getTests());

  }

  public static class Test{
    private String tests;

    public String getTests() {
      return tests;
    }

    public void setTests(String tests) {
      this.tests = tests;
    }
  }
}
