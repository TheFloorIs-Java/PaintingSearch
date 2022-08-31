import Service.PaintingService;
import Util.ConnectionUtil;

import java.sql.Connection;
import java.util.Scanner;

public class MuseumMenu {
    public static void main(String[] args) {
//        Connection conn = ConnectionUtil.getConnection();
        boolean visitingMuseum = true;
        PaintingService ps = new PaintingService();
        while(visitingMuseum){
            System.out.println("Select options: all paintings, view artist paintings, add painting, quit");
            Scanner userInput = new Scanner(System.in);
            String line = userInput.nextLine();
            if(line.equals("quit")){
                visitingMuseum = false;
            }
            else if(line.equals("all paintings")){
                System.out.println(ps.getAllPaintings());
            }
            else if(line.equals("view artist paintings")){
//                System.out.println("input artist id:");
//                int idInput = userInput.nextInt();
                System.out.println("input artist name:");
                String name = userInput.nextLine();
                System.out.println(ps.getAllPaintingsByArtistName(name));
            }
            else if(line.equals("add painting")){
                System.out.println("input title:");
                String title = userInput.nextLine();
                System.out.println("input artist id:");
                int id = userInput.nextInt();
                ps.addPainting(title, id);
            }
        }
    }
}