package co.id.dicoding.movieappdesign.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Cast implements Parcelable {

    private int cast_id;
    private String character;
    private String credit_id;
    private int gender;
    private int id;
    private String name;
    private int order;
    private String profile_path;

    public int getCast_id() {
        return cast_id;
    }

    public void setCast_id(int cast_id) {
        this.cast_id = cast_id;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public String getCredit_id() {
        return credit_id;
    }

    public void setCredit_id(String credit_id) {
        this.credit_id = credit_id;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getProfile_path() {
        return profile_path;
    }

    public void setProfile_path(String profile_path) {
        this.profile_path = profile_path;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.cast_id);
        dest.writeString(this.character);
        dest.writeString(this.credit_id);
        dest.writeInt(this.gender);
        dest.writeInt(this.id);
        dest.writeString(this.name);
        dest.writeInt(this.order);
        dest.writeString(this.profile_path);
    }

    public Cast() {
    }

    protected Cast(Parcel in) {
        this.cast_id = in.readInt();
        this.character = in.readString();
        this.credit_id = in.readString();
        this.gender = in.readInt();
        this.id = in.readInt();
        this.name = in.readString();
        this.order = in.readInt();
        this.profile_path = in.readString();
    }

    public static final Parcelable.Creator<Cast> CREATOR = new Parcelable.Creator<Cast>() {
        @Override
        public Cast createFromParcel(Parcel source) {
            return new Cast(source);
        }

        @Override
        public Cast[] newArray(int size) {
            return new Cast[size];
        }
    };
}
