package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import org.apache.http.client.fluent.Request;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players";
        
        String bodyText = Request.Get(url).execute().returnContent().asString();
                
        // System.out.println("json-muotoinen data:");
        // System.out.println( bodyText );

        Gson mapper = new Gson();
        Player[] players = mapper.fromJson(bodyText, Player[].class);
        
        // System.out.println("Oliot:");
        // for (Player player : players) {
        //     System.out.println(player);
        // }   

        ArrayList<Player> suomalaiset = new ArrayList<Player>();
        for (Player player : players) {
            if (player.getNationality().equals("FIN")) {
                suomalaiset.add(player);
            }
        } 
        Collections.sort(suomalaiset, Comparator.comparing(Player::pisteet));
        // Collections.sort(suomalaiset, Collections.reverseOrder());

        System.out.println("Players from FIN");
        for (Player player : suomalaiset) {
            System.out.println(player);
        }


    }
  
}
