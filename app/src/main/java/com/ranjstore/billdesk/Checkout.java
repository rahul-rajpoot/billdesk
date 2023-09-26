package com.ranjstore.billdesk;



public class Checkout {
   public static  final int Cancel=2;

   public static  final int NetworkError =5;
    private String setKeyID;
    private String image;

    public String getSetKeyID() {
        return setKeyID;
    }

    public void setSetKeyID(String setKeyID) {
        this.setKeyID = setKeyID;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

   

    public void setKeyID(String secretKey) {
    }
}
