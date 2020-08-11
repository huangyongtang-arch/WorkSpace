
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<body>
<head>
    <link rel="stylesheet" type="text/css" href="/lib/webuploader/0.1.5/webuploader.css">
    <script type="text/javascript" src="/lib/jquery.validation/1.14.0/jquery.validate.js"></script>
    <script type="text/javascript" src="/lib/jquery.validation/1.14.0/validate-methods.js"></script>
    <script type="text/javascript" src="/lib/jquery.validation/1.14.0/messages_zh.js"></script>
    <script type="text/javascript" src="/lib/webuploader/0.1.5/webuploader.js"></script>
    <script type="text/javascript" src="/util/single.file.webuploader.js"></script>
    <script type="text/javascript" src="/util/MyWebUpload.js"></script>
</head>
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

<div>
    <label><span style="color: red">*</span>上传参考文件</label>
    <div>
        <div id="theList" class="uploader-list"></div>
        <div id="uploader" data-ids="fileId" title="请上传word、pdf或图片文件;仅可上传一个文件">上传文件</div>
        <span style="color: red">请上传word、pdf或图片文件;仅可上传一个文件(暂不支持pdf转换)</span>
    </div>
</div>

<script type="text/javascript">
    var opts = {
        'accept': {
            extensions: 'jpg,png,bmp,jpeg,pdf,doc,docx',
            mimeTypes: 'image/jpg,image/jpeg,image/png,application/pdf,application/msword,application/vnd.openxmlformats-officedocument.wordprocessingml.document'
        },
        'maxFileSize': 500 * 1024 * 1024,
        'server': $('body').attr('path') + '/admin/upload/uploadfile',
        'deleteServer': $('body').attr('path') + '/admin/upload/deletefile',
        'uploaderListId': 'theList',
        'uploaderId': 'uploader',
        'uploadedFilesId': 'files',
        'oldFileListId': 'oldList'
    };

    $(document).ready(function () {
        $('.js-example-basic-multiple').select2();
    });
    $(document).ready(function () {
        //把下拉多选框的宽度设长
        $('.select2-container').width(550);
    });

    $(function () {
        createUploader("fileName", "sysFile", opts);

        /*$("#uploader").powerWebUpload({
            auto: true,
            fileNumLimit: 1,
            //这里添加之后需要同时添加到MyWebUpload.js对应的位置
            accept: {
                extensions: 'jpg,png,bmp,jpeg,pdf,doc,docx',
                mimeTypes: 'image/jpg,image/jpeg,image/png,application/pdf,application/msword,application/vnd.openxmlformats-officedocument.wordprocessingml.document'
            },
            fileSingleSizeLimit:10 * 1024 * 1024,
            compress: false//不启用压缩
        });*/

        $('.skin-minimal input').iCheck({
            checkboxClass: 'icheckbox-blue',
            radioClass: 'iradio-blue',
            increaseArea: '20%'
        });

        //表单验证
        $("#theForm").validate({
            rules: {
                title:{
                    required: true
                },
                cyclopediaTypeId: {
                    required: true
                },
                sysFile:{
                    required: true
                }
            },
            onkeyup: false,
            focusCleanup: false,
            success: "valid",
            submitHandler: function (form) {
                $(form).ajaxSubmit(function (data) {
                    var json = data;
                    if (json.result) {
                        layer.msg("保存成功", {icon: 1, time: 2000}, function () {
                            var index = parent.layer.getFrameIndex(window.name);
                            parent.doSearch(true);
                            parent.layer.close(index);
                        });

                    }
                    else {
                        layer.msg(json.msg, {icon: 2, time: 2000});
                    }
                });
            }
        });
    });
    function cancel() {
        var index = parent.layer.getFrameIndex(window.name);
        parent.layer.close(index);
    }

    $(function () {
        getDtc();
        getPart();
    })
</script>
</body>
</html>
