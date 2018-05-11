package ua.com.owu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.com.owu.entity.Car;
import ua.com.owu.entity.User;
import ua.com.owu.service.car.CarService;
import ua.com.owu.service.user.UserService;
import ua.com.owu.service.user.editor.UserEditor;
import ua.com.owu.service.user.validator.UserValidator;

@Controller
@RequestMapping("/save")
//контроллер реагуватиме тільки на ті посилання, які починатимуться із /save
public class SaveController {

    @Autowired
    private UserService userService;

    @Autowired
    private CarService carService;

//    @PostMapping("/user") // /save/user
//    public String saveUser(User user) {
//        userService.save(user);
//        return "index";
//    }
//
//    @PostMapping("/car")
//    public String saveCar(Car car) {
//        carService.save(car);
//        return "index";
//    }

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private UserEditor userEditor;
    //при збереженні машини із сторінки джойн ми отримуємо дві стрінги, а малиб отримувати стрінгу і об'єкт(юзера)
    //для цього мусимо створити едітора, який нам і сформує із стрінги об'єкт, витягнувши і "доліпивши" до неї ід юзера


    // байндер - це перехопник; бере об'єкт і перенаправляє далі. Існує для валідації і додаткової обробки об'єктів
    @InitBinder("userModel")
    public void binder(WebDataBinder dataBinder) {
        dataBinder.addValidators(userValidator);
    }

    @InitBinder("carModel")
    public void binder2(WebDataBinder dataBinder){
        dataBinder.registerCustomEditor(User.class, userEditor);
    }

    @PostMapping("/user") // /save/user
    public String saveUser(@ModelAttribute("userModel") @Validated User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "index";
        } else {
            userService.save(user);
            return "index";
        }
    }

    @PostMapping("/car")
    public String saveCar(@ModelAttribute("carModel") Car car) {
        carService.save(car);
        return "index";
    }

    @PostMapping("/car/user")
    public String mergeSaveCarUser(@ModelAttribute("carModel") Car carModel) {
        carService.save(carModel);
        return "index";
    }

    @ModelAttribute("userModel")
    public User user() {
        return new User();
    }

    @ModelAttribute("carModel")
    public Car car() {
        return new Car();
    }

}
