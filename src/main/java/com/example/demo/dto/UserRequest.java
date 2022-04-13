package com.example.demo.dto;
import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;

import lombok.Data;
/**
 * ユーザー情報 リクエストデータ
 */
@Data
public class UserRequest implements Serializable {


	  @NotEmpty(message = "名前を入力してください")
	  @Size(max = 100, message = "名前は100桁以内で入力してください")
    private String name;

	  @NotEmpty(message = "住所を入力してください")
	  @Size(max = 255, message = "住所は255桁以内で入力してください")
    private String address;

	  @Pattern(regexp = "0\\d{1,4}-\\d{1,4}-\\d{4}", message = "電話番号の形式で入力してください")
    private String phone;
	  @NotEmpty(message = "パスワードを入力してください")
    private String password;


	  @DateTimeFormat(pattern = "yyyy/MM/dd")
	  @NotNull

private Date birthday;


    private Long id;

	}

