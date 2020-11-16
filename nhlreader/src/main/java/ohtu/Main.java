package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import org.apache.http.client.fluent.Request;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players";
        
        String bodyText = Request.Get(url).execute().returnContent().asString();
                
        // System.out.println("json-muotoinen data:");
        // System.out.println( bodyText );

        Gson mapper = new Gson();
        Player[] players = mapper.fromJson(bodyText, Player[].class);
        
        System.out.println("Oliot:");
        for (Player player : players) {
            System.out.println(player);
        }   

        // ArrayList[] suomalaiset = new ArrayList[10];
        // for (Player player : players) {
        //     if (player.getNationality() == "FIN") {
        //         nimi = player.getName();
        //         maalit = player.getGoals() + player.getAssists();
        //         ArrayList[] pelaaja = new ArrayList[10];
        //         pelaaja[0] = maalit;
        //         pelaaja[1] = player;
        //         suomalaiset.append(pelaaja);
        //     }
        // } 
        // suomalaiset.sort();

        // System.out.println("Players from FIN");
        // for (ArrayList pelaaja : suomalaiset) {
        //     System.out.println(pelaaja[1]);
        // }


    }
  
}
