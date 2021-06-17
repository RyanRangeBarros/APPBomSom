package com.ryanandvinicius.bomsomapp.fakeDatabase;

import com.ryanandvinicius.bomsomapp.model.Client;

import java.util.ArrayList;
import java.util.List;

public class ClientRepo {
    private List<Client> clientList;

    public ClientRepo(){
        clientList = new ArrayList<>();
    }

    public void addClient(Client client){
        if (client != null){
            clientList.add(client);
        }
    }

    public void editClient(Client client){
        if (client != null){
            int index = findById(client.getCpf());
            if (index >= 0){
                clientList.add(index,client);
            }
        }
    }

    private int findById(String id){
        for (int i = 0; i < clientList.size(); i++){
            Client c = clientList.get(i);
            if (c.getCpf().trim().equals(id.trim())){
                return i;
            }
        }
        return -1;
    }


}
