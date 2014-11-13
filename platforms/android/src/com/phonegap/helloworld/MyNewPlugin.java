package com.phonegap.helloworld;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.media.AudioManager;
import android.util.Log;


public class MyNewPlugin extends CordovaPlugin {
	public static final String PluginTAG = "changeMode";
	
	public boolean execute 	(String action, JSONArray args, CallbackContext cbc) throws JSONException{
		try
		{
			if (PluginTAG.equals(action))
			{
				JSONObject arg_object = args.getJSONObject(0);
				
				Log.d("mode", arg_object.getString("mode"));
				
				AudioManager audioManager = (AudioManager) this.cordova.getActivity().getSystemService(Context.AUDIO_SERVICE);
				if(arg_object.getString("mode").equals("normal"))
				{
					//For Normal mode
					audioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
				}
				else if(arg_object.getString("mode").equals("silent"))
				{
					//For Silent mode
					audioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
				}
				else if(arg_object.getString("mode").equals("vibrate"))
				{
					//For Vibrate mode
					audioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
				}

			    cbc.success();
				return true;
			} 
			else
			{
				cbc.error("Shit happened");
				return true;
			}
		} 
		catch(Exception e) 
		{
			System.err.println("Exception: " + e.getMessage());
			cbc.error(e.getMessage());
			return false;
		}
	}
}
