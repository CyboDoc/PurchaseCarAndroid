package cybodoc.garage.ModelClass;

public class Engine
{
    public String id;
    public String name;
    public String equipmentType;
    public String availability;
    public double compressionRatio;
    public int cylinder;
    public double size;
    public double displacement ;
    public String configuration ;
    public String fuelType ;
    public int horsepower;
    public int torque ;
    public int totalValves;
    public String manufacturerEngineCode ;
    public String type ;
    public String code ;

    public int getTorque() {
        return torque;
    }

    public String getAvailability() {
        return availability;
    }

    public String getCode() {
        return code;
    }

    public double getCompressionRatio() {
        return compressionRatio;
    }

    public String getCompressorType() {
        return compressorType;
    }

    public String getConfiguration() {
        return configuration;
    }

    public int getCylinder() {
        return cylinder;
    }

    public double getDisplacement() {
        return displacement;
    }

    public String getEquipmentType() {
        return equipmentType;
    }

    public String getFuelType() {
        return fuelType;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public String getId() {
        return id;
    }

    public String getManufacturerEngineCode() {
        return manufacturerEngineCode;
    }

    public String getName() {
        return name;
    }

    public Rpm getRpm() {
        return rpm;
    }

    public double getSize() {
        return size;
    }

    public int getTotalValves() {
        return totalValves;
    }

    public String getType() {
        return type;
    }

    public Valve getValve() {
        return valve;
    }

    public String compressorType;
    public Rpm rpm ;
    public Valve valve ;
}