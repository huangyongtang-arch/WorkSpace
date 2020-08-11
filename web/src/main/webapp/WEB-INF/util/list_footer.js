

    var tables;
    var pageNumber;
    var opts;

    function doSearch(enable) {
        tables.fnDraw(enable);
    }

    function createDataTable (options) {
        opts = options;
        tables = $('.table-sort').dataTable({
            "pading": false,
            "pagingType": "full_numbers",
            "bStateSave": false,//状态保存
            //"pading":true,
            "ordering": true,
            "bServerSide": true,
            "sAjaxSource": "search",//这个是请求的地址
            "fnServerData": retrieveData, // 获取数据的处理函数
            "searching":false,
            "bProcessing": true,
            columns: opts.columns,
            "createdRow": function (row, data, index) {
                $(row).addClass('text-c');
            },
            fnDrawCallback: function(table) {
                $("#DataTables_Table_0_paginate").append("  去第 <input style='height:20px;width:40px;' class='margin text-center' id='changePage' type='text'> 页  "
                    + "<a class='paginate_button previous disabled' style='margin-bottom:5px' href='javascript:void(0);' id='dataTable-btn'>GO</a>");
                var oTable = $(".table-sort").dataTable();
                $("#changePage").val(pageNumber + 1);
                $('#dataTable-btn').click(function(e) {
                    if($("#changePage").val() && $("#changePage").val() > 0) {
                        var redirectpage = $("#changePage").val() - 1;
                    } else {
                        var redirectpage = 0;
                    }
                    oTable.fnPageChange(redirectpage);
                });
            }
        });

        bind();

        return tables;
    }

    function retrieveData(sSource, aoData, fnCallback) {
        var formData = $("#theForm").serializeArray();//把form里面的数据序列化成数组
        var param = {};
        formData.forEach(function (e) {
            param[e.name] = e.value;
        });
        var start = 0;
        var length = 10;
        aoData.forEach(function (e) {
            if (e.name === 'iDisplayStart') {
                start = e.value;
            }
            else if (e.name === 'iDisplayLength') {
                length = e.value;
            }
        });

        param["pageNumber"] = start / length;
        param["pageSize"] = length;

        pageNumber = start / length;

        $.ajax({
            url: sSource,//这个就是请求地址对应sAjaxSource
            dataSrc: "data",
            data: param,
            type: 'post',
            dataType: 'json',
            async: false,
            success: function (result) {
                fnCallback(result);//把返回的数据传给这个方法就可以了,datatable会自动绑定数据的
            },
            error: function (msg) {
                layer.msg(msg, {icon: 2, time: 2000});
            }
        });
    }
    //删除
    // function del(id) {
    //     layer.confirm("确定要删除这条记录吗?", function(index) {
    //             layer.close(index);
    //             $.ajax({
    //                 url: 'delete/' + id,
    //                 type: 'post',
    //                 dataType: "json",
    //                 cache: "false",
    //                 success: function (data) {
    //                     if (data.result) {
    //                         layer.msg('操作成功！', {icon: 1, time: 2000});
    //                         location.replace(location.href);
    //                     } else {
    //                         layer.msg('操作失败！', {icon: 2, time: 2000});
    //                     }
    //                 },
    //                 error: function (err) {
    //                     layer.msg('操作失败！', {icon: 2, time: 2000});
    //                 }
    //             });
    //         }
    //     );
    // }
    //编辑
    // function edit(id) {
    //     /*
    //     var index = layer.open({
    //         type: 2,
    //         title: opts.editTitle,
    //         content: "edit/" + id
    //     });
    //     layer.full(index);
    //     */
    //     if (w == null || w === '') {
    //         w = 800;
    //     }
    //     if (h == null || h === '') {
    //         h = ($(window).height() - 50);
    //     }
    //     layer_show(opts.editTitle, "edit/" + id, w, h);
    // }

    // 新增
    function add(w, h) {
        /*
        var index = layer.open({
            type: 2,
            title: opts.addTitle,
            content: "add"
        });
        layer.full(index);
        */
        if (w == null || w === '') {
            w=800;
        }
        if (h == null || h === '') {
            h=($(window).height() - 50);
        }
        layer_show(opts.addTitle, "add", w, h);
    }
    //详情
    // function show(id) {
    //     /*
    //     var index = layer.open({
    //         type: 2,
    //         title: "DBC文件详情",
    //         content: "show/" + id
    //     });
    //     layer.full(index);
    //     */
    //     if (w == null || w === '') {
    //         w=800;
    //     }
    //     if (h == null || h === '') {
    //         h=($(window).height() - 50);
    //     }
    //     layer_show(opts.showTitle, "show/" + id, w, h);
    // }
    function bind() {
        //删除
        $(".table-sort tbody").on("click", "#delItem", function () {
            var data = tables.api().row($(this).parents("tr")).data();
            layer.confirm("确定要删除这条记录吗?", function(index) {
                layer.close(index);
                $.ajax({
                    url: 'delete/' + data.id,
                    type: 'post',
                    dataType: "json",
                    cache: "false",
                    success: function (data) {
                        if (data.result) {
                            layer.msg('操作成功！', {icon: 1, time: 2000});
                            location.replace(location.href);
                        } else {
                            layer.msg(data.msg, {icon: 2, time: 2000});
                        }
                    },
                    error: function (err) {
                        layer.msg('操作失败！\n' + err.msg, {icon: 2, time: 2000});
                    }
                });
            });
        });

        //编辑
        $(".table-sort tbody").on("click", "#editItem", function () {
            var data = tables.api().row($(this).parents("tr")).data();
            /*
            var index = layer.open({
                type: 2,
                title: opts.editTitle,
                content: "edit/" + data.id
            });
            layer.full(index);
            */
            layer_show(opts.editTitle, "edit/" + data.id, 800, 500);
        });

        //修改状态
        $(".table-sort tbody").on("click", "#publishItem", function () {
            var data = tables.api().row($(this).parents("tr")).data();
            $.ajax({
                url: 'changeStatus',
                data: {'id': data.id, 'status': data.status},
                type: 'post',
                dataType: "json",
                cache: "false",
                success: function (data) {
                    if (data.result) {
                        layer.msg('操作成功！', {icon: 1, time: 2000});
                        location.replace(location.href);
                    } else {
                        layer.msg('操作失败！', {icon: 2, time: 2000});
                    }
                },
                error: function (err) {
                    layer.msg('操作失败！', {icon: 2, time: 2000});
                }
            });
        });

        //详情
        $(".table-sort tbody").on("click", "#showItem", function () {
            var data = tables.api().row($(this).parents("tr")).data();
            /*
            var index = layer.open({
                type: 2,
                title: opts.showTitle,
                content: "show/" + data.id
            });
            layer.full(index);
            */
            layer_show(opts.showTitle, "show/" + data.id, 800, 500);
        });

        //批量删除
        $("#btn-delAll").on("click", function () {
            var ids = [];
            $("input[name='checkList']").each(function () {
                if ($(this).prop("checked")) {
                    var data = tables.api().row($(this).parents("tr")).data();
                    ids[ids.length] = data.id;
                }
            });

            if (ids.length < 1) {
                layer.msg('请先选择要删除的记录', {time: 4000});
                return;
            }
            layer.confirm('确定要删除吗？', function (index) {
                $.ajax({
                    url: 'batchDel',
                    type: 'post',
                    dataType: 'json',
                    data: {"ids": ids},
                    success: function (data) {
                        if (data.result) {
                            layer.msg('操作成功!', {icon: 1, time: 2000});
                            tables.fnDraw(true);
                        } else {
                            layer.msg(data.msg, {icon: 2, time: 2000});
                        }
                    },
                    error: function (err) {
                        layer.msg('操作失败!', {icon: 2, time: 2000});
                    }
                });
            });
        });
    }
