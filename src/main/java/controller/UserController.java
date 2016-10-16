package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/*import com.libretaDigital.model.User;
import com.libretaDigital.services.UserService;
import com.libretaDigital.services.UserServiceImpl;

@Controller
public class UserController {

	 private UserService usuarioService = new UserServiceImpl();
	 static User user = new User();

	@RequestMapping(value = "/inicializarLogin.html", method = RequestMethod.GET)
	public ModelAndView inicializarUsuario() {

		System.out.println(	"Si hemos llegado aqui quiere decir que la pagina index.jsp ha invocado a este controlador por el request "
				+ "/inicializarLogin.html y requiere el inicializarUsuario View");
		return new ModelAndView("login", "User", new User());
	}
	
	@RequestMapping(value = "/verificarLogin.html", method = RequestMethod.POST)
    public ModelAndView verificarUsuario(@ModelAttribute("User") User user) {
        boolean existe = false;
        System.out.println("Si hemos llegado aqui quiere decir que la pagina login.jsp ha invocado a este controlador por el request "
        		+ "/verificarLogin.html y requiere el verificarUsuario View");
        existe = usuarioService.buscarUsuario(user);
 
        if("".equals(user.getNombre())&&"".equals(user.getClave())){
            System.out.println("Cargaremos por primera vez la pagina de login con el mensaje vacio");
            return new ModelAndView("login" , "mensaje", "Debe de llenar los campos de Usuario y Clave");
        }
        else if(existe){
            System.out.println("Se coloco al usuario y clave correctamente y va a la pagina de agregarComponentes");
            UserController.user.setNombre(user.getNombre());
            UserController.user.setClave(user.getClave());
            ModelAndView modelo= new ModelAndView("welcome" , "mensaje", "Usuario Correcto");
           // modelo.addObject("mensajeComponente","Agregar Componente");
            modelo.addObject("user", user);
            //modelo.addObject("componenteForm", new ComponenteForm());
            return modelo;
        }
        else{
            System.out.println("Se coloco al usuario y clave incorrectamente y regresamos a la pagina de login con el mensaje de Usuario Incorrecto");
            return new ModelAndView("login" , "mensaje", "Usuario Incorrecto");
        }
    }
}*/
