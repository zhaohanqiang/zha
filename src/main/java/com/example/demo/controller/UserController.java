package com.example.demo.controller;
	import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
	import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dto.GroupOrder;
import com.example.demo.dto.UserRequest;
	import com.example.demo.entity.User;
	import com.example.demo.service.UserService;

	@Controller
	public class UserController {

	    @Autowired
	    UserService userService;

	    @RequestMapping(value = "/user/list", method = RequestMethod.GET)
	    public String displayList(Model model) {
	        List<User> userlist = userService.searchAll();
	        model.addAttribute("userthree", new User());
	        model.addAttribute("userlist", userlist);
	        return "user/list";
	    }
	    /**
	     * ユーザー新規登録画面を表示
	     * @param model Model
	     * @return ユーザー情報一覧画面
	     */
	    @RequestMapping(value = "/user/add", method = RequestMethod.GET)
	    public String displayAdd(@Validated Model model) {

	        model.addAttribute("userRequest", new UserRequest());
	        return "user/add";
	    }
	    /**
	     * ユーザー新規登録
	     * @param userRequest リクエストデータ
	     * @param model Model
	     * @return ユーザー情報一覧画面
	     */
	    @RequestMapping(value = "/user/birthday", method = RequestMethod.POST)
	    public String create(@Validated @ModelAttribute  UserRequest userRequest, BindingResult result, Model model) {
	      if (result.hasErrors()) {
	        // 入力チェックエラーの場合
	        List<String> errorList = new ArrayList<String>();
	        for (ObjectError error : result.getAllErrors()) {
	          errorList.add(error.getDefaultMessage());
	        }
	        model.addAttribute("validationError", errorList);
	        return "user/add";
	      }
	      // ユーザー情報の登録
	      userService.Create(userRequest);
	      return "redirect:/user/list";
	    }

	    @GetMapping("/user/{id}")
	    public String displayView(@PathVariable Long id, Model model) {
	      User user = userService.findById(id);
	      model.addAttribute("userData", user);
	      UserRequest UserRequest = new UserRequest();
	      UserRequest. setId(user. getId());
	      UserRequest. setName(user. getName());
	      UserRequest. setPhone(user. getPhone());
	      UserRequest. setAddress(user. getAddress());
	      UserRequest. setPassword(user. getPassword());
	      UserRequest. setBirthday(user. getBirthday());
	   model. addAttribute("userData", UserRequest);
	      return "user/view";
	        }

	    /**
	   • 用户更新
	   * @param userRequest 请求数据
	     * @param model Model
	   • @return用户信息详细信息屏幕
	     */
	    @RequestMapping(value = "/user/update", method = RequestMethod. POST)
	    public String update( @ModelAttribute  UserRequest UserRequest, Model model) {


	   userService.update(UserRequest);
	      return "redirect:/user/list";
	    }
	    @GetMapping("/user/{id}/delete")
	    public String delete(@PathVariable Long id, Model model) {
	        // ユーザー情報の削除

	        userService.delete(id);
	        return "redirect:/user/list";




	    }

	        @RequestMapping(value = "/user/list")
	        public String index( Model model) {

	          model.addAttribute("user",new User());
	          model.addAttribute("userNumber", userService.findAllUser().size());
	          return "/user/list";
	        }

	    	//访问show页面
	    	@PostMapping(value = "/user/show")
	    	//@ModelAttribute接受表单提交过来的user对象
	    	public String show(@ModelAttribute User user, Model model) {

	    	List<User> userlist = new ArrayList<>();

	    	userlist.addAll( userService.withUserQuery(user.getName(),  user.getPassword(),user.getPhone()));
	    	  model.addAttribute("name", userlist);

	    	return "user/show";
	}
	  }











