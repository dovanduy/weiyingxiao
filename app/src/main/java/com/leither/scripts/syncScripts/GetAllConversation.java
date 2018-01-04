package com.leither.scripts.syncScripts;

import android.util.Log;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.koushikdutta.async.http.server.AsyncHttpServerResponse;
import com.leither.entity.MsgContent;
import com.leither.share.Global;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class GetAllConversation extends SyncScript{

    public AsyncHttpServerResponse response;
    public GetAllConversation(AsyncHttpServerResponse response){
        super(response);
        this.response = response;
    }
    @Override
    public String exec() throws Exception{
        Map<String, MsgContent> msgSummaryMap = Global.getDefault().getAllConversation();
        ObjectMapper objectMapper = new ObjectMapper();
        String res = objectMapper.writeValueAsString(msgSummaryMap);
        return returnValue(res);
    }
}