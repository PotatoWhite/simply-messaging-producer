package io.easywalk.simplymessagingproducer.user.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Contact {
    @Enumerated(EnumType.STRING)
    private Type   type;
    private String contact;

    public enum Type {
        HOME, OFFICE, MOBILE
    }
}
