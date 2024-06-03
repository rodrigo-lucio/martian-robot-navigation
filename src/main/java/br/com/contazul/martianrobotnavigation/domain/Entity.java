package br.com.contazul.martianrobotnavigation.domain;

import br.com.contazul.martianrobotnavigation.domain.exceptions.DomainException;
import br.com.contazul.martianrobotnavigation.domain.utils.IdUtils;
import br.com.contazul.martianrobotnavigation.domain.utils.StringUtils;

import java.util.UUID;

public abstract class Entity {

    private final String id;

    protected Entity(String id) {
        this.id = id;

        if (StringUtils.isNullOrBlank(this.id)) {
            throw new DomainException("id should not be null");
        }

    }

    public String getId() {
        return this.id;
    }

    public UUID getUuid() {
        return IdUtils.fromString(this.id);
    }

}
