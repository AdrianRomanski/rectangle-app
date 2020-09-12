package adrianromanski.rectangleapp;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;


@Route
public class RectangleGui extends VerticalLayout {

    private RectangleRepository rectangleRepository;

    private TextField textFieldHeight;
    private TextField textFieldWidth;
    private Button button;

    @Autowired
    public RectangleGui(RectangleRepository rectangleRepository) {
        this.rectangleRepository = rectangleRepository;
        textFieldHeight = new TextField("Height");
        textFieldWidth = new TextField("Width");
        button = new Button("Add");

        button.addClickListener(clickEvent -> addRectangle());

        add(textFieldHeight, textFieldWidth, button);
    }


    public void addRectangle() {
        Rectangle rectangle = new Rectangle();
        rectangle.setHeight(Integer.parseInt(textFieldHeight.getValue()));
        rectangle.setWidth(Integer.parseInt(textFieldWidth.getValue()));
        rectangleRepository.save(rectangle);
    }
}
