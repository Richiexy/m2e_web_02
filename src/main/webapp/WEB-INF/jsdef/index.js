/**
 * 首页登陆页面
 */
Ext.onReady(function () {
	 Ext.QuickTips.init();  
	    
	 var loginform = new Ext.form.FormPanel({
		 frame:true,
         defaultType: "textfield",
         defaults:{
        	 allowBlank : false, //控件是否允许为空，设置为不允许为空
        	 labelAlign : 'left', //标签对齐方式
        	 msgTarget : 'side'  //验证后字段在控件右边提示信息
         },
         labelAlign: "right",
         items: [{
             fieldLabel: "用户名",
             name:'userName',  
             blankText:'用户名不能为空'
         },{
             inputType: "password",
             fieldLabel: "密码",
             name:'userPwd',  
             blankText:'密码不能为空'
         }],
         keys:{
        	 key:13,
        	 fn:login
         },
		 renderTo :Ext.getBody()
	 });
	 
	 function login(){  
		 Ext.Msg.alert('提示', '登录窗口.' , function(){
//			 window.location.href = path + '/loginController/login';
		 	window.location.href = path + '/loginController/crudGrid';
		 });
		 
	  } 
	 
	 var win = new Ext.Window({
		title:'登录窗口',
		width: 300,
		closable: false,
		autoHeight: 'true',
		closeAction: 'close',
        buttonAlign:'center',
        items: loginform,
        buttons: [{ 
           	 text: "登录", 
           	 handler: login
         }, { 
           	  text: "重置",
           	  handler:function(){
           		  loginform.form.reset();
           	  }
        }]
	 });
	 
	 win.show();
 });