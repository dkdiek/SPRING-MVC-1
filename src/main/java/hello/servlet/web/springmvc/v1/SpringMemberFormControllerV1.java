package hello.servlet.web.springmvc.v1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * hello.servlet.web.springmvc.v1 SpringMemberFormControllerV1
 *
 * @author : K
 */
@Controller
public class SpringMemberFormControllerV1 {

  @RequestMapping("/springmvc/v1/members/new-form")
  public ModelAndView process(){
      return new ModelAndView("new-form");
  }




}
