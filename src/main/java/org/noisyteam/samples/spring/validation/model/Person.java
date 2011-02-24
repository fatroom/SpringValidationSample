package org.noisyteam.samples.spring.validation.model;

/**
 * Sample model class.
 *
 * @author Roman Romanchuk (fatroom@gmail.com)
 */
public class Person {

    private String name;
    private String nickname;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
