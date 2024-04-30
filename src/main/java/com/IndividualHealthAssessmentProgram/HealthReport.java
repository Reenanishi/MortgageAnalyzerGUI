package com.IndividualHealthAssessmentProgram;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "HealthReport")
public class HealthReport {

    private static final long serialVersionUID = 1L;

    private Integer bloodPressure;
    private Float bmi;
    private Integer cholesterolLDL;
    private Integer cholesterolHDL;
    private Integer bloodGlucoseHemoglobin;
    private Integer triglycerides;

    public HealthReport(Integer bloodPressure, Float bmi, Integer bloodGlucoseHemoglobin,
                        Integer triglycerides, Integer  cholesterolLDL, Integer cholesterolHDL) {
        super();
        this.bloodPressure = bloodPressure;
        this.bmi = bmi;
        this.cholesterolLDL = cholesterolLDL;
        this.cholesterolHDL = cholesterolHDL;
        this.bloodGlucoseHemoglobin = bloodGlucoseHemoglobin;
        this.triglycerides = triglycerides;
    }

    @XmlElement(name="BloodPressure")
    public Integer getBloodPressure() {
        return bloodPressure;
    }

    @XmlElement(name="BMI")
    public Float getBMI() {
        return bmi;
    }

    @XmlElement(name="CholesterolLDL")
    public Integer getCholesterolLDL() {
        return cholesterolLDL;
    }

    @XmlElement(name="CholesterolHDL")
    public Integer getCholesterolHDL() {
        return cholesterolHDL;
    }

    @XmlElement(name="BloodGlucoseHemoglobin")
    public Integer getBloodGlucoseHemoglobin() {
        return bloodGlucoseHemoglobin;
    }

    @XmlElement(name="Triglycerides")
    public Integer geTriglycerides() {
        return triglycerides;
    }

}