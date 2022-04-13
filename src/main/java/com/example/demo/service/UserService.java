package com.example.demo.service;


	import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserRequest;
	import com.example.demo.entity.User;
	import com.example.demo.repository.UserRepository;
	@Service
	public class UserService  {
		//自动注入userRepository，利用其实现业务层的相关操作
		@Autowired
		UserRepository userRepository;


		    public User findById(Long id) {
		        return userRepository.findById(id).get();
		    }
		    /**
		     * ユーザー情報 全検索
		     * @return 検索結果
		     */
		    public List<User> searchAll() {
		        return userRepository.findAll();
		     }

		    public void Create(UserRequest userRequest) {
		        userRepository.save(birthday(userRequest));
		    }
		    private User birthday(UserRequest userRequest) {

		        User user = new User();
		        user.setId(userRequest.getId());
		        user.setName(userRequest.getName());
		        user.setPassword(userRequest.getPassword());
		        user.setAddress(userRequest.getAddress());
		        user.setPhone(userRequest.getPhone());
		        user.setBirthday(userRequest.getBirthday());


		        return user;
		    }
		    public void update(UserRequest userRequest) {


		        User user = findById(userRequest. getId());
		        user.setName(userRequest.getName());
		        user.setAddress(userRequest.getAddress());
		        user.setPhone(userRequest.getPhone());
		        user.setPassword(userRequest.getPassword());
		        user.setBirthday(userRequest.getBirthday());
		        userRepository.save(user);

		    }
		    public void delete(Long id) {
		        User user = findById(id);
		        userRepository.delete(user);
}

		    public List<User> findAllUser(){
				return userRepository.findAll();
			}

			/**
			 * 根据name来查
			 */
		    public List<User> withUserQuery(String name,String password,String phone){
				return userRepository.findA(name, password, phone);
			}
			public List<User> withUsernameQuery(String name){
				return userRepository.withUsernameQuery(name);
			}
			public List<User> withUserpasswordQuery(String password){
				return userRepository.withUserpasswordQuery(password);
			}
			public List<User> withUserphoneQuery(String phone){
				return userRepository.withUserphoneQuery(phone);
			}

	}