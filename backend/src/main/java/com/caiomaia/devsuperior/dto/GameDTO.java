<<<<<<< HEAD
package com.caiomaia.devsuperior.dto;

import com.caiomaia.devsuperior.entities.Game;
import com.caiomaia.devsuperior.entities.enums.Platform;

import java.io.Serializable;

public class GameDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String title;
    private Platform platform;

    public GameDTO() {
    }

    public GameDTO(Game entity) {
        id = entity.getId();
        title = entity.getTitle();
        platform = entity.getPlatform();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }
}
=======
package com.caiomaia.devsuperior.dto;

import com.caiomaia.devsuperior.entities.Game;
import com.caiomaia.devsuperior.entities.enums.Platform;

import java.io.Serializable;

public class GameDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String title;
    private Platform platform;

    public GameDTO() {
    }

    public GameDTO(Game entity) {
        id = entity.getId();
        title = entity.getTitle();
        platform = entity.getPlatform();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }
}
>>>>>>> fe47691209c8e2869812d11a81464cfcdab31d7f
