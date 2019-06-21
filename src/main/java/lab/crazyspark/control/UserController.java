package lab.crazyspark.control;

// @Controller
public class UserController {
    //  @Autowired
    // private UserService UserService;

    // @RequestMapping("/home")
    // public String potal(){
    //     return "index";
    // }

    // @RequestMapping("/saveUser")
    // public String save(User User, Model model){
    //     int i = new Random().nextInt(100);
    //     User.setId(i);
    //     boolean b = UserService.save(User);
    //     if(b){
    //         model.addAttribute("msg","部门添加成功");
    //         return "/status/success";
    //     }else{
    //         model.addAttribute("msg","部门添加失败");
    //         return "/status/default";
    //     }
    // }

    // @RequestMapping("/list")
    // public String list(Model model){
    //     List<User> list = UserService.findAll();
    //     model.addAttribute("UserList",list);
    //     return "User_list";
    // }

    // @PostMapping("/del")
    // @ResponseBody
    // public boolean delete(Integer id){
    //         boolean b = UserService.delete(id);
    //         return b;
    // }

    // @RequestMapping("/update/{id}")
    // public String update(@PathVariable  Integer id,Model model){
    //        User User = UserService.findById(id);
    //        model.addAttribute("User",User);
    //        return "updateForm";
    // }

    // @RequestMapping("/updateUser")
    // public String updateUser(User User){
    //     UserService.update(User);
    //     return "redirect:/list";
    // }
}