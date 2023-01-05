package com.lti.dto;

import org.springframework.stereotype.Component;

@Component
public class ClientDetail {
    private String ClientID;
    private String ClientData;

    public ClientDetail(){
        ClientID = null;
        ClientData = null;
    }

    public ClientDetail(String id, String data){
        ClientID = id;
        ClientData = data;
    }

    public String getClientID() {
        return ClientID;
    }

    public void setClientID(String clientID) {
        ClientID = clientID;
    }

    public String getClientData() {
        return ClientData;
    }

    public void setClientData(String clientData) {
        ClientData = clientData;
    }

    @Override
    public String toString() {
        return "ClientDetail [ClientID=" + ClientID + ", ClientData=" + ClientData + "]";
    }

    

}