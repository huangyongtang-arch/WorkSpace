
function createUploader(fileNameAttr, sysFileNameAttr, opts, index) {
    /*init webuploader*/
    if(!index){
        index = 0;
    }
    var $list = $("#" + opts.uploaderListId);

    var wuFileId = "WU_FILE_" + index;
    var wuFileSelector = "#WU_FILE_" + index;

    var uploader = WebUploader.create({
            auto: true,
            // swf文件路径
            swf: $('body').attr('path') + '/lib/webuploader/0.1.5/Uploader.swf',
            // 文件接收服务端。
            server: opts.server,
            deleteServer: opts.deleteServer,

            // 选择文件的按钮。可选。
            // 内部根据当前运行是创建，可能是input元素，也可能是flash.
            pick: {
                id: '#' + opts.uploaderId
                //只能选择一个文件上传
                //multiple: false
            },
            fileSingleSizeLimit: opts.maxFileSize,   //设定单个文件大小
        //限制只能上传一个文件
        fileNumLimit: 1,

        // 不压缩image, 默认如果是jpeg，文件上传前会压缩一把再上传！
        resize: false,
        chunked: false,//分片上传-大文件的时候分片上传，默认fals,
        chunkSize: 512000 * 1024,
        accept: opts.accept
    });

    uploader.on('beforeFileQueued', function (file) {
        if ($("#" + opts.uploadedFilesId).children().length > 0 || ($("#" + opts.oldFileListId) !== undefined && $("#" + opts.oldFileListId).children().length > 0)) {
            layer.msg('请先删除之前上传的文件', {icon:2, time:2000});
            return false;
        }
        return true;
    });

    // 当有文件被添加进队列的时候
    uploader.on('fileQueued', function (file) {

        // 判断当前上传文件的格式
        if (opts.accept.extensions !== '' && opts.accept.extensions.indexOf(uploader.getFiles()[0].ext.toLowerCase()) < 0) {
            alert("上传格式不正确！");
        }
        else {
            var $li = $(wuFileSelector),
                $percent = $li.find('.info');

            if (!$percent.length) {
                $list.append('<div id="'+wuFileId+'" class="item">' +
                    '<h4 class="info">' + file.name + '</h4>' +
                    '<p class="state">等待上传...</p>' +
                    ' <span id="iid"></span><span id="all"></span>' +
                    '<div class="webuploadDelbtn"><button type="button" class="btn btn-danger">删除</button></div><br /></div>');
            }
            else {
                var $lii = $(wuFileSelector);//修改已上传的
                $lii.html('<div id='+wuFileId+' class="item">' +
                    '<h4 class="info">' + file.name + '</h4>' +
                    '<p class="state">等待上传...</p>' +
                    '<span id="iid"></span><span id="all"></span>' +
                    '<div class="webuploadDelbtn"><button type="button" class="btn btn-danger">删除</button></div><br /></div>');

            }
        }
    });

    // 文件上传过程中创建进度条实时显示。
    uploader.on('uploadProgress', function (file, percentage) {
        $li = $(wuFileSelector),
            $percent = $li.find('.progress .progress-bar');

        // 避免重复创建---进度条
        if (!$percent.length) {
            $percent = $('<div class="progress ctive">' +
                '<div class="progress-bar" role="progressbar" style="width: 0%">' +
                '</div>' +
                '</div>').appendTo($li).find('.progress-bar');
        }

        $li.find('p.state').text('上传中');
        $percent.css('width', percentage * 100 + '%');//进度条
        //上传期间所上传占总的比例
        var nowSize = 0;//已上传大小
        var allSize = 0;
        var fz;
        var gb = Math.pow(1024, 3);
        var mb = Math.pow(1024, 2);
        var kb = 1024;
        var fileSize = uploader.getFiles()[uploader.getFiles().length - 1].size;//总大小
        if (fileSize >= gb) {
            fz = (fileSize / gb).toFixed(2);
            allSize = fz + "GB";
            nowSize = (fz * percentage).toFixed(2) + "GB";
        }
        else if (fileSize >= mb) {
            fz = (fileSize / mb).toFixed(2);
            allSize = fz + "MB";
            nowSize = (fz * percentage).toFixed(2) + "MB";
        }
        else if (fileSize >= kb) {
            fz = (fileSize / kb).toFixed(2);
            allSize = fz + "KB";
            nowSize = (fz * percentage).toFixed(2) + "KB";
        }
        else {
            fz = fileSize;
            allSize = fz + "B";
            nowSize = fz * percentage + "B";
        }
        //var iidSize = nowSize / Size;
        $("#iid").html((percentage*100).toFixed(2)+"%    ");//已上传比例
        $("#all").html(nowSize + "/" + allSize);//总大小

    });
    uploader.on('uploadSuccess', function (file, response) {
        //console.log(response._raw);
        $(wuFileSelector).find('p.state').text('已完成');
        //uploader.removeFile(file);//删除
        //uploader.reset();

        //上传出错
        if (!response.result) {
            $(wuFileSelector).find('p.state').text("上传出错");
        } else {
            $(wuFileSelector).find('p.state').text('已完成');

            var sysFileName = response.relativePath;
            var dataItems = '<div id="_forDelete">';
            dataItems += '<input type="hidden" name="fileName" id="fileName" value="'+file.name+'"/>';
            dataItems += '<input type="hidden" name="sysFileName" id="sysFileName" value="'+sysFileName+'"/>';
            dataItems += '</div>';

            dataItems = dataItems.replace("fileName", fileNameAttr).replace("sysFileName", sysFileNameAttr);

            $("#" + opts.uploadedFilesId).empty();
            $("#" + opts.uploadedFilesId).append(dataItems);
        }
    });

    uploader.on('uploadError', function (file) {
        $(wuFileSelector).find('p.state').text('上传出错');
    });

    uploader.on('uploadComplete', function (file) {
        //$('#' + file.id).find('.progress').fadeOut();//删除进度条
    });

    /**
     * 验证文件格式以及文件大小
     */
    uploader.on("error", function (type) {

        if (type === "F_EXCEED_SIZE") {
            alert("文件大小不能超过限制大小");
        }
        else {
            alert("上传出错！请检查后重新上传！错误代码" + type);
        }
    });

    //删除时执行的方法
    uploader.on('fileDequeued', function (file) {
        debugger

        var fullName = $("#_forDelete").find("#sysFileName").val();
        if (fullName!=null) {
            $.post(opts.deleteServer, { sysFileName: fullName }, function (data) {
            })
        }
        $(wuFileSelector).remove();
        //删除准备上传的文件信息
        var toRemove = $("#_forDelete");
        $(toRemove).remove();
    });

    //删除
    $list.on("click", ".webuploadDelbtn", function () {
        debugger
        //var file = uploader.getFile('WU_FILE_');
        //uploader.removeFile(file);

        var id = $(this).parent().attr("id");
        var file = uploader.getFile(id);
        if (file) {
            uploader.removeFile(file);
        }
    });

    return uploader;
}