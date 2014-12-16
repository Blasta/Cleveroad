package blasta.cleveroad.system.model;

import android.util.Log;

/**
 * Created by 1 on 15.12.2014.
 */
public class ImageModel  {
    private long id = -1;
    private boolean favorite = false;
    private String title;
    private String url;
    private String thumbnailUrl;

    public ImageModel(String title,String url, String thumbnailUrl) {
        this.title = title;
        this.url = url;
        this.thumbnailUrl = url;
    }

    public long getId() {
        return id;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }


    public void setId(long id) {
        this.id = id;
    }

    public void setFavorite(boolean favorite) {
        Log.d("ImageModel", id + "setFavorite " + favorite);
        this.favorite = favorite;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String toString(){
        return String.format("id=%s title=%s image=%s thumbnail=%s favorite=%s", id,title,url,thumbnailUrl,favorite);
    }
}
