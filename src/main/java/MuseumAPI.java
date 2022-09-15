import Model.Painting;
import Service.ArtistService;
import Service.PaintingService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.Javalin;
import io.javalin.core.JavalinConfig;

import java.sql.SQLException;
import java.util.Scanner;

public class MuseumAPI {
    public static void main(String[] args) throws SQLException {

        PaintingService ps = new PaintingService();
        ArtistService as = new ArtistService();
        Javalin app = Javalin.create(JavalinConfig::enableCorsForAllOrigins);

        app.start(9000);

        app.get("/paintings/", ctx -> ctx.json(ps.getAllPaintings()));
        app.get("/paintings/artistname/{name}", ctx ->

//            we're passing in the expected behavior to the web request into the method get
//            ctx.result returns a http response
//            ctx.pathParam grabs the param surrounded by curly braces in app.get
//            for our http response, return the result of paintingservice getallpaintings(name) as a string
            ctx.json(ps.getAllPaintingsByArtistName(ctx.pathParam("name")))
        );
        app.get("paintings/artistid/{id}", ctx -> {
            ctx.json(ps.getAllPaintingsByArtistID(Integer.parseInt(ctx.pathParam("id"))));
        });
        app.post("paintings", ctx ->{
            ObjectMapper mapper = new ObjectMapper();
            Painting requestPainting = mapper.readValue(ctx.body(), Painting.class);
            ps.addPainting(requestPainting.getTitle(), requestPainting.getArtistID(), requestPainting.getUrl());
        });
        app.get("paintings/title/{title}", ctx->
        {ctx.json(ps.getPaintingByTitle(ctx.pathParam("title")));});
        app.get("artist/{id}", ctx-> {
           ctx.json(as.getArtistFromId(Integer.parseInt(ctx.pathParam("id")))) ;
        });
/*
What's actually happening with javalin is MULTITHREADING
Javalin actually runs multiple instances of Java executions simultaneously.
First, it sets up the server (with our app.get / app.post / app.delete etc endpoints) and block the program
from finishing, as it is in a permanent while loop waiting for new web requests to come in.
 */
    }
}