import DAO.PaintingRepository;
import Model.Painting;
import Service.ArtistService;
import Service.PaintingService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.SQLException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;

public class PaintingServiceTest {

    @Test
    public void addPaintingWhenPaintingExistsDoNotAdd() throws SQLException {
        ArtistService as;
        PaintingRepository pr;
        as = Mockito.mock(ArtistService.class);
        pr = Mockito.mock(PaintingRepository.class);
        Painting p =new Painting("TestPainting", 1);
        Mockito.when(pr.getPaintingByTitle("TestPainting")).thenReturn(p);
        PaintingService ps = new PaintingService(as, pr);
        Mockito.verify(pr, never()).addPainting(p);

        /*
        let's set up a fake paintingrepository and a fake artistservice:
        when the paintingrepository is asked if testpainting exists, we return a painting as if it exists
        in the DB.
        that means that paintingservice SHOULD not attempt to add the painting.
        Let mockito verify that adding the painting was never attempted.
         */
    }
    @Test
    public void addPaintingWhenPaintingDoesNotExistAdd() throws SQLException {
        ArtistService as;
        PaintingRepository pr;
        as = Mockito.mock(ArtistService.class);
        pr = Mockito.mock(PaintingRepository.class);
        Painting p =new Painting("TestPainting", 1);
        Mockito.when(pr.getPaintingByTitle("TestPainting")).thenReturn(null);
        PaintingService ps = new PaintingService(as, pr);
        ps.addPainting("TestPainting", 1);
        Mockito.verify(pr).addPainting(any(Painting.class));
        /*
        We were able to verify that the addPainting method at some point was called
         */
    }
}
