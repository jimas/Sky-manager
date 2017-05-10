$(function () {
    $("#jqGrid").jqGrid({
        url: '../system/list',
        datatype: "json",
        colModel: [			
			{ label: '外系统ID', name: 'sysId', index: 'sys_id', width: 50, key: true },
			{ label: '外系统编码', name: 'sysCode', index: 'sys_code', width: 80 }, 			
			{ label: '外系统描述', name: 'sysDesc', index: 'sys_desc', width: 80 }, 			
			{ label: '外系统URL', name: 'sysUrl', index: 'sys_url', width: 80 }, 			
			{ label: '创建时间', name: 'createTime', index: 'create_time', width: 80 }, 			
			{ label: '更新时间', name: 'updateTime', index: 'update_time', width: 80 }			
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		system: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.system = {};
		},
		update: function (event) {
			var sysId = getSelectedRow();
			if(sysId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(sysId)
		},
		saveOrUpdate: function (event) {
			var url = vm.system.sysId == null ? "../system/save" : "../system/update";
			$.ajax({
				type: "POST",
			    url: url,
			    data: JSON.stringify(vm.system),
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(index){
							vm.reload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
		del: function (event) {
			var sysIds = getSelectedRows();
			if(sysIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: "../system/delete",
				    data: JSON.stringify(sysIds),
				    success: function(r){
						if(r.code == 0){
							alert('操作成功', function(index){
								$("#jqGrid").trigger("reloadGrid");
							});
						}else{
							alert(r.msg);
						}
					}
				});
			});
		},
		getInfo: function(sysId){
			$.get("../system/info/"+sysId, function(r){
                vm.system = r.system;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                page:page
            }).trigger("reloadGrid");
		}
	}
});