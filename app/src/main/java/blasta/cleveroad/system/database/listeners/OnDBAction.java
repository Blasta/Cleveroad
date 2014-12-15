package blasta.cleveroad.system.database.listeners;

import blasta.cleveroad.system.model.ImageModel;

/**
 * Created by 1 on 15.12.2014.
 */
public interface OnDBAction {
    public void onRemove(ImageModel image);
    public void onAdd(ImageModel image);
}
