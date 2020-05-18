/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vehicle_showroom;

/**
 *
 * @author Motahar-zaman
 */
public class Vehicle {
    private String modelNo;
    private String engineType;
    private String enginePower;
    private String tyreSize;

    public String getModelNo() {
        return modelNo;
    }

    public void setModelNo(String modelNo) {
        this.modelNo = modelNo;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public String getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(String enginePower) {
        this.enginePower = enginePower;
    }

    public String getTyreSize() {
        return tyreSize;
    }

    public void setTyreSize(String tyreSize) {
        this.tyreSize = tyreSize;
    }
    
    public void setVehicle(String modelNo, String engineType, String enginePower, String tyreSize){
        this.modelNo = modelNo;
        this.engineType = engineType;
        this.enginePower = enginePower;
        this.tyreSize = tyreSize;
    }
}
