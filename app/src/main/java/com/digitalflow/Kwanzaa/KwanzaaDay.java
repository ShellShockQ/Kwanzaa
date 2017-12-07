package com.digitalflow.Kwanzaa;

/**
 * Created by Detrick on 11/29/2017.
 */

public class KwanzaaDay {
    public String theDate;
    public String EnglishName;
    public String SwahiliName;
    public String ShortExplanation;
    public int ImageId;
    public int BreadCrumb;

    public KwanzaaDay(String thedate, String EnglishName, String SwahiliName, String ShortExplanation, int imageId, int BreadCrumb) {
        this.theDate = theDate;
        this.EnglishName = EnglishName;
        this.SwahiliName = SwahiliName;
        this.ShortExplanation = ShortExplanation;
        this.ImageId = imageId;
        this.BreadCrumb = BreadCrumb;

    }


}
