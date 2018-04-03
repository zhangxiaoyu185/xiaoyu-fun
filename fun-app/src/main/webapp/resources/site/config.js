var config = {};

config.api = [ 
    {
		module : "用户相关",
		payload : [ 
			{
				name : "用户注册",
				id : "register",
				path : "busiUser/register",
				path2 : "busiUser/register",
				method : "post",
				params : {
					bsusrCode : 'zhang',
					bsusrPwd : '1234567',
					confirmPwd : '1234567',
					bsaqnQuestion : '10001',
					bsaqnResult : '123',
					version : 'V1.0.0'
				}
			},
			{
				name : "用户登录",
				id : "login",
				path : "busiUser/login",
				path2 : "busiUser/login",
				method : "post",
				params : {
					bsusrCode : 'zhang',
					bsusrPwd : '1234567',
					version : 'V1.0.0'
				}
			},
			{
				name : "忘记密码",
				id : "forgetPwd",
				path : "busiUser/forget/pwd",
				path2 : "busiUser/forget/pwd",
				method : "post",
				params : {
					bsusrCode : 'zhang',
					newPwd : '1234567',
					confirmPwd : '1234567',
					bsaqnQuestion : '10001',
					bsaqnResult : '123'
				}
			},
			{
				name : "修改密码",
				id : "updatePwd",
				path : "busiUser/update/pwd",
				path2 : "busiUser/update/pwd",
				method : "post",
				params : {
					bsusrUuid : 'UCWFDQQPFLAMTKZUMGNKOPRDBAKVVIWC',
					oldPwd : '1234567',
					newPwd : '1234567',
					confirmPwd : '1234567'
				}
			},
			{
				name : "用户登出",
				id : "logout",
				path : "busiUser/logout",
				path2 : "busiUser/logout",
				method : "post",
				params : {
				}
			}
		]
    },{
    	module : "密保问题",
    	payload : [
    	    {
    	        name : "获取密保问题列表",
    			id : "getAllSafeQuestions",
    			path : "busiQuestion/sel",
    			path2 : "busiQuestion/sel",
    			method : "post",
    			params : {
    			} 
    	    },
    	    {
    	        name : "更新用户的密保问题",
    			id : "updateAnswerquestion",
    			path : "busiAnswerquestion/update",
    			path2 : "busiAnswerquestion/update",
    			method : "post",
    			params : {
    				bsaqnUser : 'UCWFDQQPFLAMTKZUMGNKOPRDBAKVVIWC',
    				bsaqnQuestion : '10001',
    				bsaqnResult : '123'
    			} 
    	    },
    	    {
    	        name : "获取用户的密保问题",
    			id : "getAnswerquestion",
    			path : "busiAnswerquestion/get",
    			path2 : "busiAnswerquestion/get",
    			method : "post",
    			params : {
    				bsaqnUser : 'UCWFDQQPFLAMTKZUMGNKOPRDBAKVVIWC'
    			} 
    	    }
    	]
    },{
    	module : "个人中心",
    	payload : [
    	    {
    	        name : "添加反馈意见",
    			id : "addFeedback",
    			path : "busiFeedback/add",
    			path2 : "busiFeedback/add",
    			method : "post",
    			params : {
    				bsfbkContent : '我有意见',
    				bsfbkUser : 'UCWFDQQPFLAMTKZUMGNKOPRDBAKVVIWC',
    				bsfbkRelation : '1556377990@qq.com'
    			} 
    	    },
    	    {
    	        name : "版本更新",
    			id : "getVersion",
    			path : "busiVersion/get",
    			path2 : "busiVersion/get",
    			method : "post",
    			params : {
    				bsvsnNo : 'V0.0.1',
    				bsvsnType : 1
    			} 
    	    },
    	    {
    	        name : "更改个人信息",
    			id : "updateUesrInfo",
    			path : "busiUser/update/user/info",
    			path2 : "busiUser/update/user/info",
    			method : "post",
    			params : {
    				bsusrUuid : 'UCWFDQQPFLAMTKZUMGNKOPRDBAKVVIWC',
    				bsusrCode : 'zhang',
    				bsusrSignature : '',
    				bsusrBirthday : '2014-12-08',
    				bsusrSex : 1,
    				bsusrHobby : '',
    				bsusrCity : '杭州',
    				bsusrHeadUrl : '',
    				bsusrPersonalNote : '',
    				bsusrPhone : ''
    			} 
    	    },
    	    {
    	        name : "查询个人信息",
    			id : "findUesrInfo",
    			path : "busiUser/find/user/info",
    			path2 : "busiUser/find/user/info",
    			method : "post",
    			params : {
    				bsusrUuid : 'UCWFDQQPFLAMTKZUMGNKOPRDBAKVVIWC'
    			} 
    	    }
    	]
    },{
    	module : "图片处理",
    	payload : [
    	    {
    	        name : "获取头像",
    			id : "getAccountHeadPic",
    			path : "image/account/head/get/{picName}",
    			path2 : "image/account/head/get/1",
    			method : "get",
    			params : {
    			} 
    	    },
    	    {
    	        name : "获取趣事原图",
    			id : "getFunPicOriginal",
    			path : "image/fun/get/original/{picName}",
    			path2 : "image/fun/get/original/1",
    			method : "get",
    			params : {
    			} 
    	    }
    	]
    },{
    	module : "趣事",
    	payload : [
    	    {
    	        name : "趣事内容列表（最新/热门）",
    			id : "findContentList",
    			path : "busiFun/content/list",
    			path2 : "busiFun/content/list",
    			method : "post",
    			params : {
    				lastId : 10,
    				sortBy : 1,
    				type : 0,
    				limit : 3
    			} 
    	    },
    	    {
    	        name : "趣事详情",
    			id : "findContentDetail",
    			path : "busiFun/content/detail",
    			path2 : "busiFun/content/detail",
    			method : "post",
    			params : {
    				bsfunUuid : 'WGVLRVHTFJPUCQMAVJZMWWTNTIZDEQCE'
    			} 
    	    },
    	    {
    	        name : "发布趣事",
    			id : "addFun",
    			path : "busiFun/content/add",
    			path2 : "busiFun/content/add",
    			method : "post",
    			params : {
    				bsfunContent : '123123123',
    				bsfunSource : '123',
    				bsfunPicurl : 'Y',
    				bsfunPushUser : 'UCWFDQQPFLAMTKZUMGNKOPRDBAKVVIWC',
    				bsfunType : 0
    			} 
    	    },
    	    {
    	        name : "我参与的趣事",
    			id : "findMyHandIn",
    			path : "busiFun/my/hand",
    			path2 : "busiFun/my/hand",
    			method : "post",
    			params : {
    				lastId : 10,
    				userUuid : 'UCWFDQQPFLAMTKZUMGNKOPRDBAKVVIWC',
    				limit : 3
    			} 
    	    },
    	    {
    	        name : "我发布的趣事",
    			id : "findMyPush",
    			path : "busiFun/my/push",
    			path2 : "busiFun/my/push",
    			method : "post",
    			params : {
    				lastId : 10,
    				userUuid : 'UCWFDQQPFLAMTKZUMGNKOPRDBAKVVIWC',
    				limit : 3
    			} 
    	    },
    	    {
    	        name : "我收藏的趣事",
    			id : "findMyCollect",
    			path : "busiFun/my/collect",
    			path2 : "busiFun/my/collect",
    			method : "post",
    			params : {
    				lastId : 10,
    				userUuid : 'UCWFDQQPFLAMTKZUMGNKOPRDBAKVVIWC',
    				limit : 3
    			} 
    	    },
    	    {
    	        name : "赞（审核通过）",
    			id : "goodContent",
    			path : "busiFun/content/good",
    			path2 : "busiFun/content/good",
    			method : "post",
    			params : {
    				bsfunUuid : 'WGVLRVHTFJPUCQMAVJZMWWTNTIZDEQCE',
    				userUuid : 'UCWFDQQPFLAMTKZUMGNKOPRDBAKVVIWC'
    			} 
    	    },
    	    {
    	        name : "不赞（审核失败）",
    			id : "failContent",
    			path : "busiFun/content/fail",
    			path2 : "busiFun/content/fail",
    			method : "post",
    			params : {
    				bsfunUuid : 'WGVLRVHTFJPUCQMAVJZMWWTNTIZDEQCE',
    				userUuid : 'UCWFDQQPFLAMTKZUMGNKOPRDBAKVVIWC'
    			} 
    	    },
    	    {
    	        name : "跳过(下一个)",
    			id : "jumpContent",
    			path : "busiFun/content/jump",
    			path2 : "busiFun/content/jump",
    			method : "post",
    			params : {
    				userUuid : 'UCWFDQQPFLAMTKZUMGNKOPRDBAKVVIWA'
    			} 
    	    },
    	    {
    	        name : "举报趣事",
    			id : "addReport",
    			path : "busiReport/report/add",
    			path2 : "busiReport/report/add",
    			method : "post",
    			params : {
    				bsretUser : 'UCWFDQQPFLAMTKZUMGNKOPRDBAKVVIWC',
    				bsretFun : 'WGVLRVHTFJPUCQMAVJZMWWTNTIZDEQCE'
    			} 
    	    },
    	    {
    	        name : "收藏趣事",
    			id : "addCollect",
    			path : "busiCollect/collect/add",
    			path2 : "busiCollect/collect/add",
    			method : "post",
    			params : {
    				bscltUser : 'UCWFDQQPFLAMTKZUMGNKOPRDBAKVVIWC',
    				bscltFun : 'WGVLRVHTFJPUCQMAVJZMWWTNTIZDEQCE'
    			} 
    	    },
    	    {
    	        name : "取消收藏",
    			id : "cancelCollect",
    			path : "busiCollect/collect/cancel",
    			path2 : "busiCollect/collect/cancel",
    			method : "post",
    			params : {
    				bscltUser : 'UCWFDQQPFLAMTKZUMGNKOPRDBAKVVIWC',
    				bscltFun : 'WGVLRVHTFJPUCQMAVJZMWWTNTIZDEQCE'
    			} 
    	    },
    	    {
    	        name : "添加评论",
    			id : "addComment",
    			path : "busiComment/comment/add",
    			path2 : "busiComment/comment/add",
    			method : "post",
    			params : {
    				bscotUser : 'UCWFDQQPFLAMTKZUMGNKOPRDBAKVVIWC',
    				bscotFun : 'WGVLRVHTFJPUCQMAVJZMWWTNTIZDEQCE',
    				bscotContent : '啦啦啦啦啦啦啦啦'
    			} 
    	    },
    	    {
    	        name : "评论列表",
    			id : "findBusiCommentByFun",
    			path : "busiComment/comment/list",
    			path2 : "busiComment/comment/list",
    			method : "post",
    			params : {
    				lastId : 10,
    				bscotFun : 'WGVLRVHTFJPUCQMAVJZMWWTNTIZDEQCE',
    				limit : 3
    			} 
    	    }
    	]
    }
];

var _attachId = function(api) {
	for (var i = 0; i < api.length; i++) {
		var mid = "m" + i;
		api[i].id = mid;
		var pd = api[i].payload;
		for (var j = 0; j < pd.length; j++) {
			var aid = "i" + j;
			pd[j].id = mid + aid;

		}
	}

};
_attachId(config.api);

if ( typeof module === "object" && module && typeof module.exports === "object" ) {	
	module.exports = config.api;
}