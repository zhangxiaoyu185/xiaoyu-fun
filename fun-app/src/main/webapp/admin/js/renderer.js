var validFlags = [ {
	id : 'ENABLE',
	text : '有效'
}, {
	id : 'DISABLE',
	text : '无效'
} ];

var deviceTypes = [ {
	id : 1,
	text : 'WEB'
}, {
	id : 2,
	text : 'PC'
}, {
	id : 3,
	text : 'ANDROID'
}, {
	id : 4,
	text : 'IOS'
}, {
	id : 5,
	text : 'WP'
} ];

var onlineTypes = [ {
	id : 0,
	text : '离线'
}, {
	id : 1,
	text : '在线'
} ];

var checkBoxTypes = [ {
	id : 0,
	text : '单选'
}, {
	id : 1,
	text : '多选'
} ];

function onValidFlagRenderer(e) {
	for ( var i = 0, l = validFlags.length; i < l; i++) {
		var g = validFlags[i];
		if (g.id == e.value)
			return g.text;
	}
	return "";
}

function onDeviceTypeRenderer(e) {
	for ( var i = 0, l = deviceTypes.length; i < l; i++) {
		var g = deviceTypes[i];
		if (g.id == e.value)
			return g.text;
	}
	return "";
}

function onOnlinTypeRenderer(e) {
	for ( var i = 0, l = onlineTypes.length; i < l; i++) {
		var g = onlineTypes[i];
		if (g.id == e.value)
			return g.text;
	}
	return "";
}

function onCheckBoxTypeRenderer(e) {
	for ( var i = 0, l = checkBoxTypes.length; i < l; i++) {
		var g = checkBoxTypes[i];
		if (g.id == e.value)
			return g.text;
	}
	return "";
}