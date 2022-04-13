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
 * ���[�U�[��� Entity
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
     * ���O
     */
    @NotNull
    @Column(name = "name")
    private String name;
    /**
     * �Z��
     */
    @NotNull
    @Column(name = "address")
    private String address;
    /**
     * �d�b�ԍ�
     */
    @NotNull
    @Column(name = "phone")
    private String phone;
    /**
     * �X�V����
     */
    @NotNull
    @Column(name = "password")
    private String password;
    /**
     * �o�^����
     */
    @NotNull
    @Column(name = "birthday")
    private Date birthday;



	}


