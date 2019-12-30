package co.id.dicoding.movieappdesign.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Crew implements Parcelable {

    private String credit_id;
    private String department;
    private int gender;
    private int id;
    private String job;
    private String name;
    private String profile_path;

    public String getCredit_id() {
        return credit_id;
    }

    public void setCredit_id(String credit_id) {
        this.credit_id = credit_id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
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

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        dest.writeString(this.credit_id);
        dest.writeString(this.department);
        dest.writeInt(this.gender);
        dest.writeInt(this.id);
        dest.writeString(this.job);
        dest.writeString(this.name);
        dest.writeString(this.profile_path);
    }

    public Crew() {
    }

    protected Crew(Parcel in) {
        this.credit_id = in.readString();
        this.department = in.readString();
        this.gender = in.readInt();
        this.id = in.readInt();
        this.job = in.readString();
        this.name = in.readString();
        this.profile_path = in.readString();
    }

    public static final Parcelable.Creator<Crew> CREATOR = new Parcelable.Creator<Crew>() {
        @Override
        public Crew createFromParcel(Parcel source) {
            return new Crew(source);
        }

        @Override
        public Crew[] newArray(int size) {
            return new Crew[size];
        }
    };
}
