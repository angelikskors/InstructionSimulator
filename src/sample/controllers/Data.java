package sample.controllers;


import javafx.beans.property.SimpleStringProperty;

public class Data {

    private final SimpleStringProperty generalName = new SimpleStringProperty("");
    private final SimpleStringProperty name = new SimpleStringProperty("");

    public Data(String generalName, String name) {
        this.generalName.set(generalName);
        this.name.set(name);
    }

    public String getGeneralName() {
        return generalName.get();
    }

    public void setGeneralName(String generalName) {
        this.generalName.set(generalName);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public SimpleStringProperty generalNameProperty() {
        return generalName;
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }
}
