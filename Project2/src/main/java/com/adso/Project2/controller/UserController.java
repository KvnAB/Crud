//package com.adso.Project2.controller;
//
//import com.adso.Project2.model.Registro;
//import com.adso.Project2.service.ServiceRegistro;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//
//@Controller
//public class UserController {
//    @Autowired
//    private ServiceRegistro serviceRegistro;
//
//    @GetMapping("/register/new")
//    public String formRegister(Model model){
//        model.addAttribute("registro", new Registro());
//        return "pages/registro";
//    }
//
//    @PostMapping("/registro")
//    public String createRegister(@ModelAttribute Registro registro, Model model){
//        serviceRegistro.saveRegister(registro);
//        model.addAttribute("result", serviceRegistro.getAllRegistro());
//        return "redirect:/registro";
//    }
//    @GetMapping("/registro")
//    public String listRegister(Model model){
//        model.addAttribute("result", serviceRegistro.getAllRegistro());
//        return "page/index";
//    }
//    @GetMapping("/")
//    public String Prueba(){
//        return "dataSave";
//    }
//}

package com.adso.Project2.controller;


import com.adso.Project2.model.Registro;
import com.adso.Project2.service.ServiceRegistro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

//Controlador actúa como intermediario entre la vista y la lógica de negocio

@Controller //para definir la clase como controlador
public class UserController {
    @Autowired //instanciar una clase en una clase
    private ServiceRegistro serviceRegistro;

    @GetMapping("/register/new") //simplifica la configutracion de rutas http para metodos especificos dentro de un controlador
    public String FormRegister(Model model){
        model.addAttribute("registro", new Registro());//Añadir atributos (datos) al modelo que la vista necesita para renderizarse
        return "pages/registro";
    }

    @PostMapping("/datos") // se usa para definir rutas y manejar las solicitudes POST entrantes a una aplicación web
    public String CreateUser(@ModelAttribute Registro registro){
        serviceRegistro.saveRegister(registro);
        return "redirect:/datos";
    }

    @GetMapping("/datos")
    public String ListRegister(Model model){
        model.addAttribute("result", serviceRegistro.getAllRegistro());
        return "pages/dataSave";
    }

    @GetMapping("/registro/edit/{id}")
    public String ShowEditForm(@PathVariable("id") Long id, Model model) {
        Registro registro = serviceRegistro.getRegisterById(id);
        model.addAttribute("registro", registro);
        return "pages/editRegistro";
    }

    @PostMapping("/registro/update/{id}")
    public String UpdateRegister(@PathVariable("id") Long id, @ModelAttribute Registro registro) {
        registro.setId(id);
        serviceRegistro.updateRegister(registro);
        return "redirect:/datos"; // Redirige a la lista de registros después de actualizar
    }

    @GetMapping("/lista/{id}")
    public String deleteRegister(@PathVariable Long id) {
        serviceRegistro.deleteRegister(id);
        return "redirect:/datos";
    }

    /* @GetMapping("/")
    public String index(){
        return "pages/index";
    }
    @GetMapping("/users")
        public String users(){
        return "pages/users";
    }

    @GetMapping("/registro")
        public String registro(){
        return "pages/register";
    }

    @GetMapping("/login")
    public String login(){
        return "pages/login";
*/



}

