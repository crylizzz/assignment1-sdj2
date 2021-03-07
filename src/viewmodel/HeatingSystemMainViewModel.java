package viewmodel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.Model;
import view.ViewHandler;
import viewmodel.HeatingSystemMainViewModel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class HeatingSystemMainViewModel implements PropertyChangeListener {
    private Model model;
    private StringProperty temp1Property, temp2Property, outTempProperty, temp1ErrorProperty, temp2ErrorProperty, outTempErrorProperty;
    public HeatingSystemMainViewModel(Model model) {
        this.temp1Property = new SimpleStringProperty();
        this.temp2Property = new SimpleStringProperty();
        this.outTempProperty = new SimpleStringProperty();
        this.temp1ErrorProperty = new SimpleStringProperty();
        this.temp2ErrorProperty = new SimpleStringProperty();
        this.outTempErrorProperty = new SimpleStringProperty();
        this.model = model;
        //model.addListener()
    }

    public void clear() {
        //this.temp1Property.set(model)
    }
    public StringProperty getTemp1Property() {
        return temp1Property;
    }
    public StringProperty getTemp2Property() {
        return temp2Property;
    }
    public StringProperty getOutTempProperty() {
        return outTempProperty;
    }
    public StringProperty getTemp1ErrorProperty() {
        return temp1ErrorProperty;
    }
    public StringProperty getTemp2ErrorProperty() {
        return temp2ErrorProperty;
    }
    public StringProperty getOutTempErrorProperty() {
        return outTempErrorProperty;
    }
    @Override public synchronized void propertyChange(PropertyChangeEvent propertyChangeEvent) {
        //
    }
}
