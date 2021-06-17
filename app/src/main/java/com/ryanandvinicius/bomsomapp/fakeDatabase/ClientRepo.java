package com.ryanandvinicius.bomsomapp.fakeDatabase;

import com.ryanandvinicius.bomsomapp.model.Client;
import com.ryanandvinicius.bomsomapp.model.MusicStyle;

import java.util.ArrayList;
import java.util.List;

public class ClientRepo {
    private static List<Client> clientList;

    static {
        clientList = new ArrayList<>();
        Client c1 = new Client("11253378422", "João da Costa", "joaocc@gmail.com","81999415133", MusicStyle.FORRO,"Avenida Recife", "Recife", 552, "Casas");
        Client c2 = new Client("11253378422", "João do Morro", "joaocc@gmail.com","81999415133", MusicStyle.FORRO,"Avenida Recife", "Recife", 552, "Casas");
        Client c3 = new Client("11253378422", "Sergio Murilo, Caçador de Dragões", "joaocc@gmail.com","81999415133", MusicStyle.FORRO,"Avenida Recife", "Recife", 552, "Casas");
        Client c4 = new Client("11253378422", "Marcinho Beira-Mar", "joaocc@gmail.com","81999415133", MusicStyle.FORRO,"Avenida Recife", "Recife", 552, "Casas");
        clientList.add(c1);
        clientList.add(c2);
        clientList.add(c3);
        clientList.add(c4);

    }

    public static void addClient(Client client){
        if (client != null){
            clientList.add(client);
        }
    }

    public static void editClient(Client client){
        if (client != null){
            int index = findById(client.getCpf());
            if (index >= 0){
                clientList.add(index,client);
            }
        }
    }

    public static int findById(String id){
        for (int i = 0; i < clientList.size(); i++){
            Client c = clientList.get(i);
            if (c.getCpf().trim().equals(id.trim())){
                return i;
            }
        }
        return -1;
    }


    public static Client find(String id){
        for (Client c: clientList){
            if (c.getCpf().trim().equals(id.trim())){
                return c;
            }
        }
        return null;
    }


    public static List<String> getAllNames(){
        List<String> names = new ArrayList<>();

        for (Client c: clientList){
            names.add(c.getName());
        }
        return names;
    }



}
