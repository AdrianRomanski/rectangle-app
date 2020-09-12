package adrianromanski.rectangleapp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class RectangleLoader {

    private RectangleRepository rectangleRepository;

    public RectangleLoader(RectangleRepository rectangleRepository) {
        this.rectangleRepository = rectangleRepository;
    }

    @Value("${siteA1}")
    private int siteA1;
    @Value("${siteB1}")
    private int siteB1;

    @Value("${siteA2}")
    private int siteA2;
    @Value("${siteB2}")
    private int siteB2;

    @Value("${siteA3}")
    private int siteA3;
    @Value("${siteB3}")
    private int siteB3;

    @Value("${siteA4}")
    private int siteA4;
    @Value("${siteB4}")
    private int siteB4;


    @EventListener(ApplicationReadyEvent.class)
    public void addRectangles() {
        Rectangle rectangle1 = new Rectangle(siteA1, siteB1);
        Rectangle rectangle2 = new Rectangle(siteA2, siteB2);
        Rectangle rectangle3 = new Rectangle(siteA3, siteB3);
        Rectangle rectangle4 = new Rectangle(siteA4, siteB4);

        rectangleRepository.saveAll(Arrays.asList(rectangle1, rectangle2, rectangle3, rectangle4));
    }
}
