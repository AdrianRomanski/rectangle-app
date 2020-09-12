package adrianromanski.rectangleapp;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route
public class RectangleSizeGui extends VerticalLayout {

    private RectangleRepository rectangleRepository;

    private TextField textFieldSize;
    private TextArea textAreaRectangles;
    private Button buttonBigger;
    private Button buttonSmaller;

    @Autowired
    public RectangleSizeGui(RectangleRepository rectangleRepository) {
        this.rectangleRepository = rectangleRepository;

        this.textFieldSize = new TextField("Size");
        this.textAreaRectangles = new TextArea("Result");
        this.buttonBigger = new Button("Show Bigger Rectangles");
        this.buttonSmaller = new Button("Show Smaller Rectangles");

        buttonBigger.addClickListener(clickEvent -> textAreaRectangles.setValue(rectangleRepository
                .getBigRectangles(Integer.parseInt(textFieldSize.getValue())).toString()));

        buttonSmaller.addClickListener(clickEvent -> textAreaRectangles.setValue(rectangleRepository
                .getSmallRectangles(Integer.parseInt(textFieldSize.getValue())).toString()));


        add(textFieldSize);
        add(buttonBigger);
        add(buttonSmaller);
        add(textAreaRectangles);
    }
}
