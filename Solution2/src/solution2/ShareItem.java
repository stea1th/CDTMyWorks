/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solution2;

import java.util.Objects;

/**
 *
 * @author vvlasov
 */
public class ShareItem {
    public String description;
    public int itemId;

    public ShareItem() {
        this("Test Item", 0);
    }

    public ShareItem(String description) {
        this(description, 0);
    }

    public ShareItem(int itemId) {
        this("Test Item", itemId);
    }

    public ShareItem(String description, int itemId) {
        this.description = description;
        this.itemId = itemId;
    }

    public String getDescription() {
        return description;
    }

    public int getItemId() {
        return itemId;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.description);
        hash = 41 * hash + this.itemId;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ShareItem other = (ShareItem) obj;
        if (this.itemId != other.itemId) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ShareItem{" + "description=" + description + ", itemId=" + itemId + '}';
    }
    
    
}
