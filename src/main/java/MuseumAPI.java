import Model.Painting;
import Service.ArtistService;
import Service.PaintingService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.Javalin;

import java.sql.SQLException;
import java.util.Scanner;

public class MuseumAPI {
    public static void main(String[] args) throws SQLException {
        PaintingService ps = new PaintingService();
        ArtistService as = new ArtistService();
        Javalin app = Javalin.create().start(9000);

        app.get("/paintings/", ctx -> {ctx.result(ps.getAllPaintings().toString());});
        app.get("/paintings/artistname/{name}", ctx ->
        {
//            we're passing in the expected behavior to the web request into the method get
//            ctx.result returns a http response
//            ctx.pathParam grabs the param surrounded by curly braces in app.get
//            for our http response, return the result of paintingservice getallpaintings(name) as a string
            ctx.json(ps.getAllPaintingsByArtistName(ctx.pathParam("name")));
        });
        app.get("paintings/artistid/{id}", ctx -> {
            ctx.json(ps.getAllPaintingsByArtistID(Integer.parseInt(ctx.pathParam("id"))));
        });
        app.post("paintings", ctx ->{
            ObjectMapper mapper = new ObjectMapper();
            Painting requestPainting = mapper.readValue(ctx.body(), Painting.class);
            ps.addPainting(requestPainting.getTitle(), requestPainting.getArtistID());
        });

    }
}