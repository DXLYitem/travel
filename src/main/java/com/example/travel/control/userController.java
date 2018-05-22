package com.example.travel.control;

import com.example.travel.biz.UserService;
import com.example.travel.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class userController {

	@Resource
	private UserService userService;
	
/*	@Resource
	private RoleService roleService;*/
	
	/*@RequestMapping("/index")
	public String index() {
		return "login";
	}*/
	
	@RequestMapping("/doLogin")
	public String doLogin(String userCode,String userPassword,HttpSession session) {
		/*User user=new User();
		user.setUserCode(userCode);
		user.setUserPassword(userPassword);
		List<User> li=userService.list(user);
		//List<User> li1=userService.list(user);
		if(li.size()>0) {
			session.setAttribute("user", li.get(0));
		}else {
			session.setAttribute("user",null);
		}*/
		return "www.sparkletour.com/index";
	}

	@RequestMapping("/select")
	@ResponseBody
	public List<User> select(){
		return userService.findItemByPage(2,5);
	}
	
/*	@RequestMapping("/frame")
	public String frame(HttpSession session,Model model) {
		
		if(session.getAttribute("user")==null) {
			session.setAttribute("err", "�û������������");
			model.addAttribute("err","�û������������");
			return "redirect:/index";
		}else {
			return "frame";
		}
	}
	
	@RequestMapping("/dologout")
	public String doLogout(HttpSession session) {
		session.invalidate();
		return "redirect:/index";
	}
	
	@RequestMapping("/userlist")
	public String list(Model model,String userName,Integer userRole,Integer pageIndex) {
		Pages<User> li=userService.listByPage(userName, userRole, pageIndex, CommonUtil.PAGESIZE);
		model.addAttribute("pager",li);
		model.addAttribute("roleList",roleService.list(new Role()));
		model.addAttribute("userName", userName);
		model.addAttribute("userRole",userRole);
		return "user/userlist";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(Model model,@ModelAttribute("user")User user) {
		model.addAttribute("roleList",roleService.list(new Role()));
		return "user/useradd";
	}
	
	@RequestMapping(value="/doAdd",method=RequestMethod.POST)
	public String doAdd(Model model, HttpSession session,@Valid User user,BindingResult bind,MultipartFile file,HttpServletRequest request) {
		model.addAttribute("roleList",roleService.list(new Role()));
		if(bind.hasErrors()) {
			return "user/useradd";
		}
		String picPath=null;
		//======================================================================================
		if(!file.isEmpty()) {
			String path=request.getSession().getServletContext().getRealPath("statics/upload");
			String oldFileName=file.getOriginalFilename();
			String suffix=FilenameUtils.getExtension(oldFileName);
			int fileSize=5000000;
			if(file.getSize()>fileSize) {
				request.setAttribute("error", "�ļ����ܳ���5MB");
				return "redirect:/add";
			}
			if(suffix.equals("jpg")
					||suffix.equals("jpeg")
					||suffix.equals("png")
					||suffix.equals("pneg")){
				String newFileName=System.currentTimeMillis()+(new Random()).nextInt(100000)+"."+suffix;
				File targetFile=new File(path, newFileName);
				if(!targetFile.exists()) {
					targetFile.mkdirs();
				}
				try {
					file.transferTo(targetFile);
				} catch (Exception e) {
					e.printStackTrace();
					request.setAttribute("error", "�ϴ�ʧ��");
					return "redirect:/add";
				}
				picPath=newFileName;
			}else {
				request.setAttribute("error", "�ļ���ʽ����ȷ");
				return "redirect:/add";
			}
		}
		user.setPicPath(picPath);
		
		
		
		//=======================================================================================
		
		user.setCreatedBy(((User)session.getAttribute("user")).getId());
		user.setCreationDate(new Date());
		int num=userService.addUser(user);
		if(num>0) {
			return "redirect:userlist";
		}
		return "user/useradd";
	}
	
	@RequestMapping(value="/modify/{id}",method=RequestMethod.GET)
	public String modify(Model model,@PathVariable Integer id) {
		User user=new User();
		user.setId(id);
		List<User> li=userService.list(user);
		model.addAttribute("user", li.get(0));
		model.addAttribute("roleList",roleService.list(new Role()));
		return "user/usermodify";
	}
	
	@RequestMapping(value="/modify",method=RequestMethod.POST)
	public String modify(Model model,User user,HttpSession session) {
		user.setCreatedBy(((User)session.getAttribute("user")).getId());
		user.setCreationDate(new Date());
		int num=userService.modifyUserById(user);
		if(num>0) {
			return "redirect:/userlist";
		}
		return "redirect:/modify";
	}
	
	@RequestMapping("/delete/{xxx}")
	public String delete(@PathVariable Integer xxx) {
		userService.remove(xxx);
		return "redirect:/userlist";
	}
	
	@RequestMapping("/view/{id}")
	public String view(@PathVariable Integer id,Model model) {
		User u=new User();
		u.setId(id);
		model.addAttribute("user", userService.getById(u).get(0));
		return "user/userview";
	}*/
}
