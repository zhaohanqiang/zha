package com.example.demo.entity;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



import com.sun.istack.NotNull;

import lombok.Data;
/**
 * ユーザー情報 Entity
 */
@Entity
@Data
@Table(name = "user")
public class User implements Serializable {
    /**
     * ID
     */

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 名前
     */
    @NotNull
    @Column(name = "name")
    private String name;
    /**
     * 住所
     */
    @NotNull
    @Column(name = "address")
    private String address;
    /**
     * 電話番号
     */
    @NotNull
    @Column(name = "phone")
    private String phone;
    /**
     * 更新日時
     */
    @NotNull
    @Column(name = "password")
    private String password;
    /**
     * 登録日時
     */
    @NotNull
    @Column(name = "birthday")
    private Date birthday;



	}


