package view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import viewmodel.HeatingSystemMainViewModel;

public class HeatingSystemMainViewController {
    @FXML private Label temp1Label, temp2Label, outTempLabel, temp1ErrorLabel, temp2ErrorLabel, outTempErrorLabel;
    private HeatingSystemMainViewModel heatingSystemMainViewModel;
    private ViewHandler viewHandler;
    //private StringIntegerConverter stringIntegerConverter;
    private Region root;
    public HeatingSystemMainViewController() {

    }
    public void init(ViewHandler viewHandler, HeatingSystemMainViewModel viewModel, Region root) {
        this.viewHandler = viewHandler;
        this.heatingSystemMainViewModel = viewModel;
        this.root = root;
        //stringIntegerConverter=new StringIntegerConverter(-1);
        viewModel.clear();
        temp1Label.textProperty().bindBidirectional(heatingSystemMainViewModel.getTemp1Property());
        temp2Label.textProperty().bindBidirectional(heatingSystemMainViewModel.getTemp2Property());
        outTempLabel.textProperty().bindBidirectional(heatingSystemMainViewModel.getOutTempProperty());
        temp1ErrorLabel.textProperty().bindBidirectional(heatingSystemMainViewModel.getTemp1ErrorProperty());
        temp2ErrorLabel.textProperty().bindBidirectional(heatingSystemMainViewModel.getTemp2ErrorProperty());
        outTempErrorLabel.textProperty().bindBidirectional(heatingSystemMainViewModel.getOutTempErrorProperty());
    }
    public void reset() {
        heatingSystemMainViewModel.clear();
    }
    public Region getRoot() {
        return root;
    }
}
