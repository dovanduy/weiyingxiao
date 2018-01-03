package com.leither.scripts.syncScripts;

import com.koushikdutta.async.http.server.AsyncHttpServerResponse;
import com.leither.entity.MsgSummary;
import com.leither.share.Global;

import org.json.JSONObject;

import java.util.Map;

public class GetConversationList extends SyncScript{

    public AsyncHttpServerResponse response;
    public GetConversationList(AsyncHttpServerResponse response){
        super(response);
        this.response = response;
    }
    @Override
    public String exec() throws Exception{
        Map<String, MsgSummary> msgSummaryMap = Global.getDefault().getConversationList();
        JSONObject jsonObject = new JSONObject(msgSummaryMap);
        return returnValue(jsonObject);
    }
}