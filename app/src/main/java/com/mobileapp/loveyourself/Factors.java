package com.mobileapp.loveyourself;

/**
 * Created by john.villegas on 05/08/2017.
 */

public class Factors {
    private String id;
    private String dateRecordedYear;
    private String dateRecordedMonth;
    private String dateRecordedDate;
    private String description;
    private String checkReceptive;
    private String checkAccidental;
    private String checkShared;
    private String checkIntravenous;
    private String checkReceived;
    private String checkInsertive;
    private String checkOral;
    private String other;

    public Factors() {

    }

    public Factors(String id, String dateRecordedYear, String dateRecordedMonth, String dateRecordedDate, String description, String checkReceptive, String checkAccidental, String checkShared, String checkIntravenous, String checkReceived, String checkInsertive, String checkOral, String other) {
        this.id = id;
        this.dateRecordedYear = dateRecordedYear;
        this.dateRecordedMonth = dateRecordedMonth;
        this.dateRecordedDate = dateRecordedDate;
        this.description = description;
        this.checkReceptive = checkReceptive;
        this.checkAccidental = checkAccidental;
        this.checkShared = checkShared;
        this.checkIntravenous = checkIntravenous;
        this.checkReceived = checkReceived;
        this.checkInsertive = checkInsertive;
        this.checkOral = checkOral;
        this.other = other;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDateRecordedYear() {
        return dateRecordedYear;
    }

    public void setDateRecordedYear(String dateRecordedYear) {
        this.dateRecordedYear = dateRecordedYear;
    }

    public String getDateRecordedMonth() {
        return dateRecordedMonth;
    }

    public void setDateRecordedMonth(String dateRecordedMonth) {
        this.dateRecordedMonth = dateRecordedMonth;
    }

    public String getDateRecordedDate() {
        return dateRecordedDate;
    }

    public void setDateRecordedDate(String dateRecordedDate) {
        this.dateRecordedDate = dateRecordedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCheckReceptive() {
        return checkReceptive;
    }

    public void setCheckReceptive(String checkReceptive) {
        this.checkReceptive = checkReceptive;
    }

    public String getCheckAccidental() {
        return checkAccidental;
    }

    public void setCheckAccidental(String checkAccidental) {
        this.checkAccidental = checkAccidental;
    }

    public String getCheckShared() {
        return checkShared;
    }

    public void setCheckShared(String checkShared) {
        this.checkShared = checkShared;
    }

    public String getCheckIntravenous() {
        return checkIntravenous;
    }

    public void setCheckIntravenous(String checkIntravenous) {
        this.checkIntravenous = checkIntravenous;
    }

    public String getCheckReceived() {
        return checkReceived;
    }

    public void setCheckReceived(String checkReceived) {
        this.checkReceived = checkReceived;
    }

    public String getCheckInsertive() {
        return checkInsertive;
    }

    public void setCheckInsertive(String checkInsertive) {
        this.checkInsertive = checkInsertive;
    }

    public String getCheckOral() {
        return checkOral;
    }

    public void setCheckOral(String checkOral) {
        this.checkOral = checkOral;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }
}
