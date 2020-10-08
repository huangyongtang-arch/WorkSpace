package com.test;

import com.alibaba.fastjson.JSON;

import java.util.Map;

/**
 * @ClassName ccrTest
 * @Description TODO
 * @Author tommy
 * @Date 9/11/2020 10:53 PM
 **/
//  data = {courseWareList =[{courseWareId = 147071494587936768, detailList =[{code = null, format = 1, orderNum = null,
//  childDetailList =[{code = null, format = 1, orderNum = 0, content = null, parentId = 147071495636512768, url = / group1 / source / first - page - pdf.html, courseWareId = 147071494587936768,
//  usePerson = 0, name = first - page - pdf.html, id = 147071552393834496, publishStatus = null}],
//        content = null, parentId = null, url = null, courseWareId = 147071494587936768, usePerson = 0, name = 8 - 5
//        测试新增, id = 147071495636512768, publishStatus = null}],courseWareName = 8 - 5 测试新增},{
//            courseWareId = 151662158629826560, detailList =[{
//                code = null, format = 1, orderNum = null, childDetailList =[{
//                    code = null, format = 1, orderNum = 0, content = null, parentId = 151662158797598720, url =/
//                    group1 / source / first - page - pdf.html, courseWareId = 151662158629826560, usePerson = 0, name = first - page - pdf.pdf, id = 151662158868901888, publishStatus = null
//                }],
//                content = null, parentId = null, url = null, courseWareId = 151662158629826560, usePerson = 0, name = 教程阿斯蒂芬, id = 151662158797598720, publishStatus = null
//            }],courseWareName = 教程阿斯蒂芬
//        },{
//            courseWareId = 160050905369014272, detailList =[{
//                code = null, format = 1, orderNum = null, childDetailList =[{
//                    code = null, format = 1, orderNum = 0, content = null, parentId = 160050905918468096, url =/
//                    group1 / source / 哈哈哈哈哈啊 / 轨迹测试情况0724.pdf, courseWareId = 160050905369014272, usePerson = 0, name = 轨迹测试情况0724.pdf, id = 160050906174320640, publishStatus = null
//                }],
//                content = null, parentId = null, url = null, courseWareId = 160050905369014272, usePerson = 0, name = 哈哈哈哈哈啊, id = 160050905918468096, publishStatus = null
//            }],courseWareName = 哈哈哈哈哈啊
//        },{
//            courseWareId = 160457156196298752, detailList =[{
//                code = null, format = 1, orderNum = null, childDetailList =[{
//                    code = null, format = 1, orderNum = 0, content = null, parentId = 160457156838027264, url =/
//                    group1 / source / first - page - pdf.html, courseWareId = 160457156196298752, usePerson = 0, name = first - page - pdf.pdf, id = 160457157211320320, publishStatus = null
//                }],
//                content = null, parentId = null, url = null, courseWareId = 160457156196298752, usePerson = 0, name = 12131231, id = 160457156838027264, publishStatus = null
//            }],courseWareName = 12131231
//        }]}
public class ccrTest {
    public static void main(String[] args) {
        String str="{\"noticeType\": \"UNIFORM_SUBSCRIPTION\"," +
                " \"notice\": {" +
                " \"returnCode\": \"000000\"," +
                " \"description\": \"&½\"," +
                " \"orderId\": \"74f8ce8913d74969a725ef7c84f64b4b\"," +
                " \"productContent\": {" +
                " \"orderType\": \"1\"," +
                " \"productId\": \"9020500020090429000894\"," +
                " \"callNumber\": \"xxxxxxxxxxx\"," +
                " \"productPkgId\": \"00\"," +
                " \"contentId\": \"00\"," +
                " \"productName\": \"7000100301\"}}}";

        Map maps = (Map) JSON.parse(str);
        System.out.println(maps.get("notice"));


    }

}
