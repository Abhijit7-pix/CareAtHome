package com.example.careathome;

public class Appointments {
    private String serviceName;
    private String servicePrice;
    private String appointmentDate;
    private String userId;

    // Default constructor required for Firebase
    public Appointments() {
    }

    // Constructor with parameters
    public Appointments(String serviceName, String servicePrice, String appointmentDate, String userId) {
        this.serviceName = serviceName;
        this.servicePrice = servicePrice;
        this.appointmentDate = appointmentDate;
        this.userId = userId;
    }

    // Getters and Setters
    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(String servicePrice) {
        this.servicePrice = servicePrice;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
