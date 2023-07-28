package shop.mtcoding.blogv2.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import shop.mtcoding.blogv2.dto.JoinDTO;
import shop.mtcoding.blogv2.repository.UserRepository;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // ip주소 부여 : 10.1.1.1. -> 도메인을 사서 mtcoding.com
    // 포트로 결정(:8080) -> 10.1.1.1:8080
    // a태그 form태그 method=get
    @GetMapping("/joinForm")
    public String joinForm() {
        return "user/joinForm";
    }

    @GetMapping("/loginForm")
    public String loginForm() {
        System.out.println("123");

        return "user/loginForm";
    }

    @GetMapping("/user/updateForm")
    public String userForm() {
        return "user/updateForm";
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/";
    }

    
    // 더 좋은 방법.(실무 1)
    // 회원가입을 위한 DTO를 만들어서 클래스로 받기
    @PostMapping("/join")
    public String join(JoinDTO joinDTO) {

        userRepository.save(joinDTO);
        // validation check (유효성 검사)
        if (joinDTO.getUsername() == null || joinDTO.getUsername().isEmpty()) {
            return "error/ex40x";
        }
        if (joinDTO.getPassword() == null || joinDTO.getPassword().isEmpty()) {
            return "error/ex40x";
        }
        if (joinDTO.getUsername() == null || joinDTO.getUsername().isEmpty()) {
            return "error/ex40x";
        }
        return "redirect:/loginForm";
    }    
}

    // 정상
//    @PostMapping("/join")
//    public String join(String username, String password, String email) {
//        // username=ssar&password=1234&email=ssar@nate.com
//        System.out.println("username : " + username);
//        System.out.println("password : " + password);
//        System.out.println("email : " + email);
//
//        return "rediretct:/loginForm";
//    }
    // // 비정상
    // @PostMapping("/join")
    // public String join(HttpServletRequest request) throws IOException {
    // // username=ssar&password=1234&email=ssar@nate.com
    // BufferedReader br = request.getReader();

    // // 버퍼소비
    // String body = br.readLine();

    // // (값이 없어서 못꺼냄)
    // String username = request.getParameter("username");

    // System.out.println("body : " + body);
    // System.out.println("username : " + username);
    // return "redirect:/loginForm";
    // }

    // 약간 정상
    // DS(컨트롤러 메서드 찾기, 바디데이터 파싱)
    // DS가 바디데이터를 찾지 않고 컨트롤러 메서드만 찾은 상황
    // 컴퍼넌트 스캔
    // @PostMapping("/join")
    // public String join(HttpServletRequest request) {
    // String username = request.getParameter("username");
    // String password = request.getParameter("password");
    // String email = request.getParameter("email");
    // System.out.println("username : " + username);
    // System.out.println("password : " + password);
    // System.out.println("email : " + email);
    // return "redirect:/loginForm";
    // }
