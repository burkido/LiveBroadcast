package com.example.kanal;

import java.util.ArrayList;

public class Chanel  {

    private String chanelName;
    private int ImageID;
    private String link;

    public Chanel() {

    }


    public Chanel(String chanelName, int imageID, String link) {
        this.chanelName = chanelName;
        this.ImageID = imageID;
        this.link = link;
    }


    public String getChanelName() {
        return chanelName;
    }

    public void setChanelName(String chanelName) {
        this.chanelName = chanelName;
    }

    public int getImageID() {
        return ImageID;
    }

    public void setImageID(int imageID) {
        ImageID = imageID;
    }

    public String getLinkName() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }


    public static ArrayList<Chanel>getData(){

        ArrayList<Chanel> chanelArrayList = new ArrayList<>();

        String chanelNames[] = {"Kanal D", "Show TV", "Atv", "FOX", "Star", "Tv8", "NBA"};
        int chanelImages[] = {R.drawable.kanal_d, R.drawable.show_tv, R.drawable.atv, R.drawable.fox, R.drawable.star_tv, R.drawable.tv8, R.drawable.nba};
        String links[] = {"https://www.kanald.com.tr/canli-yayin", "https://www.showtv.com.tr/canli-yayin/", "https://www.atv.com.tr/webtv/canli-yayin",
        "https://www.fox.com.tr/canli-yayin","https://www.startv.com.tr/canli-yayin", "https://www.startv.com.tr/canli-yayin", "http://nbastreams.xyz/schedules/"};

        for(int i=0; i< chanelImages.length;i++){

            Chanel data = new Chanel();

            data.setChanelName(chanelNames[i]);
            data.setImageID(chanelImages[i]);
            data.setLink(links[i]);

            chanelArrayList.add(data);
        }
        return chanelArrayList;
    }
}