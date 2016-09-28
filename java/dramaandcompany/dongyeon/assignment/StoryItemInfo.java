package dramaandcompany.dongyeon.assignment;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by kimkisun on 2016-01-04.
 */
public class StoryItemInfo implements Parcelable {
    String image;
    String title;
    String date;
    String memo;

    public String getDate() {
        return date;
    }

    public String getImage() {
        return image;
    }

    public String getMemo() {
        return memo;
    }

    public String getTitle() {
        return title;
    }

    public StoryItemInfo() {
    }

    public StoryItemInfo(Parcel source) {
        image = source.readString();
        title = source.readString();
        memo = source.readString();
        date = source.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(image);
        dest.writeString(title);
        dest.writeString(date);
        dest.writeString(memo);
    }

    public static Creator<StoryItemInfo> CREATOR = new Creator<StoryItemInfo>() {
        @Override
        public StoryItemInfo createFromParcel(Parcel source) {
            return new StoryItemInfo(source);
        }

        @Override
        public StoryItemInfo[] newArray(int size) {
            return new StoryItemInfo[size];
        }
    };
}
