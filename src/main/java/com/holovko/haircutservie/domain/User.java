package com.holovko.haircutservie.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @NotNull
    @Column(name="name")
    private String name;

    @Column(name="login")
    private String login;

    @NotNull
    @Column(name="email")
    private String email;

    @Column(name="phone")
    private String phone;

    @NotNull
    @Column(name="password")
    private String password;

    @NotNull
    @Column(name="confirm_password")
    private String confirmPassword;

    @Column(name="salt")
    private String salt;

    @Column(name="filepath")
    private String filepath;

    @Column(name="avatar")
    private String avatar;

    @Column(name="is_confirmed")
    private Boolean isConfirmed;

    @Column(name="is_approved")
    private Boolean isApproved;

    @Column(name="is_banned")
    private Boolean isBanned;

    @Column(name="secret_question")
    private String secretQuestion;

    @Column(name="secret_answer")
    private String secretAnswer;

}
