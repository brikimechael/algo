package domain;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import javax.persistence.*;
import static domain.UserStatus.*;

@Entity(name="USER_TABLE")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    @Size(min = 8, message = "Login must have at least 8 characters")
    @NotNull(message = "Login cannot be null")
    private String login;

    @Convert(converter = NameConverter.class)
    @Column(name = "FULL_NAME", nullable = false)
    private Name name;

    @Convert(converter = AddressConverter.class)
    @Column(name = "ADDRESS_STREET")
    private Address address;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserStatus status;

    private User(Builder builder) {
        name = builder.name;
        login = builder.login;
        status = builder.status;
        address = builder.address;
    }

    public void change(Address address) {
        this.address = address;
    }

    public void activate() {
        status = ACTIVE;
    }

    public void block() {
        status = BLOCKED;
    }

    public Long getId() {
        return id;
    }

    public Name getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public UserStatus getStatus() {
        return status;
    }

    public Address getAddress() {
        return address;
    }

    public static class Builder {
        private Name name;
        private String login;
        private UserStatus status;
        private Address address;

        private Builder(UserStatus status) {
            this.status = status;
        }

        public static Builder aUser() {
            return new Builder(INACTIVE);
        }

        public Builder with(Name name) {
            this.name = name;
            return this;
        }

        public Builder withLogin(String login) {
            this.login = login;
            return this;
        }

        public Builder with(Address address) {
            this.address = address;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}