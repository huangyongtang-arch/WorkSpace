<html>
<body>
<h2>Hello World!</h2>
<%--<div>--%>
<%--     <div class="row cl">--%>
<%--          <label class="form-label col-xs-4 col-sm-2">descript:</label>--%>
<%--          <div class="formControls col-xs-8 col-sm-9">--%>
<%--                <textarea name="remark" cols="" rows="" class="textarea" placeholder="" datatype="*10-100"--%>
<%--                          dragonfly="true" nullmsg="备注不能为空！" onKeyUp="changeSize(this)">--%>
<%--&lt;%&ndash;                     ${data.remark}&ndash;%&gt;--%>
<%--                </textarea>--%>
<%--               <p class="textarea-numberbar"><em class="textarea-length">0</em>/255</p>--%>
<%--          </div>--%>
<%--     </div>--%>
<%--</div>--%>

<%--<script type="text/javascript">--%>
<%--     $(function () {--%>
<%--          $('.textarea-numberbar').html('<em class="textarea-length">' + $('textarea[name="remark"]').val().length + '</em>/255');--%>
<%--     });--%>
<%--     function changeSize(obj) {--%>
<%--          var size = obj.value.length;--%>
<%--          obj.keyCode !== 8 ? size : size -= 1;--%>
<%--          $('.textarea-numberbar').html('<em class="textarea-length">' + size + '</em>/255');--%>
<%--     }--%>
<%--</script>--%>


<%--<script>--%>
<%--     function check() {--%>
<%--          var regC = /[^ -~]+/g;--%>
<%--          var regE = /\D+/g;--%>
<%--          var str = t1.value;--%>

<%--          if (regC.test(str)){--%>
<%--               t1.value = t1.value.substr(0,10);--%>
<%--          }--%>

<%--          if(regE.test(str)){--%>
<%--               t1.value = t1.value.substr(0,20);--%>
<%--          }--%>
<%--     }--%>
<%--</script>--%>
<textarea maxlength="255" id="t1">
"/" “\”
</textarea>


</body>
</html>
