package com.quathar.form.model;

import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class MyParams {

    private static final int MAX_NUM_FIELDS = 13;

    // <<-FIELDS-->
    private String name;
    private String passwd;
    private String confirmPasswd;
    private String iterations;
    private String selectedSemaphore;
    private String selectedCountry;
    private String document;
    private List<String> selectedMusic;
    private List<String> selectedHobbies;
    private String comments;
    private String license;
    private String iconX;
    private String iconY;
    private int counter = 0;

    // <<-CONSTRUCTORS-->
    public MyParams() {
//        setCounter(MAX_NUM_FIELDS + 1);
//        setCounter("0");
    }

    public MyParams(String name, String passwd, String confirmPasswd, String iterations,
                    String selectedSemaphore, String selectedCountry, String document,
                    List<String> selectedMusic, List<String> selectedHobbies,
                    String comments, String license, String iconX, String iconY) {
//        setCounter          ("0");
        setName             (name);
        setPasswd           (passwd);
        setConfirmPasswd    (confirmPasswd);
        setIterations       (iterations);
        setSelectedSemaphore(selectedSemaphore);
        setSelectedCountry  (selectedCountry);
        setDocument         (document);
        setSelectedMusic    (selectedMusic);
        setSelectedHobbies  (selectedHobbies);
        setComments         (comments);
        setLicense          (license);
        setIconX            (iconX);
        setIconY            (iconY);
    }

    // <-
    private String count(String attr) {
        if (attr != null) counter++;
        return attr;
    }

    private List<String> count(List<String> attr) {
        if (attr != null) counter++;
        return attr;
    }

    // <<-GETTERS AND SETTERS-->
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = count(name);
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = count(passwd);
    }

    public String getConfirmPasswd() {
        return confirmPasswd;
    }

    public void setConfirmPasswd(String confirmPasswd) {
        this.confirmPasswd = count(confirmPasswd);
    }

    public String getIterations() {
        return iterations;
    }

    public void setIterations(String iterations) {
        if (iterations != null)
            counter++;
        this.iterations = iterations != null ?
                String.valueOf(Integer.parseInt(iterations) + 1):
                "1";
    }

    public String getSelectedSemaphore() {
        return selectedSemaphore;
    }

    public void setSelectedSemaphore(String selectedSemaphore) {
        this.selectedSemaphore = count(selectedSemaphore);
    }

    public String getSelectedCountry() {
        return selectedCountry;
    }

    public void setSelectedCountry(String selectedCountry) {
        this.selectedCountry = count(selectedCountry);
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = count(document);
    }

    public List<String> getSelectedMusic() {
        return selectedMusic;
    }

    public void setSelectedMusic(List<String> selectedMusic) {
        this.selectedMusic = count(selectedMusic);
    }

    public List<String> getSelectedHobbies() {
        return selectedHobbies;
    }

    public void setSelectedHobbies(List<String> selectedHobbies) {
        this.selectedHobbies = count(selectedHobbies);
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = count(comments);
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = count(license);
    }

    public String getIconX() {
        return iconX;
    }

    public void setIconX(String iconX) {
        System.out.println("Se recibe Icono X");
        this.iconX = count(iconX);
    }

    public String getIconY() {
        return iconY;
    }

    public void setIconY(String iconY) {
        this.iconY = count(iconY);
    }

    public String getCounter() {
        if (counter > MAX_NUM_FIELDS) return "";
        return "Se han recibido " + counter + " parámetros";
    }

//    public void setCounter(int signal) {
//        counter = signal;
//    }

}
