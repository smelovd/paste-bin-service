package com.shimada.pastebin.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Bin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "user_id")

    private User user;

    private String text;

    public Bin(Long id, User user, String text) {
        this.id = id;
        this.user = user;
        this.text = text;
    }

    public Bin(User user, String text) {
        this.user = user;
        this.text = text;
    }
}
