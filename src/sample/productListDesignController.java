package sample;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import model.product;

public class productListDesignController {

    @FXML
    private ImageView profile;

    @FXML
    private Text name;

    @FXML
    private Text price;

    @FXML
    private Text description;

    public void setData(product Product){
        Image image = new Image(getClass().getResourceAsStream(Product.getImgSrc()));
        profile.setImage(image);
        name.setText(Product.getName());
        price.setText(Product.getPrice());
        description.setText(Product.getDescription());
    }

}
