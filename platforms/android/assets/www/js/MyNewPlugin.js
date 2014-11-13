var MyNewPlugin = {
		createEvent: function(mode, successCallback, errorCallback){
			cordova.exec(
					successCallback, 
					errorCallback,
					'MyNewPlugin',
					'changeMode',
					[{
						"mode": mode
					}]
			);
		}
}