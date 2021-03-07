package view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import viewmodel.HeatingSystemMainViewModel;

public class ControlHeaterViewController {
    @FXML
    private Label t1Label, t2Label, outTempLabel, t1ErrorLabel, t2ErrorLabel, outTempErrorLabel;
    @FXML
    private Button controlButton;
    private HeatingSystemMainViewModel heatingSystemMainViewModel;
    private ViewHandler viewHandler;
    //private StringIntegerConverter stringIntegerConverter;
    private Region root;

    public ControlHeaterViewController() {

    }

    public void init(ViewHandler viewHandler, HeatingSystemMainViewModel heatingSystemMainViewModel, Region root) {
        this.viewHandler = viewHandler;
        this.heatingSystemMainViewModel = heatingSystemMainViewModel;
        this.root = root;
        //stringIntegerConverter=new StringIntegerConverter(-1);
        heatingSystemMainViewModel.clear();

    }
}