package main.navdrawer.codeeden.types;

import android.support.annotation.DrawableRes;

/**
 * Created by Hrishikesh on 5/29/2016.
 */
public class MenuItem {
    private String itemName;
    @DrawableRes
    private int itemMainIcon;
    @DrawableRes
    private String itemUpdates;

    private boolean showUpdates;

    private boolean groupcaption;

    public MenuItem() {
    }

    public MenuItem(String itemName, int itemMainIcon, String itemUpdates, boolean showUpdates, boolean groupcaption) {
        this.itemName = itemName;
        this.itemMainIcon = itemMainIcon;
        this.itemUpdates = itemUpdates;
        this.showUpdates = showUpdates;
        this.groupcaption = groupcaption;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemMainIcon() {
        return itemMainIcon;
    }

    public void setItemMainIcon(int itemMainIcon) {
        this.itemMainIcon = itemMainIcon;
    }

    public String getItemUpdates() {
        return itemUpdates;
    }

    public void setItemUpdates(String itemUpdates) {
        this.itemUpdates = itemUpdates;
    }

    public boolean isShowUpdates() {
        return showUpdates;
    }

    public void setShowUpdates(boolean showUpdates) {
        this.showUpdates = showUpdates;
    }

    public boolean isGroupcaption() {
        return groupcaption;
    }

    public void setGroupcaption(boolean groupcaption) {
        this.groupcaption = groupcaption;
    }
}
